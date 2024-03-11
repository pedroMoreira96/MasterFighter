package io.codeforall.gameweek;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class InputHandlerStartScreen implements KeyboardHandler {

    private GameEngine startScreen;
    private boolean isGameStarted;

    public InputHandlerStartScreen(GameEngine startScreen) {
        this.startScreen = startScreen;
        addKeyboard();
    }

    private Keyboard keyboard2 = new Keyboard(this);

    public void addKeyboard() {
        KeyboardEvent start = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_SPACE);
        start.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard2.addEventListener(start);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();
        if (key == 32) {
            if (!isGameStarted) {
                startScreen.startStage();
                isGameStarted = true;
            }
        }
    }
}
