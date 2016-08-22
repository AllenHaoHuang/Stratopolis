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
        // We don't want to parse a null string...
        if (placement == null) return false;

        // We check the placement string length is a multiple of 4, is non-empty, and contains a maximum of 41
        if (placement.length() % TILE_PLACEMENT_LENGTH != 0 ||
            placement.length() == 0 ||
            placement.length() > TILE_PLACEMENT_LENGTH * MAX_TILE_PLACEMENTS) {
            return false;
        }

        // i is our index in the string. We check that the first tile placement is 'MMUA'
        if (!(placement.substring(0, 4).equals("MMUA"))) {
            return false;
        }

        // If the length of the placement string is 4, then it only contains 'MMUA'
        if (placement.length() == 4) return true;

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
            if (!isTilePlacementWellFormed(placement.substring(i, i+4)))
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
    public static boolean isPlacementValid(String placement) {
        // FIXME Task 6: determine whether a placement is valid

        // We first check if the input Placement String is well-formed itself
        if (!isPlacementWellFormed(placement)) return false;
        // If the placement string is just 'MMUA'
        if (placement.equals("MMUA")) return true;

        /* Initialise the 2-dimensional array (which represents the board) to store the
         * maximum height of the stacked pieces (if any) to 0. */
        int[][] heightArray = new int[BOARD_SIZE][BOARD_SIZE];

        /* Initialise the 2-dimensional array (which represents the board) to the Black
         * tile colour. Recall, that Black is neutral - i.e. Red, Green and Black can
         * be stacked upon Black. */
        Colour[][] colourArray = new Colour[BOARD_SIZE][BOARD_SIZE];
        for (Colour[] row : colourArray)
            Arrays.fill(row, Colour.Black);

        /* This array identifies the pieces which are placed at a position based on a unique pieceID.
         * The whole array is initially set to 0 (by default) */
        int[][] pieceIDArray = new int [BOARD_SIZE][BOARD_SIZE];
        int pieceID = 1; // pieceID is incremented each time a tile is valid and placed on the 'board'

        /* Since we already checked if the placement string is well formed, we know
           the first four characters are "MMUA". Update the arrays accordingly */
        Tile initialTile = new Tile(new Position('M','M'), Shape.U, Orientation.A);
        heightArray[12][12]++;
        heightArray[12][13]++;
        colourArray[12][12] = Colour.Red;
        colourArray[12][13] = Colour.Green;
        pieceIDArray[12][12] = pieceID;
        pieceIDArray[12][13] = pieceID;
        pieceID++;

        /* Loop over the rest of the placement string, bar "MMUA" */
        for (int i = 4; i < placement.length(); i += TILE_PLACEMENT_LENGTH) {
            // Create a new tile from the placement string
            Tile substringTile = new Tile(new Position(placement.charAt(i), placement.charAt(i+1)),
                                          Shape.fromChar(placement.charAt(i+2)),
                                          Orientation.fromChar(placement.charAt(i+3)));
            // We check if all the rules are fulfilled. If so, then update the arrays and continue looping
            if (isOnBoard(substringTile) &&
                isAdjacent(substringTile, heightArray) &&
                areColoursValid(substringTile, colourArray) &&
                areHeightsValid(substringTile, heightArray) &&
                isOverTwoTiles(substringTile, pieceIDArray, heightArray)) {
                    // Update the arrays and increment pieceID
                    colourArray = updateBoardColours(substringTile, colourArray);
                    heightArray = updateBoardHeights(substringTile, heightArray);
                    pieceIDArray = updateIdentifier(substringTile, pieceIDArray, pieceID++);
            } else {
                /* FIXME: Testing code */
                System.out.println("Placement String: " + placement);
                System.out.println("TEST RESULTS - isOnBoard: " + isOnBoard(substringTile) + ", isAdjacent: " + isAdjacent(substringTile,heightArray)
                        + ", areColoursValid: " + areColoursValid(substringTile, colourArray) + ", areHeightsValid: "
                        + areHeightsValid(substringTile, heightArray) + ", isOverTwoTiles: " + isOverTwoTiles(substringTile, pieceIDArray, heightArray));
                return false;
            }
        }

        // When we are here, the whole placement string has been parsed and is thus valid
        return true;
    }

    /* Given a tile and the board (array) of colours, change the colours */
    private static Colour[][] updateBoardColours(Tile tile, Colour[][] colourArray) {
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

    /* Given a tile and the board (array) of heights, increase the height */
    private static int[][] updateBoardHeights(Tile tile, int[][] heightArray) {
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

    /* Updates the pieceID array with the new Tile */
    private static int[][] updateIdentifier(Tile tile, int[][] pieceIDArray, int pieceID) {
        /* Get position coordinates for each of the 3 cells on our tile */
        Position index0 = cellPosition(tile, 0);
        Position index1 = cellPosition(tile, 1);
        Position index2 = cellPosition(tile, 2);

        // Update the array with the new Tile piece we have placed down
        pieceIDArray[index0.getX()][index0.getY()] = pieceID;
        pieceIDArray[index1.getX()][index1.getY()] = pieceID;
        pieceIDArray[index2.getX()][index2.getY()] = pieceID;
        return pieceIDArray;
    }

    /* Checks that no part of the tile extends beyond the board */
    private static boolean isOnBoard (Tile tile) {
        // Get the position coordinates of our Tile
        Position position = tile.getPosition();
        /* We check the Tile over the orientation. Recall that a coordinate on the board
         * is encoded as (x,y) where 'A' <= x <= 'Z' and 'A' <= y <= 'Z' */
        switch (tile.getOrientation()) {
            case A:
                // At right or bottom edge of the board
                return (!(position.getX() == 'Z' || position.getY() == 'Z'));
            case B:
                // At left or bottom edge of the board
                return (!(position.getX() == 'A' || position.getY() == 'Z'));
            case C:
                // At left or top edge of the board
                return (!(position.getX() == 'A' || position.getY() == 'A'));
            case D:
                // At right or top edge of the board
                return (!(position.getX() == 'Z' || position.getY() == 'A'));
            default:
                return false;
        }
    }

    /* We check if a tile is adjacent to another tile:
     * isAdjacent checks if it is next to a tile, if the heights directly on or next to the position
     * of the tile placed is larger than 0, it is next to a piece */
    private static boolean isAdjacent(Tile tile, int[][] heightArray) {
        /* Get position coordinates for each of the origin cell on our tile */
        Position index0 = cellPosition(tile, 0);
        int x = index0.getX();
        int y = index0.getY();

        // TODO: Need to account for boundaries, please do this Marvin
        // We take the relevant x and y positions about the origin cell using maths
        switch(tile.getOrientation()) {
            // Recall that `&&` will not check the 2nd condition if the 1st is false
            case A:
                /**
                 * // FIXME: Marvin please read the comments and do this
                 * Recall that x cannot be smaller than 0 or bigger than 25 - i.e. 0 <= x <= 25
                 * Also, y cannot be smaller than 0 or bigger than 25 - i.e. 0 <= y <= 25
                 * e.g. heightArray[x-1][y] > 0 translates to
                 *      if (!(x-1 < 0) && heightArray[x-1][y] > 0) return true;
                 *
                 *      heightArray[x+1][y-1] > 0 translates to
                 *      if (!(x+1 > 25) && !(x-1 < 0) && heightArray[x+1][y-1] > 0) return true;
                 */

                return (heightArray[x-1][y] > 0 ||
                        heightArray[x+2][y] > 0 ||
                        heightArray[x][y-1] > 0 ||
                        heightArray[x+1][y-1] > 0 ||
                        heightArray[x-1][y+1] > 0 ||
                        heightArray[x+1][y+1] > 0 ||
                        heightArray[x][y+2] > 0);
            case B:
                return (heightArray[x-2][y] > 0 ||
                        heightArray[x+1][y] > 0 ||
                        heightArray[x][y-1] > 0 ||
                        heightArray[x-1][y-1] > 0 ||
                        heightArray[x-1][y+1] > 0 ||
                        heightArray[x+1][y+1] > 0 ||
                        heightArray[x][y+2] > 0);
            case C:
                return (heightArray[x+1][y] > 0 ||
                        heightArray[x-2][y] > 0 ||
                        heightArray[x+1][y-1] > 0 ||
                        heightArray[x-1][y-1] > 0 ||
                        heightArray[x][y+1] > 0 ||
                        heightArray[x-1][y+1] > 0 ||
                        heightArray[x][y-2] > 0);
            case D:
                return (heightArray[x-1][y] > 0 ||
                        heightArray[x+2][y] > 0 ||
                        heightArray[x-1][y-1] > 0 ||
                        heightArray[x+1][y-1] > 0 ||
                        heightArray[x][y+1] > 0 ||
                        heightArray[x+1][y+1] > 0 ||
                        heightArray[x][y-2] > 0);
            default:
                return false;
        }
    }

    /* Determine whether the colour placement of a tile is valid on the given board */
    private static boolean areColoursValid (Tile tile, Colour[][] colourArray) {
        /* Get position coordinates for each of the 3 cells on our tile */
        Position index0 = cellPosition(tile, 0);
        Position index1 = cellPosition(tile, 1);
        Position index2 = cellPosition(tile, 2);

        // We check over all the cells of the tile
        Colour colour0 = tile.getShape().colourAtIndex(0);
        Colour colour1 = tile.getShape().colourAtIndex(1);
        Colour colour2 = tile.getShape().colourAtIndex(2);

        return (isColourValidOnTile(index0, colour0, colourArray) &&
                isColourValidOnTile(index1, colour1, colourArray) &&
                isColourValidOnTile(index2, colour2, colourArray));
    }

    /* Checks if the colour placement is valid on a single cell of a tile */
    private static boolean isColourValidOnTile (Position position, Colour colour, Colour[][] colourArray) {
        switch (colour) {
            case Black:
                return true;
            case Green:
                return (!(colourArray[position.getX()][position.getY()] == Colour.Red));
            case Red:
                return (!(colourArray[position.getX()][position.getY()] == Colour.Green));
            default:
                return false;
        }
    }

    /* Check if a placement is valid height-wise, i.e. the heights of each of the three cells are equal */
    private static boolean areHeightsValid(Tile tile, int[][] heightArray) {
        /* Get position coordinates for each of the 3 cells on our tile */
        Position index0 = cellPosition(tile, 0);
        Position index1 = cellPosition(tile, 1);
        Position index2 = cellPosition(tile, 2);

        /* Check whether all the heights of all three cells are equal */
        return (heightArray[index0.getX()][index0.getY()] == heightArray[index1.getX()][index1.getY()] &&
                heightArray[index0.getX()][index0.getY()] == heightArray[index2.getX()][index2.getY()]);
    }

    /* Check if a Tile is placed over two tiles (i.e. straddled) */
    private static boolean isOverTwoTiles (Tile tile, int[][] pieceIDArray, int[][] heightArray) {
        /* Get position coordinates for each of the 3 cells on our tile */
        Position index0 = cellPosition(tile, 0);
        Position index1 = cellPosition(tile, 1);
        Position index2 = cellPosition(tile, 2);

        /* Check if the tile is placed at height = 0, then we don't need to check if it is
         *  straddled over 2 different tiles */
        if (heightArray[index0.getX()][index0.getY()] == 0) return true;

        // Check if our new tile would be placed over 2 different tiles
        return (!(pieceIDArray[index0.getX()][index0.getY()] == pieceIDArray[index1.getX()][index1.getY()] &&
                  pieceIDArray[index1.getX()][index1.getY()] == pieceIDArray[index2.getX()][index2.getY()]));
    }

    /**
     *  Return the position of a specific cell of a Tile on the board.
     *  The 'A' orientation of a L-shaped tile based on 'index' is represented as:
     *     [0]  [1]
     *     [2]
     */
    private static Position cellPosition (Tile tile, int index) {
        // Return the position of the origin cell if zero index is requested
        if (index == 0) return tile.getPosition();

        /* We retrieve the X and Y character coordinates of
           the origin index - i.e. at index = 0. */
        int originX = tile.getPosition().getX();
        int originY = tile.getPosition().getY();

        //Here, we check the Orientation of our tile and return the relevant Positions
        switch (tile.getOrientation()) {
            case A:
                if (index == 1) return new Position((char)(originX+1+'A'), (char)(originY+'A'));
                if (index == 2) return new Position((char)(originX+'A'), (char)(originY+1+'A'));
            case B:
                if (index == 1) return new Position((char)(originX+'A'), (char)(originY+1+'A'));
                if (index == 2) return new Position((char)(originX-1+'A'), (char)(originY+'A'));
            case C:
                if (index == 1) return new Position((char)(originX-1+'A'), (char)(originY+'A'));
                if (index == 2) return new Position((char)(originX+'A'), (char)(originY-1+'A'));
            case D:
                if (index == 1) return new Position((char)(originX+'A'), (char)(originY-1+'A'));
                if (index == 2) return new Position((char)(originX+1+'A'), (char)(originY+'A'));
            default:
                // Something went wrong...
                return new Position('#','#'); // need more appropriate return
        }
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

    /* FIXME: TESTING Code */
    public static void main(String[] args) {
        System.out.println("----------------------------");
        String[] strArr = {"MMUA","MMUANLOB","MMUANLOBLNBC","MMUANLOBLNBCONSCKLDAPOTCMLEBPLMBKNJDOLNBMLDANPLDNNBAONMCLOFAPQTC",
        "MMUANLOBNMHC"};
        for (String str : strArr) {
            if (str.length() > 4) {
                System.out.println("String being tested: " + str);
                boolean b2 = isPlacementWellFormed(str);
                boolean b3 = isPlacementValid(str);
                System.out.println("isPlacementWellFormed: " + b2 + ", isPlacementValid: " + b3);
                System.out.println("----------------------------");
            } else {
                boolean b1 = isTilePlacementWellFormed(str);
                boolean b2 = isPlacementWellFormed(str);
                boolean b3 = isPlacementValid(str);
                System.out.println("String being tested: " + str);
                System.out.println("isTilePlacementWellFormed: " + b1 + ", isPlacementWellFormed: " + b2
                        + ", isPlacementValid: " + b3);
                System.out.println("----------------------------");
            }
        }
    }
}
