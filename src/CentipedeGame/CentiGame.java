/*
Name: Steven Marco Navarrette
Date: 2/19/2025
Assignment: Centipede game
Modifications:
    - Background is the planet Saturn
    - The player has full range of motion
    - Fire rate decreases each time you kill centipede
    - Boss fight where there are two centipedes: The first one is invulnerable and can only be killed by shooting its head which resets the fight
                                                 The second one can be hurt with your blaster, and you must head-shot it to win the game
    - Music for first stages, boss stage, blaster, and finale
 */

package CentipedeGame;

import javax.swing.*;

public class CentiGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CentipedeGame.Centipede Game");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new GamePanel()) ;
         frame.setVisible(true);
    }
}
