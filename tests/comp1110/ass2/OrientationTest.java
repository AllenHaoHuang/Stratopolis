package comp1110.ass2;

import comp1110.ass2.logic.Orientation;
import comp1110.ass2.logic.Shape;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by allen on 18/09/2016.
 */
public class OrientationTest {
    @Test
    public void fromChar() throws Exception {
        // Set up test values
        Orientation[] orientationArr = new Orientation[Orientation.values().length];
        int i = 0;
        for (Orientation orientation : Orientation.values()) {
            orientationArr[i++] = orientation;
        }
        // Check fromChar works properly
        for (i = 0; i < Orientation.values().length; i++) {
            assertTrue("For character "+(char)(i+'A')+" expected "+orientationArr[i]+
                            "but got "+Orientation.fromChar((char)(i+'A')),
                    Orientation.fromChar((char)(i+'A')) == orientationArr[i]);
        }
    }

    @Test
    public void toChar() throws Exception {
        // Set up test values
        char[] orientationArr = new char[Orientation.values().length];
        for (int i = 0; i < Orientation.values().length; i++) {
            orientationArr[i] = (char)(i+'A');
        }
        // Set up last value for NULL enum type
        orientationArr[Orientation.values().length-1] = '\0';
        // Check toChar works properly
        int j = 0;
        for (Orientation orientation : Orientation.values()) {
            assertTrue("For orientation "+orientation+" expected "+orientationArr[j]+"but got "+Orientation.toChar(orientation),
                    Orientation.toChar(orientation) == orientationArr[j]);
            j++;
        }
    }

    @Test
    public void next() throws Exception {
        assertTrue("Expected B for next orientation after A", Orientation.next(Orientation.A) == Orientation.B);
        assertTrue("Expected C for next orientation after B", Orientation.next(Orientation.B) == Orientation.C);
        assertTrue("Expected D for next orientation after C", Orientation.next(Orientation.C) == Orientation.D);
        assertTrue("Expected A for next orientation after D", Orientation.next(Orientation.D) == Orientation.A);
    }
}