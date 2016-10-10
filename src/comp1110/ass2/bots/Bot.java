package comp1110.ass2.bots;

import comp1110.ass2.logic.*;

/**
 * `Bot` is the abstract class and is the framework
 * we base EasyBot and HardBot off
 *
 * @author William Shen - u6096655
 */

/* We want to limit the access of this class to only this package */
abstract class Bot {
    // For each bot we store the game state and which player the bot is
    BoardState game;
    Colour myPlayer;

    // Used for object initialisation, mainly here for inheritance
    Bot(BoardState parentGame, boolean isGreenPlayer) {
        this.game = new BoardState(parentGame);
        myPlayer = (isGreenPlayer) ? Colour.Green : Colour.Red;
    }

    // To be implemented by any class that extends
    public abstract Tile getMove();
}
