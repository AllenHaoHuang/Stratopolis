package comp1110.ass2;

import comp1110.ass2.logic.Orientation;
import comp1110.ass2.logic.Shape;
import org.junit.Test;

import static org.junit.Assert.*;

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
        assertTrue("Expected B for next orientation after A", Orientation.A.next() == Orientation.B);
        assertTrue("Expected C for next orientation after B", Orientation.B.next() == Orientation.C);
        assertTrue("Expected D for next orientation after C", Orientation.C.next() == Orientation.D);
        assertTrue("Expected A for next orientation after D", Orientation.D.next() == Orientation.A);
    }

    @Test
    public void previous() throws Exception {
        assertEquals(Orientation.D, Orientation.A.previous());
        assertEquals(Orientation.A, Orientation.B.previous());
        assertEquals(Orientation.B, Orientation.C.previous());
        assertEquals(Orientation.C, Orientation.D.previous());
    }
}