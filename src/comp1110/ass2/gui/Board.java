package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
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
    private Orientation hoverOrientation = Orientation.A;

    /* Variables for JavaFX */
    private final Group root = new Group();
    private final Group greenCurrentTile = new Group();
    private final Group greenNextTile = new Group();
    private final Group redCurrentTile = new Group();
    private final Group redNextTile = new Group();
    private final Group hoverCurrentTile = new Group();

    private Label greenPiecesLeft = new Label();
    private Label redPiecesLeft = new Label();
    private Label playerTurn = new Label();

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
        greenPiecesLeft.setTranslateY(180);
        redPiecesLeft.setTranslateX(BOARD_WIDTH - 110);
        redPiecesLeft.setTranslateY(180);
        root.getChildren().addAll(playerTurn, greenPiecesLeft, redPiecesLeft);
        // Initialise the 'deck' of tiles for the players and display them
        setupPlayerTiles();
        // We wait for the green player's turn and display the top pieces
        isGreen = true;
    }

    private void setupPlayerTiles() {
        // Initialise the 'deck' of tiles for the players and shuffle them
        for (Shape i : EnumSet.range(Shape.A, Shape.J)) {
            playerRed.add(i);
            //playerRed.add(i);
        }
        for (Shape i : EnumSet.range(Shape.K, Shape.T)) {
            playerGreen.add(i);
            //playerGreen.add(i);
        }
        Collections.shuffle(playerGreen);
        Collections.shuffle(playerRed);
        // Show the tile previews
        previewTiles();
        previewTiles();
    }

    private void previewTiles() {
        // Show how many pieces a player has left
        if (isGreen) greenPiecesLeft.setText(playerGreen.size() + " piece(s) left.");
        else redPiecesLeft.setText(playerRed.size() + " piece(s) left.");

        // Set text in label for whose turn it is
        if (!isGreen) {
            playerTurn.setTextFill(Color.GREEN);
            playerTurn.setText("Green Player's Turn");
        } else {
            playerTurn.setTextFill(Color.RED);
            playerTurn.setText("Red Player's Turn");
        }

        // Check if we are approaching the end game state
        if (isGreen && playerGreen.size() == 0) {
            // Green runs out of pieces
            root.getChildren().remove(greenCurrentTile);
            greenPiecesLeft.setVisible(false);
            isGreen = !isGreen;
            return;
        } else if (playerRed.size() == 0) {
            // Red runs out of pieces, end of game
            root.getChildren().remove(redCurrentTile);
            redPiecesLeft.setVisible(false);
            // Prepare board for endgame state
            endGame();
            return;
        }

        // We create a new preview cell based on whose turn it is
        if (isGreen) showCurrentTile(playerGreen.getFirst());
        else showCurrentTile(playerRed.getFirst());

        // Add next tile to preview or move the `Pieces Left` label
        if (playerGreen.size() == 1 && isGreen) {
            root.getChildren().remove(greenNextTile);
            greenPiecesLeft.setTranslateY(110);
        } else if (playerRed.size() == 1) {
            root.getChildren().remove(redNextTile);
            redPiecesLeft.setTranslateY(110);
        } else {
            // Get the next shape after the current one - i.e. player has picked up current shape
            Shape temp = (isGreen) ? playerGreen.get(1) : playerRed.get(1);
            showNextTile(temp);
        }

        // We invert whose turn it is
        isGreen = !isGreen;
    }

    private void showCurrentTile(Shape shape) {
        // Create new cells
        Cell zero = new Cell(shape.colourAtIndex(0));
        Cell one = new Cell(shape.colourAtIndex(1));
        Cell two = new Cell(shape.colourAtIndex(2));

        // Remove existing tile and add new one to root
        if (isGreen) {
            root.getChildren().remove(greenCurrentTile);
            greenCurrentTile.getChildren().clear();
            // Set up position of cells on screen
            zero.setTranslateX(50); zero.setTranslateY(50);
            one.setTranslateX(74); one.setTranslateY(50);
            two.setTranslateX(50); two.setTranslateY(74);
            greenCurrentTile.getChildren().addAll(zero, one, two);
            root.getChildren().add(greenCurrentTile);
        } else {
            root.getChildren().remove(redCurrentTile);
            redCurrentTile.getChildren().clear();
            // Set up position of cells on screen
            zero.setTranslateX(BOARD_WIDTH - 80); zero.setTranslateY(50);
            one.setTranslateX(zero.getTranslateX() + 24); one.setTranslateY(50);
            two.setTranslateX(zero.getTranslateX()); two.setTranslateY(74);
            redCurrentTile.getChildren().addAll(zero, one, two);
            root.getChildren().add(redCurrentTile);
        }
    }

    private void showNextTile(Shape shape) {
        // Create new cells
        Cell zero = new Cell(shape.colourAtIndex(0));
        Cell one = new Cell(shape.colourAtIndex(1));
        Cell two = new Cell(shape.colourAtIndex(2));

        // Removing existing tile and add new one to root
        if (isGreen) {
            root.getChildren().remove(greenNextTile);
            greenNextTile.getChildren().clear();
            // Set up position of cells on screen
            zero.setTranslateX(50); zero.setTranslateY(115);
            one.setTranslateX(74); one.setTranslateY(115);
            two.setTranslateX(50); two.setTranslateY(139);
            greenNextTile.getChildren().addAll(zero, one, two);
            greenNextTile.setOpacity(0.55);
            root.getChildren().add(greenNextTile);
        } else {
            root.getChildren().remove(redNextTile);
            redNextTile.getChildren().clear();
            // Set up position of cells on screen
            zero.setTranslateX(BOARD_WIDTH - 80); zero.setTranslateY(115);
            one.setTranslateX(zero.getTranslateX() + 24); one.setTranslateY(115);
            two.setTranslateX(zero.getTranslateX()); two.setTranslateY(139);
            redNextTile.getChildren().addAll(zero, one, two);
            redNextTile.setOpacity(0.55);
            root.getChildren().add(redNextTile);
        }
    }

    private void endGame() {
        // Update label text
        playerTurn.setTextFill(Color.DEEPPINK);
        playerTurn.setText("Game finished.");
        // Disable the grid at end of game to prevent clicks or hovering
        for (int i = 0; i < GRID_SIZE * GRID_SIZE; i++) {
            root.getChildren().get(i).setDisable(true);
        }

        // Show who has won the game
        int greenScore = Score.getScore(boardState, true);
        int redScore = Score.getScore(boardState, false);
        Alert test = new Alert(Alert.AlertType.INFORMATION);
        if (greenScore > redScore) {
            test.setTitle("Player Green wins!");
            test.setHeaderText("Player Green wins!");
            test.setContentText("Player Green wins with a score of "
                    + greenScore + ", while Player Red scored " + redScore);
            test.showAndWait();
        } else if (redScore > greenScore) {
            test.setTitle("Player Red wins!");
            test.setHeaderText("Player Red wins!");
            test.setContentText("Player Red wins with a score of "
                    + redScore + ", while Player Green scored " + greenScore);
            test.showAndWait();
        } else {
            test.setTitle("Tie!");
            test.setHeaderText("Both players tie!");
            test.setContentText("Player Green and Red tie at " +
                    greenScore + " points each");
            test.showAndWait();
        }

        /* Controls to set up new game if necessary */
    }

    // We create the default grid
    private void newGrid() {
        // Clear any existing children
        root.getChildren().clear();
        // Create grid with cell identifiers
        for (int i = 0; i < GRID_SIZE; i++) { // columns
            for (int j = 0; j < GRID_SIZE; j++) { // rows
                // Build a new cell with the identifiers and add to root
                char x = (char) (j + 'A');
                char y = (char) (i + 'A');
                addCell(x, y, Colour.NULL);
            }
        }
        // Set the initial 'MMUA' piece
        addCell('M', 'M', Colour.Red);
        addCell('M', 'N', Colour.Green);
    }

    private void hoverTile(char x, char y) {
        // Get the shape so we can extract the colours
        Shape shape = (isGreen) ? playerGreen.getFirst() : playerRed.getFirst();
        // We don't want to show shape if it is out of bounds
        switch (hoverOrientation) {
            case A :
                if (x == 'Z' || y == 'Z') return;
                // Build the cells into the `hoverTile` Group
                hoverCell(x, y, shape.colourAtIndex(0));
                hoverCell((char)(x+1), y, shape.colourAtIndex(1));
                hoverCell(x, (char)(y+1), shape.colourAtIndex(2));
                break;
            case B :
                if (x == 'A' || y == 'Z') return;
                // Build the cells into the `hoverTile` Group
                hoverCell(x, y, shape.colourAtIndex(0));
                hoverCell(x, (char)(y+1), shape.colourAtIndex(1));
                hoverCell((char)(x-1), y, shape.colourAtIndex(2));
                break;
            case C :
                if (x == 'A' || y == 'A') return;
                // Build the cells into the `hoverTile` Group
                hoverCell(x, y, shape.colourAtIndex(0));
                hoverCell((char)(x-1), y, shape.colourAtIndex(1));
                hoverCell(x, (char)(y-1), shape.colourAtIndex(2));
                break;
            case D :
                if (x == 'Z' || y == 'A') return;
                // Build the cells into the `hoverTile` Group
                hoverCell(x, y, shape.colourAtIndex(0));
                hoverCell(x, (char)(y-1), shape.colourAtIndex(1));
                hoverCell((char)(x+1), y, shape.colourAtIndex(2));
                break;
        }
        // Add the tile hover to the root node
        hoverCurrentTile.setMouseTransparent(true);
        root.getChildren().add(hoverCurrentTile);
    }

    private void hoverCell(char x, char y, Colour colour) {
        // Create new cell, change its properties and add to group
        Cell cell;
        cell = new Cell(colour, isGreen);
        cell.setTranslateX(translateX(x));
        cell.setTranslateY(translateY(y));
        cell.setOpacity(0.85);
        hoverCurrentTile.getChildren().add(cell);
    }

    private void addTile(char x, char y) {
        // Create a new tile
        Shape shape = (isGreen) ? playerGreen.getFirst() : playerRed.getFirst();
        Tile tile = new Tile(new Position(x, y), shape, hoverOrientation);
        // Add a new tile to our board if it is valid
        if (boardState.isTileValid(tile)) {
            boardState.addTile(tile);
        } else {
            // When tile placement is not valid, we show an error message
            playerTurn.setTextFill(Color.RED);
            if (playerTurn.getText().contains("Invalid Tile Placement"))
                playerTurn.setText("!" + playerTurn.getText() + "!");
            else playerTurn.setText("!Invalid Tile Placement!");
            return;
        }

        // Add cells onto the board based on the tile orientation
        switch (hoverOrientation) {
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
        previewTiles();
    }

    private void addCell(char x, char y, Colour colour) {
        // Creating a new cell
        Cell cell;
        // Handling grid identifier cells
        if (colour == Colour.NULL) {
            cell = new Cell("" + x + y);
            cell.setTranslateX((x - 'A') * 24 + 154);
            cell.setTranslateY((y - 'A') * 24 + 30);
            root.getChildren().add(cell);
        } else {
            // Create new cell, change its properties and add to root
            if (boardState.getHeight(x, y) > 1)
                cell = new Cell(colour, boardState.getHeight(x, y));
            else
                cell = new Cell(colour);
            cell.setTranslateX(translateX(x));
            cell.setTranslateY(translateY(y));
            root.getChildren().set(getIndex(x, y), cell);
        }

        /* Add a tile to the board state and GUI grid */
        cell.setOnMouseClicked(event -> {
            addTile(x, y);
        });
        /* Show a slightly transparent tile on the GUI grid */
        cell.setOnMouseEntered(event -> {
            hoverTile(x, y);
        });
        /* Remove the preview tile on the GUI grid */
        cell.setOnMouseExited(event -> {
            root.getChildren().remove(hoverCurrentTile);
            hoverCurrentTile.getChildren().clear();
        });
        /* Change the orientation of a preview tile on the GUI grid */
        cell.setOnScroll(event -> {
            // Remove the current tile preview and draw another one
            root.getChildren().remove(hoverCurrentTile);
            hoverCurrentTile.getChildren().clear();
            hoverOrientation = Orientation.next(hoverOrientation);
            hoverTile(x, y);
        });
    }

    // Calculate how many pixels to translate x and y by on window
    private int translateX(char x) { return (x - 'A')*24 + 154; }
    private int translateY(char y) { return (y - 'A')*24 + 30; }

    /* We get the index in the Scene `root`, of the position given */
    private int getIndex(char x, char y) {
        if (y - 'A' == 0) return x - 'A';
        else return (x - 'A')+(y - 'A')*26;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the game
        primaryStage.setTitle("StratoGame");
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);
        newGrid();
        setupGame();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
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
