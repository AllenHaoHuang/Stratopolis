package comp1110.ass2.bots;

public enum Player {
    Human("Human"),
    EasyBot("Easy Bot"),
    HardBot("Hard Bot");

    private final String player;

    Player(String player) {
        this.player = player;
    }

    public Player getNext() {
        return values()[(ordinal() + 1) % values().length];
    }

    public Boolean isHuman() {
        return (this == Human);
    }

    @Override
    public String toString() {
        return player;
    }
}