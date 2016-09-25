package comp1110.ass2.bots;

import comp1110.ass2.logic.Shape;
import comp1110.ass2.logic.Tile;
import comp1110.ass2.logic.BoardState;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

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
        // Elapsed time calculator from http://memorynotfound.com/calculating-elapsed-time-java/
        long startTime = System.nanoTime();

        // Score the different tile placements - messages for debugging
        Shape shape;
        if (myPlayer.isGreen()) {
            shape = game.getGreenShapes().getFirst();
            System.out.print("\nAlphaBeta Green Bot, Depth: " + lookahead);
        } else {
            shape = game.getRedShapes().getFirst();
            System.out.print("\nAlphaBeta Red Bot, Depth: " + lookahead);
        }
        LinkedList<Tile> possibleMoves = game.generatePossibleMoves(shape);
        Tile bestMove = possibleMoves.getFirst();
        int maxScore = -9999;

        for (Tile tile : possibleMoves) {
            BoardState node = new BoardState(game);
            node.addTile(tile);

            int tileScore = AlphaBeta.start(node, lookahead - 1, this.myPlayer, true, -9999, 9999);

            if (tileScore > maxScore) {
                bestMove = tile;
                maxScore = tileScore;
            }
        }

        long timeElapsed = System.nanoTime() - startTime;

        System.out.println("\nTIME ELAPSED: " + TimeUnit.NANOSECONDS.toMillis(timeElapsed)
                + "ms, MAX SCORE: " + maxScore + ", FINAL CHOICE: " + bestMove);
        return bestMove;
    }


}
