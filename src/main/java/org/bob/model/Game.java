package org.bob.model;

public class Game {
    protected Board board;
    protected Timberman timberman;
    protected int score = 0;
    protected int timer = 100;
    protected int tick = 0;

    public Game() {
        this.board = new Board(10);
        this.timberman = new Timberman();
    }

    public Timberman getTimberman() {
        return timberman;
    }

    public int getScore() {
        return score;
    }

    protected void calculateTime(){
        if(tick == 20){
            timer -= score / 100 + 1;
            tick = 0;
        }
    }

}
