package comp1110.ass2.bots;

import comp1110.ass2.logic.BoardState;
import comp1110.ass2.logic.Colour;
import comp1110.ass2.logic.Shape;
import comp1110.ass2.logic.Tile;

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

        // We can use normal alpha beta for the first 2 moves as the player has information to this
        if (original - depth > 2)
            return probabilisticAlphaBeta(node, depth, myPlayer, isMax, alpha, beta);

        // Check if this instance is a maximising or minimising player
        if (isMax) {
            Shape shape = (myPlayer.isGreen()) ? node.getGreenShapes().getFirst()
                    : node.getRedShapes().getFirst();
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
            Shape shape = (myPlayer.isGreen()) ? node.getRedShapes().getFirst()
                    : node.getGreenShapes().getFirst();
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

    private static double probabilisticAlphaBeta(BoardState node, int depth, Colour myPlayer, boolean isMax, double alpha, double beta) {
        // If we run out of lookahead or the game is finished we return the heuristic
        if (depth == 0 || node.isFinished())
            return node.getScore(myPlayer) - node.getScore(myPlayer.nextPlayer());

        // Linked list that is going to contain all the shapes available
        LinkedList<Shape> shapes;
        // Linked list that contains all the shapes available with no repeats
        LinkedList<Shape> shapeNoRepeat = new LinkedList<>();

        // Check if this instance is a maximising or minimising player
        if (isMax) {
            shapes = node.getShapes(myPlayer);
            // generation of a list having no repeat
            Set<Shape> hs = new HashSet<>();
            hs.addAll(shapes);
            shapeNoRepeat.addAll(hs);

            double nodeScore = 0.0;

            for (Shape s : shapeNoRepeat) {
                // For each shape generate a linked list having all possible moves
                LinkedList<Tile> possibleMoves = node.generatePossibleMoves(s);
                // stores current alpha and beta so when it can reset when going through different shapes
                double originalAlpha = alpha;
                double originalBeta = beta;

                // probability of a shape being selected
                double probability = (double)Collections.frequency(shapes, s) / shapes.size();

                for (Tile tile : possibleMoves) {
                    // Create a new board state if the given tile is placed
                    BoardState child = new BoardState(node);
                    child.addTile(tile);
                    child.removeTile(tile);
                    // Recursive call on Alpha-Beta bot as minimising player
                    double score = probabilisticAlphaBeta(child, depth - 1, myPlayer, false, alpha, beta);
                    // We break if we have an beta cut-off
                    alpha = Math.max(score, alpha);
                    if (alpha >= beta) break;
                }
                // the score of the node is equal to the weighted average of the alphas of its children
                nodeScore += alpha * probability;
                alpha = originalAlpha;
                beta = originalBeta;
            }

            return nodeScore;
        } else {
            shapes = node.getShapes(myPlayer.nextPlayer());
            // generation of a list having no repeat
            Set<Shape> hs = new HashSet<>();
            hs.addAll(shapes);
            shapeNoRepeat.addAll(hs);

            double nodeScore = 0.0;

            for (Shape s : shapeNoRepeat) {
                // For each shape generate a linked list having all possible moves
                LinkedList<Tile> possibleMoves = node.generatePossibleMoves(s);

                // stores current alpha and beta so when it can reset when going through different shapes
                double originalAlpha = alpha;
                double originalBeta = beta;

                // probability of the shape being selected
                double probability = (double)Collections.frequency(shapes, s) / shapes.size();

                for (Tile tile : possibleMoves) {
                    // Create a new board state if the given tile is placed
                    BoardState child = new BoardState(node);
                    child.addTile(tile);
                    child.removeTile(tile);
                    // Recursive call on Alpha-Beta bot as maximising player
                    double score = probabilisticAlphaBeta(child, depth-1, myPlayer, true, alpha, beta);
                    // We break if we have an alpha cut-off
                    beta = Math.min(score, beta);
                    if (alpha >= beta) break;
                }
                // the score of the node is equal to the weighted average of the betas of its children
                nodeScore += beta * probability;
                alpha = originalAlpha;
                beta = originalBeta;
            }
            return nodeScore;
        }
    }
}


