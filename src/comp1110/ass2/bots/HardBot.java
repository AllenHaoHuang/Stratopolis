package comp1110.ass2.bots;

/**
 *  Created by William Shen on 15/08/16
 */

public class HardBot extends Bot {
    private String game;

    public HardBot(String game) {
        super(game);
    }

    /* This will hopefully use Minimax with Alpha-Beta Pruning */
    public String getMove() {
        return "";
    }

    /* How we score the board at a given game state */
    private Integer getHeuristic(String move) {
        return 0;
    }
}
