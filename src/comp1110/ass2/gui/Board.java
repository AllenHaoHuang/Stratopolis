package comp1110.ass2.gui;

import comp1110.ass2.bots.Player;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import comp1110.ass2.logic.*;
import comp1110.ass2.bots.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class Board extends Stage {
    /* Constants */
    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 720;
    private static final int GRID_SIZE = 26;
    // In pixels
    private static final int CELL_SIZE = 26;
    private static final int X_OFFSET = 135;
    private static final int Y_OFFSET = 45;

    /* Class variables to store the board, and decks for the players, and state */
    private BoardState boardState = new BoardState();
    private Player greenState;
    private Player redState;
    private int greenDifficulty;
    private int redDifficulty;
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
    }

    private void setupPlayerTiles() {
        // Create the pieces for the players
        boardState.createPlayerPieces();
        // Show the tile previews
        previewTiles(true);
        previewTiles(false);
        // Set player's turn
        playerTurn.setTextFill(Color.GREEN);
        playerTurn.setText("Green Player's Turn");
    }

    private void previewTiles(boolean isGreenTurn) {
        // Set up variables for ease of use
        LinkedList<Shape> greenShapes = boardState.getGreenShapes();
        LinkedList<Shape> redShapes = boardState.getRedShapes();

        // Show how many pieces a player has left and the score
        if (isGreenTurn) {
            greenPiecesLeft.setText(greenShapes.size() + " piece(s) left."
                    + "\nScore = " + boardState.getScore(true));
            playerTurn.setTextFill(Color.RED);
            playerTurn.setText("Red Player's Turn");
        } else {
            redPiecesLeft.setText(redShapes.size() + " piece(s) left."
                    + "\nScore = " + boardState.getScore(false));
            playerTurn.setTextFill(Color.GREEN);
            playerTurn.setText("Green Player's Turn");
        }
        
        // Check if we are approaching the end game state
        if (isGreenTurn && greenShapes.isEmpty()) {
            // Green runs out of pieces
            root.getChildren().remove(greenCurrentTile);
            greenPiecesLeft.setTranslateY(45);
            return;
        } else if (redShapes.isEmpty()) {
            // Red runs out of pieces, end of game
            root.getChildren().remove(redCurrentTile);
            redPiecesLeft.setTranslateY(45);
            return;
        }

        // We create a new preview cell based on whose turn it is
        if (isGreenTurn) showCurrentTile(greenShapes.getFirst(), true);
        else showCurrentTile(redShapes.getFirst(), false);

        // Add next tile to preview or move the `Pieces Left` label
        if (greenShapes.size() == 1 && isGreenTurn) {
            root.getChildren().remove(greenNextTile);
            greenPiecesLeft.setTranslateY(110);
        } else if (redShapes.size() == 1) {
            root.getChildren().remove(redNextTile);
            redPiecesLeft.setTranslateY(110);
        } else {
            // Get the next shape after the current one - i.e. player has picked up current shape
            Shape shape = (isGreenTurn) ? greenShapes.get(1) : redShapes.get(1);
            showNextTile(shape, isGreenTurn);
        }
    }

    private void showCurrentTile(Shape shape, boolean isGreen) {
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

    private void showNextTile(Shape shape, boolean isGreen) {
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
        // Game state to terminal
        System.out.println("Placement String: " + boardState.getPlacementString());
        // Update label text and disable grid
        disableGrid();

        // Show who has won the game and display scores
        int greenScore = boardState.getScore(true);
        int redScore = boardState.getScore(false);

        playerTurn.setTextFill(Color.DEEPPINK);
        playerTurn.setText("Game finished.");

        Alert test = new Alert(Alert.AlertType.INFORMATION);
        if (greenScore > redScore) {
            System.out.println("Player Green wins! Green = " + greenScore + ", Red = " + redScore);
            test.setTitle("Player Green wins!");
            test.setHeaderText("Player Green wins!");
            test.setContentText("Player Green wins with a score of "
                    + greenScore + ", while Player Red scored " + redScore);
            test.showAndWait();
        } else if (redScore > greenScore) {
            System.out.println("Player Red Wins! Green = " + greenScore + ", Red = " + redScore);
            test.setTitle("Player Red wins!");
            test.setHeaderText("Player Red wins!");
            test.setContentText("Player Red wins with a score of "
                    + redScore + ", while Player Green scored " + greenScore);
            test.showAndWait();
        } else {
            System.out.println("Tie! Green = " + greenScore + ", Red = " + redScore);
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
        if (boardState.getRedShapes().isEmpty()) {
            endGame();
            return;
        }
        // Get the shape to hover
        Shape shape = (boardState.isGreenTurn()) ? boardState.getGreenShapes().getFirst()
                : boardState.getRedShapes().getFirst();

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
        cell = new Cell(colour, boardState.isGreenTurn());
        cell.setTranslateX(translateX(x));
        cell.setTranslateY(translateY(y));
        cell.setOpacity(0.85);
        hoverCurrentTile.getChildren().add(cell);
    }

    private void addTile(char x, char y) {
        // Create a new tile
        Shape shape = (boardState.isGreenTurn()) ? boardState.getGreenShapes().getFirst()
                : boardState.getRedShapes().getFirst();
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
        handleOrientation(tile);

        previewTiles(!boardState.isGreenTurn());
        // Reset preview orientation
        hoverOrientation = Orientation.A;
        botPlay();
    }

    // Add tile to board for bot, assume valid tile input
    private void addTile(Tile tile) {
        boardState.addTile(tile);

        // Add cells onto the board based on the tile orientation
        handleOrientation(tile);
        System.out.println("======== SUCCESS ========\n");

        previewTiles(!boardState.isGreenTurn());
        botPlay();
    }

    private void handleOrientation(Tile tile) {
        char x = tile.getPosition().getCharX();
        char y = tile.getPosition().getCharY();
        Shape shape = tile.getShape();
        Orientation orientation = tile.getOrientation();

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

        if (boardState.getPlayerTurn() == Colour.Red) boardState.getGreenShapes().removeFirst();
        else boardState.getRedShapes().removeFirst();
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

    private void botPlay() {
        if (boardState.isGreenTurn() && greenState.isHuman() || !boardState.isGreenTurn() && redState.isHuman()) {
            enableGrid();
            return;
        } else if (boardState.getRedShapes().isEmpty()) {
            endGame();
            return;
        } else {
            disableGrid();
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        actualPlay();
                    }
                });

            }
        }, 100);
    }

    // Let the bots play a move if it is their turn
    private void actualPlay() {
        // Check for which bot to initialise
        if (boardState.isGreenTurn() && greenState == Player.EasyBot) {
            EasyBot bot = new EasyBot(boardState, true);
            addTile(bot.getMove());
            return;
        } else if (boardState.isGreenTurn() && greenState == Player.HardBot) {
            HardBot bot = new HardBot(boardState, true, greenDifficulty);
            addTile(bot.getMove());
            return;
        }

        // Temporary workaround to prevent unavoidable exceptions
        try {
            if (!boardState.isGreenTurn() && redState == Player.EasyBot) {
                EasyBot bot = new EasyBot(boardState, false);
                addTile(bot.getMove());
            } else if (!boardState.isGreenTurn() && redState == Player.HardBot) {
                HardBot bot = new HardBot(boardState, false, redDifficulty);
                addTile(bot.getMove());
            }
        } catch (Exception e) {
            return;
        }
    }

    Board(Stage parentStage, Player greenState, Player redState, double greenDifficulty, double redDifficulty) {
        // Set player states
        this.greenState = greenState;
        this.redState = redState;
        this.greenDifficulty = (int)(greenDifficulty * 2.5 + 1.5);
        this.redDifficulty = (int)(redDifficulty * 2.5 + 1.5);

        // Prepare and show stage
        Stage primaryStage = new Stage();
        primaryStage.setTitle("StratoGame");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("assets/G.png")));
        primaryStage.setResizable(false);
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);
        primaryStage.setScene(scene);

        // Open as blocking dialog, so only one instance at a time
        primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.initOwner(parentStage);

        newGrid();
        setupGame();

        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            if (boardState.getRedShapes().isEmpty())
                new Alert(Alert.AlertType.ERROR, "Game in progress");
            primaryStage.close();
        });

        disableGrid();
        botPlay();
    }
}
