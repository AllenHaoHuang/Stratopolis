package comp1110.ass2.bots;

import comp1110.ass2.logic.*;

import java.util.LinkedList;

/**
 *  Created by William Shen on 15/08/16
 */

public class EasyBot extends Bot {
    // Constructors using that of the superclass 'Bot'
    public EasyBot(BoardState parentGame, boolean isGreenPlayer) {
        super(parentGame, isGreenPlayer);
    }

    public EasyBot(String placement, char myPiece, char opponentsPiece) {
        super(placement, myPiece, opponentsPiece);
    }

    @Override
    public Tile getMove() {
        // Setting up console message
        if (myPlayer == Colour.Green) System.out.println("===== EASY GREEN BOT ===== ");
        else System.out.println("===== EASY RED BOT ===== ");

        // Get the shape the bot will be playing
        Shape shape = (myPlayer == Colour.Green) ? game.getGreenShapes().getFirst()
                : game.getRedShapes().getFirst();

        // Generate the potential moves the bot can place, then loop through them and evaluate
        LinkedList<Tile> possibleMoves = game.generatePossibleMoves(shape);
        Tile bestMove = possibleMoves.getFirst();
        int maxScore = 0;

        for (Tile tile : possibleMoves) {
            BoardState gameCopy = new BoardState(game);
            gameCopy.addTile(tile);
            int tileScore = gameCopy.getScore(myPlayer == Colour.Green);
            if (tileScore > maxScore) {
                bestMove = tile;
                maxScore = tileScore;
            }
        }

        System.out.println("MAX SCORE: " + maxScore + ", FINAL CHOICE: " + bestMove);
        return bestMove;
    }
}
