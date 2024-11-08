package org.bob.view;

import org.bob.enums.RGBColorEnums;
import org.bob.model.Board;
import org.bob.model.Timberman;

import java.util.LinkedList;

public interface GameUI {
    void init();
    void update();
    void close();
    void drawMenu(int selectedOption);
    void drawBackground();
    void drawBoard(Board board);
    void drawTimberman(Timberman timberman);
    void drawScore(int score);
    void drwaGameOver(int score);
    void drawTimer(int time);
    void drawScoreboard(LinkedList<Integer> scoreboard);
    void drawColorMenu(int selectedColorIndex, RGBColorEnums[] colors);
}
