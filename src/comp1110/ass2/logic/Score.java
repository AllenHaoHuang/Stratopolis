package comp1110.ass2.logic;

/**
 * Created by Allen Huang on 15/08/2016.
 * Edited by Marvin and William on 15/08/2016.
 */

public class Score {
    // Find the number of the largest valid area achieved
    private static int getLargestArea(BoardState board, boolean isGreen) {
        return 1;
    }

    // Finds the maximum height on the board
    private static int maximumHeight(BoardState board, boolean isGreen){
        return 1;
    }

    // Calculates Score for given player
    public static int getScore(BoardState board, boolean isGreen) {
        return getLargestArea(board, isGreen) * maximumHeight(board, isGreen);
    }

    // Checks whether the game is finished or not
    public static boolean gameFinished(String board) {
        return true;
    }
}





