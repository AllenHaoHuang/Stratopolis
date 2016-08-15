package comp1110.ass2.logic;

/**
 *  Created by William Shen on 15/08/16
 */

public class Tile {
    Position position;
    Shape shape;
    Orientation orientation;
    Integer height;

    /* Constructor for a Tile - includes where the tile is located,
       which tile it represents, and its orientation */
    public Tile(Position p, Shape s, Orientation o, Integer h) {
        // Needs better parameter names
        this.position = p;
        this.shape = s;
        this.orientation = o;
        this.height = h;
    }

    // To implement - hopefully...
    // Note very carefully how we can stack pieces
    public void translatePiece(Position newPosition) {}
    public void rotatePiece(Orientation newOrientation) {}

    // Needs to print out in the 4-character string format
    @Override
    public String toString() {
        return "";
    }
}
