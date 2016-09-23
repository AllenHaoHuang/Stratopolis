package comp1110.ass2.bots;

import comp1110.ass2.logic.BoardState;
import comp1110.ass2.logic.Shape;
import comp1110.ass2.logic.Tile;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

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
        // Select a random placement from the array of possible Tile placements
        Random random = new Random();
        // Debugging
        LinkedList<Tile> moves = generatePossibleMoves();
        int index = random.nextInt(moves.size());
        System.out.println("Possible Moves: " + moves);
        System.out.println("Random Index: " + index  + ", Final Move: " + moves.get(index));

        super.addTile(moves.get(index));
        return moves.get(index);
    }

    // Opponent placed a tile, we add it to our board
    public void addTile(Tile tile) { super.addTile(tile); }
}
