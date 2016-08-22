package comp1110.ass2.gui;

import comp1110.ass2.logic.Colour;
import comp1110.ass2.logic.Orientation;
import comp1110.ass2.logic.Shape;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import comp1110.ass2.StratoGame;

import java.util.Arrays;

/**
 * A very simple viewer for piece placements in the link game.
 *
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various piece
 * placements.
 */
public class Viewer extends Application {

    /* board layout */
    private static final int VIEWER_WIDTH = 750;
    private static final int VIEWER_HEIGHT = 700;
    private static final int GRID_SIZE = 26;
    private static final int TILE_PLACEMENT_LENGTH = 4;

    private static final String URI_BASE = "assets/";
    private final Group root = new Group();
    private final Group controls = new Group();
    private TextField textField;

    // Array to store heights
    private int[][] heightArray = new int[GRID_SIZE][GRID_SIZE];

    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement  A valid placement string
     */
    void makePlacement(String placement) {
        // We clear an existing grid and set the initial tile "MMUA"
        defaultGrid();
        setInitialPiece();

        // Clear the height array and set 'MMUA' height
        for(int i = 0; i < GRID_SIZE; i++ )
            Arrays.fill(heightArray[i], 0);
        heightArray[12][12]++;
        heightArray[12][13]++;

        // We know if |placement| = 4, placement = "MMUA" only
        if (placement.length() == 4) { return; }

        // Loop through the rest of the placement string
        for (int i = 4; i < placement.length(); i += TILE_PLACEMENT_LENGTH) {
            // We get the X and Y coordinate, and create a Shape and Orientation object
            char originX = placement.charAt(i);
            char originY = placement.charAt(i + 1);
            Shape shapeID = Shape.fromChar(placement.charAt(i + 2));
            Orientation orientation = Orientation.fromChar(placement.charAt(i + 3));

            // Update the height array with the new tile
            updateHeightArray(originX, originY, orientation);

            /* We set a cell on the board according to its orientation.
               Recall that we represent a L-tile as a triple (a, b, c) encoded as:
                     [a = 0]  [b = 1]
                     [c = 2]
               By using the methods in Colour, we can get the colour of a cell
               within a tile at a given index.
            */
            switch(orientation) {
                case A :
                    setCell(originX, originY, shapeID.colourAtIndex(0));
                    setCell((char)(originX+1), originY, shapeID.colourAtIndex(1));
                    setCell(originX, (char)(originY+1), shapeID.colourAtIndex(2));
                    break;
                case B :
                    setCell(originX, originY, shapeID.colourAtIndex(0));
                    setCell(originX, (char)(originY+1), shapeID.colourAtIndex(1));
                    setCell((char)(originX-1), originY, shapeID.colourAtIndex(2));
                    break;
                case C :
                    setCell(originX, originY, shapeID.colourAtIndex(0));
                    setCell((char)(originX-1), originY, shapeID.colourAtIndex(1));
                    setCell(originX, (char)(originY-1), shapeID.colourAtIndex(2));
                    break;
                case D :
                    setCell(originX, originY, shapeID.colourAtIndex(0));
                    setCell(originX, (char)(originY-1), shapeID.colourAtIndex(1));
                    setCell((char)(originX+1), originY, shapeID.colourAtIndex(2));
                    break;
                case NULL:
                    break;
            }
        }
    }

    /* Set a cell on the board */
    private void setCell(char x, char y, Colour colour) {
        // Create a new Cell based on the given colour
        Cell cell;
        if (heightArray[x - 'A'][y - 'A'] > 1 && !(colour.equals(Colour.Black)))
            cell = new Cell(colour, heightArray[x - 'A'][y - 'A']);
        else
            cell = new Cell(colour);
        // How much we translate the cell from (0,0)
        cell.setTranslateX(translateX(x));
        cell.setTranslateY(translateY(y));
        // Add the Cell to the group and hence the Scene
        root.getChildren().set(getIndex(x, y), cell);
    }

    /* Update the height array */
    private void updateHeightArray(char c1, char c2, Orientation orientation) {
        int x = c1 - 'A';
        int y = c2 - 'A';
        switch(orientation) {
            case A:
                heightArray[x][y]++;
                heightArray[x+1][y]++;
                heightArray[x][y+1]++;
                return;
            case B:
                heightArray[x][y]++;
                heightArray[x][y+1]++;
                heightArray[x-1][y]++;
                return;
            case C:
                heightArray[x][y]++;
                heightArray[x-1][y]++;
                heightArray[x][y-1]++;
                return;
            case D:
                heightArray[x][y]++;
                heightArray[x][y-1]++;
                heightArray[x+1][y]++;
                return;
            case NULL:
        }
    }

    /* We get the index in the Scene `root`, of the position given */
    private int getIndex(char x, char y) {
        if (y - 'A' == 0) return x - 'A';
        else return (x - 'A')+(y - 'A')*26;
    }

    // Calculate how many pixels to translate x and y by on window
    private int translateX(char x) { return (x - 'A')*24 + 63; }
    private int translateY(char y) { return (y - 'A')*24 + 10; }

    // Set the initial "MMUA" for ease
    private void setInitialPiece() {
        Cell c1 = new Cell(Colour.Red);
        Cell c2 = new Cell(Colour.Green);
        c1.setTranslateX(351); c1.setTranslateY(298);
        c2.setTranslateX(351); c2.setTranslateY(322);
        root.getChildren().set(324, c1);
        root.getChildren().set(350, c2);
    }

    // We create the default grid
    private void defaultGrid() {
        // Clear any existing children
        root.getChildren().clear();
        // Create grid with cell identifiers
        for (int i = 0; i < GRID_SIZE; i++) { // columns
            for (int j = 0; j < GRID_SIZE; j++) { // rows
                char x = (char)(j+'A');
                char y = (char)(i+'A');
                StringBuilder sb = new StringBuilder().append(x).append(y);
                Cell cell = new Cell(sb.toString());
                cell.setTranslateX(j*24 + 63);
                cell.setTranslateY(i*24 + 10);
                root.getChildren().add(cell);
            }
        }
        root.getChildren().add(controls);
    }

    /** We represent the grid as a collection of Cells.
     *  Each Cell is initially initalised with their respective coordinate positions.
     *  Cells with colours can be created to fill in a cell
     */
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

        private Cell(Colour colour, int height) {
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
            // We create the text to indicate the position
            Text text = new Text(String.valueOf(height));
            text.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            text.setFill(Color.WHITE);
            setAlignment(Pos.CENTER);
            // Add the cell with height text
            getChildren().addAll(cell, text);
        }
    }

    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Placement:");
        textField = new TextField ();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        // Handle <ENTER> key pressed on TextField
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)) handleRefresh();
            }
        });
        // Handle click of `Refresh` button
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                handleRefresh();
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    // Checks if the placement string is valid. If not, show popup dialog
    private void handleRefresh() {
        if(StratoGame.isPlacementValid(textField.getText())) {
            makePlacement(textField.getText());
            textField.clear();
        } else {
            defaultGrid();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid placement string.");
            alert.showAndWait();
            textField.clear();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("StratoGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        // First create grid with cell identifiers then enable controls
        defaultGrid();
        makeControls();

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
