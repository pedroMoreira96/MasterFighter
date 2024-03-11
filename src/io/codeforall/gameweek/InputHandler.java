package io.codeforall.gameweek;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class InputHandler implements KeyboardHandler {

    private Player1 player1;
    private Player2 player2;

    public InputHandler(Player1 player1, Player2 player2) {
        this.player1 = player1;
        this.player2 = player2;
        addKeyboard();
    }

    private Keyboard keyboard = new Keyboard(this);

    public void addKeyboard(){
        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(moveRight);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(moveLeft);

        KeyboardEvent attack1 = new KeyboardEvent();
        attack1.setKey(KeyboardEvent.KEY_L);
        attack1.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(attack1);


        KeyboardEvent moveRight2 = new KeyboardEvent();
        moveRight2.setKey(KeyboardEvent.KEY_D);
        moveRight2.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(moveRight2);

        KeyboardEvent moveLeft2 = new KeyboardEvent();
        moveLeft2.setKey(KeyboardEvent.KEY_A);
        moveLeft2.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(moveLeft2);

        KeyboardEvent attack2 = new KeyboardEvent();
        attack2.setKey(KeyboardEvent.KEY_C);
        attack2.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(attack2);
    }
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();
        if(key == 39){
            player2.moveRight2();
        }
        if(key == 37){
            player2.moveLeft2();
        }
        if(key == 76){
            player2.attack();
        }
        if(key == 68){
            player1.moveRight();

        }
        if(key == 65){
            player1.moveLeft();
        }
        if(key == 67){
            player1.attack();
        }
    }
}
