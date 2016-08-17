package comp1110.ass2.logic;

/**
 * Created by Allen Huang on 15/08/2016.
 * Edited by Marvin and William on 15/08/2016.
 */

public class Score {
    // Find the number of the largest valid area achieved
    private static int getLargestArea(String board, Colour player) {
        return 1;
    }

    // Finds the maximum height on the board
    private static int maximumHeight(String board, Colour player){
        return 1;
    }

    // Calculates Score for given player
    public static int getScore(String board, Colour player) {
        return getLargestArea(board, player) * maximumHeight(board, player);
    }

    // Checks whether the game is finished or not
    public static boolean gameFinished(String board) {
        return true;
    }
}





