package comp1110.ass2.bots;

import comp1110.ass2.StratoGame;
import comp1110.ass2.logic.*;

import java.util.LinkedList;

/**
 *  Created by William Shen on 15/08/16
 */

/* We want to limit the access of this class to only this package */
abstract class Bot {
    private static final int BOARD_SIZE = 26;

    private BoardState game = new BoardState();

    /*
    private LinkedList<Shape> playerGreen;
    private LinkedList<Shape> playerRed;
    private boolean isGreen;
*/
    /* commenting out for now
    // Used for object initialisation, mainly here for inheritance
    Bot(LinkedList<Shape> playerGreen, LinkedList<Shape> playerRed, boolean isGreen) {
        game.playerGreen = playerGreen;
        game.playerRed = playerRed;
        game.isGreen = isGreen;
    }*/

    // To be implemented by any class that extends
    public abstract Tile getMove();

    // Opponent placed a tile, add it to the bot's BoardState
    public void addTile(Tile tile) { game.addTile(tile); }

    // Generates the possible moves given a particular game state, basic bot shouldn't use this, it should
    // break once it finds first valid move
    Tile[] generatePossibleMoves() {
        LinkedList<Tile> tileLinkedList = new LinkedList<>();
        boolean[][] positionsToCheck = game.getPossiblePosArray();

        if (game.getIsGreen()) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (positionsToCheck[i][j] == true) {
                        for (Shape s : game.getGreenShapeLinkedList()) {
                            for (Orientation o : Orientation.values()) {
                                Tile newTile = new Tile(new Position(i, j), s, o);
                                if (game.isTileValid(newTile)) {
                                    tileLinkedList.add(newTile);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (positionsToCheck[i][j] == true) {
                        for (Shape s : game.getRedShapeLinkedList()) {
                            for (Orientation o : Orientation.values()) {
                                Tile newTile = new Tile(new Position(i, j), s, o);
                                if (game.isTileValid(newTile)) {
                                    tileLinkedList.add(newTile);
                                }
                            }
                        }
                    }
                }
            }
        }
        return (tileLinkedList.toArray(new Tile[tileLinkedList.size()]));
    }
}
