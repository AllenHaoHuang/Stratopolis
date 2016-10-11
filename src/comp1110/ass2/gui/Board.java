package comp1110.ass2.gui;

import comp1110.ass2.logic.Player;
import comp1110.ass2.logic.Shape;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import comp1110.ass2.logic.*;
import comp1110.ass2.bots.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.util.*;

/**
 * `Board` is the window in which games are played, it is
 * initialised in Menu.
 *
 * @author William Shen - u6096655
 */
class Board extends Stage {
    /* Constants */
    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 720;
    private static final int GRID_SIZE = 26;
    // In pixels, used to help layout
    private static final int CELL_SIZE = 26;
    private static final int X_OFFSET = 135;
    private static final int Y_OFFSET = 45;

    /* Variables for JavaFX */
    private final Stage primaryStage = new Stage();
    private final Group root = new Group();
    private final Group greenCurrentTile = new Group();
    private final Group greenNextTile = new Group();
    private final Group redCurrentTile = new Group();
    private final Group redNextTile = new Group();
    private final Group hoverCurrentTile = new Group();
    private final Group hintTile = new Group();

    private Label greenPiecesLeft = new Label();
    private Label redPiecesLeft = new Label();
    private Label playerTurn = new Label();

    private Button greenHint = new Button();
    private Button redHint = new Button();
    private Label greenHintLbl;
    private Label redHintLbl;

    /* Class variables to store the board, and associated options */
    private BoardState boardState = new BoardState();
    private Player greenState;
    private Player redState;
    private int greenDifficulty;
    private int redDifficulty;
    private int hintCount;
    private int greenHintCount;
    private int redHintCount;
    private Orientation hoverOrientation = Orientation.A;

    /* Prepare everything accordingly for play */
    private void setupGame() {
        // Large box identifiers - i.e. panels
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
        // Place labels to identify players. If they are bot we label the bot's difficulty
        Label greenPlayer = (greenState.isHuman()) ? new Label("Player Green")
                : new Label(greenState.toString());
        greenPlayer.setFont(Font.font("System", FontWeight.BOLD, 18));
        greenPlayer.setPrefWidth(X_OFFSET);
        greenPlayer.setAlignment(Pos.CENTER);
        greenPlayer.setTranslateY(10);
        Label redPlayer = (redState.isHuman()) ? new Label("Player Red")
                : new Label(redState.toString());
        redPlayer.setFont(Font.font("System", FontWeight.BOLD, 18));
        redPlayer.setPrefWidth(X_OFFSET - 5);
        redPlayer.setAlignment(Pos.CENTER);
        redPlayer.setTranslateX(X_OFFSET + CELL_SIZE * GRID_SIZE);
        redPlayer.setTranslateY(10);
        // Set up the 'pieces left' labels
        greenPiecesLeft.setFont(Font.font("Open Sans", 16));
        greenPiecesLeft.setPrefWidth(X_OFFSET);
        greenPiecesLeft.setAlignment(Pos.CENTER);
        greenPiecesLeft.setTranslateY(180);
        redPiecesLeft.setFont(Font.font("Open Sans", 16));
        redPiecesLeft.setPrefWidth(X_OFFSET);
        redPiecesLeft.setAlignment(Pos.CENTER);
        redPiecesLeft.setTranslateX(X_OFFSET + CELL_SIZE * GRID_SIZE - 5);
        redPiecesLeft.setTranslateY(180);
        // Set up the main status label on the screen
        playerTurn.setFont(Font.font("System", FontWeight.BOLD, 18));
        playerTurn.setPrefWidth(BOARD_WIDTH - 2 * X_OFFSET);
        playerTurn.setTranslateX(X_OFFSET+5);
        playerTurn.setTranslateY(10);
        playerTurn.setAlignment(Pos.CENTER);
        root.getChildren().addAll(greenPlayer, redPlayer, greenPiecesLeft, redPiecesLeft, playerTurn);
        // Setup hints if the player is human and we have allocated hints
        if (greenState.isHuman() && greenHintCount != 0) {
            // Set up labels and buttons
            greenHintLbl = new Label("Hints Left: " + greenHintCount);
            greenHintLbl.setPrefWidth(X_OFFSET);
            greenHintLbl.setAlignment(Pos.CENTER);
            greenHintLbl.setFont(Font.font(16));
            greenHintLbl.setTranslateY(BOARD_HEIGHT - 85);
            greenHint = new Button("Hint");
            greenHint.setId("control-btn");
            greenHint.setPrefWidth(80);
            greenHint.setTranslateX(27);
            greenHint.setTranslateY(BOARD_HEIGHT - 50);
            root.getChildren().addAll(greenHintLbl, greenHint);
            // Show hint by using EasyBot
            greenHint.setOnAction(event -> {
                if (greenHintCount == 0) {
                    greenHint.setDisable(true);
                    return;
                }
                greenHint.setDisable(true);
                EasyBot hint = new EasyBot(boardState, true);
                showHint(hint.getMove());
                greenHintLbl.setText("Hints Left: " + --greenHintCount);
            });
        }
        if (redState.isHuman() && redHintCount != 0) {
            // Set up labels and buttons
            redHintLbl = new Label("Hints Left: " + redHintCount);
            redHintLbl.setPrefWidth(X_OFFSET);
            redHintLbl.setAlignment(Pos.CENTER);
            redHintLbl.setFont(Font.font(16));
            redHintLbl.setTranslateX(X_OFFSET + CELL_SIZE * GRID_SIZE);
            redHintLbl.setTranslateY(BOARD_HEIGHT - 85);
            redHint = new Button("Hint");
            redHint.setDisable(true);
            redHint.setId("control-btn");
            redHint.setPrefWidth(80);
            redHint.setTranslateX(X_OFFSET + CELL_SIZE * GRID_SIZE + 27);
            redHint.setTranslateY(BOARD_HEIGHT - 50);
            root.getChildren().addAll(redHintLbl, redHint);
            // Show hint by using EasyBot
            redHint.setOnAction(event -> {
                if (redHintCount == 0) {
                    redHint.setDisable(true);
                    return;
                }
                redHint.setDisable(true);
                EasyBot hint = new EasyBot(boardState, false);
                showHint(hint.getMove());
                redHintLbl.setText("Hints Left: " + --redHintCount);
            });
        }
        // Initialise the 'deck' of tiles for the players and display them
        setupPlayerTiles();
    }

    private void setupPlayerTiles() {
        // Create the pieces for the players
        boardState.createPlayerPieces();
        // Show the tile previews and disable red player hint button for green's turn
        previewTiles(true);
        previewTiles(false);
        redHint.setDisable(true);
        // Set player's turn
        playerTurn.setTextFill(Color.GREEN);
        playerTurn.setText("Green Player's Turn");
    }

    private void previewTiles(boolean isGreenTurn) {
        // Set up variables for ease of use
        LinkedList<Shape> greenShapes = boardState.getGreenShapes();
        LinkedList<Shape> redShapes = boardState.getRedShapes();

        // Show how many pieces a player has left and the current score
        if (isGreenTurn) {
            greenPiecesLeft.setText(greenShapes.size() + " piece(s) left"
                    + "\nScore = " + boardState.getScore(true));
            playerTurn.setTextFill(Color.RED);
            playerTurn.setText("Red Player's Turn");
            if (redHintCount != 0) redHint.setDisable(false);
            greenHint.setDisable(true);
            greenNextTile.setVisible(false);
            redNextTile.setVisible(true);
        } else {
            redPiecesLeft.setText(redShapes.size() + " piece(s) left"
                    + "\nScore = " + boardState.getScore(false));
            playerTurn.setTextFill(Color.GREEN);
            playerTurn.setText("Green Player's Turn");
            if (greenHintCount != 0) greenHint.setDisable(false);
            redHint.setDisable(true);
            redNextTile.setVisible(false);
            greenNextTile.setVisible(true);
        }
        
        // Check if we are approaching the end game state, if so translate pieces left labels accordingly
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
            zero.setTranslateX(41); zero.setTranslateY(50);
            one.setTranslateX(zero.getTranslateX() + CELL_SIZE); one.setTranslateY(50);
            two.setTranslateX(41); two.setTranslateY(zero.getTranslateY() + CELL_SIZE);
            greenCurrentTile.getChildren().addAll(zero, one, two);
            root.getChildren().add(greenCurrentTile);
        } else {
            root.getChildren().remove(redCurrentTile);
            redCurrentTile.getChildren().clear();
            // Set up position of cells on screen
            zero.setTranslateX(X_OFFSET + GRID_SIZE * CELL_SIZE + 41); zero.setTranslateY(50);
            one.setTranslateX(zero.getTranslateX() + CELL_SIZE); one.setTranslateY(50);
            two.setTranslateX(zero.getTranslateX()); two.setTranslateY(zero.getTranslateY() + CELL_SIZE);
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
            zero.setTranslateX(41); zero.setTranslateY(115);
            one.setTranslateX(zero.getTranslateX() + CELL_SIZE); one.setTranslateY(115);
            two.setTranslateX(41); two.setTranslateY(zero.getTranslateY() + CELL_SIZE);
            greenNextTile.getChildren().addAll(zero, one, two);
            greenNextTile.setOpacity(0.55);
            root.getChildren().add(greenNextTile);
        } else {
            root.getChildren().remove(redNextTile);
            redNextTile.getChildren().clear();
            // Set up position of cells on screen
            zero.setTranslateX(X_OFFSET + GRID_SIZE * CELL_SIZE + 41); zero.setTranslateY(115);
            one.setTranslateX(zero.getTranslateX() + CELL_SIZE); one.setTranslateY(115);
            two.setTranslateX(zero.getTranslateX()); two.setTranslateY(zero.getTranslateY() + CELL_SIZE);
            redNextTile.getChildren().addAll(zero, one, two);
            redNextTile.setOpacity(0.55);
            root.getChildren().add(redNextTile);
        }
    }

    private void endGame() {
        // Print game state to terminal
        System.out.println("\nPlacement String: " + boardState.getPlacementString());
        // Update label text and disable grid, remove hint controls
        disableGrid();
        root.getChildren().removeAll(greenHint, greenHintLbl, redHint, redHintLbl);
        playerTurn.setTextFill(Color.DEEPPINK);
        playerTurn.setText("Game finished.");

        // Show who has won the game and display scores
        Score greenScore = new Score(boardState, Colour.Green);
        Score redScore = new Score(boardState, Colour.Red);

        scorecheck :
        if (greenScore.getScore() > redScore.getScore()) {
            playerTurn.setText("Player Green wins! Green = " + greenScore.getScore() + ", Red = " + redScore.getScore());
            System.out.println("Player Green wins! Green = " + greenScore.getScore() + ", Red = " + redScore.getScore());
        } else if (redScore.getScore() > greenScore.getScore()) {
            playerTurn.setText("Player Red wins! Green = " + greenScore.getScore() + ", Red = " + redScore.getScore());
            System.out.println("Player Red wins! Green = " + greenScore.getScore() + ", Red = " + redScore.getScore());
        } else {
            // Cascade down the value of the largest regions, no duplicates
            TreeSet<Integer> greenSet = greenScore.getPrevArea();
            TreeSet<Integer> redSet = redScore.getPrevArea();
            while (greenSet.size() > 0 && redSet.size() > 0) {
                int green = greenSet.pollFirst();
                int red = redSet.pollFirst();
                if (green > red) {
                    playerTurn.setText("Player Green wins tie decision by larger area! Green = " + green + ", Red = " + red);
                    System.out.println("Player Green wins tie decision by larger area! Green = " + green + ", Red = " + red);
                    break scorecheck; // exit to main endGame() function
                } else if (red > green) {
                    playerTurn.setText("Player Red wins tie decision by larger area! Green = " + green + ", Red = " + red);
                    System.out.println("Player Red wins tie decision by larger area! Green = " + green + ", Red = " + red);
                    break scorecheck; // exit to main endGame() function
                }
            }
            // Randomly select winner. 0 = GREEN, 1 = RED
            int coin = new Random().nextInt(2);
            if (coin == 0) {
                playerTurn.setText("Player Green wins by coin toss!");
                System.out.println("Player Green wins by coin toss!");
            } else {
                playerTurn.setText("Player Red wins by coin toss!");
                System.out.println("Player Red wins by coin toss!");
            }
        }

        /* Controls to set up new game if necessary */
        Button playAgain = new Button("Play\nAgain");
        playAgain.setId("control-btn");
        playAgain.setPrefWidth(100);
        playAgain.setOnAction(event -> {
            resetGame();
            System.out.println("\nNew game! " + greenState + " vs. " + redState);
        });
        Button menu = new Button("Menu");
        menu.setId("control-btn");
        menu.setPrefWidth(100);
        menu.setOnAction(event -> {
            primaryStage.close();
        });
        Button exit = new Button("Exit");
        exit.setId("control-btn");
        exit.setPrefWidth(100);
        exit.setOnAction(event -> {
            // Ask user if they want to exit the whole game
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                    "Do you really want to exit?", ButtonType.NO, ButtonType.YES);
            Optional<ButtonType> response = confirm.showAndWait();
            if (response.isPresent() && ButtonType.YES.equals(response.get())) System.exit(0);
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(playAgain, menu, exit);
        vBox.setTranslateX((X_OFFSET - 100) / 2);
        vBox.setTranslateY(BOARD_HEIGHT - 200);
        vBox.setSpacing(20);

        root.getChildren().addAll(vBox);
        root.requestFocus();
    }

    // Start new game
    private void resetGame() {
        // Create new BoardState, reset hint count
        boardState = new BoardState();
        greenHintCount = hintCount;
        redHintCount = hintCount;
        // Setup UI and bots for new game
        newGrid();
        setupGame();
        disableGrid();
        botPlay();
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
                addCell(x, y, null);
            }
        }
        // Set the initial 'MMUA' piece
        addCell('M', 'M', Colour.Red);
        addCell('M', 'N', Colour.Green);
    }

    // Disable the grid at end of game or when bot is thinking to prevent clicks or hovering
    private void disableGrid() {
        for (int i = 0; i < GRID_SIZE * GRID_SIZE; i++)
            root.getChildren().get(i).setDisable(true);
    }
    // Enable grid
    private void enableGrid() {
        for (int i = 0; i < GRID_SIZE * GRID_SIZE; i++)
            root.getChildren().get(i).setDisable(false);
    }

    // Get the tile returned by the EasyBot and show it on the screen
    private void showHint(Tile tile) {
        char x = tile.getPosition().getCharX();
        char y = tile.getPosition().getCharY();
        switch (tile.getOrientation()) {
            case A :
                hintCell(x, y);
                hintCell((char)(x+1), y);
                hintCell(x, (char)(y+1));
                break;
            case B :
                hintCell(x, y);
                hintCell(x, (char)(y+1));
                hintCell((char)(x-1), y);
                break;
            case C :
                hintCell(x, y);
                hintCell((char)(x-1), y);
                hintCell(x, (char)(y-1));
                break;
            case D :
                hintCell(x, y);
                hintCell(x, (char)(y-1));
                hintCell((char)(x+1), y);
                break;
        }
        hintTile.setMouseTransparent(true);
        root.getChildren().add(hintTile);
    }

    // Show a cell of a hint tile on the screen
    private void hintCell(char x, char y) {
        // Create new cell, change its properties and add to group
        Cell cell = new Cell();
        cell.setTranslateX(translateX(x));
        cell.setTranslateY(translateY(y));
        hintTile.getChildren().add(cell);
    }

    private void hoverTile(char x, char y) {
        // Check end game state
        if (boardState.getRedShapes().isEmpty()) {
            endGame();
            return;
        }
        // Get the shape we need to hover
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
        Cell cell = new Cell(colour, boardState.isGreenTurn());
        cell.setTranslateX(translateX(x));
        cell.setTranslateY(translateY(y));
        hoverCurrentTile.getChildren().add(cell);
    }

    private void addTile(char x, char y) {
        // Create a new tile
        Shape shape = (boardState.isGreenTurn()) ? boardState.getGreenShapes().getFirst()
                : boardState.getRedShapes().getFirst();
        Tile tile = new Tile(new Position(x, y), shape, hoverOrientation);
        // Add a new tile to our board if it is valid
        if (boardState.isTileValid(tile)) {
            // Remove hint tile and add new tile to board
            root.getChildren().remove(hintTile);
            hintTile.getChildren().clear();
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
        previewTiles(boardState.isRedTurn());

        // Reset preview orientation and check if bot is playing
        hoverOrientation = Orientation.A;
        botPlay();
    }

    // Add tile to board for bot, assume valid tile input
    private void addTile(Tile tile) {
        root.getChildren().remove(hintTile);
        hintTile.getChildren().clear();
        boardState.addTile(tile);

        // Add cells onto the board based on the tile orientation
        handleOrientation(tile);

        // Preview next tiles and play game for bot
        previewTiles(boardState.isRedTurn());
        botPlay();
    }

    private void handleOrientation(Tile tile) {
        // Add cells with their given colours given their orientation
        char x = tile.getPosition().getCharX();
        char y = tile.getPosition().getCharY();
        Shape shape = tile.getShape();

        switch (tile.getOrientation()) {
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

        // Remove tiles from player pieces accordingly, recall player turn is inverted in BoardState
        if (boardState.getPlayerTurn() == Colour.Red) boardState.getGreenShapes().removeFirst();
        else boardState.getRedShapes().removeFirst();
    }

    private void addCell(char x, char y, Colour colour) {
        // Creating a new cell
        Cell cell;
        // Handling grid identifier cells
        if (colour == null) {
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

        // Disable cursor over boadr
        cell.setCursor(Cursor.NONE);

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
            // Remove the current tile preview and draw another one based on scroll direction
            root.getChildren().remove(hoverCurrentTile);
            hoverCurrentTile.getChildren().clear();
            // Scroll down = clockwise, Scroll up = anti-clockwise
            if (event.getDeltaY() < 0)
                hoverOrientation = hoverOrientation.next();
            else
                hoverOrientation = hoverOrientation.previous();
            hoverTile(x, y);
        });
    }

    // Calculate how many pixels to translate x and y by on window
    private int translateX(char x) { return (x - 'A') * CELL_SIZE + X_OFFSET; }
    private int translateY(char y) { return (y - 'A') * CELL_SIZE + Y_OFFSET; }

    /* We get the index in the Group `root`, of the position given */
    private int getIndex(char x, char y) {
        if (y - 'A' == 0) return x - 'A';
        else return (x - 'A')+(y - 'A')*26;
    }

    private void botPlay() {
        // Check if the current player is human or not, or if it is the end of the game and act accordingly
        if (boardState.isGreenTurn() && greenState.isHuman() || boardState.isRedTurn() && redState.isHuman()) {
            enableGrid();
            return;
        } else if (boardState.getRedShapes().isEmpty()) {
            endGame();
            return;
        } else {
            playerTurn.setText(playerTurn.getText() + ". Bot thinking...");
            disableGrid();
        }
        // Delay the play of the bot so we can see placements as they occur, create a thread
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> actualPlay());
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

        if (boardState.isRedTurn() && redState == Player.EasyBot) {
            EasyBot bot = new EasyBot(boardState, false);
            addTile(bot.getMove());
        } else if (boardState.isRedTurn() && redState == Player.HardBot) {
            HardBot bot = new HardBot(boardState, false, redDifficulty);
            addTile(bot.getMove());
        }
    }

    // Move Cursor bot from http://stackoverflow.com/questions/37500567/javafx-how-to-position-the-mouse
    private void moveCursor(double x, double y) {
        Platform.runLater(() -> {
            try {
                Robot robot = new Robot();
                robot.mouseMove((int) x, (int) y);
            } catch (AWTException e) {
                System.out.println("Something went horribly wrong...");
            }
        });
    }

    Board(Stage parentStage, Player greenState, Player redState, double greenDifficulty, double redDifficulty, int hintCount) {
        // Set player states and difficulty
        this.greenState = greenState;
        this.redState = redState;
        this.greenDifficulty = (int)(greenDifficulty);
        this.redDifficulty = (int)(redDifficulty);
        this.hintCount = this.greenHintCount = this.redHintCount = hintCount;

        // Prepare and show stage
        primaryStage.setTitle("StratoGame");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("assets/G.png")));
        primaryStage.setResizable(false);
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);
        primaryStage.setScene(scene);

        // Open as blocking dialog, so only one instance at a time
        primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.initOwner(parentStage);

        // Add CSS Stylesheet and add Open Sans for buttons
        String style = getClass().getResource("assets/theme.css").toExternalForm();
        scene.getStylesheets().add(style);
        Font.loadFont(getClass().getResourceAsStream("assets/OpenSans-Regular.ttf"), 16);

        // Setup the game
        newGrid();
        setupGame();
        disableGrid();
        botPlay();

                /* Let player's play with arrow keys. Player Green = WASD, Q and E to rotate and CAPS LOCK to place
         * Player Red = IJKL, U and O to rotate and ENTER to place. */
        scene.setOnKeyPressed(event -> {
            // Consume and return if bot is thinking and human key press
            if (boardState.isGreenTurn() && !greenState.isHuman()
                    || boardState.isRedTurn() && !redState.isHuman()) {
                event.consume();
                return;
            }
            // Get which grid char-wise (x, y) the mouse pointer is currently at
            Point p = MouseInfo.getPointerInfo().getLocation();
            Point2D local = root.screenToLocal(p.getX(), p.getY());
            char x = (char)((local.getX() - X_OFFSET)/CELL_SIZE + 'A');
            char y = (char)((local.getY() - Y_OFFSET)/CELL_SIZE + 'A');


            /* Place piece with space bar
            if (event.getCode() == KeyCode.SPACE && boardState.isGreenTurn()
                    || event.getCode() == KeyCode.ENTER && !boardState.isGreenTurn()) {
                addTile(x, y);
            } */
            
            /* Rotate clockwise for E or O key and anticlockwise for Q or I key
             * W = up, A = left, S = down, D = right, CAPS LOCK = place tile
             * I = up, J = left, K = down, L = right, ENTER = place tile
             * We update the preview of the tile accordingly with the key movements */
            if (event.getCode() == KeyCode.Q && boardState.isGreenTurn()
                    || event.getCode() == KeyCode.U && boardState.isRedTurn()) {
                root.getChildren().remove(hoverCurrentTile);
                hoverCurrentTile.getChildren().clear();
                hoverOrientation = hoverOrientation.previous();
                hoverTile(x, y);
            } else if (event.getCode() == KeyCode.E && boardState.isGreenTurn()
                    || event.getCode() == KeyCode.O && boardState.isRedTurn()) {
                root.getChildren().remove(hoverCurrentTile);
                hoverCurrentTile.getChildren().clear();
                hoverOrientation = hoverOrientation.next();
                hoverTile(x, y);
            } else if (event.getCode() == KeyCode.W && boardState.isGreenTurn()
                    || event.getCode() == KeyCode.I && boardState.isRedTurn()) {
                // Must be within the game grid
                if (x >= 'A' && x <= 'Z' && y > 'A' && y <= 'Z' && Position.isOnBoard(hoverOrientation, x, (char)(y-1)))
                    moveCursor(p.getX(), p.getY() - CELL_SIZE);
            } else if (event.getCode() == KeyCode.A && boardState.isGreenTurn()
                    || event.getCode() == KeyCode.J && boardState.isRedTurn()) {
                if (x > 'A' && x <= 'Z' && y >= 'A' && y <= 'Z' && Position.isOnBoard(hoverOrientation, (char)(x-1), y))
                    moveCursor(p.getX() - CELL_SIZE, p.getY());
            } else if (event.getCode() == KeyCode.S && boardState.isGreenTurn()
                    || event.getCode() == KeyCode.K && boardState.isRedTurn()) {
                if (x >= 'A' && x <= 'Z' && y >= 'A' && y < 'Z' && Position.isOnBoard(hoverOrientation, x, (char)(y+1)))
                    moveCursor(p.getX(), p.getY() + CELL_SIZE);
            } else if (event.getCode() == KeyCode.D && boardState.isGreenTurn()
                    || event.getCode() == KeyCode.L && boardState.isRedTurn()) {
                if (x >= 'A' && x < 'Z' && y >= 'A' && y <= 'Z' && Position.isOnBoard(hoverOrientation, (char)(x+1), y))
                    moveCursor(p.getX() + CELL_SIZE, p.getY());
            } else if (event.getCode() == KeyCode.CAPS && boardState.isGreenTurn()
                    || event.getCode() == KeyCode.ENTER && boardState.isRedTurn()) {
                if (x >= 'A' && x <= 'Z' && y >= 'A' && y <= 'Z' && Position.isOnBoard(hoverOrientation, x, y))
                    addTile(x, y);
            }
        });

        // As of now, we cannot terminate a Bot vs Bot game as it is constantly recursively called
        primaryStage.setOnCloseRequest(event -> {
            if (!redState.isHuman() && !greenState.isHuman() && !boardState.isFinished()) {
                Alert message = new Alert(Alert.AlertType.ERROR, "Bot vs Bot game in progress."
                        + " Please wait until the game is finished.");
                message.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                message.showAndWait();
                event.consume();
            } else if (!boardState.isFinished()){
                // If at least one player is human and the game isn't finished, gain user's confirmation
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                        "Game in progress. Do you really want to close?", ButtonType.NO, ButtonType.YES);
                Optional<ButtonType> response = confirm.showAndWait();
                if (response.isPresent() && ButtonType.NO.equals(response.get())) event.consume();
            } else {
                // Game has finished here
                primaryStage.close();
            }
        });

        primaryStage.showAndWait();
    }
}
