package io.codeforall.gameweek;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player2 extends Player {

    private Picture picture;
    private int frameCounter;
    public int xP2;
    private ColisionDetector colisionDetector;
    private SoundManager sound;
    private boolean isDead;
    private boolean allowMove = true;
    private final int initialX = 1150;
    private Picture[] framePic2 = {new Picture(1150, 400, "resources/player2.png"), new Picture(1150, 400, "resources/player2_0.png")};

    private Picture[] attackPic2 = {new Picture(1150, 400, "resources/player2_1.png"), new Picture(1150, 400, "resources/player2_2.png")};


    public Player2(String name) {
        super(name);
        framePic2[0].draw();
        updatePos();
        try {
            this.sound = new SoundManager();
        } catch (Exception e) {

        }
    }

    public void setColisionDetector(ColisionDetector colisionDetector) {
        this.colisionDetector = colisionDetector;
    }

    public void refresh() {
        framePic2[frameCounter % 2].delete();
        framePic2[frameCounter % 2].draw();
    }


    @Override
    protected void updatePos() {
        x = framePic2[frameCounter % 2].getX();
        xP2 = framePic2[frameCounter % 2].getX();
    }

    @Override
    protected void block() {
        isBlocking = true;
    }


    public void attack() {
        if(!isDead && allowMove) {
            updatePos();
            colisionDetector.checkColision(this);
            framePic2[frameCounter % 2].delete();
            Attack attack = new Attack(this);
            Thread thread = new Thread(attack);
            thread.start();
            thread.interrupt();

            sound.playAttackSound();
        }
    }

    public void show() {
        if(!isDead) {
            framePic2[frameCounter % 2].draw();
        }
    }


    public void moveLeft2() {
        if(!isDead && allowMove) {
            if (framePic2[frameCounter % 2].getX() >= 30) {
                if (colisionDetector.canMove()) {
                    framePic2[0].translate(-40, 0);
                    framePic2[1].translate(-40, 0);
                    attackPic2[0].translate(-40, 0);
                    attackPic2[1].translate(-40, 0);

                    framePic2[frameCounter % 2].delete();
                    frameCounter++;
                    framePic2[frameCounter % 2].draw();

                    updatePos();
                }
            }
        }
    }


    public void moveRight2() {
        if(!isDead && allowMove) {
            if (framePic2[frameCounter % 2].getX() <= Stage.width - 10 - framePic2[frameCounter % 2].getWidth()) {
                framePic2[0].translate(40, 0);
                framePic2[1].translate(40, 0);
                attackPic2[0].translate(40, 0);
                attackPic2[1].translate(40, 0);

                framePic2[frameCounter % 2].delete();
                frameCounter++;
                framePic2[frameCounter % 2].draw();
                updatePos();
            }
        }
    }

    public void setDead() {
        this.isDead = true;
        framePic2[0].delete();
        framePic2[1].delete();
        Picture p1Dead = new Picture(framePic2[frameCounter % 2].getX(), 400, "player2_dead.png");
        p1Dead.draw();
    }

    public boolean getIsDead() {
        return isDead;
    }

    public void resetPosition() {
        framePic2[0].translate(initialX - xP2, 0);
        framePic2[1].translate(initialX - xP2, 0);
        updatePos();

    }

    public void setAllowMove(boolean allowMove) {
        this.allowMove = allowMove;
    }
}


