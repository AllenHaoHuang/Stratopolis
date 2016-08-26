package comp1110.ass2.logic;

/**
 *  Created by William Shen on 15/08/16
 */

public enum Orientation {
    /** The orientation of a piece:
     *    A: upright
     *    B: rotate 90 degrees clockwise
     *    C: rotated 180 degrees
     *    D: rotate 90 degrees anticlockwise
     */
    A, B, C, D, NULL;

    /* Return the Orientation enum given a character input */
    public static Orientation fromChar(char ch) {
        switch (ch) {
            case 'A': return Orientation.A;
            case 'B': return Orientation.B;
            case 'C': return Orientation.C;
            case 'D': return Orientation.D;
            default : return NULL;
        }
    }

    /* Return a character given an Orientation input */
    public static char toChar(Orientation orientation) {
        switch (orientation) {
            case A : return 'A';
            case B : return 'B';
            case C : return 'C';
            case D : return 'D';
            default : return '\0';
        }
    }
}
