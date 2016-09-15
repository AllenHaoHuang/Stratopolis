package comp1110.ass2.bots;

import comp1110.ass2.logic.BoardState;
import comp1110.ass2.logic.Shape;
import comp1110.ass2.logic.Tile;

import java.util.LinkedList;

/**
 *  Created by William Shen on 15/08/16
 */

/* We want to limit the access of this class to only this package */
abstract class Bot {
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

    // To be implemented by any class that extends
    public abstract Tile getMove();

    // Opponent placed a tile, add it to the bot's BoardState
    public void addTile(Tile tile) { game.addTile(tile); }

    // Generates the possible moves given a particular game state
    Tile[] generatePossibleMoves() {
        return null;
    }
}
