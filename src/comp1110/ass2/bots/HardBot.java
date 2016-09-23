package comp1110.ass2.bots;

import comp1110.ass2.logic.Shape;
import comp1110.ass2.logic.Tile;
import comp1110.ass2.logic.BoardState;

import java.util.LinkedList;

/**
 *  Created by William Shen on 15/08/16
 */

public class HardBot extends Bot {
    private int lookahead;
    private double difficulty;

    public HardBot(LinkedList<Shape> playerGreen, LinkedList<Shape> playerRed, boolean isGreen, double difficulty) {
        super(playerGreen, playerRed, isGreen);
        lookahead = (int)(difficulty * 2) + 1;
        this.difficulty = difficulty;
        System.out.println("Lookahead: " + lookahead);
    }

    @Override
    public Tile getMove() {
        // Copied from easybot for now
        LinkedList<Tile> possibleMoves = generatePossibleMoves();
        Tile bestMove = possibleMoves.getFirst();
        int maxScore = 0;

        if (isGreen) System.out.println("===============\nGreen Bot   Thinking...");
        else System.out.println("===============\nRed Bot   Thinking...");

        for (Tile tile : possibleMoves) {
            HardBot copy = new HardBot(this.playerGreen, this.playerRed, this.isGreen, difficulty);
            copy.addTile(tile);

            int tileScore = minimax(copy, 2, true);
            System.out.print(tile + ", "+ tileScore + " | ");
            if (tileScore > maxScore) {
                bestMove = tile;
                maxScore = tileScore;
            }
        }

        System.out.println("\nMAX SCORE: " + maxScore + ", FINAL CHOICE: " + bestMove);
        return bestMove;
    }

    public int minimax(Bot minimaxBot, int depth, boolean maximising) {
        LinkedList<Tile> possibleMoves = minimaxBot.generatePossibleMoves();

        // if depth is 0, return the boardScore
        if (depth == 0) {
            BoardState board = minimaxBot.game;
            return board.getScore(minimaxBot.isGreen);
        }

        // if game is finished, return the boardScore
        if ((minimaxBot.isGreen && minimaxBot.playerGreen.isEmpty()) || ((!minimaxBot.isGreen) && minimaxBot.playerRed.isEmpty())) {
            BoardState board = minimaxBot.game;
            return board.getScore(minimaxBot.isGreen);
        }

        if (maximising) {
            // initially best score is a very low number
            int bestScore = -1000;
            for (Tile t : possibleMoves) {
                HardBot copy = new HardBot(minimaxBot.playerGreen, minimaxBot.playerRed, minimaxBot.isGreen, difficulty);
                copy.addTile(t);
                // find the currentscore for a board, if its higher than the best score, it is the new best score
                // for maximising
                int currentScore = minimax(copy, depth-1, false);
                if (currentScore > bestScore) {
                    bestScore = currentScore;
                }
            }
            return bestScore;
        } else {
            // initially best score is a very high number
            int bestScore = 1000;
            for (Tile t : possibleMoves) {
                HardBot copy = new HardBot(minimaxBot.playerGreen, minimaxBot.playerRed, minimaxBot.isGreen, difficulty);
                copy.addTile(t);
                // find the currentscore for a board, if it is lower than the best score, it is the new best score
                // for minimising
                int currentScore = minimax(copy, depth-1, true);
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
