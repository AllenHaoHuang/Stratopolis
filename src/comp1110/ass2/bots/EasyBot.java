package comp1110.ass2.bots;

import comp1110.ass2.logic.*;

import java.util.LinkedList;

/**
 * `EasyBot` is a bot that will play the highest scoring
 * move, with a preference towards the top-left of the board
 *
 * @author William Shen - u6096655
 */
public class EasyBot extends Bot {
    // Constructors using that of the superclass 'Bot'
    public EasyBot(BoardState parentGame, boolean isGreenPlayer) {
        super(parentGame, isGreenPlayer);
    }

    @Override
    public Tile getMove() {
        // Set up console message and get the relevant shape
        Shape shape;
        if (myPlayer.isGreen()) {
            System.out.print("\nEasy Green Bot, ");
            shape = game.getGreenShapes().getFirst();
        } else {
            System.out.print("\nEasy Red Bot, ");
            shape = game.getRedShapes().getFirst();
        }

        // Generate the potential moves the bot can place, then loop through them and evaluate
        LinkedList<Tile> possibleMoves = game.generatePossibleMoves(shape);
        Tile bestMove = possibleMoves.getFirst();
        int maxScore = -9999;

        for (Tile tile : possibleMoves) {
            // Create a board state with the current tile added
            BoardState gameCopy = new BoardState(game);
            gameCopy.addTile(tile);
            // Get the score for the board and update the bestMove and maxScore accordingly
            int tileScore = gameCopy.getScore(myPlayer);
            if (tileScore > maxScore) {
                bestMove = tile;
                maxScore = tileScore;
            }
        }

        // Print console message and return the best move
        System.out.println("MAX SCORE: " + maxScore + ", FINAL CHOICE: " + bestMove);
        return bestMove;
    }
}
