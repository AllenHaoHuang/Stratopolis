package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private boolean alreadyHovered = false;
    private Orientation hoverOrientation = Orientation.A;

    /* Variables for JavaFX */
    private final Group root = new Group();
    private final Group greenCurrentTile = new Group();
    private final Group redCurrentTile =new Group();
    private final Group hoverTile = new Group();

    private Label greenPiecesLeft = new Label();
    private Label redPiecesLeft = new Label();
    private Label playerTurn = new Label();

    /** INITIAL DESIGN FOR ROOT INDEXES
     *  - 0 to 675 for grid and cells
     *  - 676 and on for other stuff
     */

    /* Prepare everything accordingly for play */
    private void setupGame() {
        // Place labels to identify players
        Label greenPlayer = new Label("Player Green:");
        Label redPlayer = new Label("Player Red:");
        greenPlayer.setTranslateX(35);
        greenPlayer.setTranslateY(25);
        redPlayer.setTranslateX(BOARD_WIDTH - 95);
        redPlayer.setTranslateY(25);
        root.getChildren().addAll(greenPlayer, redPlayer);
        // Add labels for pieces left and whose turn it is
        playerTurn.setTranslateX(BOARD_WIDTH/2 - 70);
        playerTurn.setTranslateY(5);
        greenPiecesLeft.setTranslateX(30);
        greenPiecesLeft.setTranslateY(105);
        redPiecesLeft.setTranslateX(BOARD_WIDTH - 110);
        redPiecesLeft.setTranslateY(105);
        root.getChildren().addAll(playerTurn, greenPiecesLeft, redPiecesLeft);
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
        showNextTile();
        showNextTile();
    }

    private void showNextTile() {
        /* FIXME: Extremely ugly code */
        piecesLeft();
        Shape nextTile;
        Cell zero, one, two;
        
        // Set text in label for whose turn it is
        if (!isGreen) {
            playerTurn.setTextFill(Color.GREEN);
            playerTurn.setText("Green Player's Turn");
        } else {
            playerTurn.setTextFill(Color.RED);
            playerTurn.setText("Red Player's Turn");
        }

        // The green player is first to run out of pieces, so red does too
        if (isGreen && playerGreen.size() == 0) {
            root.getChildren().remove(greenCurrentTile);
            isGreen = !isGreen;
            return;
        } else if (playerRed.size() == 0) {
            playerTurn.setText("Game finished.");
            root.getChildren().remove(redCurrentTile);
            return;
        } else if (isGreen) {
            // Remove existing shape preview for green player
            root.getChildren().remove(greenCurrentTile);
            greenCurrentTile.getChildren().clear();
            nextTile = playerGreen.getFirst();
            zero = new Cell(nextTile.colourAtIndex(0));
            one = new Cell(nextTile.colourAtIndex(1));
            two = new Cell(nextTile.colourAtIndex(2));
            zero.setTranslateX(50);
        } else {
            // Remove existing shape preview for red player
            root.getChildren().remove(redCurrentTile);
            redCurrentTile.getChildren().clear();
            nextTile = playerRed.getFirst();
            zero = new Cell(nextTile.colourAtIndex(0));
            one = new Cell(nextTile.colourAtIndex(1));
            two = new Cell(nextTile.colourAtIndex(2));
            zero.setTranslateX(BOARD_WIDTH - 80);
        }

        // Set position of cells on scene
        zero.setTranslateY(50);
        one.setTranslateX(zero.getTranslateX() + 24);
        one.setTranslateY(zero.getTranslateY());
        two.setTranslateX(zero.getTranslateX());
        two.setTranslateY(zero.getTranslateY() + 24);

        // Add the cells to the relevant groups
        if (isGreen) {
            greenCurrentTile.getChildren().addAll(zero, one, two);
            root.getChildren().add(greenCurrentTile);
        } else {
            // Add the cells to the relevant groups
            redCurrentTile.getChildren().addAll(zero, one, two);
            root.getChildren().add(redCurrentTile);
        }

        // We invert whose turn it is
        isGreen = !isGreen;
    }

    private void piecesLeft() {
        // Update how many pieces a player has left after they have played a move
        if (isGreen)
            greenPiecesLeft.setText(playerGreen.size() + " pieces left.");
        else
            redPiecesLeft.setText(playerRed.size() + " pieces left.");
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
                cell.setTranslateY(i * 24 + 30);
                /* We place a tile if a  */
                cell.setOnMouseClicked(event -> {
                    addTile(x, y);
                });
                /* HANDLE HOVER OVER : RIP THIS CODE KILLS */
                cell.setOnMouseEntered(event -> {
                    hoverTile(x, y);
                });
                cell.setOnMouseExited(event -> {
                    root.getChildren().remove(hoverTile);
                    hoverTile.getChildren().clear();
                    alreadyHovered = false;
                });
                cell.setOnScroll(event -> {
                    // Remove the current tile preview and draw another one
                    root.getChildren().remove(hoverTile);
                    hoverTile.getChildren().clear();
                    hoverOrientation = Orientation.next(hoverOrientation);
                    alreadyHovered = false;
                    hoverTile(x, y);
                });

                root.getChildren().add(cell);
            }
        }
        // Set the initial 'MMUA' piece
        Cell c1 = new Cell(Colour.Red);
        Cell c2 = new Cell(Colour.Green);
        c1.setTranslateX(442);
        c1.setTranslateY(318);
        c2.setTranslateX(442);
        c2.setTranslateY(342);
        root.getChildren().set(324, c1);
        root.getChildren().set(350, c2);
    }

    private void hoverTile(char x, char y) {
        // Get the tile ID so we can extract the colours
        Shape tile = (isGreen) ? playerGreen.getFirst() : playerRed.getFirst();

        // We don't want to show tile if it is out of bounds
        switch (hoverOrientation) {
            case A :
                if (x == 'Z' || y == 'Z') return;
                // Build the cells into the `hoverTile` Group
                hoverCell(x, y, tile.colourAtIndex(0));
                hoverCell((char)(x+1), y, tile.colourAtIndex(1));
                hoverCell(x, (char)(y+1), tile.colourAtIndex(2));
                break;
            case B :
                if (x == 'A' || y == 'Z') return;
                // Build the cells into the `hoverTile` Group
                hoverCell(x, y, tile.colourAtIndex(0));
                hoverCell(x, (char)(y+1), tile.colourAtIndex(1));
                hoverCell((char)(x-1), y, tile.colourAtIndex(2));
                break;
            case C :
                if (x == 'A' || y == 'A') return;
                // Build the cells into the `hoverTile` Group
                hoverCell(x, y, tile.colourAtIndex(0));
                hoverCell((char)(x-1), y, tile.colourAtIndex(1));
                hoverCell(x, (char)(y-1), tile.colourAtIndex(2));
                break;
            case D :
                if (x == 'Z' || y == 'A') return;
                // Build the cells into the `hoverTile` Group
                hoverCell(x, y, tile.colourAtIndex(0));
                hoverCell(x, (char)(y-1), tile.colourAtIndex(1));
                hoverCell((char)(x+1), y, tile.colourAtIndex(2));
                break;
        }

        // Add the tile hover to the root
        hoverTile.setMouseTransparent(true);
        root.getChildren().add(hoverTile);
        alreadyHovered = true;
    }

    private void hoverCell(char x, char y, Colour colour) {
        // Create new cell, change its properties and add to group
        Cell cell = new Cell(colour);
        cell.setTranslateX(translateX(x));
        cell.setTranslateY(translateY(y));
        cell.setOpacity(0.5);
        hoverTile.getChildren().add(cell);
    }

    private void addTile(char x, char y) {
        // Create a new tile
        Position position = new Position(x, y);
        Shape shape = (isGreen) ? playerGreen.getFirst() : playerRed.getFirst();
        Orientation orientation = hoverOrientation;
        Tile tile = new Tile(position, shape, orientation);
        // Add a new tile to our board if it is valid
        if (boardState.isTileValid(tile)) {
            boardState.addTile(new Tile(position, shape, orientation));
        } else {
            // When tile placement is not valid, we show an error message
            playerTurn.setTextFill(Color.RED);
            if (playerTurn.getText().contains("Invalid Tile Placement"))
                playerTurn.setText("!" + playerTurn.getText() + "!");
            else playerTurn.setText("!Invalid Tile Placement!");
            return;
        }

        // Add cells onto the board based on the tile orientation
        switch (orientation) {
            case A :
                addCell(x, y, shape.colourAtIndex(0));
                addCell((char)(x+1), y, shape.colourAtIndex(1));
                addCell(x, (char)(y+1), shape.colourAtIndex(2));
                break;
            case B :
                addCell(x, y, shape.colourAtIndex(0));
                addCell(x, (char)(y+1), shape.colourAtIndex(1));
                addCell((char)(x-1), y, shape.colourAtIndex(2));
                break;
            case C :
                addCell(x, y, shape.colourAtIndex(0));
                addCell((char)(x-1), y, shape.colourAtIndex(1));
                addCell(x, (char)(y-1), shape.colourAtIndex(2));
                break;
            case D :
                addCell(x, y, shape.colourAtIndex(0));
                addCell(x, (char)(y-1), shape.colourAtIndex(1));
                addCell((char)(x+1), y, shape.colourAtIndex(2));
                break;
        }

        // Remove the piece from the player's pieces and show their next piece
        if (isGreen) playerGreen.removeFirst();
        else playerRed.removeFirst();
        showNextTile();
        // Reset the orientation for hovering
        hoverOrientation = Orientation.A;
    }

    private void addCell(char x, char y, Colour colour) {
        // Create new cell, change its properties and add to root
        Cell cell = new Cell(colour);
        cell.setTranslateX(translateX(x));
        cell.setTranslateY(translateY(y));
        root.getChildren().set(getIndex(x, y), cell);
        // NEED TO HANDLE EVENTS - i.e. Stacking of tiles
    }

    // Calculate how many pixels to translate x and y by on window
    private int translateX(char x) { return (x - 'A')*24 + 154; }
    private int translateY(char y) { return (y - 'A')*24 + 30; }

    /* We get the index in the Scene `root`, of the position given */
    private int getIndex(char x, char y) {
        if (y - 'A' == 0) return x - 'A';
        else return (x - 'A')+(y - 'A')*26;
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
            switch (colour) {
                case Black:
                    cell.setFill(Color.rgb(0, 0, 0));
                    break;
                case Red:
                    cell.setFill(Color.rgb(255, 0, 0));
                    break;
                case Green:
                    cell.setFill(Color.rgb(0, 127, 0));
                    break;
                case NULL:
                    cell.setFill(null);
            }
            getChildren().add(cell);
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("StratoGame");
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);

        newGrid();
        setupGame();

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
