package comp1110.ass2.logic;

/**
 *  Created by William Shen on 15/08/16
 */

public enum Colour {
    // The colours on our pieces
    Red, Green, Black, NULL;

    public static Colour getValue(Colour colour) {
        switch (colour) {
            case Red :
                return Red;
            case Green :
                return Green;
            case Black :
                return Black;
            default :
                return NULL;
        }
    }
    public Colour nextPlayer() {
        if (this == Red)
            return Green;
        else if (this == Green)
            return Red;
        else
            return NULL;
    }

    public boolean isGreen() {
        return this == Green;
    }
}
