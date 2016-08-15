package comp1110.ass2.logic;

/**
 * Created by Allen Huang on 15/08/2016.
 */

public class Score {
    // FIXME Marvin to do this: Logic for evaluating score of board
    private String board;
    //check whether the game is end
    public boolean checkEnd () {
        return true;
    }

    //find the number of the largest area achieved by either red or green
    public int getLargestArea (String board) {
       return 0;
    }

    public int getHeight (String board){
        return 0;
    }

    public int Score (String board) {
        int a = getLargestArea(board);
        int b = getHeight(board);
        return  a*b;
    }

}



    /* We basically take in a board (which is a string), and do all the fancy logic
     * to calculate the score.
     * We know the colour of the shapes from the 'Tile' enum class, anything across the package is accessible
     */

