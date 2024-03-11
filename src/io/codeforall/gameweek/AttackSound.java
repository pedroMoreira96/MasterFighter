package io.codeforall.gameweek;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AttackSound implements Runnable{

    private Clip attackSound;

    public AttackSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        AudioInputStream attackSoundStream = AudioSystem.getAudioInputStream(new File("resources/lightsaber.wav").getAbsoluteFile());
        attackSound = AudioSystem.getClip();
        attackSound.open(attackSoundStream);
        FloatControl gainControl = (FloatControl) attackSound.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-20.0f);
        //attackSound.loop(Clip.LOOP_CONTINUOUSLY);
    }

    @Override
    public void run() {
        attackSound.start();
        try{
            Thread.sleep(5000);
        } catch (Exception e) {

        }
    }
}
