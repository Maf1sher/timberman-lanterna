package org.bob.controller;

import org.bob.view.GameUI;

public class MenuController{

    private final GameController gameController;
    private final GameUI gameUI;
    private boolean menuRunning = true;
    private int selectedOption = 0;

    public MenuController(GameUI gameUI) {
        this.gameUI = gameUI;
        this.gameController = new GameController(gameUI);
    }

    public void run(){
        gameUI.init();
        while (menuRunning) {
            gameUI.drawBackground();
            gameUI.drawMenu(selectedOption);
            gameUI.update();
            if(KeyController.isEnternProcessed()){
                if(selectedOption == 0){
                    gameController.gameStart();
                    while(!KeyController.isEnternProcessed());
                }

                if(selectedOption == 1){
                    scoreBoardMenu();
                }

                if(selectedOption == 2){
                    gameUI.close();
                    menuRunning = false;
                }
            }

            if(KeyController.isDownProcessed()){
                if(selectedOption < 1){
                    selectedOption++;
                }
            }

            if(KeyController.isUpProcessed()){
                if(selectedOption > 0){
                    selectedOption--;
                }
            }
        }
    }

    private void scoreBoardMenu(){
        gameUI.drawBackground();
        gameUI.drawScoreboard();
        gameUI.update();

        while(!KeyController.isEnternProcessed());
    }
}
