package comp1110.ass2;

import org.junit.Test;

import static org.junit.Assert.*;
import static comp1110.ass2.TestUtility.INVALID_PLACEMENTS;


public class ScoreTest {

    @Test
    public void testEmpty() {
        boolean isGreen = true;
        assertTrue("Null placement string expected score of 0, but got " +
                    StratoGame.getScoreForPlacement(null, isGreen),
                    StratoGame.getScoreForPlacement(null, isGreen) == 0);
        assertTrue("Empty placement string expected score of 0, but got " +
                    StratoGame.getScoreForPlacement("", isGreen),
                    StratoGame.getScoreForPlacement("", isGreen) == 0);
    }

    @Test
    public void testGood() {
        String placement = "MMUANLOBLNBCONSCKLDAPOTCMLEBPLMBKNJDOLNBMLDANPLDNNBAONMCLOFAPQTC";
        int greenScore = 8;
        int redScore = 33;
        boolean isGreen = true;
        assertTrue("Placement Test String: " + placement +
                        "\nExpected score for green player = " + greenScore + ", but got " +
                        StratoGame.getScoreForPlacement(placement, isGreen),
                        StratoGame.getScoreForPlacement(placement, isGreen) == greenScore);
        assertTrue("Placement Test String: " + placement +
                        "\nExpected score for green player = " + greenScore + ", but got " +
                        StratoGame.getScoreForPlacement(placement, !isGreen),
                        StratoGame.getScoreForPlacement(placement, !isGreen) == redScore);
    }

    @Test
    public void testBad() {
        for (int i = 0; i < INVALID_PLACEMENTS.length; i++) {
            String p = INVALID_PLACEMENTS[i];
            assertTrue("Placement '" + p + "' is invalid, but gave score " +
                        StratoGame.getScoreForPlacement(p, true) + " instead of 0",
                        StratoGame.getScoreForPlacement(p, true) == 0);
        }
    }
}