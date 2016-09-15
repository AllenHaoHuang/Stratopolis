package comp1110.ass2.bots;

import comp1110.ass2.logic.Shape;
import comp1110.ass2.logic.Tile;

import java.util.LinkedList;

/**
 *  Created by William Shen on 15/08/16
 */

public class HardBot extends Bot {
    public HardBot(LinkedList<Shape> playerGreen, LinkedList<Shape> playerRed, boolean isGreen) {
        super(playerGreen, playerRed, isGreen);
    }

    @Override
    public Tile getMove() {
        // Minimax with Alpha-Beta pruning
        return null;
    }

    // Opponent placed a tile, we add it to our board
    public void addTile(Tile tile) { super.addTile(tile); }
}
