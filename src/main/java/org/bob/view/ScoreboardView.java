package org.bob.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.bob.Tools.DrawStringManager;

import java.util.LinkedList;

public class ScoreboardView {

    public void draw(TextGraphics textGraphics, LinkedList<Integer> scoreboard) {

        int screenCol = textGraphics.getSize().getColumns();
        int screenRow = textGraphics.getSize().getRows();

        int width = 60;
        int height = 40;

        String scoreboardString =
                """
                         _____                    _                         _\s
                        /  ___|                  | |                       | |
                        \\ `--.  ___ ___  _ __ ___| |__   ___   __ _ _ __ __| |
                         `--. \\/ __/ _ \\| '__/ _ \\ '_ \\ / _ \\ / _` | '__/ _` |
                        /\\__/ / (_| (_) | | |  __/ |_) | (_) | (_| | | | (_| |
                        \\____/ \\___\\___/|_|  \\___|_.__/ \\___/ \\__,_|_|  \\__,_|""";

        textGraphics.setBackgroundColor(new TextColor.RGB(208, 205, 205));

        textGraphics.fillRectangle(
                new TerminalPosition(
                        screenCol / 2 - width / 2,
                        screenRow / 2 - height / 2),
                new TerminalSize(width, height),
                ' '
        );

        textGraphics.setForegroundColor(TextColor.ANSI.RED);

        DrawStringManager.drawString(textGraphics,  scoreboardString, screenCol / 2, screenRow / 4 - 5);

        for (int i = 0; i < scoreboard.size(); i++) {
            textGraphics.putString(
                    new TerminalPosition(
                            screenCol / 2,
                            screenRow / 4 + 5 + i * 2),
                    i + 1 + ". " + scoreboard.get(i)
            );
        }
    }
}
