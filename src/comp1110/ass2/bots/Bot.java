package comp1110.ass2.bots;

import comp1110.ass2.StratoGame;
import comp1110.ass2.logic.*;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *  Created by William Shen on 15/08/16
 */

/* We want to limit the access of this class to only this package */
abstract class Bot {
    private static final int BOARD_SIZE = 26;

    private BoardState game = new BoardState();
    private LinkedList<Shape> playerGreen;
    private LinkedList<Shape> playerRed;
    private boolean isGreen;

    // Used for object initialisation, mainly here for inheritance
    Bot(LinkedList<Shape> playerGreen, LinkedList<Shape> playerRed, boolean isGreen) {
        this.playerGreen = playerGreen;
        this.playerRed = playerRed;
        this.isGreen = isGreen;
    }

    // Used for object initialisation from valid placement string
    Bot(String placement, char myPiece, char opponentsPiece) {
        game = new BoardState(placement);

        playerGreen = new LinkedList<>();
        playerRed = new LinkedList<>();

        if (myPiece >= 'A' && myPiece <= 'J') {
            // myPiece is for playerRed
            playerRed.add(Shape.fromChar(myPiece));
            playerGreen.add(Shape.fromChar(opponentsPiece));
            isGreen = false;
        } else {
            // myPiece is for playerGreen
            playerGreen.add(Shape.fromChar(myPiece));
            playerRed.add(Shape.fromChar(opponentsPiece));
            isGreen = true;
        }
    }

    // To be implemented by any class that extends
    public abstract Tile getMove();

    // Opponent placed a tile, add it to the bot's BoardState
    public void addTile(Tile tile) { game.addTile(tile); }

    // Generates the possible moves given a particular game state, basic bot shouldn't use this, it should
    // break once it finds first valid move
    LinkedList<Tile> generatePossibleMoves() {
        LinkedList<Tile> tileList = new LinkedList<>();
        boolean[][] positionsToCheck = game.getPossiblePosArray();

        /* For DEBUGGING
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("[");
            for (int j = 0;  j < BOARD_SIZE; j++) {
                if (positionsToCheck[i][j]) {
                    if (j == BOARD_SIZE - 1) System.out.print("T");
                    else System.out.print("T, ");
                } else {
                    if (j == BOARD_SIZE - 1) System.out.print("F");
                    else System.out.print("F, ");
                }
            }
            System.out.println("]");
        } */

        Shape shape;
        if (isGreen) shape = playerGreen.getFirst();
        else shape = playerRed.getFirst();

        // Loop through board grid
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                // Check if it is possible to place piece
                if (positionsToCheck[i][j]) {
                    for (Orientation orientation : Orientation.values()) {
                        Tile newTile = new Tile(new Position(i,j), shape, orientation);
                        if (game.isTileValid(newTile)) tileList.add(newTile);
                    }
                }
            }
        }

        return tileList;
    }
}
