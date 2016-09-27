package comp1110.ass2.bots;

import comp1110.ass2.logic.BoardState;
import comp1110.ass2.logic.Colour;
import comp1110.ass2.logic.Shape;
import comp1110.ass2.logic.Tile;

import java.util.LinkedList;

/**
 * This class is used to start a recursive instance of
 * an Alpha-Beta pruning bot for StratoGame. It is called in
 * the method getMove() in HardBot.
 *
 * @author Allen Huang - u6096857
 * @author William Shen - u6096655
 */
class AlphaBeta {
    static int start(BoardState node, int depth, Colour myPlayer, boolean isMax, int alpha, int beta) {
        // If we run out of lookahead or the game is finished we return the heuristic
        if (depth == 0 || node.isFinished())
            return node.getScore(myPlayer) - node.getScore(myPlayer.nextPlayer());

        // Check if this instance is a maximising or minimising player
        if (isMax) {
            // Get the relevant shape and remove it from the board
            Shape shape;
            if (myPlayer.isGreen()) {
                shape = node.getGreenShapes().getFirst();
                node.removeGreenShape();
            } else {
                shape = node.getRedShapes().getFirst();
                node.removeRedShape();
            }

            // Generate all the possible moves given the shape and loop through them
            LinkedList<Tile> possibleMoves = node.generatePossibleMoves(shape);
            for (Tile tile : possibleMoves) {
                // Create a new board state if the given tile is placed
                BoardState child = new BoardState(node);
                child.addTile(tile);
                // Recursive call on Alpha-Beta bot as minimising player
                int score = start(child, depth-1, myPlayer, false, alpha, beta);
                // We break if we have an beta cut-off
                alpha = Math.max(score, alpha);
                if (alpha >= beta) break;
            }
            return alpha;
        } else {
            // Get the relevant shape and remove it from the board
            Shape shape;
            if (myPlayer.isGreen()) {
                shape = node.getRedShapes().getFirst();
                node.removeRedShape();
            } else {
                shape = node.getGreenShapes().getFirst();
                node.removeGreenShape();
            }

            // Generate all the possible moves given the shape and loop through them
            LinkedList<Tile> possibleMoves = node.generatePossibleMoves(shape);
            for (Tile tile : possibleMoves) {
                // Create a new board state if the given tile is placed
                BoardState child = new BoardState(node);
                child.addTile(tile);
                // Recursive call on Alpha-Beta bot as maximising player
                int score = start(child, depth-1, myPlayer, true, alpha, beta);
                // We break if we have an alpha cut-off
                beta = Math.min(score, beta);
                if (alpha >= beta) break;
            }
            return beta;
        }

    }


}


