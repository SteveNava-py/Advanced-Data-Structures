//Name: Steven Marco Navarrette
//Date: 4/9/2025
//Assignment: OOP assignment Exercise 3

/*Sources: *Google AI overview for reference on format and structure on junit testing
            *ChatGPT for more ideas on what to test and how to execute the program on command line */

package Exercise3;

import static org.junit.jupiter.api.Assertions.*; //imports for junit assertions and testing
import org.junit.jupiter.api.Test; //added dependencies to these packages by using IDE's quick solutions

public class TestShape {

    //test for Circle class w/ positive values
    @Test
    public void testCirclePositive() {
        Circle circle = new Circle(4);
        assertEquals(3.14 * 4 * 4, circle.area(), 0.0001);
    }

    //test Circle class with radius of 0
    @Test
    public void testCircleZero() {
        Circle circle = new Circle(0);
        assertEquals(0, circle.area(), 0.0001);
    }

    //test Circle class with a negative radius
    @Test
    public void testCircleNegative() {
        Circle circle = new Circle(-5);
        assertEquals(3.14 * 25, circle.area(), 0.0001);
    }

    //test Rectangle class with positive dimensions
    @Test
    public void testRectanglePositive() {
        Rectangle rectangle = new Rectangle(4, 3);
        assertEquals(12, rectangle.area(), 0.0001);
    }

    //test Rectangle class with a height or width of 0
    @Test
    public void testRectangleZeroHeight() {
        Rectangle rectangle = new Rectangle(0, 5);
        assertEquals(0, rectangle.area(), 0.0001);
    }

    @Test
    public void testRectangleZeroWidth() {
        Rectangle rectangle = new Rectangle(3, 0);
        assertEquals(0, rectangle.area(), 0.0001);
    }

    //test Rectangle class with Negative height and width
    @Test
    public void testRectangleNegativeValues() {
        Rectangle rectangle = new Rectangle(-3, -4);
        assertEquals(12, rectangle.area(), 0.0001);
    }
}

