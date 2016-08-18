package comp1110.ass2.logic;

/**
 *  Created by William Shen on 15/08/16
 */

public class Position {
    private char x;
    private char y;

    /* We assume inputs are correctly formatted,
       i.e. 'A' <= x <= 'Z' and 'A' <= y <= 'Z' */
    public Position (char x, char y) {
        this.x = x;
        this.y = y;
    }

    // Return the fields of a Position object
    public int getX() { return x - 'A'; }
    public int getY() { return y - 'A'; }

    @Override
    public String toString() {
        return Character.toString(x) + Character.toString(y);
    }
}
