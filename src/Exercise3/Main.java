//Name: Steven Marco Navarrette
//Date: 4/8/2025
//Assignment: OOP assignment Exercise 3
/* Sources: Only asked ChatGPT to remind me why it was necessary to override the area methods */

package Exercise3;

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle(4);
        Rectangle r = new Rectangle(4, 3);
        ShowArea(c);
        ShowArea(r);
    }

    public static void ShowArea(Shape s) {
        double area = s.area();
        System.out.println("The area of the shape is " + area);
    }
}
