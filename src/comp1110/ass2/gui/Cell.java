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

class Cell extends StackPane {

    Cell(String str) {
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

    Cell(Colour colour) {
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

    Cell(Colour colour, boolean isGreen) {
        // Create the hover cell and fill it with the relevant colour
        Rectangle cell = new Rectangle(24, 24);
        // Change border colours to recognise each player
        if (isGreen) cell.setStroke(Color.LIGHTGREEN);
        else cell.setStroke(Color.LIGHTPINK);
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

    Cell(Colour colour, int height) {
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
        // We create the text to indicate the position
        Text text = new Text(String.valueOf(height));
        text.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        text.setFill(Color.WHITE);
        setAlignment(Pos.CENTER);
        // Add the cell with height text
        getChildren().addAll(cell, text);
    }
}
