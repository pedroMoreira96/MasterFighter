package io.codeforall.gameweek;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Round3 implements Runnable{

    private Clip round3Sound;

    public Round3() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        AudioInputStream round3SoundStream = AudioSystem.getAudioInputStream(new File("resources/finalround.wav").getAbsoluteFile());
        round3Sound = AudioSystem.getClip();
        round3Sound.open(round3SoundStream);
        FloatControl gainControl = (FloatControl) round3Sound.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(+6.0f);
        //attackSound.loop(Clip.LOOP_CONTINUOUSLY);
    }

    @Override
    public void run() {
        round3Sound.start();
        try{
            Thread.sleep(5000);
        } catch (Exception e) {

        }
    }
}
