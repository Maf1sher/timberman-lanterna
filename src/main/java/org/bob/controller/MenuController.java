package org.bob.controller;

import org.bob.view.GameUI;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MenuController{

    private final GameController gameController;
    private final GameUI gameUI;
    private boolean menuRunning = true;
    private int selectedOption = 0;
    private final LinkedList<Integer> scoreBoard;
    private final String scoreBoardFileName = "scoreboard.txt";

    public MenuController(GameUI gameUI) {
        this.gameUI = gameUI;
        this.gameController = new GameController(gameUI);
        this.scoreBoard = readScoreBoard();
    }

    public void run(){
        gameUI.init();
        while (menuRunning) {
            gameUI.drawBackground();
            gameUI.drawMenu(selectedOption);
            gameUI.update();
            if(KeyController.isEnternProcessed()){
                if(selectedOption == 0){
                    int score = gameController.gameStart();
                    scoreBoard.add(score);
                    scoreBoard.sort(Collections.reverseOrder());
                    while(!KeyController.isEnternProcessed());
                }

                if(selectedOption == 1){
                    scoreBoardMenu();
                }

                if(selectedOption == 2){
                    gameUI.close();
                    menuRunning = false;
                    try {
                        saveScoreBoard();
                    }catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            if(KeyController.isDownProcessed()){
                if(selectedOption < 2){
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
        gameUI.drawScoreboard(scoreBoard.stream().limit(10).collect(Collectors.toCollection(LinkedList::new)));
        gameUI.update();

        while(!KeyController.isEnternProcessed());
    }

    private void saveScoreBoard() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(scoreBoardFileName));
        for(int i = 0; i < (Math.min(scoreBoard.size(), 10)); i++){
            writer.write(scoreBoard.get(i) + "\n");
        }
        writer.close();
    }

    private LinkedList<Integer> readScoreBoard(){
        BufferedReader reader;
        LinkedList<Integer> readedScoreBoard = new LinkedList<>();

        try {
            reader = new BufferedReader(new FileReader(scoreBoardFileName));
            String line = reader.readLine();

            while (line != null && !line.equals("\n")) {
                readedScoreBoard.add(Integer.parseInt(line));
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readedScoreBoard;
    }
}
