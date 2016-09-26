package comp1110.ass2.logic;

/**
 * `Position` is the class we use to identify where
 * a cell, or origin of a tile is on the board. We
 * use characters to describe this.
 *
 * @author William Shen - u6096655
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

    // variation of constructor that takes in ints
    Position (int x, int y) {
        this.x = (char)(x + (int)'A') ;
        this.y = (char)(y + (int)'A');
    }

    // Return the fields of a Position object in int index form
    int getX() { return x - 'A'; }
    int getY() { return y - 'A'; }

    // Return the fields of a Position object in char form
    public char getCharX() { return x; }
    public char getCharY() { return y; }

    @Override
    public String toString() {
        return Character.toString(x) + Character.toString(y);
    }
}
