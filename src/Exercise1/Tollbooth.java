//Name: Steven Marco Navarrette
//Date: 4/7/2025
//Assignment: OOP assignment Exercise 1

package Exercise1;

public class Tollbooth {
    //declaring the number of trucks and receipt variables
    private int trucks;
    private int receipts;

    //scanTruck method for calculating the toll based on user input
    //scanTruck method also counts the number of trucks and adds the total amount of toll money
    public int scanTruck(Truck truck) {
        int a = truck.getAxles();
        int w = truck.getWeight();

        int toll = (5 * a) + (10 * (w / 1000));
        System.out.println("\nYour calculated toll is: " + toll + "$");
        System.out.println();

        trucks++;
        receipts += toll;
        return toll;
    }

    public Tollbooth() {
        this.trucks = 0;
        this.receipts = 0;
    }

    public Tollbooth(Tollbooth booth) {
        this.trucks = booth.trucks;
        this.receipts = booth.receipts;
    }

    //displayTotal method displays the total amount of toll money collected which is returned form the scanTruck method
    public void displayTotal() {
        System.out.println("\n#Trucks: " + " " + trucks + "\n" +
                "Total Amount: " + receipts + "$");
        System.out.println();

    }

    //removeDrawer method that does the same as displayTotal except it makes a copy of the toll and resets the count of trucks and receipts back to 0
    public void removeDrawer() {
        System.out.println("\n*** Collecting Receipts ***");
        System.out.println("#Trucks: " + " " + trucks + "\n" +
                "Total Amount: " + receipts + "$");
        System.out.println();

        Tollbooth tollsCopy = new Tollbooth(this);

        trucks = 0;
        receipts = 0;
    }
}
