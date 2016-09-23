package comp1110.ass2.bots;

import comp1110.ass2.StratoGame;
import comp1110.ass2.logic.*;

import java.util.LinkedList;

/**
 *  Created by William Shen on 15/08/16
 */

public class EasyBot extends Bot {
    public EasyBot(LinkedList<Shape> playerGreen, LinkedList<Shape> playerRed, boolean isGreen) {
        super(playerGreen, playerRed, isGreen);
    }

    public EasyBot(String placement, char myPiece, char opponentsPiece) {
        super(placement, myPiece, opponentsPiece);
        System.out.println("placement: " + placement + ", mypiece: " + myPiece + ", opppiece: " +opponentsPiece);
    }

    @Override
    public Tile getMove() {
        // Score the different tile placements - messages for debugging
        LinkedList<Tile> possibleMoves = generatePossibleMoves();
        Tile bestMove = possibleMoves.getFirst();
        int maxScore = 0;

        if (isGreen) System.out.println("===============\nGreen Bot   Thinking...");
        else System.out.println("===============\nRed Bot   Thinking...");

        for (Tile tile : possibleMoves) {
            BoardState copy = new BoardState(game);
            copy.addTile(tile);
            int tileScore = copy.getScore(isGreen);
            System.out.print(tile + ", "+ tileScore + " | ");
            if (tileScore > maxScore) {
                bestMove = tile;
                maxScore = tileScore;
            }
        }

        System.out.println("\nMAX SCORE: " + maxScore + ", FINAL CHOICE: " + bestMove);
        return bestMove;
    }
}
