/*
Name: Steven Marco Navarrette
Date: 2/19/2025
Assignment: Centipede game
 */

package CentipedeGame;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    private Clip clip; // clip variable

    // method that plays desired soundtrack
    public void play(String filePath) {
        try {
            stop(); // stops the background music
            File file = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY); // loops the new background music
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // method to play the blaster sound effect called in the game panel class to not interrupt background music
    public void blaster(String filePathII) {
        try {
            File fileII = new File(filePathII);
            AudioInputStream audio = AudioSystem.getAudioInputStream(fileII);
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // method to play the victory theme in the game panel class to not overlap with other background music
    public void finale(String filePathIII) {
        try {
            stop();
            File fileIII = new File(filePathIII);
            AudioInputStream audioII = AudioSystem.getAudioInputStream(fileIII);
            clip = AudioSystem.getClip();
            clip.open(audioII);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // method that stops the background music
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
