package comp1110.ass2.logic;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedList;

public class BoardState {
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

        updatePositionsToCheck();
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
        updatePositionsToCheck();
    }

    /* Constructor for Board State given an old state - i.e. makes a copy*/
    public BoardState(BoardState oldState) {
        this(oldState.getPlacementString());
        // Ignore the warnings, linked lists can be cast (I hope...)
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

    public LinkedList<Shape> getGreenShapes() { return greenShapes; }
    public LinkedList<Shape> getRedShapes() { return redShapes; }

    public void removeGreenShape() { greenShapes.removeFirst(); }
    public void removeRedShape() { redShapes.removeFirst(); }

    // Return whose turn it is in colours
    public Colour getPlayerTurn() {
        return playerTurn;
    }

    // Return if its green player's turn
    public boolean isGreenTurn() {
        return playerTurn == Colour.Green;
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
    public int[][] getHeightArray() {
        int[][] newHeightArray = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                newHeightArray[i][j] = heightArray[i][j];
        return newHeightArray;
    }

    public Colour[][] getColourArray() {
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
        // Update positions to check
        updatePositionsToCheck();
        // Invert player turn
        playerTurn = playerTurn.nextPlayer();
    }

    // Get the height at a certain cell on our board
    public int getHeight(char x, char y) {
        return heightArray[x - 'A'][y - 'A'];
    }

    // Get the score of a player at the current board status
    public int getScore(boolean isGreen) {
        return Score.getScore(this, isGreen);
    }

    // Get the score based off a colour
    public int getScore(Colour player) {
        if (player == Colour.Green) return Score.getScore(this, true);
        else return Score.getScore(this, false);
    }

    // Get the placement string
    public String getPlacementString() {
        return placementString;
    }

    // Returns arrays on which positions to check
    public boolean[][] getPossiblePosArray() {
        return possiblePosArray;
    }

    // Positions to check
    public void updatePositionsToCheck() {
        // Firstly makes a 2-D boolean array that is true for a position if that positions height
        // is larger than 0 or is adjacent to a position of height larger than 0
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (heightArray[i][j] > 0) {
                    possiblePosArray[i][j] = true;

                    if (i % BOARD_SIZE == 0 && j % BOARD_SIZE == 0) {
                        possiblePosArray[i + 1][j] = true;
                        possiblePosArray[i][j + 1] = true;
                    } else if (i % BOARD_SIZE == 0 && j % BOARD_SIZE == BOARD_SIZE - 1) {
                        possiblePosArray[i + 1][j] = true;
                        possiblePosArray[i - 1][j] = true;
                    } else if (i % BOARD_SIZE == BOARD_SIZE - 1 && j % BOARD_SIZE == 0) {
                        possiblePosArray[i - 1][j] = true;
                        possiblePosArray[i + 1][j] = true;
                    } else if (i % BOARD_SIZE == BOARD_SIZE - 1 && j % BOARD_SIZE == BOARD_SIZE - 1) {
                        possiblePosArray[i - 1][j] = true;
                        possiblePosArray[i - 1][j] = true;
                    } else if (i % BOARD_SIZE == 0) {
                        possiblePosArray[i + 1][j] = true;
                        possiblePosArray[i][j + 1] = true;
                        possiblePosArray[i][j - 1] = true;
                    } else if (i % BOARD_SIZE == BOARD_SIZE - 1) {
                        possiblePosArray[i - 1][j] = true;
                        possiblePosArray[i][j + 1] = true;
                        possiblePosArray[i][j - 1] = true;
                    } else if (j % BOARD_SIZE == 0) {
                        possiblePosArray[i - 1][j] = true;
                        possiblePosArray[i + 1][j] = true;
                        possiblePosArray[i][j + 1] = true;
                    } else if (j % BOARD_SIZE == BOARD_SIZE - 1) {
                        possiblePosArray[i - 1][j] = true;
                        possiblePosArray[i + 1][j] = true;
                        possiblePosArray[i][j - 1] = true;
                    } else {
                        possiblePosArray[i + 1][j] = true;
                        possiblePosArray[i - 1][j] = true;
                        possiblePosArray[i][j + 1] = true;
                        possiblePosArray[i][j - 1] = true;
                    }
                }
            }
        }
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
}
