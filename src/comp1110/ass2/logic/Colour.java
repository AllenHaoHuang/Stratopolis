package comp1110.ass2.logic;

/**
 * `Colour` is the enumeration used to identify the
 * colour of a cell, or the colour of a player
 *
 * @author William Shen - u6096655
 */
public enum Colour {
    // The colours on our pieces
    Red, Green, Black;

    public static Colour getValue(Colour colour) {
        switch (colour) {
            case Red :
                return Red;
            case Green :
                return Green;
            default :
                return Black;
        }
    }

    public Colour nextPlayer() {
        if (this == Red)
            return Green;
        else if (this == Green)
            return Red;
        else
            return Black;
    }

    public boolean isGreen() {
        return this == Green;
    }
}
