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
    }

}
