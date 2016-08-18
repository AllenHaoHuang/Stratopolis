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
        // FIXME Task 4: determine whether a placement is well-formed

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
        int[][] heightArray = initialiseZeroArray();
        Colour[][] colorArray = initialiseBlackArray();

        // temporary
        String subString;
        Tile subStringTile = new Tile(charsToPosition(subString.charAt(0), subString.charAt(1)),
                                      charToShape(subString.charAt(2)),
                                      charToOrientation(subString.charAt(3)));



        return false;
    }

    // given a tile and array of colours, changes colours
    static Colour[][] placeTileColour(Tile tile, Colour[][] colourArray) {
        Position index0 = tile.getPosition();
        Position index1 = tilePosition(tile, 1);
        Position index2 = tilePosition(tile, 2);
        Shape shape = tile.getShape();

        colourArray[index0.getx()][index0.gety()]=getColour(shape,0);
        colourArray[index1.getx()][index1.gety()]=getColour(shape,1);
        colourArray[index2.getx()][index2.gety()]=getColour(shape,2);

        return colourArray;
    }

    // gets colour from shape
    static Colour getColour(Shape shape, int index) {

    }

    // given a tile and array of heights, changes tile height array
    static int[][] placeTileHeight(Tile tile, int[][] heightArray) {
        Position index0 = tile.getPosition();
        Position index1 = tilePosition(tile, 1);
        Position index2 = tilePosition(tile, 2);

        heightArray[index0.getx()][index0.gety()]++;
        heightArray[index1.getx()][index1.gety()]++;
        heightArray[index2.getx()][index2.gety()]++;

        return heightArray;
    }

    // checks if tile is adjacent to another tile
    static boolean isAdjacent(Tile tile, int[][] heightArray) {
        Position index0 = tile.getPosition();
        Position index1 = tilePosition(tile, 1);
        Position index2 = tilePosition(tile, 2);

        if (heightArray[index0.getx()][index0.gety()] > 0   ||
            heightArray[index0.getx()+1][index0.gety()] > 0 ||
            heightArray[index0.getx()-1][index0.gety()] > 0 ||
            heightArray[index0.getx()][index0.gety()+1] > 0 ||
            heightArray[index0.getx()][index0.gety()-1] > 0 ||
            heightArray[index1.getx()][index1.gety()] > 0   ||
            heightArray[index1.getx()+1][index1.gety()] > 0 ||
            heightArray[index1.getx()-1][index1.gety()] > 0 ||
            heightArray[index1.getx()][index1.gety()+1] > 0 ||
            heightArray[index1.getx()][index1.gety()-1] > 0 ||
            heightArray[index2.getx()][index2.gety()] > 0   ||
            heightArray[index2.getx()+1][index2.gety()] > 0 ||
            heightArray[index2.getx()-1][index2.gety()] > 0 ||
            heightArray[index2.getx()][index2.gety()+1] > 0 ||
            heightArray[index2.getx()][index2.gety()-1] > 0) {
            return true
        }
        return false;
    }

    // checks if positions tile placed on have same height
    static boolean isHeightsValid(Tile tile, int[][] heightArray) {
        Position index0 = tile.getPosition();
        Position index1 = tilePosition(tile, 1);
        Position index2 = tilePosition(tile, 2);

        if (heightArray[index0.getx()][index0.gety()] == heightArray[index1.getx()][index1.gety()] &&
            heightArray[index0.getx()][index0.gety()] == heightArray[index1.getx()][index2.gety()]) {
            return true;
        }
        return false;
    }

    // initials 26*26 size colour array with all being black
    static Colour[][] initialiseBlackArray() {
        Colour[][] array = new Colour[BOARD_SIZE][BOARD_SIZE];
        for (int i=0; i<BOARD_SIZE; i++ ) {
            for (int j=0; i<BOARD_SIZE; j++ ) {
                array[i][j] = Colour.Black;
            }
        }
        return array;
    }

    // initials 26*26 size int array with all being zero
    static int[][] initialiseZeroArray() {
        int[][] array = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i=0; i<BOARD_SIZE; i++ ) {
            for (int j=0; i<BOARD_SIZE; j++ ) {
                array[i][j] = 0;
            }
        }
        return array;
    }

    // gives tile position, index is as follows
    // for in a orientation
    // 0 1
    // 2 #
    // returns a tile position given the origin, orientation and index
    static Position tilePosition (Tile tile, int index) {
        Orientation orientation = tile.getOrientation();
        Position origin = tile.getPosition();
        char originX = origin.getx();
        char originY = origin.gety();

        switch (orientation) {
            case A:
                switch (index) {
                    // returns origin position
                    case 0:
                        return origin;
                    // returns x coord + 1
                    case 1:
                        return new Position((char)(originX+1), originY);
                    // returns y coord + 1
                    case 2:
                        return new Position(originX, (char)(originY+1));
                }
            case B:
                switch (index) {
                    // returns origin position
                    case 0:
                        return origin;
                    // returns y coord + 1
                    case 1:
                        return new Position(originX, (char)(originY+1));
                    // returns x coord - 1
                    case 2:
                        return new Position((char)(originX-1), originY);
                }
            case C:
                switch (index) {
                    // returns origin position
                    case 0:
                        return origin;
                    // returns x coord - 1
                    case 1:
                        return new Position((char)(originX-1), originY);
                    // returns y coord - 1
                    case 2:
                        return new Position(originX, (char)(originY-1));
                }
            case D:
                switch (index) {
                    // returns origin position
                    case 0:
                        return origin;
                    // returns y coord - 1
                    case 1:
                        return new Position(originX, (char)(originY-1));
                    // returns x coord + 1
                    case 2:
                        return new Position((char)(originX+1), originY);
                }
        }
        // not needed
        return origin;
    }

    // takes in string of length 4 and returns true if on board
    static boolean isOnBoard (Tile tile) {
        Position position = tile.getPosition();
        Orientation orientation = tile.getOrientation();

        switch (orientation) {
            case A:
                // at right or bottom edge return false
                if (position.getx() == BOARD_SIZE || position.gety() == BOARD_SIZE) {
                    return false;
                }
                break;
            case B:
                // at left or bottom edge return false
                if (position.getx() == 1 || position.gety() == BOARD_SIZE) {
                    return false;
                }
                break;
            case C:
                // at left or top edge return false
                if (position.getx() == 1 || position.gety() == 1) {
                    return false;
                }
                break;
            case D:
                // at right or top edge return false
                if (position.getx() == BOARD_SIZE || position.gety() == 1) {
                    return false;
                }
                break;
        }
        return true;
    }

    // takes in 2 chars and returns a position
    static Position charsToPosition (char row, char column) {
        Position position = new Position(row, column);
        return position;
    }

    // takes in a char and returns orientation
    static Orientation charToOrientation (char ch) {
        switch (ch) {
            case 'A':
                return Orientation.A;
            case 'B':
                return Orientation.B;
            case 'C':
                return Orientation.C;
            case 'D':
                return Orientation.D;
        }
        // not necessary
        return Orientation.A;
    }

    // takes in a character and returns the shape it refers to
    static Shape charToShape (char ch) {
        switch (ch) {
            case 'A':
                return Shape.A;
            case 'B':
                return Shape.B;
            case 'C':
                return Shape.C;
            case 'D':
                return Shape.D;
            case 'E':
                return Shape.E;
            case 'F':
                return Shape.F;
            case 'G':
                return Shape.G;
            case 'H':
                return Shape.H;
            case 'I':
                return Shape.I;
            case 'J':
                return Shape.J;
            case 'K':
                return Shape.K;
            case 'L':
                return Shape.L;
            case 'M':
                return Shape.M;
            case 'N':
                return Shape.N;
            case 'O':
                return Shape.O;
            case 'P':
                return Shape.P;
            case 'Q':
                return Shape.Q;
            case 'R':
                return Shape.R;
            case 'S':
                return Shape.S;
            case 'T':
                return Shape.T;
            case 'U':
                return Shape.U;
        }
        // not necessary
        return Shape.A;
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
