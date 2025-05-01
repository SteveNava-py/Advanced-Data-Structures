//Name: Steven Marco Navarrette
//Date: 4/8/2025
//Assignment: OOP assignment Exercise 2
/* Sources: * ChatGPT for ideas for the logic on line 18 */

package Exercise2;

import java.util.Random;

public class LoadedDice extends Random {

    public LoadedDice() {
        super(); //calls the constructor of Random
    }

    @Override
    public int nextInt(int num) {
        if (super.nextBoolean()) { //returns num - 1(highest value) with a 50% chance
            return num - 1;
        } else {
            return super.nextInt(num);
        }
    }
}
