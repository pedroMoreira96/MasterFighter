package io.codeforall.gameweek;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Round1 implements Runnable{

    private Clip round1Sound;

    public Round1() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        AudioInputStream round1SoundStream = AudioSystem.getAudioInputStream(new File("resources/round1.wav").getAbsoluteFile());
        round1Sound = AudioSystem.getClip();
        round1Sound.open(round1SoundStream);
        FloatControl gainControl = (FloatControl) round1Sound.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(+6.0f);
        //attackSound.loop(Clip.LOOP_CONTINUOUSLY);
    }

    @Override
    public void run() {
        round1Sound.start();
        try{
            Thread.sleep(5000);
        } catch (Exception e) {

        }
    }
}
