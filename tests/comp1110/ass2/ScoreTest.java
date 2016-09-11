package comp1110.ass2;

import org.junit.Test;

import static org.junit.Assert.*;

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
        System.out.println("Test Placement String: " + placement);
        assertTrue("Expected score for green player = " + greenScore + ", but got " +
                        StratoGame.getScoreForPlacement(placement, isGreen),
                        StratoGame.getScoreForPlacement(placement, isGreen) == greenScore);
        assertTrue("Expected score for red player = " + redScore + ", but got " +
                        StratoGame.getScoreForPlacement(placement, !isGreen),
                        StratoGame.getScoreForPlacement(placement, !isGreen) == redScore);
    }

}