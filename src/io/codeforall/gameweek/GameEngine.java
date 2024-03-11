package io.codeforall.gameweek;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameEngine {
    private Picture startScreen = new Picture(10, 10, "resources/start.png");
    InputHandlerStartScreen inputHandlerStartScreen = new InputHandlerStartScreen(this);

    public GameEngine() {
        startScreen.draw();
    }





    public void startStage() {
        startScreen.delete();

        Player1 player1 = new Player1("Gustavo - aka: Gonçalo");

        Player2 player2 = new Player2("Andreia");

        Stage stage = new Stage(player1, player2);

        ColisionDetector colisionDetector = new ColisionDetector(player1, player2, stage);

        {
            player1.setColisionDetector(colisionDetector);
            player2.setColisionDetector(colisionDetector);
        }
        InputHandler inputHandler = new InputHandler(player1, player2);
    }








}



