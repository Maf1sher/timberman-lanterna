package org.bob.controller;

import com.googlecode.lanterna.TextColor;
import org.bob.model.Timberman;
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

    private final TextColor[] colors = {
            new TextColor.RGB(166, 13, 31),
            new TextColor.RGB(0, 255, 0),
            new TextColor.RGB(0, 0, 255),
            new TextColor.RGB(255, 255, 0),
            new TextColor.RGB(255, 165, 0) 
    };

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
                    colorMenu();
                }

                if(selectedOption == 3){
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
                if(selectedOption < 3){
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

    public void colorMenu(){
        int selectedColorIndex = 0;

        while (true) {
            gameUI.drawBackground();
            gameUI.drawColorMenu(selectedColorIndex, colors);
            gameUI.update();

            if (KeyController.isUpProcessed()) {
                selectedColorIndex = (selectedColorIndex - 1 + colors.length) % colors.length;
            }

            if (KeyController.isDownProcessed()) {
                selectedColorIndex = (selectedColorIndex + 1) % colors.length;
            }

            if (KeyController.isEnternProcessed()) {
                Timberman timberman = gameController.getTimberman();
                timberman.setColor(colors[selectedColorIndex]);
                break;
            }
        }
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
