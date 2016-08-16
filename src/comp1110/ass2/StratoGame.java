package comp1110.ass2;

import comp1110.ass2.logic.Colour;
import comp1110.ass2.logic.Score;

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
    private static final int MAX_NUMBER_OF_TILES = 40;

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
                // Alternate players
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
                // Alternate players - now it is Red's turn
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
        return false;
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
