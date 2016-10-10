package comp1110.ass2.logic;

/**
 * `Orientation` is the enumeration used to identify the
 * orientation of a tile:
 *    - A: upright
 *    - B: rotate 90 degrees clockwise
 *    - C: rotated 180 degrees
 *    - D: rotate 90 degrees anticlockwise
 *
 * @author William Shen - u6096655
 */
public enum Orientation {
    A, B, C, D;

    /* Return the Orientation enum given a character input */
    public static Orientation fromChar(char ch) {
        switch (ch) {
            case 'A': return Orientation.A;
            case 'B': return Orientation.B;
            case 'C': return Orientation.C;
            default : return Orientation.D;
        }
    }

    /* Return a character given an Orientation input */
    public static char toChar(Orientation orientation) {
        switch (orientation) {
            case A : return 'A';
            case B : return 'B';
            case C : return 'C';
            default : return 'D';
        }
    }

    // For storing static enum values
    private static Orientation[] enumValues = values();

    /* Return the next Orientation enum for changing hover piece orientation on the board */
    public Orientation next() {
        return values()[(ordinal() + 1) % enumValues.length];
    }

    /* Return the previous Orientation enum for scrolling on the board */
    public Orientation previous() {
        int rem = (ordinal() - 1) % enumValues.length;
        if (rem < 0) rem += enumValues.length;
        return values()[rem];
    }
}
