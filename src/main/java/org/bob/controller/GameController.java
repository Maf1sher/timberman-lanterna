package org.bob.controller;

import org.bob.model.Game;
import org.bob.model.TupleBoolean;
import org.bob.view.GameUI;

import java.util.List;
import java.util.Random;

public class GameController extends Game{

    private final GameUI gameUI;
    private final List<TupleBoolean> tree;
    private final Random rand;
    private boolean branchLevel = false;

    public GameController(GameUI gameUI) {
        this.gameUI = gameUI;
        this.rand = new Random();
        this.tree = board.getTree();
    }

    public void gameStart(){
        this.tree.clear();
        this.score = 0;
        this.timer = 100;
        board.addLevel(new TupleBoolean(false, false));
        for (int i = 0; i < 10; i++) {
            board.addLevel(generateLevel());
        }
        refreshBoard();

        while(gameOver()){
            tick++;
            calculateTime();
            if(KeyController.isLeftPressed()){
                timberman.setLeftSide();
                tree.add(generateLevel());
                deleteLevel();
                score++;
                if(timer < 100)
                    timer++;
                refreshBoard();
            }

            if(KeyController.isRightPressed()){
                timberman.setRightSide();
                tree.add(generateLevel());
                deleteLevel();
                score++;
                if(timer < 100)
                    timer++;
                refreshBoard();
            }


            try {
                Thread.sleep(20);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            gameUI.drawTimer(timer);
            gameUI.update();
        }
        gameUI.drwaGameOver(score);
        gameUI.update();

    }

    private void refreshBoard(){
        gameUI.drawBackground();
        gameUI.drawBoard(board);
        gameUI.drawTimberman(timberman);
        gameUI.drawScore(score);
        gameUI.drawTimer(timer);
        gameUI.update();
    }

    private void deleteLevel(){
        tree.remove(0);
    }

    private TupleBoolean generateLevel(){
        if(branchLevel){
            boolean side = rand.nextBoolean();
            branchLevel = false;
            return new TupleBoolean(side, !side);
        }
        branchLevel = true;
        return new TupleBoolean(false, false);
    }

    private boolean gameOver() {
        if(timer <= 0)
            return false;

        if(timberman.isLeftSide() && tree.get(0).getValue1())
            return false;

        if(timberman.isRightSide() && tree.get(0).getValue2())
            return false;

        return true;

    }
}
