package comp1110.ass2.logic;

/**
 *  Created by William Shen on 15/08/16
 */

public class Tile {
    private Position position;
    private Shape shape;
    private Orientation orientation;

    /* Constructor for a Tile - includes where the tile is located,
       which tile it represents, and its orientation */
    public Tile(Position position, Shape shape, Orientation orientation) {
        this.position = position;
        this.shape = shape;
        this.orientation = orientation;
    }

    // Returns the fields of a Tile object
    public Position getPosition() {return position;}
    public Shape getShape() {return shape;}
    public Orientation getOrientation() {return orientation;}

    /**
     *  Return the position of a specific cell of a Tile on the board.
     *  The 'A' orientation of a L-shaped tile based on 'index' is represented as:
     *     [0]  [1]
     *     [2]
     */
    public Position positionAtIndex(int index) {
        // Return the position of the origin cell if zero index is requested
        if (index == 0) return position;

        /* We retrieve the X and Y character coordinates of
           the origin index - i.e. at index = 0. */
        int originX = position.getX() + 'A';
        int originY = position.getY() + 'A';

        // Here, we check the Orientation of our tile and return the relevant Positions
        switch (orientation) {
            case A:
                if (index == 1) return new Position((char)(originX+1), (char)(originY));
                if (index == 2) return new Position((char)(originX), (char)(originY+1));
            case B:
                if (index == 1) return new Position((char)(originX), (char)(originY+1));
                if (index == 2) return new Position((char)(originX-1), (char)(originY));
            case C:
                if (index == 1) return new Position((char)(originX-1), (char)(originY));
                if (index == 2) return new Position((char)(originX), (char)(originY-1));
            case D:
                if (index == 1) return new Position((char)(originX), (char)(originY-1));
                if (index == 2) return new Position((char)(originX+1), (char)(originY));
            default:
                return null; // Something went wrong...
        }
    }

    // Get the x-coordinate at a specific index of a tile
    public int getX(int index) {
        return positionAtIndex(index).getX();
    }

    // Get the y-coordinate at a specific index of a tile
    public int getY(int index) {
        return positionAtIndex(index).getY();
    }

    /* Checks that no part of the tile extends beyond the board */
    public boolean isOnBoard() {
        /* We check the Tile over the orientation. Recall that a coordinate on the board
         * is encoded as (x,y) where 'A' <= x <= 'Z' and 'A' <= y <= 'Z' */
        switch (orientation) {
            case A:
                // At right or bottom edge of the board
                return (!(position.getCharX() == 'Z' || position.getCharY() == 'Z'));
            case B:
                // At left or bottom edge of the board
                return (!(position.getCharX() == 'A' || position.getCharY() == 'Z'));
            case C:
                // At left or top edge of the board
                return (!(position.getCharX() == 'A' || position.getCharY() == 'A'));
            case D:
                // At right or top edge of the board
                return (!(position.getCharX() == 'Z' || position.getCharY() == 'A'));
            default:
                return false;
        }
    }
    
    // Prints out tile in 4-character string format
    @Override
    public String toString() {
        return position.toString() + Shape.toChar(shape) + Orientation.toChar(orientation);
    }
}
