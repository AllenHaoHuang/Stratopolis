package comp1110.ass2;

import comp1110.ass2.logic.*;

import java.util.Arrays;

/**
 * This class provides the text interface for the Strato Game
 *
 * The game is based directly on Gigamic's Stratopolis game
 * (http://boardgamegeek.com/boardgame/125022/stratopolis)
 */
public class StratoGame {
    
    private static final int TILE_PLACEMENT_LENGTH = 4;
    private static final int MAX_TILE_PLACEMENTS = 41;
    private static final int BOARD_SIZE = 26;

    /**
     * Determine whether a tile placement is well-formed according to the following:
     * - it consists of exactly four characters
     * - the first character is in the range A .. Z
     * - the second character is in the range A .. Z
     * - the third character is in the range A .. U
     * - the fourth character is in the range A .. D
     *
     * @param tilePlacement A string describing a tile placement
     * @return True if the tile placement is well-formed
     */
    static boolean isTilePlacementWellFormed(String tilePlacement) {
        // Return false if length of string does not equal 4
        if (tilePlacement.length() != TILE_PLACEMENT_LENGTH)
            return false;

        // Read in characters at their positions in the string
        char c1 = tilePlacement.charAt(0);
        char c2 = tilePlacement.charAt(1);
        char c3 = tilePlacement.charAt(2);
        char c4 = tilePlacement.charAt(3);

        // Compare the characters to the relevant conditions and return
        return (c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z' &&
                c3 >= 'A' && c3 <= 'U' && c4 >= 'A' && c4 <= 'D');
    }

    /**
     * Determine whether a placement string is well-formed:
     *  - it consists of exactly N four-character tile placements (where N = 1 .. 41)
     *  - each tile placement is well-formed
     *  - the first tile placement is 'MMUA'
     *  - the second tile placement (if any) is for a green tile
     *  - remaining tile placements alternate between red and green
     *  - no tile appears more than twice in the placement
     *
     * @param placement A string describing a placement of one or more tiles
     * @return True if the placement is well-formed
     */
    static boolean isPlacementWellFormed(String placement) {
        // We check the placement string length is a multiple of 4, is non-empty, and contains a maximum of 41
        if (placement.length() % TILE_PLACEMENT_LENGTH != 0 ||
            placement.length() == 0 ||
            placement.length() > TILE_PLACEMENT_LENGTH * MAX_TILE_PLACEMENTS) {
            return false;
        }

        // i is our index in the string. We check that the first tile placement is 'MMUA'
        if (!placement.substring(0, 3).equals("MMUA")) {
            return false;
        }

        // The flag used to indicate which player's piece we expect next
        boolean isGreen = true;

        /** The array used to store the count of pieces. Recall that the characters 'A' to 'T'
         *  represent the Green and Red Player's Pieces. This means there are 20 pieces.
         *  We initialise the array to 2, as we subtract 1 each time we encounter a piece.
         *  Therefore, if we encounter a 0 as an element, we know there have been 2 pieces
         *  of a same type already.
         *  Index 0 refers to 'A', 1 refers to 'B', ... , 19 refers to 'T'
         */
        int[] letterCount = new int[20];
        Arrays.fill(letterCount, 2);

        // Here we loop through the placement string excluding the first tile placement
        for (int i = 4; i < placement.length(); i += TILE_PLACEMENT_LENGTH) {
            if (!isTilePlacementWellFormed(placement.substring(i, i+3)))
                return false;
            // The third character in a tile placement - i.e. the piece ID
            char pieceID = placement.charAt(i+2);
            if (isGreen) {
                // We check that the piece belongs to the Green Player
                if (!(pieceID >= 'K' && pieceID <= 'T')) return false;
                // We check if there have been 2 of the same pieces already
                if (letterCount[pieceID - 'A'] == 0) {
                    return false;
                } else {
                    letterCount[pieceID - 'A'] -= 1;
                }
                // Alternate players - now it's Red's turn
                isGreen = false;
            } else {
                // We check that the piece belongs to the Red Player
                if (!(pieceID >= 'A' && pieceID <= 'J')) return false;
                // We check if there have been 2 of the same pieces already
                if (letterCount[pieceID - 'A'] == 0) {
                    return false;
                } else {
                    letterCount[pieceID - 'A'] -= 1;
                }
                // Alternate players - now it is Green's turn
                isGreen = true;
            }
        }
        // The placement string passes all the tests
        return true;
    }

    /**
     * Determine whether a placement is valid.  To be valid, the placement must be well-formed
     * and each tile placement must follow the game's placement rules.
     *
     * @param placement A placement string
     * @return True if the placement is valid
     */
    static boolean isPlacementValid(String placement) {
        // FIXME Task 6: determine whether a placement is valid

        // We first check if the input Placement String is well-formed itself
        if (!isPlacementWellFormed(placement)) return false;

        /* Initialise the 2-dimensional array (which represents the board) to store the
         * maximum height of the stacked pieces (if any) to 0. */
        int[][] heightArray = new int[BOARD_SIZE][BOARD_SIZE];

        /* Initialise the 2-dimensional array (which represents the board) to the Black
         * tile colour. Recall, that Black is neutral - i.e. it can be stacked on top of
         * Red, Green and itself. */
        Colour[][] colourArray = new Colour[BOARD_SIZE][BOARD_SIZE];
        Arrays.fill(colourArray, Colour.Black);


        // Some for loop here to go over the placement string?
        Tile subStringTile = new Tile(new Position(placement.charAt(0), placement.charAt(1)),
                                      Shape.fromChar(placement.charAt(2)),
                                      Orientation.fromChar(placement.charAt(3)));


        // Only here for demonstration
        colourArray = updateBoardColours(subStringTile, colourArray);
        heightArray = updateBoardHeights(subStringTile, heightArray);
        Orientation or = Orientation.fromChar('A');
        Shape shp = Shape.fromChar('B');
        boolean meme = areHeightsValid(subStringTile, heightArray);
        // If all the above tests have failed
        return false;
    }

    /* THESE FUNCTIONS CAN BE MORE PRIVATE UNLESS WE NEED TO ACCESS THEM FROM THE OUTSIDE */

    /**
     *  Return the position of a specific cell of a Tile on the board.
     *  The 'A' orientation of a L-shaped tile based on 'index' is represented as:
     *     [0]  [1]
     *     [2]
     */
    static Position cellPosition (Tile tile, int index) {
        // Return the position of the origin cell if zero index is requested
        if (index == 0) return tile.getPosition();

        /* We retrieve the X and Y character coordinates of
           the origin index - i.e. at index = 0. */
        char originX = tile.getPosition().getX();
        char originY = tile.getPosition().getY();

        // Here, we check the Orientation of our tile and return the relevant Positions
        switch (tile.getOrientation()) {
            case A:
                if (index == 1) return new Position((char)(originX+1), originY);
                if (index == 2) return new Position(originX, (char)(originY+1));
            case B:
                if (index == 1) return new Position(originX, (char)(originY+1));
                if (index == 2) return new Position((char)(originX-1), originY);
            case C:
                if (index == 1) return new Position((char)(originX-1), originY);
                if (index == 2) return new Position(originX, (char)(originY-1));
            case D:
                if (index == 1) return new Position(originX, (char)(originY-1));
                if (index == 2) return new Position((char)(originX+1), originY);
        }

        // FIXME: Return something appropriate or create exception? We know that all input is valid
        return new Position('A','A');
    }

    // Given a tile and the board (array) of colours, change the colours
    static Colour[][] updateBoardColours(Tile tile, Colour[][] colourArray) {
        /* Get position coordinates for each of the 3 cells on our tile */
        Position index0 = cellPosition(tile, 0);
        Position index1 = cellPosition(tile, 1);
        Position index2 = cellPosition(tile, 2);

        /* Set the relevant cells in the colourArray to their corresponding cell
         * colours given their Shape ID, and return */
        colourArray[index0.getX()][index0.getY()]= tile.getShape().colourAtIndex(0);
        colourArray[index1.getX()][index1.getY()]= tile.getShape().colourAtIndex(1);
        colourArray[index2.getX()][index2.getY()]= tile.getShape().colourAtIndex(2);
        return colourArray;
    }

    // Given a tile and the board (array) of heights, increase the height
    static int[][] updateBoardHeights(Tile tile, int[][] heightArray) {
        /* Get position coordinates for each of the 3 cells on our tile */
        Position index0 = cellPosition(tile, 0);
        Position index1 = cellPosition(tile, 1);
        Position index2 = cellPosition(tile, 2);

        /* Increment the corresponding positions in the heightArray by 1 and return */
        heightArray[index0.getX()][index0.getY()]++;
        heightArray[index1.getX()][index1.getY()]++;
        heightArray[index2.getX()][index2.getY()]++;
        return heightArray;
    }

    /* Check if a placement is valid height-wise, i.e. the heights of each of the three cells are equal */
    static boolean areHeightsValid(Tile tile, int[][] heightArray) {
        /* Get position coordinates for each of the 3 cells on our tile */
        Position index0 = cellPosition(tile, 0);
        Position index1 = cellPosition(tile, 1);
        Position index2 = cellPosition(tile, 2);

        /* Check whether all the heights of all three cells are equal */
        return (heightArray[index0.getX()][index0.getY()] == heightArray[index1.getX()][index1.getY()] &&
                heightArray[index0.getX()][index0.getY()] == heightArray[index2.getX()][index2.getY()]);
    }

    /* TODO:
    Tiles may be placed adjacent to any other tile (edge touching edge).
    When tiles are stacked:
        - Green and red cannot be stacked on top of each other. (simple)
        - Black (neutral) can be stacked with green and red. (simple)
        - Each color may be stacked on top of itself. (simple)
        - Each square of the tile must be stacked upon a square below (no overhangs allowed). (simple)
        - Each stacked tile must straddle at least two tiles below. (hard - how do we tell which tiles have been placed where?)
    */

    /* FIXME: Fix and clean all the code here */
    /* We check if a tile is adjacent to another tile */
    // TODO: PLEASE EXPLAIN HOW THE LOGIC HERE WORKS
    private static boolean isAdjacent(Tile tile, int[][] heightArray) {
        /* Get position coordinates for each of the 3 cells on our tile */
        Position index0 = cellPosition(tile, 0);
        Position index1 = cellPosition(tile, 0);
        Position index2 = cellPosition(tile, 0);

        return (heightArray[index0.getX()][index0.getY()]   > 0 ||
                heightArray[index0.getX()+1][index0.getY()] > 0 ||
                heightArray[index0.getX()-1][index0.getY()] > 0 ||
                heightArray[index0.getX()][index0.getY()+1] > 0 ||
                heightArray[index0.getX()][index0.getY()-1] > 0 ||
                heightArray[index1.getX()][index1.getY()]   > 0 ||
                heightArray[index1.getX()+1][index1.getY()] > 0 ||
                heightArray[index1.getX()-1][index1.getY()] > 0 ||
                heightArray[index1.getX()][index1.getY()+1] > 0 ||
                heightArray[index1.getX()][index1.getY()-1] > 0 ||
                heightArray[index2.getX()][index2.getY()]   > 0 ||
                heightArray[index2.getX()+1][index2.getY()] > 0 ||
                heightArray[index2.getX()-1][index2.getY()] > 0 ||
                heightArray[index2.getX()][index2.getY()+1] > 0 ||
                heightArray[index2.getX()][index2.getY()-1] > 0);
    }


    /* Checks that no part of the tile extends beyond the board */
    private static boolean isOnBoard (Tile tile) {
        // Get the position coordinates of our Tile
        Position position = tile.getPosition();
        // We check the Tile over the orientation
        switch (tile.getOrientation()) {
            /* FIXME: LOGIC FOR THESE IS INCORRECT
             *   - char's don't correspond with int's nicely
             *   - if we have, say orientation 'A' across the most right column
             *     of the board, it is not on the board for the whole column, not just the corners, use >= <= etc.
             *   - etc.
             */
            case A:
                // at right or bottom edge return false
                if (position.getX() == BOARD_SIZE || position.getY() == BOARD_SIZE) {
                    return false;
                }
                break;
            case B:
                // at left or bottom edge return false
                if (position.getX() == 1 || position.getY() == BOARD_SIZE) {
                    return false;
                }
                break;
            case C:
                // at left or top edge return false
                if (position.getX() == 1 || position.getY() == 1) {
                    return false;
                }
                break;
            case D:
                // at right or top edge return false
                if (position.getX() == BOARD_SIZE || position.getY() == 1) {
                    return false;
                }
                break;
        }
        return true;
    }


    /**
     * Determine the score for a player given a placement, following the
     * scoring rules for the game.
     *
     * @param placement A placement string
     * @param green True if the score for the green player is requested,
     *              otherwise the score for the red player should be returned
     * @return the score for the requested player, given the placement
     */
    static int getScoreForPlacement(String placement, boolean green) {
        // FIXME Task 7: determine the score for a player given a placement
        if (green)
            return Score.getScore(placement, Colour.Green);
        else
            return Score.getScore(placement, Colour.Red);
    }

    /**
     * Generate a valid move that follows from: the given placement, a piece to
     * play, and the piece the opponent will play next.
     *
     * @param placement  A valid placement string indicating a game state
     * @param piece  The piece you are to play ('A' to 'T')
     * @param opponentsPiece The piece your opponent will be asked to play next ('A' to 'T' or 0 if last move).
     * @return A string indicating a valid tile placement that represents your move.
     */
    static String generateMove(String placement, char piece, char opponentsPiece) {
        // FIXME Task 10: generate a valid move
        return null;
    }
}
