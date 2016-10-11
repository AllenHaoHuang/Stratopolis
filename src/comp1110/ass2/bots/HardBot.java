package comp1110.ass2.bots;

import comp1110.ass2.logic.Shape;
import comp1110.ass2.logic.Tile;
import comp1110.ass2.logic.BoardState;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * `HardBot` is a bot that will use Alpha-Beta pruning with
 * a given lookahead to play the most desirable move.
 *
 * @author Allen Huang - u6096857
 * @author William Shen - u6096655
 */
public class HardBot extends Bot {
    private int lookahead;

    // Constructor using superclass and set lookahead
    public HardBot(BoardState parentGame, boolean isGreenPlayer, int lookahead) {
        super(parentGame, isGreenPlayer);
        this.lookahead = lookahead;
    }

    public Tile getMove() {
        // We want to show how long the bot took to think
        long startTime = System.nanoTime();

        // Get the relevant shape and output console message
        Shape shape;
        if (myPlayer.isGreen()) {
            shape = game.getGreenShapes().getFirst();
            System.out.print("\nAlphaBeta Green Bot, Depth: " + lookahead);
        } else {
            shape = game.getRedShapes().getFirst();
            System.out.print("\nAlphaBeta Red Bot, Depth: " + lookahead);
        }

        // Generate the potential moves the bot can place, then loop through them and evaluate
        LinkedList<Tile> possibleMoves = game.generatePossibleMoves(shape);
        Tile bestMove = possibleMoves.getFirst();
        double maxScore = -9999;

        for (Tile tile : possibleMoves) {
            // Create a board state with the current tile added
            BoardState node = new BoardState(game);
            node.addTile(tile);
            // Get the score for the board and update the bestMove and maxScore accordingly
            double tileScore = AlphaBeta.start(node, lookahead, lookahead - 1, this.myPlayer, false, -9999, 9999);
            if (tileScore > maxScore) {
                bestMove = tile;
                maxScore = tileScore;
            }
        }

        // Calculate how many milliseconds have elapsed and output console message
        System.out.println("\nTIME ELAPSED: " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime)
                + "ms, MAX SCORE: " + maxScore + ", FINAL CHOICE: " + bestMove);
        return bestMove;
    }
}
