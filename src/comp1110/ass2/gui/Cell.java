package comp1110.ass2.gui;

import comp1110.ass2.logic.Colour;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * `Cell` is the class used to create coloured square for
 * displaying on the board.
 *
 * @author William Shen - u6096655
 */
class Cell extends StackPane {
    private static final int CELL_SIZE = 26;
    private Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);

    // For creating a cell with coordinates (e.g. MM, MN, etc.)
    Cell(String str) {
        cell.setFill(null);
        cell.setStroke(Color.LIGHTGREY);
        Text text = new Text(str);
        text.setFont(Font.font(12));
        text.setFill(Color.GRAY);
        setAlignment(Pos.CENTER);
        getChildren().addAll(cell, text);
    }

    // For creating a normal cell where the height does not exceed 1
    Cell(Colour colour) {
        setCellStroke();
        setCellColour(colour);
        getChildren().add(cell);
    }

    // For creating a normal cell with a height that is bigger than 1
    Cell(Colour colour, int height) {
        setCellStroke();
        setCellColour(colour);
        Text text = new Text(String.valueOf(height));
        text.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        text.setFill(Color.WHITE);
        setAlignment(Pos.CENTER);
        getChildren().addAll(cell, text);
    }

    // For creating a hover tile with a border colour to identify the player
    Cell(Colour colour, boolean isGreen) {
        if (isGreen) cell.setStroke(Color.LIGHTGREEN);
        else cell.setStroke(Color.LIGHTPINK);
        cell.setStrokeType(StrokeType.INSIDE);
        cell.setStrokeWidth(2);
        cell.setOpacity(0.85);
        setCellColour(colour);
        getChildren().add(cell);
    }

    // For creating a hint tile
    Cell() {
        setCellStroke();
        cell.setFill(Color.YELLOW);
        cell.setOpacity(0.8);
        getChildren().add(cell);
    }

    // Set default cell border/stroke for a Cell
    private void setCellStroke() {
        cell.setStroke(Color.rgb(54, 54, 54));
        cell.setStrokeType(StrokeType.INSIDE);
        cell.setStrokeWidth(2);
    }

    // Set the fill for a cell based on input colour
    private void setCellColour(Colour colour) {
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
        }
    }
}
