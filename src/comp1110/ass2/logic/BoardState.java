package comp1110.ass2.logic;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedList;

/**
 * `BoardState` allows us initiate objects that
 * hold the entire board state. We can add tiles,
 * check if tiles are valid, etc. to the board
 *
 * @author Allen Huang - u6096857
 * @author William Shen - u6096655
 * @author Marvin Yang - u5894100
 */
public class BoardState{
    // Constants
    private static final int BOARD_SIZE = 26;

    // Object fields
    private int[][] heightArray = new int[BOARD_SIZE][BOARD_SIZE];
    private Colour[][] colourArray = new Colour[BOARD_SIZE][BOARD_SIZE];
    private int[][] pieceIDArray = new int[BOARD_SIZE][BOARD_SIZE];
    private boolean[][] possiblePosArray = new boolean[BOARD_SIZE][BOARD_SIZE];
    private int pieceID = 1;
    private String placementString = "MMUA";

    // Holding the pieces
    private LinkedList<Shape> greenShapes = new LinkedList<>();
    private LinkedList<Shape> redShapes = new LinkedList<>();
    private Colour playerTurn = Colour.Green;

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
        updatePositionsAround(12,12);
        updatePositionsAround(12,13);
    }

    /* Constructor for Board State given a valid placement string */
    public BoardState(String placement) {
        // Run constructor above to set up object
        this();
        // Loop through placement string excluding "MMUA"
        for (int i = 4; i < placement.length(); i += 4) {
            // Create a new tile from the placement string
            Tile substringTile = new Tile(new Position(placement.charAt(i), placement.charAt(i + 1)),
                    Shape.fromChar(placement.charAt(i + 2)),
                    Orientation.fromChar(placement.charAt(i + 3)));
            this.addTile(substringTile);
        }
    }

    /* Constructor for Board State given an old state - i.e. makes a copy */
    public BoardState(BoardState oldState) {
        this(oldState.getPlacementString());
        this.greenShapes = (LinkedList<Shape>) oldState.getGreenShapes().clone();
        this.redShapes = (LinkedList<Shape>) oldState.getRedShapes().clone();
        this.playerTurn = Colour.getValue(playerTurn);
    }

    // Initialise the 'deck' of tiles (shapes) for the players and shuffle them
    public void createPlayerPieces() {
        for (Shape i : EnumSet.range(Shape.A, Shape.J)) {
            redShapes.add(i);
            redShapes.add(i);
        }
        for (Shape i : EnumSet.range(Shape.K, Shape.T)) {
            greenShapes.add(i);
            greenShapes.add(i);
        }
        Collections.shuffle(greenShapes);
        Collections.shuffle(redShapes);
    }

    // Get the linked list containing the pieces of a player
    public LinkedList<Shape> getShapes(Colour colour) {
        if (colour == Colour.Green)
            return greenShapes;
        else
            return redShapes;
    }

    public LinkedList<Shape> getGreenShapes() { return greenShapes; }
    public LinkedList<Shape> getRedShapes() { return redShapes; }

    // Return whose turn it is in colours
    public Colour getPlayerTurn() { return playerTurn; }

    // Return if its green player's turn or red player's turn
    public boolean isGreenTurn() { return playerTurn == Colour.Green; }
    public boolean isRedTurn() { return playerTurn == Colour.Red; }

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
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                newColourArray[i][j] = colourArray[i][j];
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
        // Update positions to check
        updatePositionsToCheck(tile);
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

        playerTurn = playerTurn.nextPlayer();
    }

    // Get the height at a certain cell on our board
    public int getHeight(char x, char y) {
        return heightArray[x - 'A'][y - 'A'];
    }

    // Get the score of a player at the current board status
    public int getScore(boolean isGreen) {
        return new Score(this, isGreen).getScore();
    }

    // Get the score based off a colour
    public int getScore(Colour player) {
        if (player == Colour.Green)
            return new Score(this, true).getScore();
        else
            return new Score(this, false).getScore();
    }

    // Get the placement string
    public String getPlacementString() {
        return placementString;
    }

    /* Given some tile, changes the possible positions array so that all positions directly next
     * a tile is changed to true
     */
    public void updatePositionsToCheck(Tile tile) {
        int xCoord = tile.getX(0);
        int yCoord = tile.getY(0);

        if (heightArray[xCoord][yCoord] == 0) {
            possiblePosArray[xCoord][yCoord] = true;
            updatePositionsAround(xCoord, yCoord);
            updatePositionsAround(tile.getX(1), tile.getY(1));
            updatePositionsAround(tile.getX(2), tile.getY(2));
        }
    }

    // For each part of a tile, update the positions directly around that tile for the possible positions array
    public void updatePositionsAround(int x, int y) {
        boolean notOnLeft = (x % BOARD_SIZE != 0);
        boolean notOnRight = (x % BOARD_SIZE != BOARD_SIZE - 1);
        boolean notOnTop = (y % BOARD_SIZE != 0);
        boolean notOnBottom = (y % BOARD_SIZE != BOARD_SIZE - 1);

        if (notOnLeft) possiblePosArray[x-1][y] = true;
        if (notOnRight) possiblePosArray[x+1][y] = true;
        if (notOnTop) possiblePosArray[x][y-1] = true;
        if (notOnBottom) possiblePosArray[x][y+1] = true;
        if (notOnLeft && notOnTop) possiblePosArray[x-1][y-1] = true;
        if (notOnLeft && notOnBottom) possiblePosArray[x-1][y+1] = true;
        if (notOnRight && notOnTop) possiblePosArray[x+1][y-1] = true;
        if (notOnRight && notOnBottom) possiblePosArray[x+1][y+1] = true;
    }

    // Generate possible moves for a given shape and the current board state
    public LinkedList<Tile> generatePossibleMoves(Shape shape) {
        LinkedList<Tile> tileList = new LinkedList<>();
        // Loop through board grid
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                // Check if it is possible to place piece
                if (possiblePosArray[i][j]) {
                    for (Orientation orientation : Orientation.values()) {
                        Tile newTile = new Tile(new Position(i,j), shape, orientation);
                        if (this.isTileValid(newTile)) tileList.add(newTile);
                    }
                }
            }
        }
        return tileList;
    }

    // Function that removes a some tile from the tile list
    public void removeTile (Tile tile) {
        if (playerTurn == Colour.Green) {
            greenShapes.removeFirstOccurrence(tile.getShape());
        } else {
            redShapes.removeFirstOccurrence(tile.getShape());
        }
    }

    // Check if game is finished - i.e. either players have no pieces left
    public boolean isFinished() {
        return (getRedShapes().isEmpty() || getGreenShapes().isEmpty());
    }
}
