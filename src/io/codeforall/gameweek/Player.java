package io.codeforall.gameweek;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Player{
    protected double health;
    protected double attack;
    protected int x;

    protected String name;
    protected boolean isBlocking = false;

    protected Stage stage;

    public Player(String name) {
        this.health = 110;
        this.attack = health *0.01;
        this.name = name;
    }



    protected abstract void updatePos();
    protected abstract void block();


    public void show() {
    }
}