/*
Name: Steven Marco Navarrette
Date: 2/19/2025
Assignment: Centipede game
 */

package CentipedeGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Centipede centipede;
    private LinkedList<Point> bullets = new LinkedList<>();
    private int playerX = 400;
    private int playerY = 550;                                       // new y position for the player to move vertically
    private int level = 1;
    private boolean easyMode = true;
    private boolean running = true;
    private int pWidth = 50;
    private int pHeight = 35;

    private AudioPlayer playAudio = new AudioPlayer();       // creating a variable that represents new audio to be used
    public boolean bossMusic = false;                             // creating variable to represent the boss fight music
    private AudioPlayer playBlaster = new AudioPlayer();

    private Timer timer = new Timer(20, this);

    private int fireRate = 50;                                          // declaring the initial delay for the fire rate
    private long lastFired = 0;                                         // declaring the time stamp of the last shot

    private BufferedImage background;

    public GamePanel() {
        setBackground(Color.BLACK);
        centipede = new Centipede(0, 100, 10);
        timer.start();
        addKeyListener(this);
        setFocusable(true);

        // after setting initial black background, set the stage to be the planet Saturn!
        try {
            background = ImageIO.read(new File("src/CentipedeGame/Battleground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // starts music which is zero's theme from mega man
        playAudio.play("src/CentipedeGame/27 - Zero.wav");
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        if(background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }

        //Draw centipede
        Segment current = centipede.head;
        g.setColor(Color.yellow);
        int segmentSize = centipede.bossFight ? 25 : 15; // makes the boss centipede big
        while (current != null){
            g.fillOval(current.x, current.y, 15, 15);
            current = current.next;
        }

        // when the boss mode is active, brother centipede will appear
        if(centipede.bossFight && centipede.brother != null) {
            current = centipede.brother.head;
            g.setColor(Color.orange);
            while (current != null) {
                g.fillOval(current.x, current.y, segmentSize, segmentSize);
                current = current.next;
            }

        // when you shoot the brother centipedes head, the game is over and you win
        if(centipede.brother.head == null) {
            Font gamefont = new Font("Arial", Font.BOLD, 50);
            g.setFont(gamefont);
            g.setColor(Color.GREEN);
            g.drawString("YOU SAVED THE GALAXY!", getWidth() / 2 - (25*12), getHeight() / 2);
            playAudio.finale("src/CentipedeGame/BGM26.wav");
        }
        }

        //Draw player
        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, pWidth, pHeight); //modified so player would not remain in fixed position vertically

        //Draw bullets
        g.setColor(Color.CYAN);
        for(Point b:bullets) {
            g.fillRect(b.x, b.y, 5, 10);
        }

        //Draw "GAME OVER"
        Font gamefont = new Font("Arial", Font.BOLD, 30);
        g.setFont(gamefont);

        if (!running) {
            g.setColor(Color.RED);
            g.drawString("YOU DIED", getWidth() / 2 - (25 * 5), getHeight() / 2);
        }

    }

    private void checkCollisions(){
        LinkedList<Point> toRemove = new LinkedList<>();

        for (Point bullet : bullets) {
            Segment current = centipede.head;
            while (current != null) {
                double dist = bullet.distance(current.x + 10, current.y + 10);

                if (dist < 15) { //This is a headshot
                    if (current == centipede.head) {
                        level++;
                        if(level == 5) { //debugging
                            System.out.println("you saved the galaxy");
                        }
                        centipede = new Centipede(0, 100, 10 * level);

                        fireRate += 50; //slows down the rate of fire
                    } else { //This is a bodyshot
                        if (easyMode) {
                            centipede.split(current);
                        } else {
                            //Customization for hard mode
                        }
                    }
                    toRemove.add(bullet);
                    break;
                }
                current = current.next;

                // check brother centipede if it's in boss mode
                if (centipede.bossFight && centipede.brother != null) {
                    if (centipede.bossFight && !bossMusic) {
                        playAudio.play("src/CentipedeGame/04. Zero.wav");
                        bossMusic = true;
                    }
                    current = centipede.brother.head;
                    while (current != null) {
                        double dist2 = bullet.distance(current.x + 10, current.y + 10);
                        if (dist2 < 15) {
                            centipede.brother.split(current);
                            toRemove.add(bullet);
                            break;
                        }
                        current = current.next;
                    }
                }
            }
        }
        bullets.removeAll(toRemove);
    }

    private void checkShipCollision(){
        Rectangle shipRect = new Rectangle(playerX, playerY, pWidth, pHeight);

        //Check segment of each snake
        Segment current = centipede.head;
        while (current != null){
            Rectangle segmentRect = new Rectangle(current.x, current.y, 15, 15);

            //If the bounding box rectangle from the ship intersects
            //the bounding box rectangle  form the head of the snake
            if (shipRect.intersects(segmentRect)){
                running = false;    //Declare Game Over
                timer.stop();       //Stop the game completely
                playAudio.stop();   // stop music when game is over
                return;
            }
            current = current.next;
        }

        // check if the boss fight is active and if brother centipede has appeared
        if (centipede.bossFight && centipede.brother != null) {
            current = centipede.brother.head;
            while (current != null) {
                if (shipRect.intersects(new Rectangle(current.x, current.y, 15, 15))) {
                    running = false;
                    timer.stop();
                    return;
                }
                current = current.next;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        centipede.move();
        centipede.checkAndTurn(getWidth(), getHeight());

        //Bullet speed
        for (Point b:bullets){
            b.y -= 15;
        }
        checkCollisions();
        checkShipCollision();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            playerX = Math.max(0, playerX - 50);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            playerX = Math.min(getWidth()-pWidth, playerX + 50);
        }
        // if statements for the player to be able to move vertically
        if (e.getKeyCode() == KeyEvent.VK_UP){
            playerY = Math.max(0, playerY - 50);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            playerY = Math.min(getHeight() - pHeight, playerY + 50);
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){

            //sound effect for blaster
            playBlaster.blaster("src/CentipedeGame/blaster-2-81267.wav");

            // creates variable of time of type long and checks if the cooldown has happened
            // updates the last time the shot was fired
            long current = System.currentTimeMillis();
            if (current - lastFired >= fireRate) {
                bullets.add(new Point(playerX + 20, playerY - 10));
                lastFired = current;
            }
        }
        if(!running){ //player cannot do anything further when dead
            return;
        }
        repaint(); //enforces changes
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}