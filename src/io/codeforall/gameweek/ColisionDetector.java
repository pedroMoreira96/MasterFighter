package io.codeforall.gameweek;

public class ColisionDetector {

    Player1 player1;
    Player2 player2;

    Stage stage;

    public ColisionDetector(Player1 player1, Player2 player2, Stage stage) {
        this.player1 = player1;
        this.player2 = player2;
        this.stage = stage;
        this.init();
    }


    public void init() {

    }

    public boolean checkColision(Player player) {
        if (!player1.getIsDead() && !player2.getIsDead()) {
            if ((player2.x - player1.x) < 200) {
                if (player.equals(player1)) {
                    player2.health -= player1.attack;
                    stage.decreaseP2HealthBar();
                    System.out.println(" player 2 lost: " + player2.health);
                } else if (player.equals(player2)) {
                    player1.health -= player2.attack;
                    stage.decreaseP1HealthBar();
                    System.out.println(" player 1 lost: " + player1.health);

                }
                return true;

            }
        }
        return false;
    }
    public boolean canMove(){
        if((player2.x - player1.x) < 50 ) {
            return false;

        }
        return true;
    }

}
