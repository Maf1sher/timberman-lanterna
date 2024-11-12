package org.bob.controller;

import org.bob.model.Game;
import org.bob.model.TupleBoolean;
import org.bob.view.GameUI;

public class GameController extends Game{

    private final GameUI gameUI;

    public GameController(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    public int startGame(){
        initializeGame();
        while(gameOver()){
            gameLoop();
        }
        endGame();
        return score;
    }

    private void initializeGame() {
        board.clearBoard();
        this.score = 0;
        this.timer = 100;
        board.addLevel(new TupleBoolean(false, false));
        for (int i = 0; i < 10; i++) {
            board.addLevel(generateLevel());
        }
        refreshBoard();
    }

    private void gameLoop(){
        tick++;
        calculateTime();
        if(KeyController.isLeftPressed()){
            timberman.setLeftSide();
            cutLevel();
        }

        if(KeyController.isRightPressed()){
            timberman.setRightSide();
            cutLevel();
        }

        try {
            Thread.sleep(20);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        gameUI.drawTimer(timer);
        gameUI.update();
    }

    private void endGame() {
        gameUI.drwaGameOver(score);
        gameUI.update();
    }

    private void cutLevel(){
        board.addLevel(generateLevel());
        board.deleteLevel();
        score++;
        if(timer < 100)
            timer++;
        refreshBoard();
    }

    private void refreshBoard(){
        gameUI.drawBackground();
        gameUI.drawBoard(board);
        gameUI.drawTimberman(timberman);
        gameUI.drawScore(score);
        gameUI.drawTimer(timer);
        gameUI.update();
    }


    private boolean gameOver() {
        if(timer <= 0)
            return false;

        if(timberman.isLeftSide() && board.getFirstLevel().getValue1())
            return false;

        if(timberman.isRightSide() && board.getFirstLevel().getValue2())
            return false;

        return true;

    }
}
