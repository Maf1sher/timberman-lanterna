package org.bob.view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.TerminalEmulatorAutoCloseTrigger;
import org.bob.model.Board;
import org.bob.model.Timberman;

import java.io.IOException;
import java.util.LinkedList;

public class GameUILanterna implements GameUI{

    private Screen screen;
    private Terminal terminal;
    private TextGraphics textGraphics;
    private final MenuView menuView;
    private final BackgroundView backgroundView;
    private final BoardView boardView;
    private final TimbermanrView timbermanrView;
    private final ScoreView scoreView;
    private final GameOverView gameOverView;
    private final TimerView timerView;
    private final ScoreboardView scoreboardView;

    public GameUILanterna() {
        this.menuView = new MenuView();
        this.backgroundView = new BackgroundView();
        this.boardView = new BoardView();
        this.timbermanrView = new TimbermanrView();
        this.scoreView = new ScoreView();
        this.gameOverView = new GameOverView();
        this.timerView = new TimerView();
        this.scoreboardView = new ScoreboardView();
    }


    @Override
    public void init() {
        try {
            terminal = new DefaultTerminalFactory()
                    .setInitialTerminalSize(new TerminalSize(75,50))
                    .setTerminalEmulatorTitle("Timberman")
                    .setTerminalEmulatorFrameAutoCloseTrigger(TerminalEmulatorAutoCloseTrigger.CloseOnEscape)
                    .createTerminal();
            screen = new TerminalScreen(terminal);
            textGraphics = screen.newTextGraphics();
            screen.startScreen();
            screen.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update() {
        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            screen.stopScreen();
            terminal.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawMenu(int selectedOption) {
        menuView.draw(textGraphics, selectedOption);
    }

    @Override
    public void drawBackground() {
        backgroundView.draw(textGraphics);
    }

    @Override
    public void drawBoard(Board board) {
        boardView.draw(textGraphics, board);
    }

    @Override
    public void drawTimberman(Timberman timberman) {
        timbermanrView.draw(textGraphics, timberman);
    }

    @Override
    public void drawScore(int score) {
        scoreView.draw(textGraphics, score);
    }

    @Override
    public void drwaGameOver(int score) {
        gameOverView.draw(textGraphics, score);
    }

    @Override
    public void drawTimer(int time) {
        timerView.draw(textGraphics, time);
    }

    @Override
    public void drawScoreboard(LinkedList<Integer> scoreboard) {
        scoreboardView.draw(textGraphics, scoreboard);
    }
}
