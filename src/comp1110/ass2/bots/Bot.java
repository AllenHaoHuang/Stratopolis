package comp1110.ass2.bots;

/**
 *  Created by William Shen on 15/08/16
 */

/* We want to limit the access of this class to only this package */
abstract class Bot {
    // Holds the game state
    private String game;

    // Used for object initialisation, mainly here for inheritance
    Bot(String game) {
        this.game = game;
    }

    // To be implemented by any class that extends
    public abstract String getMove();

    // Generates the possible moves given a particular game state
    String[] generatePossibleMoves() {
        return new String[] {this.game};
    }
}
