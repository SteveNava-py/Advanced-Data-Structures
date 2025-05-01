//Name: Steven Marco Navarrette
//Date: 4/8/2025
//Assignment: OOP assignment Exercise 3

package Exercise3;

public class Rectangle implements Shape{ //implements shape interface
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    //getters for Rectangle
    public double getHeight(){
        return height;
    }

    public double getWidth(){
        return width;
    }

    //setters for Rectangle
    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    //area calculation for a rectangle
    @Override
    public double area() {
        return width * height;
    }
}
