// NAME: Steven Navarrette
// DATE: 1/30/2025
// ENHANCEMENTS: A cosmic background, rainbow sand, and can vacuum sand

package FallingSand;

import javax.swing.JFrame;

/**
 *
 * @author mZaki
 */
public class CosmicSand {
    public static void main(String[] args){

        //FallingSand game = new FallingSand();
        CosmicSandDoubleBuffering game2 = new CosmicSandDoubleBuffering();
        
        JFrame frame = new JFrame();
        frame.add(game2);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Run the main loop
        game2.run();

    }
    
}
