package comp1110.ass2.bots;

import comp1110.ass2.logic.BoardState;
import comp1110.ass2.logic.Colour;
import comp1110.ass2.logic.Shape;
import comp1110.ass2.logic.Tile;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * This class is used to start a recursive instance of
 * an Alpha-Beta pruning bot for StratoGame. It is called in
 * the method getMove() in HardBot.
 *
 * @author Allen Huang - u6096857
 * @author William Shen - u6096655
 */
class AlphaBeta {
    static double start(BoardState node, int depth, Colour myPlayer, boolean isMax, double alpha, double beta) {
        // If we run out of lookahead or the game is finished we return the heuristic
        if (depth == 0 || node.isFinished())
            return node.getScore(myPlayer) - node.getScore(myPlayer.nextPlayer());

        LinkedList<Shape> shapes;
        LinkedList<Shape> shapeNoRepeat = new LinkedList<>();
        double finalScore = 0.0;

        // Check if this instance is a maximising or minimising player
        if (isMax) {
            if (myPlayer.isGreen()) {
                shapes = node.getGreenShapes();
                // makes a new linked list with no repeat
                Set<Shape> hs = new HashSet<>();
                hs.addAll(shapes);
                shapeNoRepeat.addAll(hs);

                for (Shape s : shapeNoRepeat) {
                    LinkedList<Tile> possibleMoves = node.generatePossibleMoves(s);
                    int count = 0;
                    double tileTotalScore = 0;

                    for (Tile tile : possibleMoves) {
                        // Create a new board state if the given tile is placed
                        BoardState child = new BoardState(node);
                        child.addTile(tile);
                        // Recursive call on Alpha-Beta bot as minimising player
                        double score = start(child, depth - 1, myPlayer, false, alpha, beta);
                        // We break if we have an beta cut-off
                        alpha = Math.max(score, alpha);
                        if (alpha >= beta) break;
                        tileTotalScore += alpha;
                        count++;
                    }
                    finalScore += (tileTotalScore / count) * (Collections.frequency(shapes, s) / shapes.size());
                }
            }
        } else {
            shapes = node.getRedShapes();
            // makes a new linked list with no repeat
            Set<Shape> hs = new HashSet<>();
            hs.addAll(shapes);
            shapeNoRepeat.addAll(hs);

            for (Shape s : shapeNoRepeat) {
                LinkedList<Tile> possibleMoves = node.generatePossibleMoves(s);
                int count = 0;
                double tileTotalScore = 0;

                for (Tile tile : possibleMoves) {
                    // Create a new board state if the given tile is placed
                    BoardState child = new BoardState(node);
                    child.addTile(tile);
                    // Recursive call on Alpha-Beta bot as maximising player
                    double score = start(child, depth-1, myPlayer, true, alpha, beta);
                    // We break if we have an alpha cut-off
                    beta = Math.min(score, beta);
                    if (alpha >= beta) break;
                    tileTotalScore += beta;
                    count++;
                }
                finalScore += (tileTotalScore / count) * (Collections.frequency(shapes, s) / shapes.size());
            }
        }
        return finalScore;
    }
}


