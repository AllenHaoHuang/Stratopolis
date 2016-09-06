package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import comp1110.ass2.logic.*;
import comp1110.ass2.bots.*;

import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedList;

public class Board extends Application {
    /* Constants */
    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;
    private static final int GRID_SIZE = 26;

    /* Class variables to store the board, and decks for the players */
    private BoardState boardState = new BoardState();
    private LinkedList<Shape> playerRed = new LinkedList<>();
    private LinkedList<Shape> playerGreen = new LinkedList<>();
    private boolean isGreen;

    /* Variables for JavaFX */
    private final Group root = new Group();


    /* Prepare everything accordingly for play */
    private void setupGame() {
        // Initialise the 'deck' of tiles for the players and shuffle them
        for (Shape i : EnumSet.range(Shape.A, Shape.J)) {
            playerRed.add(i);
            playerRed.add(i);
        }
        for (Shape i : EnumSet.range(Shape.K, Shape.T)) {
            playerGreen.add(i);
            playerGreen.add(i);
        }
        Collections.shuffle(playerGreen);
        Collections.shuffle(playerRed);
        // We wait for the green player's turn
        isGreen = true;
        // DISABLE RED TILE DECK
    }

    private void showNextTile() {
        // The tile has been removed off the top of the deck by the player
        if (isGreen) {
            playerGreen.removeFirst();
            // CODE FOR SHOWING TILE; PROBABLY DRAW ON CONSTANT STACKPANE
            // DISABLE RED TILE DECK
        } else {
            playerRed.removeFirst();
            // CODE FOR SHOWING TILE; PROBABLY DRAW ON CONSTANT STACKPANE
            // DISABLE GREEN TILE DECK
        }
        // We invert whose turn it is
        isGreen = !isGreen;
    }

    private void addTile() {
        // DETECT POSITION ON BOARD AND ORIENTATION

        // Create a new tile
        Position position = new Position('A', 'A');
        Shape shape = (isGreen) ? playerGreen.getFirst() : playerRed.getFirst();
        Orientation orientation = Orientation.fromChar('A');
        Tile tile = new Tile(position, shape, orientation);
        // Add a new tile to our board
        if (boardState.isTileValid(tile)) {
            boardState.addTile(new Tile(position, shape, orientation));
            showNextTile();
        } else {
            // SHOW SOME ERROR MESSAGE ON WINDOW
        }
    }

    // We create the default grid
    private void newGrid() {
        // Clear any existing children
        root.getChildren().clear();
        // Create grid with cell identifiers
        for (int i = 0; i < GRID_SIZE; i++) { // columns
            for (int j = 0; j < GRID_SIZE; j++) { // rows
                char x = (char) (j + 'A');
                char y = (char) (i + 'A');
                StringBuilder sb = new StringBuilder().append(x).append(y);
                Cell cell = new Cell(sb.toString());
                cell.setTranslateX(j * 24 + 154);
                cell.setTranslateY(i * 24 + 20);
                root.getChildren().add(cell);
            }
        }
        // Set the initial 'MMUA' piece
        Cell c1 = new Cell(Colour.Red);
        Cell c2 = new Cell(Colour.Green);
        c1.setTranslateX(442); c1.setTranslateY(308);
        c2.setTranslateX(442); c2.setTranslateY(332);
        root.getChildren().set(324, c1);
        root.getChildren().set(350, c2);
    }

    private class Cell extends StackPane {
        private Cell(String str) {
            // We create a square with a border
            Rectangle border = new Rectangle(24, 24);
            border.setFill(null);
            border.setStroke(Color.LIGHTGREY);
            // We create the text to indicate the position
            Text text = new Text(str);
            text.setFont(Font.font(12));
            text.setFill(Color.GRAY);
            setAlignment(Pos.CENTER);
            // Combine the square and the text
            getChildren().addAll(border, text);
        }
        private Cell(Colour colour) {
            // Create the cell and fill it with the relevant colour
            Rectangle cell = new Rectangle(24, 24);
            cell.setStroke(Color.rgb(54, 54, 54));
            cell.setStrokeType(StrokeType.INSIDE);
            cell.setStrokeWidth(2);
            switch(colour) {
                case Black:
                    cell.setFill(Color.rgb(0, 0, 0));
                    break;
                case Red:
                    cell.setFill(Color.rgb(255, 0, 0));
                    break;
                case Green:
                    cell.setFill(Color.rgb(0, 127, 0));
                    break;
                case NULL :
                    cell.setFill(null);
            }
            getChildren().add(cell);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("StratoGame");
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);

        setupGame();
        newGrid();

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    // FIXME Task 8: Implement a basic playable Strato Game in JavaFX that only allows pieces to be placed in valid places
    private void playGame() {
        // We create this tile for the UML diagram
        Tile temp = new Tile(null, Shape.A, Orientation.A);
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

}
