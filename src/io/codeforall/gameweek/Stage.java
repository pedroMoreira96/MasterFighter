package io.codeforall.gameweek;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.crypto.spec.PSource;

public class Stage implements Runnable {

    private int player1RoundsWon = 0;
    private int player2RoundsWon = 0;
    public static int height;
    public static int width;

    int roundCounter = 1;
    private double initialSizeBar = 480;

    private Player1 player1;
    private Player2 player2;

    private String pathP1 = "resources/hp_p1_110_v2.png";
    private String pathP2 = "resources/hp_p2_110_v2.png";
    public Rectangle p1_0 = new Rectangle(172, 80, initialSizeBar, 50);
    public Rectangle p2_0 = new Rectangle(972, 80, initialSizeBar, 50);

    Picture healthP1 = new Picture(100, 30, pathP1);
    Picture healthP2 = new Picture(900, 30, pathP2);

    SoundManager sound;

    Picture score0_p1 = new Picture(40, 45, "0.png");
    Picture score0_p2 = new Picture(1520, 45, "0.png");

    Picture score1_p1 = new Picture(40, 40, "1.png");
    Picture score1_p2 = new Picture(1520, 40, "1.png");

    Picture pic2counter = new Picture(720, 200, "2counter.png");
    Picture pic1counter = new Picture(720, 200, "1counter.png");
    Picture pic0counter = new Picture(720, 200, "0counter.png");

    private Picture background;
    public Picture vs = new Picture(720, 10, "resources/vs.png");



    public Stage(Player1 player1, Player2 player2) {
        defineStage();
        try {
            this.sound = new SoundManager();
        } catch (Exception e) {

        }

        sound.startBackgroundMusic();

        this.player1 = player1;
        this.player2 = player2;
        background.draw();
        width = background.getWidth();
        height = background.getHeight();
        Canvas.limitCanvasHeight(background.getHeight());
        Canvas.limitCanvasWidth(background.getWidth());
        vs.draw();
        score0_p1.draw();
        score0_p2.draw();

        p1_0.draw();
        p2_0.draw();
        healthP1.draw();
        healthP2.draw();
        p1_0.setColor(Color.RED);
        p1_0.fill();
        p2_0.setColor(Color.BLUE);
        p2_0.fill();

        player1.refresh();
        player2.refresh();
        Thread thread = new Thread(this);
        thread.start();

        sound.playRound1Sound();

    }
        public void defineStage(){
            int stageSelection = (int)Math.floor(Math.random() *2);
            String stagePath;
        switch (stageSelection){
            case 0:
                stagePath = "resources/background1.jpg";
                break;
            default:
                stagePath = "resources/background3.jpg";
        }
            this.background = new Picture(10, 10, stagePath);
        }

    private void checkRoundOutcome() {
        if (player1.health <= 0) {
            player2.setAllowMove(false);
            player1.setAllowMove(false);
            if(player1RoundsWon != 2) {
                Picture andreiaWonRound = new Picture(10, 40, "resources/andreia_won_round.png");
                andreiaWonRound.draw();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                andreiaWonRound.delete();
            }
            player2RoundsWon++;
            roundCounter++;
            resetRound();

            System.out.println("Player 2 wins the round!"); // Draw text box or something
            if(player2RoundsWon != 2) {
                try {
                    pic2counter.draw();
                    Thread.sleep(1000);
                    roundSound();
                    pic2counter.delete();
                    pic1counter.draw();
                    Thread.sleep(1000);
                    pic1counter.delete();
                    pic0counter.draw();
                    Thread.sleep(1000);
                    pic0counter.delete();
                    player1.setAllowMove(true);
                    player2.setAllowMove(true);

                } catch (Exception e) {

                }
            } else {
                Picture andreiaWinner =  new Picture(10, 40, "resources/winnerAndreia.png");
                andreiaWinner.draw();
            }

        } else if (player2.health <= 0) {
            player2.setAllowMove(false);
            player1.setAllowMove(false);
            if(player1RoundsWon != 2) {
                Picture gustavoWonRound = new Picture(10, 40, "resources/gustavo_won_round.png");
                gustavoWonRound.draw();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                gustavoWonRound.delete();
            }
            player1RoundsWon++;
            roundCounter++;
            resetRound();

            System.out.println("Player 1 wins the round!"); // Draw text box or something
            if(player1RoundsWon != 2) {
                try {

                    pic2counter.draw();
                    Thread.sleep(1000);
                    roundSound();
                    pic2counter.delete();
                    pic1counter.draw();
                    Thread.sleep(1000);
                    pic1counter.delete();
                    pic0counter.draw();
                    Thread.sleep(1000);
                    pic0counter.delete();
                    player1.setAllowMove(true);
                    player2.setAllowMove(true);
                } catch (Exception e) {

                }
            } else {
                Picture gustavoWinner =  new Picture(10, 40, "resources/winnerGustavo.png");
                gustavoWinner.draw();
            }


        }
    }

    public void roundSound() {
        if(roundCounter == 2) {
            sound.playRound2Sound();
        } else if (roundCounter == 3){
            if(player1RoundsWon == 1 && player2RoundsWon == 1) {
                sound.playRound3Sound();
            }
        }
    }


    private void checkGameOutcome() {
        int maxRounds = 2;
        if (player1RoundsWon >= maxRounds) {
            // Insert text box "Player 1 wins the game!"
            // Game ends
        } else if (player2RoundsWon >= maxRounds) {
            // Insert text box "Player 2 wins the game!"
            // Game ends
        }
    }

    private void resetRound() {
        player1.health = 110;
        player2.health = 110;
        p1_0.translate(((initialSizeBar - p1_0.getWidth()) / 2.0), 0);
        p2_0.translate(((initialSizeBar - p2_0.getWidth()) / 2.0), 0);
        p1_0.grow(((initialSizeBar - p1_0.getWidth()) / 2.0), 0);
        p2_0.grow(((initialSizeBar - p2_0.getWidth()) / 2.0), 0);


        if(player1RoundsWon == 1) {
            score0_p1.delete();
            score1_p1.draw();
        }
        if (player2RoundsWon == 1){
            score0_p2.delete();
            score1_p2.draw();
        }
        if (player1RoundsWon == 2) {
            player2.setDead();
            sound.playP1VictorySound();
        }
        if (player2RoundsWon == 2) {
            player1.setDead();
            sound.playP2VictorySound();
        }
        if(player1RoundsWon == 1 && player2RoundsWon == 1 || player1RoundsWon == 0 && player2RoundsWon == 1 || player1RoundsWon == 1 && player2RoundsWon == 0) {
            player1.resetPosition();
            player2.resetPosition();
        }


    }

    public void decreaseP1HealthBar() {
            p1_0.grow(-(initialSizeBar * 0.005), 0);
            p1_0.translate(-(initialSizeBar * 0.005), 0);
            System.out.println(p1_0.getWidth());
    }

    public void decreaseP2HealthBar() {
            p2_0.grow(-(initialSizeBar * 0.005), 0);
            p2_0.translate(-(initialSizeBar * 0.005), 0);
    }


    @Override
    public void run() {
        while (true) {
            checkRoundOutcome();
            checkGameOutcome();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}





