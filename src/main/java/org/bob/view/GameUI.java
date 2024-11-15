package org.bob.view;

import com.googlecode.lanterna.terminal.Terminal;
import org.bob.enums.RGBColorEnums;
import org.bob.model.Board;
import org.bob.model.GameResult;
import org.bob.model.Timberman;

import java.util.LinkedList;
import java.util.List;

public interface GameUI {
    void init();
    void update();
    void close();
    void drawMenu(int selectedOption);
    void drawBackground();
    void drawBoard(Board board);
    void drawTimberman(Timberman timberman);
    void drawScore(int score);
    void drwaGameOver(int score, String nick);
    void drawTimer(int time);
    void drawScoreboard(List<GameResult> scoreboard);
    void drawColorMenu(int selectedColorIndex, RGBColorEnums[] colors);
    Terminal getTerminal();
}
