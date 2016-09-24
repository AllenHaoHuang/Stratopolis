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

    public HardBot(BoardState parentGame, boolean isGreenPlayer, int lookahead) {
        super(parentGame, isGreenPlayer);
        this.lookahead = lookahead;
    }

    public Tile getMove() {
        // Score the different tile placements - messages for debugging
        Shape shape;
        if (myPlayer.isGreen()) {
            shape = game.getGreenShapes().getFirst();
            System.out.println("===== MINIMAX: Green Bot, Depth: " + lookahead + " =====");
        } else {
            shape = game.getRedShapes().getFirst();
            System.out.println("===== MINIMAX: Red Bot, Depth: " + lookahead + " =====");
        }

        LinkedList<Tile> possibleMoves = game.generatePossibleMoves(shape);
        Tile bestMove = possibleMoves.getFirst();
        int maxScore = 0;

        System.out.print("Thinking");

        for (Tile tile : possibleMoves) {
            BoardState node = new BoardState(game);
            node.addTile(tile);

            int tileScore = MiniMax.start(node, lookahead - 1, this.myPlayer, true);

            System.out.print(".");

            if (tileScore > maxScore) {
                bestMove = tile;
                maxScore = tileScore;
            }
        }

        System.out.println("\nMAX SCORE: " + maxScore + ", FINAL CHOICE: " + bestMove);
        return bestMove;
    }


}
