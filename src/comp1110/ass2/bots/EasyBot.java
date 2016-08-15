package comp1110.ass2.bots;

/**
 *  Created by William Shen on 15/08/16
 */

public class EasyBot extends Bot {
    private String game;

    public EasyBot(String game) {
        super(game);
    }

    /* We generate an array of potential moves and select a random one */
    public String getMove() {
        String[] moves = generatePossibleMoves(this.game);
        return selectRandomMove(moves);
    }

    /* We select a random move from our array of potential moves */
    private String selectRandomMove(String[] moves) {
        return "";
    }
}
