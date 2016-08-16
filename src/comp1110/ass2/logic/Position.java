package comp1110.ass2.logic;

/**
 *  Created by William Shen on 15/08/16
 */

public class Position {
    private char x;
    private char y;

    public Position(char x, char y) throws Exception {
        if (x >= 'A' && x <= 'Z' && y >= 'A' && y <= 'Z') {
            this.x = x;
            this.y = y;
        } else {
            throw new Exception("Invalid x or y position");
        }
    }

    @Override
    public String toString() {
        return Character.toString(x) + Character.toString(y);
    }
}
