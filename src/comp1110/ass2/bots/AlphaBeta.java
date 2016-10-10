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
    static double start(BoardState node, int original, int depth, Colour myPlayer, boolean isMax, double alpha, double beta) {
        // If we run out of lookahead or the game is finished we return the heuristic
        if (depth == 0 || node.isFinished())
            return node.getScore(myPlayer) - node.getScore(myPlayer.nextPlayer());

        if (original - depth > 2) {
            return imperfectAlphaBeta(node, depth, myPlayer, isMax, alpha, beta);
        }

        // We can use normal alpha beta for the first 2 moves as the player has information to this
        // Check if this instance is a maximising or minimising player
        if (isMax) {
            Shape shape;
            if (myPlayer.isGreen()) {
                shape = node.getGreenShapes().getFirst();
            } else {
                shape = node.getRedShapes().getFirst();
            }

            // Generate all the possible moves given the shape and loop through them
            LinkedList<Tile> possibleMoves = node.generatePossibleMoves(shape);
            for (Tile tile : possibleMoves) {
                // Create a new board state if the given tile is placed
                BoardState child = new BoardState(node);
                child.addTile(tile);
                child.removeTile(tile);
                // Recursive call on Alpha-Beta bot as minimising player
                double score = start(child, original, depth-1, myPlayer, false, alpha, beta);
                // We break if we have an beta cut-off
                alpha = Math.max(score, alpha);
                if (alpha >= beta) break;
            }
            return alpha;
        } else {
            Shape shape;
            if (myPlayer.isGreen()) {
                shape = node.getRedShapes().getFirst();
            } else {
                shape = node.getGreenShapes().getFirst();
            }

            // Generate all the possible moves given the shape and loop through them
            LinkedList<Tile> possibleMoves = node.generatePossibleMoves(shape);
            for (Tile tile : possibleMoves) {
                // Create a new board state if the given tile is placed
                BoardState child = new BoardState(node);
                child.addTile(tile);
                child.removeTile(tile);
                // Recursive call on Alpha-Beta bot as maximising player
                double score = start(child, original, depth-1, myPlayer, true, alpha, beta);
                // We break if we have an alpha cut-off
                beta = Math.min(score, beta);
                if (alpha >= beta) break;
            }
            return beta;
        }

    }

    static double imperfectAlphaBeta(BoardState node, int depth, Colour myPlayer, boolean isMax, double alpha, double beta) {
        // If we run out of lookahead or the game is finished we return the heuristic
        if (depth == 0 || node.isFinished())
            return node.getScore(myPlayer) - node.getScore(myPlayer.nextPlayer());

        LinkedList<Shape> shapes;
        LinkedList<Shape> shapeNoRepeat = new LinkedList<>();
        double finalScore = 0.0;

        // Check if this instance is a maximising or minimising player
        if (isMax) {
            shapes = node.getShapes(myPlayer);
            // makes a new linked list with no repeat
            Set<Shape> hs = new HashSet<>();
            hs.addAll(shapes);
            shapeNoRepeat.addAll(hs);

            for (Shape s : shapeNoRepeat) {
                LinkedList<Tile> possibleMoves = node.generatePossibleMoves(s);
                int count = 0;
                double tileTotalScore = 0;
                double probability = (double)Collections.frequency(shapes, s) / shapes.size();


                for (Tile tile : possibleMoves) {
                    // Create a new board state if the given tile is placed
                    BoardState child = new BoardState(node);
                    child.addTile(tile);
                    child.removeTile(tile);
                    // Recursive call on Alpha-Beta bot as minimising player
                    double score = imperfectAlphaBeta(child, depth - 1, myPlayer, false, alpha, beta);
                    // We break if we have an beta cut-off
                    alpha = Math.max(score, alpha);
                    if (alpha >= beta) break;
                    tileTotalScore += alpha * probability;
                    count++;
                }
                if (count != 0) {
                    finalScore += (tileTotalScore / count);
                }
            }

            return finalScore;
        } else {
            shapes = node.getShapes(myPlayer.nextPlayer());
            // makes a new linked list with no repeat
            Set<Shape> hs = new HashSet<>();
            hs.addAll(shapes);
            shapeNoRepeat.addAll(hs);

            for (Shape s : shapeNoRepeat) {
                LinkedList<Tile> possibleMoves = node.generatePossibleMoves(s);
                int count = 0;
                double tileTotalScore = 0;
                double probability = (double)Collections.frequency(shapes, s) / shapes.size();

                for (Tile tile : possibleMoves) {
                    // Create a new board state if the given tile is placed
                    BoardState child = new BoardState(node);
                    child.addTile(tile);
                    child.removeTile(tile);
                    // Recursive call on Alpha-Beta bot as maximising player
                    double score = imperfectAlphaBeta(child, depth-1, myPlayer, true, alpha, beta);
                    // We break if we have an alpha cut-off
                    beta = Math.min(score, beta);
                    if (alpha >= beta) break;
                    tileTotalScore += beta * probability;
                    count++;
                }
                if (count != 0) {
                    finalScore += (tileTotalScore / count);
                }
            }
            return finalScore;
        }
    }
}


