//Name: Steven Marco Navarrette
//Date: 4/8/2025
//Assignment: OOP assignment Exercise 3

package Exercise3;

public class Circle implements Shape{ //implements shape interface
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    } //getter for the radius

    public void setRadius(int radius) {
        this.radius = radius;
    } //setter for the radius

    @Override
    public double area() {
        return 3.14 * (radius * radius);
    } //area calculation method for Circle
}
