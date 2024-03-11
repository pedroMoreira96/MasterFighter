package io.codeforall.gameweek;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player1 extends Player {

    private Picture picture;
    private int frameCounter;
    private int xP1;
    private ColisionDetector colisionDetector;
    private SoundManager sound;
    private final int initialX = 30;
    private boolean allowMove = true;
    private boolean isDead;

    private Picture [] framePic = {new Picture(30, 400, "resources/player1.png"),new Picture(30, 400, "resources/player1_0.png")};
    private Picture [] attackPic = {new Picture(30, 400, "resources/teste.png"),new Picture(30, 400, "resources/teste.png")};


    public Player1(String name) {
        super(name);
        framePic[0].draw();
        updatePos();
        try {
            this.sound = new SoundManager();
        } catch (Exception e) {

        }
    }

    public void setColisionDetector(ColisionDetector colisionDetector) {
        this.colisionDetector = colisionDetector;
    }

    @Override
    protected void updatePos() {
        x = framePic[frameCounter % 2].getX();
        xP1 = framePic[frameCounter % 2].getX();
    }

    public void refresh() {
        framePic[frameCounter % 2].delete();
        framePic[frameCounter % 2].draw();
    }

    @Override
    protected void block() {
        isBlocking = true;
    }


    public void attack() {
        if(!isDead && allowMove) {
            updatePos();
            colisionDetector.checkColision(this);
            framePic[frameCounter % 2].delete();
            Attack attack = new Attack(this);
            Thread thread1 = new Thread(attack);
            thread1.start();
            thread1.interrupt();

            sound.playAttackSound();
        }



    }
    public void jump(){

    }

    public void show() {
        if(!isDead) {
            framePic[frameCounter % 2].draw();
        }
    }


    public void moveLeft() {
        if(!isDead && allowMove) {
            if (framePic[frameCounter % 2].getX() >= 40) {
                framePic[0].translate(-40, 0);
                framePic[1].translate(-40, 0);

                framePic[frameCounter % 2].delete();
                frameCounter++;
                framePic[frameCounter % 2].draw();
                updatePos();
            }
        }
    }


    public void moveRight() {
        if(!isDead && allowMove) {
            if (framePic[frameCounter % 2].getX() <= Stage.width - 10 - framePic[frameCounter % 2].getWidth()) {
                if (colisionDetector.canMove()) {
                    framePic[0].translate(40, 0);
                    framePic[1].translate(40, 0);
                    attackPic[0].translate(40, 0);
                    attackPic[1].translate(40, 0);

                    framePic[frameCounter % 2].delete();
                    frameCounter++;
                    framePic[frameCounter % 2].draw();

                    updatePos();
                }
            }
        }
    }

    public void setDead() {
        this.isDead = true;
        framePic[0].delete();
        framePic[1].delete();
        Picture p1Dead = new Picture(framePic[frameCounter % 2].getX(), 400, "player1_dead.png");
        p1Dead.draw();
    }

    public boolean getIsDead() {
        return isDead;
    }

    public void resetPosition() {
        framePic[0].translate(initialX - xP1, 0);
        framePic[1].translate(initialX - xP1, 0);
        updatePos();

    }

    public void setAllowMove(boolean allowMove) {
        this.allowMove = allowMove;
    }

}