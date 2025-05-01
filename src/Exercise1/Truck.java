//Name: Steven Marco Navarrette
//Date: 4/7/2025
//Assignment: OOP assignment Exercise 1

package Exercise1;

public class Truck {
    //declaring attributes of a truck
    private String make;
    private int axles;
    private int weight;

    //getters for the attributes
    public String getMake() {
        return make;
    }

    public int getAxles() {
        return axles;
    }

    public int getWeight() {
        return weight;
    }

    //setters for the attributes of a truck
    public Truck(String make, int axles, int weight) {
        this.make = make;
        this.axles = axles;
        this.weight = weight;
    }

}
