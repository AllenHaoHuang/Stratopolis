package comp1110.ass2;

import comp1110.ass2.logic.Orientation;
import comp1110.ass2.logic.Tile;
import org.junit.Test;
import comp1110.ass2.logic.Position;
import comp1110.ass2.logic.Shape;

import static org.junit.Assert.*;

/**
 * Created by yjl427 on 2016/9/20.
 */
public class isOnBoardTest {
    @Test
    public void checkOrientation(){
        for (Orientation orientation : Orientation.values()) {
            for (char i = 'A'; i <= 'Z'; i++) {
                for (char j = 'A'; j <= 'Z'; j++) {
                    Position pos = new Position(i, j);
                    Tile tile = new Tile(pos, Shape.A, orientation);
                    switch (orientation) {
                        case A :
                            if (i == 'Z' || j == 'Z') {
                                assertTrue("Tile " + tile + " is not on board, " +
                                        "but we get that it is", tile.isOnBoard() == false);
                            } else {
                                assertTrue("Tile " + tile + " is on board, " +
                                        "but we get that it isn't", tile.isOnBoard() == true);
                            }
                            return;
                        case B :
                            if (i == 'A' || j == 'Z') {
                                assertTrue("Tile " + tile + " is not on board, " +
                                        "but we get that it is", tile.isOnBoard() == false);
                            } else {
                                assertTrue("Tile " + tile + " is on board, " +
                                        "but we get that it isn't", tile.isOnBoard() == true);
                            }
                            return;
                        case C :
                            if (i == 'A' || j == 'A') {
                                assertTrue("Tile " + tile + " is not on board, " +
                                        "but we get that it is", tile.isOnBoard() == false);
                            } else {
                                assertTrue("Tile " + tile + " is on board, " +
                                        "but we get that it isn't", tile.isOnBoard() == true);
                            }
                            return;
                        case D :
                            if (i == 'Z' || j == 'A') {
                                assertTrue("Tile " + tile + " is not on board, " +
                                        "but we get that it is", tile.isOnBoard() == false);
                            } else {
                                assertTrue("Tile " + tile + " is on board, " +
                                        "but we get that it isn't", tile.isOnBoard() == true);
                            }
                            return;
                        default :
                            return;
                    }
                }
            }
        }
    }
}
