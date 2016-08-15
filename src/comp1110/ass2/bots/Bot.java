package comp1110.ass2.bots;

/**
 *  Created by William Shen on 15/08/16
 */

public abstract class Bot {
    private String game;

    public Bot(String game) {
        this.game = game;
    }

    public abstract String getMove();

    public String[] generatePossibleMoves(String game) {
        String[] temp = {};
        return temp;
    }
}
