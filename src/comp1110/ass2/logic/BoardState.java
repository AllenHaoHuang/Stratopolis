package comp1110.ass2.logic;

import java.util.Arrays;

public class BoardState {
    // Constants
    private static final int BOARD_SIZE = 26;

    // Object fields
    private int[][] heightArray = new int[BOARD_SIZE][BOARD_SIZE];
    private Colour[][] colourArray = new Colour[BOARD_SIZE][BOARD_SIZE];
    private int[][] pieceIDArray = new int[BOARD_SIZE][BOARD_SIZE];
    private int pieceID = 1;
    private String placementString = "MMUA";

    /* Constructor for BoardState, we create a board with 'MMUA' initially */
    public BoardState() {
        // Fill the colour array with all black
        for (Colour[] row : colourArray)
            Arrays.fill(row, Colour.Black);
        // Account for 'MMUA' piece
        heightArray[12][12]++;
        heightArray[12][13]++;
        colourArray[12][12] = Colour.Red;
        colourArray[12][13] = Colour.Green;
        pieceIDArray[12][12] = pieceID;
        pieceIDArray[12][13] = pieceID++;
    }

    // A tile must obey all the rules for it to be valid
    public boolean isTileValid(Tile tile) {
        return (tile.isOnBoard() &&
                isAdjacent(tile) &&
                areColoursValid(tile) &&
                areHeightsValid(tile) &&
                isOverTwoTiles(tile));
    }

    // Returning a copy of the height and colour array for scoring
    int[][] getHeightArray() {
        int[][] newHeightArray = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                newHeightArray[i][j] = heightArray[i][j];
        return newHeightArray;
    }
    Colour[][] getColourArray() {
        Colour[][] newColourArray = new Colour[BOARD_SIZE][BOARD_SIZE];
        for(int i = 0; i < BOARD_SIZE; i++)
            for(int j = 0; j < BOARD_SIZE; j++)
                newColourArray[i][j]=colourArray[i][j];
        return newColourArray;
    }

    // Check that the tile is adjacent to another tile by checking the height neighbouring cells
    private boolean isAdjacent(Tile tile) {
        int x = tile.getX(0);
        int y = tile.getY(0);
        switch (tile.getOrientation()) {
            case A:
                return (!(x - 1 < 0) && heightArray[x - 1][y] > 0 ||
                        !(x + 2 > 25) && heightArray[x + 2][y] > 0 ||
                        !(y - 1 < 0) && heightArray[x][y - 1] > 0 ||
                        !(x + 1 > 25) && !(y - 1 < 0) && heightArray[x + 1][y - 1] > 0 ||
                        !(x - 1 < 0) && !(y + 1 > 25) && heightArray[x - 1][y + 1] > 0 ||
                        !(x + 1 > 25) && !(y + 1 > 25) && heightArray[x + 1][y + 1] > 0 ||
                        !(y + 2 > 25) && heightArray[x][y + 2] > 0);
            case B:
                return (!(x - 2 < 0) && heightArray[x - 2][y] > 0 ||
                        !(x + 1 > 25) && heightArray[x + 1][y] > 0 ||
                        !(y - 1 < 0) && heightArray[x][y - 1] > 0 ||
                        !(x - 1 < 0) && !(y - 1 < 0) && heightArray[x - 1][y - 1] > 0 ||
                        !(x - 1 < 0) && !(y + 1 > 25) && heightArray[x - 1][y + 1] > 0 ||
                        !(x + 1 > 25) && !(y + 1 > 25) && heightArray[x + 1][y + 1] > 0 ||
                        !(y + 2 > 25) && heightArray[x][y + 2] > 0);
            case C:
                return (!(x + 1 > 25) && heightArray[x + 1][y] > 0 ||
                        !(x - 2 < 0) && heightArray[x - 2][y] > 0 ||
                        !(x + 1 > 25) && !(y - 1 < 0) && heightArray[x + 1][y - 1] > 0 ||
                        !(x - 1 < 0) && !(y - 1 < 0) && heightArray[x - 1][y - 1] > 0 ||
                        !(y + 1 > 25) && heightArray[x][y + 1] > 0 ||
                        !(x - 1 < 0) && !(y + 1 > 25) && heightArray[x - 1][y + 1] > 0 ||
                        !(y - 2 < 0) && heightArray[x][y - 2] > 0);
            case D:
                return (!(x - 1 < 0) && heightArray[x - 1][y] > 0 ||
                        !(x + 2 > 25) && heightArray[x + 2][y] > 0 ||
                        !(x - 1 < 0) && !(y - 1 < 0) && heightArray[x - 1][y - 1] > 0 ||
                        !(x + 1 > 25) && !(y - 1 < 0) && heightArray[x + 1][y - 1] > 0 ||
                        !(y + 1 > 25) && heightArray[x][y + 1] > 0 ||
                        !(x + 1 > 25) && !(y + 1 > 25) && heightArray[x + 1][y + 1] > 0 ||
                        !(y - 2 < 0) && heightArray[x][y - 2] > 0);
            default:
                return false;
        }
    }

    // We check if the tile follows the colour rules
    private boolean areColoursValid(Tile tile) {
        Colour colour0 = tile.getShape().colourAtIndex(0);
        Colour colour1 = tile.getShape().colourAtIndex(1);
        Colour colour2 = tile.getShape().colourAtIndex(2);
        return (isColourValidOnTile(tile.getX(0), tile.getY(0), colour0) &&
                isColourValidOnTile(tile.getX(1), tile.getY(1), colour1) &&
                isColourValidOnTile(tile.getX(2), tile.getY(2), colour2));
    }

    // Helper function for `areColoursValid`
    private boolean isColourValidOnTile(int x, int y, Colour colour) {
        switch (colour) {
            case Black:
                return true;
            case Green:
                return (!(colourArray[x][y] == Colour.Red));
            case Red:
                return (!(colourArray[x][y] == Colour.Green));
            default:
                return false;
        }
    }

    // The heights must be equal for a tile placement to be valid
    private boolean areHeightsValid(Tile tile) {
        return (heightArray[tile.getX(0)][tile.getY(0)] == heightArray[tile.getX(1)][tile.getY(1)] &&
                heightArray[tile.getX(0)][tile.getY(0)] == heightArray[tile.getX(2)][tile.getY(2)]);
    }

    // If a tile is placed over others, it must straddle at least two tiles
    private boolean isOverTwoTiles(Tile tile) {
        return (heightArray[tile.getX(0)][tile.getY(0)] == 0 ||
                !(pieceIDArray[tile.getX(0)][tile.getY(0)] == pieceIDArray[tile.getX(1)][tile.getY(1)] &&
                        pieceIDArray[tile.getX(1)][tile.getY(1)] == pieceIDArray[tile.getX(2)][tile.getY(2)]));
    }

    /* Add a tile to the board state, we assume valid tile input */
    public void addTile(Tile tile) {
        // Update Board Colours
        colourArray[tile.getX(0)][tile.getY(0)] = tile.getShape().colourAtIndex(0);
        colourArray[tile.getX(1)][tile.getY(1)] = tile.getShape().colourAtIndex(1);
        colourArray[tile.getX(2)][tile.getY(2)] = tile.getShape().colourAtIndex(2);
        // Update height at board cells
        heightArray[tile.getX(0)][tile.getY(0)]++;
        heightArray[tile.getX(1)][tile.getY(1)]++;
        heightArray[tile.getX(2)][tile.getY(2)]++;
        // Update the piece identifier array
        pieceIDArray[tile.getX(0)][tile.getY(0)] = pieceID;
        pieceIDArray[tile.getX(1)][tile.getY(1)] = pieceID;
        pieceIDArray[tile.getX(2)][tile.getY(2)] = pieceID++;
        // Update placement string
        placementString += tile.toString();
    }

    // Get the height at a certain cell on our board
    public int getHeight(char x, char y) {
        return heightArray[x - 'A'][y - 'A'];
    }

    // Get the score of a player at the current board status
    public int getScore(boolean isGreen) { return Score.getScore(this, isGreen); }

    // Get the placement string
    public String getPlacementString() { return placementString; }
}
