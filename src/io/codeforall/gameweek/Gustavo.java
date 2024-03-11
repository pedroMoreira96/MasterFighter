package io.codeforall.gameweek;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Gustavo implements Runnable {

    private Clip gustavoSound;

    public Gustavo() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        AudioInputStream gustavoSoundStream = AudioSystem.getAudioInputStream(new File("resources/Gustavo_JM.wav").getAbsoluteFile());
        gustavoSound = AudioSystem.getClip();
        gustavoSound.open(gustavoSoundStream);
        FloatControl gainControl = (FloatControl) gustavoSound.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(+6.0f);
        //attackSound.loop(Clip.LOOP_CONTINUOUSLY);
    }

    @Override
    public void run() {
        gustavoSound.start();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
    }
}
