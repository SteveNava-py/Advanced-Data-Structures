// NAME: Steven Navarrette
// DATE: 1/30/2025
// ENHANCEMENTS: A cosmic background, rainbow sand, and can vacuum sand

package FallingSand;

/** To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.Image;
import java.util.Random; // the random library for fluctuation of rainbow sand and stars
import javax.swing.JPanel;

/**
 * A solution to the flickering problem
 * is a standard technique from graphics programming called double buffering:
 * Create an “offscreen” image that has the same size as the visible window and obtain
 * a Graphics object to draw onto it. Paint the entire frame onto the offscreen image rather than onto the visible window.
 * At the end of p
 * Change Canvas to JPanel (improves flickering a lot)
 * Extensions: Add wind to the model: if a particle has nothing to its right, move it that direction,
 stopping at the edge. Play around with making drifts and dunes.
 • Once you have wind, try applying to only pixels that have nothing above them, so
 the top layer of a structure can continuously erode away.
 **/

public class CosmicSandDoubleBuffering extends JPanel implements MouseListener, MouseMotionListener, Runnable {

    private final int WIDTH = 500;
    private final int HEIGHT = 200;
    private final int SIZE = 2;

    private final boolean[][] sand = new boolean[HEIGHT][WIDTH];
    private final int[][] sandColorIndex = new int[HEIGHT][WIDTH]; //declares the sand particles index as and int
    private boolean active = false;

    private int x; // x and y declared as int
    private int y;

    // declares color of rainbows as Color[] type using color library
    private final Color[] rainbowColors = {
            Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
            Color.BLUE, new Color(75, 0, 130), new Color(143, 0, 255) //adds new colors using their rgb coor. as arguments from color library
    };

    private final int STAR_COUNT = 200; // declaring count of stars as an int
    private final int[] starX = new int[STAR_COUNT]; // declares x and y as indexes of type int of the count of stars
    private final int[] starY = new int[STAR_COUNT];
    private final Color[] starColors = {Color.WHITE, Color.CYAN, Color.BLUE}; // delcares color of stars they will fluctuate

    private Image offscreen;
    private Graphics og;

    public CosmicSandDoubleBuffering() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addMouseListener(this);
        addMouseMotionListener(this);
        generateStars(); //calls method that generates stars
    }

    // method that generates stars
    private void generateStars() {
        Random rand = new Random();
        for (int i = 0; i < STAR_COUNT; i++) {
            starX[i] = rand.nextInt(WIDTH);
            starY[i] = rand.nextInt(HEIGHT);
        }
    }

    public void mousePressed(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
        this.active = true;
    }

    public void mouseDragged(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        this.active = false;
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}

    public void paint(Graphics g) {
        g.drawImage(offscreen, 0, 0, this);
    }

    // draws the background and at each conditional statement implements the stars and their colors
    public void draw() {
        offscreen = createImage(WIDTH, HEIGHT);
        og = offscreen.getGraphics();

        og.setColor(Color.BLACK);
        og.fillRect(0, 0, WIDTH, HEIGHT);

        Random rand = new Random();
        for (int i = 0; i < STAR_COUNT; i++) {
            og.setColor(starColors[rand.nextInt(starColors.length)]);
            og.fillRect(starX[i], starY[i], 2, 2);
        }

        for (int r = 0; r < HEIGHT; r++) {
            for (int c = 0; c < WIDTH; c++) {
                if (sand[r][c]) {
                    og.setColor(rainbowColors[sandColorIndex[r][c]]);
                    og.fillRect(c, r, SIZE, SIZE);
                }
            }
        }
    }

    // method that runs the program
    public void run() {
        boolean running = true;
        while (running) {
            try {
                Thread.sleep(30); // for smoother fluctuation of sand
            } catch (Exception e) {
                e.printStackTrace();
            }

            // will update the sand[][] and sandColorIndex[][]
            if (active) {
                if (y >= 0 && y < HEIGHT && x >= 0 && x < WIDTH) { // Ensure within bounds
                    if (sand[y][x]) {
                        // checks if sand is there and vacuums it if it is
                        sand[y][x] = false;
                    } else {
                        // if no sand is there it will continue falling
                        sand[y][x] = true;
                        sandColorIndex[y][x] = (int) (Math.random() * rainbowColors.length);
                    }
                }
            }

            for (int r = HEIGHT - 2; r >= 0; r--) {
                for (int c = 1; c < WIDTH - 1; c++) {
                    if (!sand[r][c]) continue;

                    //fluctuates through the colors
                    sandColorIndex[r][c] = (sandColorIndex[r][c] + 1) % rainbowColors.length;

                    // for moving down
                    if (!sand[r + 1][c]) {
                        sand[r][c] = false;
                        sand[r + 1][c] = true;
                        sandColorIndex[r + 1][c] = sandColorIndex[r][c];
                    }
                    else if (!sand[r + 1][c - 1]) {
                        sand[r][c] = false;
                        sand[r + 1][c - 1] = true;
                        sandColorIndex[r + 1][c - 1] = sandColorIndex[r][c];
                    }
                    else if (!sand[r + 1][c + 1]) {
                        sand[r][c] = false;
                        sand[r + 1][c + 1] = true;
                        sandColorIndex[r + 1][c + 1] = sandColorIndex[r][c];
                    }
                }
            }
            draw();
            repaint();
        }
    }
}
