package FallingSand;
import javax.swing.JFrame;

public class ControlSand {
    public static void main(String[] args) {
        FallingSandDoubleBuffering game = new FallingSandDoubleBuffering();
        JFrame frame = new JFrame();
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.run();
    }
}