package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import comp1110.ass2.logic.*;
import comp1110.ass2.bots.*;

public class Board extends Application {
    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;

    // FIXME Task 8: Implement a basic playable Strato Game in JavaFX that only allows pieces to be placed in valid places
    // This links to PlayGame and Tile, we create a tile for the UML diagram
    private void playGame() {
        Tile temp = new Tile(null, Shape.A, Orientation.A, 1);
    }

    // FIXME Task 9: Implement scoring
    private int scoring(Colour player) {
        return Score.getScore("board", player);
    }


    // FIXME Task 11: Implement a game that can play valid moves (even if they are weak moves)
    private void easyGame() {
        EasyBot easyBot = new EasyBot("board");
        String easyMove = easyBot.getMove();
    }

    // FIXME Task 12: Implement a game that can play good moves
    private void hardGame() {
        HardBot hardBot = new HardBot("Board");
        String hardMove = hardBot.getMove();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
