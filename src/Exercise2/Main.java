//Name: Steven Marco Navarrette
//Date: 4/8/2025
//Assignment: OOP assignment Exercise 2

package Exercise2;

import java.util.Random;

public class Main {

    public static void printDiceRolls(Random randGenerator){
        for(int i = 0; i < 100; i++){
            System.out.println(randGenerator.nextInt(6) + 1);
        }
    }

    public static void main(String[] args){
        LoadedDice myDice = new LoadedDice();
        printDiceRolls(myDice);  //uses polymorphism to call LoadedDice.nextInt()
    }
}
