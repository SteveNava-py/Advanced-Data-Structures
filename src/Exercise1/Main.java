//Name: Steven Marco Navarrette
//Date: 4/7/2025
//Assignment: OOP assignment Exercise 1
/*Sources: * https://stackoverflow.com/questions/59224667/how-to-read-multiple-inputs-on-same-line-in-java
            * https://stackoverflow.com/questions/51572399/how-to-get-user-input-in-same-line */

package Exercise1;

import java.util.Scanner; //scanner library for user input

public class Main {
    public static void main(String[] args) {

        Tollbooth booth = new Tollbooth(); //creates object of Tollbooth
        Scanner scanner = new Scanner(System.in); //creates scanner that reads user input

        while(true){ //infinite while loop for continuous runs
            System.out.println("\nWelcome to the Houston Toll Road\n" + //prompt user
                    "Make One of the Following Selections: \n" +
                    "1 - Scan Truck Info & Display Toll \n" +
                    "2 - Calculate & Display Booth's Total\n" +
                    "3 - Remove Cash Drawer\n" +
                    "4 - Exit");

            int scan = scanner.nextInt(); //read integer from user

            //if & else logic to run the different functionalities implemented in the other class files
            if (scan == 1) {
                System.out.println("\nWhat is the make of your vehicle? : ");
                String m = scanner.nextLine();
                scanner.nextLine(); //this is to clear the buffer

                System.out.println("How many axles does the vehicle have? : ");
                int a = scanner.nextInt();

                System.out.println("How much does your vehicle weight in IBS? : ");
                int w = scanner.nextInt();

                Truck truck = new Truck(m, a, w); //creates object of truck with attributes based on user input

                booth.scanTruck(truck); //passes the new truck object created by the user through the scanTruck method in Tollbooth
            }
            else if (scan == 2) {
                booth.displayTotal(); //calls the displayTotal method in Tollbooth
            }
            else if (scan == 3) {
                booth.removeDrawer(); //calls the remove drawer method in Tollbooth
            }
            else if (scan == 4) {
                System.out.println("\nGoodbye... ");
                return; //quits the program
            } else {
                System.out.println("Invalid input, please try again. "); //error handling for invalid inputs
            }
        }
    }
}