package comp1110.ass2.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BoardState {
    // Constants
    private static final int BOARD_SIZE = 26;
    private static final int PLAYABLE_TILES = 20;

    // Object fields
    private int[][] heightArray = new int[BOARD_SIZE][BOARD_SIZE];
    private Colour[][] colourArray = new Colour[BOARD_SIZE][BOARD_SIZE];
    private int[][] pieceIDArray = new int[BOARD_SIZE][BOARD_SIZE];
    private boolean[][] possiblePosArray = new boolean[BOARD_SIZE][BOARD_SIZE];
    private LinkedList<Shape> greenShapeLinkedList = new LinkedList<>();
    private LinkedList<Shape> redShapeLinkedList = new LinkedList<>();
    private boolean isGreen;

    private int pieceID = 1;
    private String placementString = "MMUA";

    /* Constructor for BoardState, we create a board with 'MMUA' initially */
    public BoardState() {
        // Fill up shapes array for red and green
        int position = 0;

        Shape[] playableShapes = new Shape[PLAYABLE_TILES*2];
        for (Shape s : Shape.values()) {
            if (s != Shape.NULL && s !=Shape.U) {
                playableShapes[position] = s;
                playableShapes[position+1] = s;
                position+=2;
            }
        }

        for (int i=0; i<PLAYABLE_TILES; i++) {
            greenShapeLinkedList.add(playableShapes[i]);
        }
        for (int i=PLAYABLE_TILES; i<2*PLAYABLE_TILES; i++) {
            redShapeLinkedList.add(playableShapes[i]);
        }

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

    // A tile must obey all the rules for it to be valid
    public boolean isTileValid(Tile tile) {
        return (tile.isOnBoard() &&
                isAdjacent(tile) &&
                areColoursValid(tile) &&
                areHeightsValid(tile) &&
                isOverTwoTiles(tile));
    }

    // All the get functions for the private variables of boardstate
    public int[][] getHeightArray() {return heightArray;}
    public Colour[][] getColourArray() {return colourArray;}
    public boolean[][] getPossiblePosArray() {
        return possiblePosArray;
    }
    public LinkedList<Shape> getGreenShapeLinkedList() {return greenShapeLinkedList;}
    public LinkedList<Shape> getRedShapeLinkedList() {return redShapeLinkedList;}
    public boolean getIsGreen() {return isGreen;}

    // Modified function to get green playable shapes array so there is no repeats
    public Shape[] getPlayableGreenShapes() {
        ArrayList<Shape> shapeArrayList = new ArrayList<>();
        for (Shape s : greenShapeLinkedList) {
            if (s!=Shape.NULL && !(shapeArrayList.contains(s))) {
                shapeArrayList.add(s);
            }
        }
        return (shapeArrayList.toArray(new Shape[shapeArrayList.size()]));
    }

    // Modified function to get red playable shapes array so there is no repeats
    public Shape[] getPlayableRedShapes() {
        ArrayList<Shape> shapeArrayList = new ArrayList<>();
        for (Shape s : redShapeLinkedList) {
            if (s!=Shape.NULL && !(shapeArrayList.contains(s))) {
                shapeArrayList.add(s);
            }
        }
        return (shapeArrayList.toArray(new Shape[shapeArrayList.size()]));
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
        // If green, remove tile from green linked list
        if (isGreen) {
            for (Shape s : greenShapeLinkedList) {
                if (s == tile.getShape()) {
                    greenShapeLinkedList.removeFirstOccurrence(s);
                    break;
                }
            }
        } else {
            for (Shape s : redShapeLinkedList) {
                if (s == tile.getShape()) {
                    redShapeLinkedList.removeFirstOccurrence(s);
                    break;
                }
            }
        }
        // changes the boolean identifying the player's turn
        if (isGreen) {
            isGreen = false;
        } else {
            isGreen = true;
        }
        // Update positions to check
        updatePositionsToCheck();
    }

    // Get the height at a certain cell on our board
    public int getHeight(char x, char y) {
        return heightArray[x - 'A'][y - 'A'];
    }

    // Get the score of a player at the current board status
    public int getScore(boolean isGreen) { return Score.getScore(this, isGreen); }

    // Get the placement string
    public String getPlacementString() { return placementString; }

    // Positions to check
    public void updatePositionsToCheck() {
        // Firstly makes a 2-D boolean array that is true for a position if that positions height
        // is larger than 0 or is adjacent to a position of height larger than 0
        for (int i=0; i<BOARD_SIZE; i++) {
            for (int j=0; j<BOARD_SIZE; j++) {
                if (heightArray[i][j] > 0) {
                    possiblePosArray[i][j] = true;

                    if (i%BOARD_SIZE == 0) {
                        possiblePosArray[i+1][j] = true;
                        possiblePosArray[i][j+1] = true;
                        possiblePosArray[i][j-1] = true;
                    } else if (i%BOARD_SIZE == BOARD_SIZE-1) {
                        possiblePosArray[i-1][j] = true;
                        possiblePosArray[i][j+1] = true;
                        possiblePosArray[i][j-1] = true;
                    } else if (j%BOARD_SIZE == 0) {
                        possiblePosArray[i-1][j] = true;
                        possiblePosArray[i+1][j] = true;
                        possiblePosArray[i][j+1] = true;
                    } else if (j%BOARD_SIZE == BOARD_SIZE-1) {
                        possiblePosArray[i-1][j] = true;
                        possiblePosArray[i+1][j] = true;
                        possiblePosArray[i][j-1] = true;
                    } else {
                        possiblePosArray[i+1][j] = true;
                        possiblePosArray[i-1][j] = true;
                        possiblePosArray[i][j+1] = true;
                        possiblePosArray[i][j-1] = true;
                    }
                }
            }
        }
    }
}
