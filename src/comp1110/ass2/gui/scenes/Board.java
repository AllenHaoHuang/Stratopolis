package comp1110.ass2.gui.scenes;

import comp1110.ass2.bots.Player;
import comp1110.ass2.gui.Cell;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import comp1110.ass2.logic.*;
import comp1110.ass2.bots.*;

import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedList;

public class Board extends Scene {
    /* Constants */
    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 720;
    private static final int GRID_SIZE = 26;
    // In pixels
    private static final int CELL_SIZE = 26;
    private static final int X_OFFSET = 135;
    private static final int Y_OFFSET = 45;

    /* Bot States, left uninitialised for now */
    private EasyBot greenEasyBot;
    private EasyBot redEasyBot;
    private HardBot greenHardBot;
    private HardBot redHardBot;

    /* Class variables to store the board, and decks for the players, and state */
    private BoardState boardState = new BoardState();
    private LinkedList<Shape> playerGreen = new LinkedList<>();
    private LinkedList<Shape> playerRed = new LinkedList<>();
    private Player greenState;
    private Player redState;
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
        // Large box identifiers
        Rectangle greenPanel = new Rectangle(X_OFFSET, 752);
        greenPanel.setFill(Color.GREEN);
        greenPanel.setOpacity(0.3);
        Rectangle redPanel = new Rectangle(X_OFFSET, 752);
        redPanel.setFill(Color.RED);
        redPanel.setOpacity(0.3);
        redPanel.setTranslateX(X_OFFSET + CELL_SIZE * GRID_SIZE);
        Rectangle greyPanelTop = new Rectangle(GRID_SIZE * CELL_SIZE, 45);
        greyPanelTop.setFill(Color.GREY);
        greyPanelTop.setOpacity(0.2);
        greyPanelTop.setTranslateX(X_OFFSET);
        root.getChildren().addAll(greenPanel, redPanel, greyPanelTop);
        // Place labels to identify players
        Label greenPlayer = new Label("Player Green");
        Label redPlayer = new Label("Player Red");
        greenPlayer.setFont(Font.font("System", FontWeight.BOLD, 18));
        redPlayer.setFont(Font.font("System", FontWeight.BOLD, 18));
        greenPlayer.setTranslateX(13);
        greenPlayer.setTranslateY(10);
        redPlayer.setTranslateX(X_OFFSET + CELL_SIZE * GRID_SIZE + 14);
        redPlayer.setTranslateY(10);
        // Change position of pieces left
        greenPiecesLeft.setFont(Font.font(16));
        redPiecesLeft.setFont(Font.font(16));
        greenPiecesLeft.setTranslateX(13);
        greenPiecesLeft.setTranslateY(180);
        redPiecesLeft.setTranslateX(X_OFFSET + CELL_SIZE * GRID_SIZE + 10);
        redPiecesLeft.setTranslateY(180);
        // Add labels for pieces left and whose turn it is
        playerTurn.setFont(Font.font("System", FontWeight.BOLD, 18));
        playerTurn.setPrefWidth(676);
        playerTurn.setTranslateX(X_OFFSET);
        playerTurn.setTranslateY(10);
        playerTurn.setAlignment(Pos.CENTER);
        root.getChildren().addAll(greenPlayer, redPlayer, greenPiecesLeft, redPiecesLeft, playerTurn);
        // Initialise the 'deck' of tiles for the players and display them
        setupPlayerTiles();

        // We wait for the green player's turn and display the top pieces
        isGreen = true;
    }

    private void setupPlayerTiles() {
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
        // Show the tile previews
        previewTiles();
        previewTiles();
        // Set player's turn
        playerTurn.setTextFill(Color.GREEN);
        playerTurn.setText("Green Player's Turn");
    }

    private void previewTiles() {
        // Show how many pieces a player has left
        if (isGreen) greenPiecesLeft.setText(playerGreen.size() + " piece(s) left."
                + "\nScore = " + boardState.getScore(true));
        else redPiecesLeft.setText(playerRed.size() + " piece(s) left."
                + "\nScore = " + boardState.getScore(false));

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
            greenPiecesLeft.setTranslateY(45);
            isGreen = !isGreen;
            return;
        } else if (playerRed.size() == 0) {
            // Red runs out of pieces, end of game
            root.getChildren().remove(redCurrentTile);
            redPiecesLeft.setTranslateY(45);
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
            zero.setTranslateX(40); zero.setTranslateY(50);
            one.setTranslateX(64); one.setTranslateY(50);
            two.setTranslateX(40); two.setTranslateY(74);
            greenCurrentTile.getChildren().addAll(zero, one, two);
            root.getChildren().add(greenCurrentTile);
        } else {
            root.getChildren().remove(redCurrentTile);
            redCurrentTile.getChildren().clear();
            // Set up position of cells on screen
            zero.setTranslateX(BOARD_WIDTH - 90); zero.setTranslateY(50);
            one.setTranslateX(zero.getTranslateX() + CELL_SIZE); one.setTranslateY(50);
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
            zero.setTranslateX(40); zero.setTranslateY(115);
            one.setTranslateX(64); one.setTranslateY(115);
            two.setTranslateX(40); two.setTranslateY(139);
            greenNextTile.getChildren().addAll(zero, one, two);
            greenNextTile.setOpacity(0.55);
            root.getChildren().add(greenNextTile);
        } else {
            root.getChildren().remove(redNextTile);
            redNextTile.getChildren().clear();
            // Set up position of cells on screen
            zero.setTranslateX(BOARD_WIDTH - 90); zero.setTranslateY(115);
            one.setTranslateX(zero.getTranslateX() + CELL_SIZE); one.setTranslateY(115);
            two.setTranslateX(zero.getTranslateX()); two.setTranslateY(139);
            redNextTile.getChildren().addAll(zero, one, two);
            redNextTile.setOpacity(0.55);
            root.getChildren().add(redNextTile);
        }
    }

    private void endGame() {
        // Update label text and disable grid
        playerTurn.setTextFill(Color.DEEPPINK);
        playerTurn.setText("Game finished.");
        disableGrid();

        // Show who has won the game and display scores
        int greenScore = boardState.getScore(true);
        int redScore = boardState.getScore(false);
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

    // Disable the grid at end of game to prevent clicks or hovering, e.g. when bot is playing
    private void disableGrid() {
        for (int i = 0; i < GRID_SIZE * GRID_SIZE; i++)
            root.getChildren().get(i).setDisable(true);
    }
    // Enable grid
    private void enableGrid() {
        for (int i = 0; i < GRID_SIZE * GRID_SIZE; i++)
            root.getChildren().get(i).setDisable(false);
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
                playerTurn.setText(playerTurn.getText() + "!");
            else playerTurn.setText("Invalid Tile Placement!");
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
        // Reset preview orientation
        hoverOrientation = Orientation.A;

        // Disable board according to if player is a bot or not
        if ((!isGreen && redState == Player.EasyBot) || isGreen && greenState == Player.EasyBot) {
            System.out.println("disable grid");
            //disableGrid();
            easyGame();
        } else if ((!isGreen && redState == Player.HardBot) || isGreen && greenState == Player.HardBot) {
            System.out.println("disable grid");
            //disableGrid();
            hardGame();
        }
        // Enable board according to if player is a bot or not
        if (!isGreen && (greenState == Player.EasyBot || greenState == Player.HardBot)) {
            System.out.println("enable grid");
            enableGrid();
        } else if (isGreen && (redState == Player.EasyBot || redState == Player.HardBot)) {
            System.out.println("enable grid");
            enableGrid();
        }
    }

    private void addCell(char x, char y, Colour colour) {
        // Creating a new cell
        Cell cell;
        // Handling grid identifier cells
        if (colour == Colour.NULL) {
            cell = new Cell("" + x + y);
            cell.setTranslateX((x - 'A') * CELL_SIZE + X_OFFSET);
            cell.setTranslateY((y - 'A') * CELL_SIZE + Y_OFFSET);
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

        cell.setCursor(Cursor.DISAPPEAR);

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
            if (event.getDeltaY() < 0)
                hoverOrientation = Orientation.next(hoverOrientation);
            else
                hoverOrientation = Orientation.previous(hoverOrientation);
            hoverTile(x, y);
        });
    }

    // Calculate how many pixels to translate x and y by on window
    private int translateX(char x) { return (x - 'A')* CELL_SIZE + X_OFFSET; }
    private int translateY(char y) { return (y - 'A')* CELL_SIZE + Y_OFFSET; }

    /* We get the index in the Scene `root`, of the position given */
    private int getIndex(char x, char y) {
        if (y - 'A' == 0) return x - 'A';
        else return (x - 'A')+(y - 'A')*26;
    }

    // Initialise the bots
    private void newBots() {
        // Green bot
        if (greenState == Player.EasyBot)
            greenEasyBot = new EasyBot(playerGreen, playerRed, true);
        else if (redState == Player.HardBot)
            greenHardBot = new HardBot(playerGreen, playerRed, true);
        // Red bot
        if (redState == Player.EasyBot)
            redEasyBot = new EasyBot(playerGreen, playerRed, false);
        else if (redState == Player.HardBot)
            redHardBot = new HardBot(playerGreen, playerRed, false);
    }

    public Board(Group parentRoot, Player greenState, Player redState) {
        super(parentRoot, BOARD_WIDTH, BOARD_HEIGHT);
        parentRoot.getChildren().add(root);
        this.greenState = greenState;
        this.redState = redState;
        System.out.println("width: " + this.getWidth() + ", height : " + this.getHeight());
        newBots();
        newGrid();
        setupGame();
    }

    /*
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the game
        primaryStage.setTitle("StratoGame");
        Scene scene = new Scene(root, BOARD_WIDTH + 1, BOARD_HEIGHT);
        newGrid();
        setupGame();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        System.out.println("width:" + scene.getWidth() + ", height: " + scene.getHeight());
    }
    */

    // FIXME Task 11: Implement a game that can play valid moves (even if they are weak moves)
    private void easyGame() {
        EasyBot easyBot = new EasyBot(playerGreen, playerRed, true);
        Tile easyMove = easyBot.getMove();
    }

    // FIXME Task 12: Implement a game that can play good moves
    private void hardGame() {
        HardBot hardBot = new HardBot(playerGreen, playerRed, true);
        Tile hardMove = hardBot.getMove();
    }
}
