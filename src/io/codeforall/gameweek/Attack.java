package io.codeforall.gameweek;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Attack implements Runnable {

    Player player;
    public Picture[] attackPicP1 = new Picture[2];
    public Picture[] attackPicP2 = new Picture[2];
    //private SoundManager sound;


    public Attack(Player player) {
        this.player = player;
        initArrayPics(player.x);
    }

    public void initArrayPics(int x) {
        /*try {
            this.sound = new SoundManager();
        } catch (Exception e) {

        }*/

        this.attackPicP1[0] = new Picture(x, 400, "resources/player1_1.png");
        this.attackPicP1[1] = new Picture(x, 400, "resources/player1_2.png");

        this.attackPicP2[0] = new Picture(x, 400, "resources/player2_1.png");
        this.attackPicP2[1] = new Picture(x, 400, "resources/player2_2.png");

    }

    @Override
    public void run() {
        //sound.playAttackSound();
        if (player instanceof Player2) {
            for (int i = 0; i < 2; i++) {
                attackPicP2[i].draw();
                try {
                    attackPicP2[i - 1].delete();
                } catch (Exception e) {

                }

                try {
                    Thread.sleep(40);
                } catch (Exception e) {

                }
            }

            for (int i = 1; i >= 0; i--) {
                attackPicP2[i].draw();
                try {
                    attackPicP2[i + 1].delete();
                } catch (Exception e) {

                }

                try {
                    Thread.sleep(40);
                } catch (Exception e) {

                } finally {
                    attackPicP2[0].delete();
                    attackPicP2[1].delete();
                }
            }
            attackPicP2[0].delete();
            attackPicP2[1].delete();
        } else {

            for (int i = 0; i < 2; i++) {
                attackPicP1[i].draw();
                try {
                    attackPicP1[i - 1].delete();
                } catch (Exception e) {

                }

                try {
                    Thread.sleep(40);
                } catch (Exception e) {

                }
            }

            for (int i = 1; i >= 0; i--) {
                attackPicP1[i].draw();
                try {
                    attackPicP1[i + 1].delete();
                } catch (Exception e) {

                }

                try {
                    Thread.sleep(40);
                } catch (Exception e) {

                } finally {
                    attackPicP1[0].delete();
                    attackPicP1[1].delete();
                }
            }
            attackPicP1[0].delete();
            attackPicP1[1].delete();
        }
        player.show();
        System.out.print("");

    }
}
