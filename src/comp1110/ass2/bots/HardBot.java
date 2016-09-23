package comp1110.ass2.bots;

import comp1110.ass2.logic.Shape;
import comp1110.ass2.logic.Tile;

import java.util.LinkedList;

/**
 *  Created by William Shen on 15/08/16
 */

public class HardBot extends Bot {
    private int lookahead;

    public HardBot(LinkedList<Shape> playerGreen, LinkedList<Shape> playerRed, boolean isGreen, double difficulty) {
        super(playerGreen, playerRed, isGreen);
        lookahead = (int)(difficulty * 2) + 1;
        System.out.println("Lookahead: " + lookahead);
    }

    @Override
    public Tile getMove() {
        // Minimax with Alpha-Beta pruning, recursion etc.
        LinkedList<Tile> possibleMoves = generatePossibleMoves();
        return possibleMoves.getFirst();

    public int minimax(BoardState board, int depth, boolean maximising) {
        // NEEDS POSSIBLE MOVES FUNCTION INSIDE BOARDSTATE, BUT THAT NEEDS THE BOOLEAN ISGREEN IN BOARDSTATE AS WELL
        LinkedList<Tile> possibleMoves = generatePossibleMoves();

        // if depth is 0, return the boardScore
        if (depth == 0) {
            return board.getScore(isGreen);
        }

        // if game is finished, return the boardScore
        if ((isGreen && playerGreen.isEmpty()) || ((!isGreen) && playerRed.isEmpty())) {
            return board.getScore(isGreen);
        }

        if (maximising) {
            // initially best score is a very low number
            int bestScore = -1000;
            for (Tile t : possibleMoves) {
                // generate a new board and add the tile
                BoardState newBoard = board;
                newBoard.addTile(t);
                // find the currentscore for a board, if its higher than the best score, it is the new best score
                // for maximising
                int currentScore = minimax(newBoard, depth-1, false);
                if (currentScore > bestScore) {
                    bestScore = currentScore;
                }
            }
            return bestScore;
        } else {
            // initially best score is a very high number
            int bestScore = 1000;
            for (Tile t : possibleMoves) {
                // generate a new board and add the tile
                BoardState newBoard = board;
                newBoard.addTile(t);
                // find the currentscore for a board, if it is lower than the best score, it is the new best score
                // for minimising
                int currentScore = minimax(newBoard, depth-1, true);
                if (currentScore < bestScore) {
                    bestScore = currentScore;
                }
            }
            return bestScore;
        }
    }

    // Opponent placed a tile, we add it to our board
    public void addTile(Tile tile) { super.addTile(tile); }
}
