package comp1110.ass2.logic;


import java.util.TreeSet;

/**
 * `Score` allows us to score board states for the
 * green player and red player
 *
 * @author Marvin Yang - u5894100
 * @author William Shen - u6096655
 */
public class Score {
    // Class Variables
    private int maxArea = 0;
    private int maxHeight = 0;
    // Stores unique areas in descending order for tie situations
    private TreeSet<Integer> prevArea;

    // Helper variables to calculate score
    private static final int GRID_SIZE = 26;
    private static Colour[][] colourArray = new Colour[GRID_SIZE][GRID_SIZE];
    private static int[][] heightArray = new int[GRID_SIZE][GRID_SIZE];
    private static int exploreHeight = 0;
    private static Colour searchColour;

    public Score(BoardState board, boolean isGreen) {
        // Initialise the arrays and variables
        colourArray = board.getColourArray();
        heightArray = board.getHeightArray();

        // Set the search colour
        if (isGreen) searchColour = Colour.Green;
        else searchColour = Colour.Red;

        // Loop through the board, only search on cells that correspond to the player
        for (int i = 0; i < GRID_SIZE; i++){
            for (int j = 0; j < GRID_SIZE; j++){
                if (colourArray[i][j] == searchColour) {
                    int exploreArea = explore_board(i, j);
                    // Update max area and max height if there is a bigger region
                    if (exploreArea > maxArea) {
                        maxArea = exploreArea;
                        maxHeight = exploreHeight;
                    } else if (exploreArea == maxArea) {
                        // If region of equal size get the bigger height
                        if (exploreHeight > maxHeight) maxHeight = exploreHeight;
                    }
                    // Reset the height for the next cell search
                    exploreHeight = 0;
                }
            }
        }
    }

    /* Used for End Game State to prevent unnecessary use of TreeSet when getting score in normal state */
    public Score(BoardState board, Colour player) {
        // Initialise the arrays and variables
        prevArea = new TreeSet<>((i1, i2) -> i2.compareTo(i1));
        colourArray = board.getColourArray();
        heightArray = board.getHeightArray();

        // Set the search colour
        if (player.isGreen()) searchColour = Colour.Green;
        else searchColour = Colour.Red;

        // Loop through the board, only search on cells that correspond to the player
        for (int i = 0; i < GRID_SIZE; i++){
            for (int j = 0; j < GRID_SIZE; j++){
                if (colourArray[i][j] == searchColour) {
                    int exploreArea = explore_board(i, j);
                    // Add searched area to the previous unique areas
                    prevArea.add(exploreArea);
                    // Update max area and max height if there is a bigger region
                    if (exploreArea > maxArea) {
                        maxArea = exploreArea;
                        maxHeight = exploreHeight;
                    } else if (exploreArea == maxArea) {
                        // If region of equal size get the bigger height
                        if (exploreHeight > maxHeight) maxHeight = exploreHeight;
                    }
                    // Reset the height for the next cell search
                    exploreHeight = 0;
                }
            }
        }
    }


    /* This function relies on recursion to explore the surrounding cells */
    private int explore_board(int x, int y) {
        // Once we read a cell set it to black so it cannot be read again
        int area = 1;
        colourArray[x][y] = Colour.Black;

        // Finding the maximum height of a connected region
        if (heightArray[x][y] > exploreHeight)
            exploreHeight = heightArray[x][y];

        // Search and explore the cells surrounding our current one
        if (x > 0 && colourArray[x-1][y] == searchColour)
            area += explore_board(x-1, y);
        if (x < 25 && colourArray[x+1][y] == searchColour)
            area += explore_board(x+1, y);
        if (y > 0 && colourArray[x][y-1] == searchColour)
            area += explore_board(x, y-1);
        if (y < 25 && colourArray[x][y+1] == searchColour)
            area += explore_board(x, y+1);
        return area;
    }

    public int getScore() { return maxArea * maxHeight; }
    public TreeSet<Integer> getPrevArea() { return prevArea; }
}

