package org.bob.controller;

import org.bob.view.GameUI;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ScoreBoardController {

    private final String scoreBoardFileName = "scoreboard.txt";
    private final LinkedList<Integer> scoreBoard;

    public ScoreBoardController() {
        this.scoreBoard = readScoreBoard();
    }

    public void addScore(int score) {
        scoreBoard.add(score);
        scoreBoard.sort(Collections.reverseOrder());
    }

    public void showScoreBoard(GameUI gameUI) {
        gameUI.drawBackground();
        gameUI.drawScoreboard(scoreBoard.stream().limit(10).collect(Collectors.toCollection(LinkedList::new)));
        gameUI.update();
        while (!KeyController.isEnternProcessed());
    }

    public void saveScoreBoard() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(scoreBoardFileName))) {
            for (int i = 0; i < Math.min(scoreBoard.size(), 10); i++) {
                writer.write(scoreBoard.get(i) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LinkedList<Integer> readScoreBoard() {
        LinkedList<Integer> readedScoreBoard = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(scoreBoardFileName))) {
            String line;
            while ((line = reader.readLine()) != null && !line.equals("\n")) {
                readedScoreBoard.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readedScoreBoard;
    }
}
