package comp1110.ass2.gui;

import comp1110.ass2.logic.Colour;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import comp1110.ass2.StratoGame;

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

    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement  A valid placement string
     */
    void makePlacement(String placement) {
        // FIXME Task 5

        // We clear an existing grid and set the initial tile "MMUA"
        defaultGrid();
        setInitialPiece();

        // We know if |placement| = 4, placement = "MMUA" only
        if (placement.length() == 4) { return; }

        // Loop through the rest of the placement string
        for (int i = 4; i < placement.length(); i += TILE_PLACEMENT_LENGTH) {
            char originX = placement.charAt(i);
            char originY = placement.charAt(i+1);
            char shapeID = placement.charAt(i+2);
            char orientation = placement.charAt(i+3);
            // FIXME: Code in how each piece is placed as a cell on the board
            // check orientation, use Shapes class and use logic
            System.out.println(originX+originY+shapeID+orientation);
            return;
        }

        // Translate position rules, here so you can understand
        char x = 'M', y = 'N';
        int translateX = translateX(x);
        int translateY = translateY(y);
        System.out.println("translateX: " + translateX + ", translateY: "+ translateY);
        int index = getIndex(x, y);
        System.out.println("Index for 'MN' in root group: " + index);
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
        for (int i = 0; i < GRID_SIZE; i++) { // rows
            for (int j = 0; j < GRID_SIZE; j++) { // columns
                char x = (char)(i+'A');
                char y = (char)(j+'A');
                StringBuilder sb = new StringBuilder().append(x).append(y);
                Cell cell = new Cell(sb.toString());
                cell.setTranslateX(j*24 + 63);
                cell.setTranslateY(i*24 + 10);
                root.getChildren().add(cell);
            }
        }
        root.getChildren().add(controls);
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

    /** We represent the grid as a collection of Cells.
     *  Each Cell is initially initalised with their respective coordinate positions.
     *  Cells with colours can be created to fill in a cell
     */
    private class Cell extends StackPane {
        public Cell(String str) {
            Rectangle border = new Rectangle(24, 24);
            border.setFill(null);
            border.setStroke(Color.DARKGRAY);

            Text text = new Text(str);
            text.setFont(Font.font(12));
            text.setFill(Color.GRAY);

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);
        }

        public Cell(Colour colour) {
            Rectangle cell = new Rectangle(24, 24);
            cell.setStroke(Color.gray(0.1));
            cell.setStrokeType(StrokeType.INSIDE);
            cell.setStrokeWidth(2);

            switch(colour) {
                case Black:
                    cell.setFill(Color.BLACK);
                    break;
                case Red:
                    cell.setFill(Color.RED);
                    break;
                case Green:
                    cell.setFill(Color.GREEN);
                    break;
                default :
                    cell.setFill(null);
            }
            getChildren().add(cell);
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
        primaryStage.show();
    }
}
