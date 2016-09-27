package comp1110.ass2.bots;

import comp1110.ass2.logic.*;

import java.util.LinkedList;

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

    // Used for object initialisation from valid placement string, task 10
    Bot(String placement, char myPiece, char opponentsPiece) {
        // Create new game state
        game = new BoardState(placement);

        // Check if player red or player green
        if (myPiece >= 'A' && myPiece <= 'J') {
            this.myPlayer = Colour.Red;
            game.getRedShapes().add(Shape.fromChar(myPiece));
            game.getGreenShapes().add(Shape.fromChar(opponentsPiece));
        } else {
            this.myPlayer = Colour.Green;
            game.getGreenShapes().add(Shape.fromChar(myPiece));
            game.getRedShapes().add(Shape.fromChar(opponentsPiece));
        }
    }

    // To be implemented by any class that extends
    public abstract Tile getMove();
}
