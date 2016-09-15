package comp1110.ass2;

import comp1110.ass2.logic.Shape;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeTest {
    @Test
    public void fromChar() {
        // Set up test values
        Shape[] shapeArr = new Shape[Shape.values().length];
        int i = 0;
        for (Shape shp : Shape.values()) {
            shapeArr[i++] = shp;
        }
        // Check fromChar works properly
        for (i = 0; i < Shape.values().length; i++) {
            assertTrue("For character "+(char)(i+'A')+" expected "+shapeArr[i]+
                        "but got "+Shape.fromChar((char)(i+'A')),
                        Shape.fromChar((char)(i+'A')) == shapeArr[i]);
        }
    }

    @Test
    public void toChar() {
        // Set up test values
        char[] charArr = new char[Shape.values().length];
        for (int i = 0; i < Shape.values().length; i++) {
            charArr[i] = (char)(i+'A');
        }
        // Set up last value for NULL enum type
        charArr[Shape.values().length-1] = '\0';
        // Check fromChar works properly
        int j = 0;
        for (Shape shp : Shape.values()) {
            assertTrue("For shape "+shp+" expected "+charArr[j]+"but got "+Shape.toChar(shp),
                    Shape.toChar(shp) == charArr[j]);
            j++;
        }
    }

}