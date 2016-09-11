package comp1110.ass2;

import comp1110.ass2.logic.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreTest {

    @Test
    public void getScore() throws Exception {
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