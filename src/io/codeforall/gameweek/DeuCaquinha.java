package io.codeforall.gameweek;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class DeuCaquinha implements Runnable {

    private Clip deuCaquinhaSound;

    public DeuCaquinha() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        AudioInputStream deuCaquinhaSoundStream = AudioSystem.getAudioInputStream(new File("resources/deucaquinha.wav").getAbsoluteFile());
        deuCaquinhaSound = AudioSystem.getClip();
        deuCaquinhaSound.open(deuCaquinhaSoundStream);
        FloatControl gainControl = (FloatControl) deuCaquinhaSound.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(+6.0f);
        //attackSound.loop(Clip.LOOP_CONTINUOUSLY);
    }

    @Override
    public void run() {
        deuCaquinhaSound.start();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
    }
}
