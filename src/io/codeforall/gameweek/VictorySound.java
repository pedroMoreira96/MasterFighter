package io.codeforall.gameweek;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class VictorySound implements Runnable {

    private Clip victorySound;

    public VictorySound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        AudioInputStream victorySoundStream = AudioSystem.getAudioInputStream(new File("resources/flawlessvictory.wav").getAbsoluteFile());
        victorySound = AudioSystem.getClip();
        victorySound.open(victorySoundStream);
        FloatControl gainControl = (FloatControl) victorySound.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(+6.0f);
        //attackSound.loop(Clip.LOOP_CONTINUOUSLY);
    }

    @Override
    public void run() {
        victorySound.start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
    }
}
