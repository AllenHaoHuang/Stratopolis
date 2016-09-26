package comp1110.ass2.logic;

/**
 * `Player` is the enumeration used to identify the
 * state of a player - i.e. Human or Bot and more
 * specifically, Human or Easy Bot or Hard Bot?
 *
 * @author William Shen - u6096655
 */
public enum Player {
    Human("Human"),
    EasyBot("Easy Bot"),
    HardBot("Hard Bot");

    private final String player;

    Player(String player) {
        this.player = player;
    }

    // For storing static enum values
    private static Player[] enumValues = values();

    // Get the next enum of Player for the Menu buttons
    public Player getNext() {
        return values()[(ordinal() + 1) % enumValues.length];
    }

    public Boolean isHuman() {
        return (this == Human);
    }

    @Override
    public String toString() {
        return player;
    }
}