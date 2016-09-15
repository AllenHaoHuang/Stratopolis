package comp1110.ass2.bots;

import comp1110.ass2.logic.Shape;
import comp1110.ass2.logic.Tile;

import java.util.LinkedList;
import java.util.Random;

/**
 *  Created by William Shen on 15/08/16
 */

public class EasyBot extends Bot {
    public EasyBot(LinkedList<Shape> playerGreen, LinkedList<Shape> playerRed, boolean isGreen) {
        super(playerGreen, playerRed, isGreen);
    }

    @Override
    public Tile getMove() {
        // Select a random placement from the array of possible Tile placements
        Tile[] placements = generatePossibleMoves();
        return placements[new Random().nextInt(placements.length)];
    }

    // Opponent placed a tile, we add it to our board
    public void addTile(Tile tile) { super.addTile(tile); }
}
