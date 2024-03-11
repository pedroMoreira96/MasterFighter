package io.codeforall.gameweek;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Round2 implements Runnable {

    private Clip round2Sound;

    public Round2() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        AudioInputStream round2SoundStream = AudioSystem.getAudioInputStream(new File("resources/round2.wav").getAbsoluteFile());
        round2Sound = AudioSystem.getClip();
        round2Sound.open(round2SoundStream);
        FloatControl gainControl = (FloatControl) round2Sound.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(+6.0f);
        //attackSound.loop(Clip.LOOP_CONTINUOUSLY);
    }

    @Override
    public void run() {
        round2Sound.start();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
    }
}
