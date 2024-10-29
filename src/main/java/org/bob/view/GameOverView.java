package org.bob.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.bob.Tools.DrawStringManager;

public class GameOverView {

    public void draw(TextGraphics textGraphics, int score) {
        int screenCol = textGraphics.getSize().getColumns();
        int screenRow = textGraphics.getSize().getRows();

        int width = 50;
        int height = 20;

        textGraphics.setBackgroundColor(new TextColor.RGB(208, 205, 205));

        textGraphics.fillRectangle(
                new TerminalPosition(
                        screenCol / 2 - width / 2,
                        screenRow / 2 - height / 2),
                new TerminalSize(width, height),
                ' '
        );

        String gameOverString =
                """
                           ____    _    __  __ _____\s
                          / ___|  / \\  |  \\/  | ____|
                         | |  _  / _ \\ | |\\/| |  _| \s
                         | |_| |/ ___ \\| |  | | |___\s
                          \\____/_/   \\_\\_|__|_|_____|
                          / _ \\ \\   / / ____|  _ \\  \s
                         | | | \\ \\ / /|  _| | |_) | \s
                         | |_| |\\ V / | |___|  _ <  \s
                          \\___/  \\_/  |_____|_| \\_\\ \s
                        """;

        textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
        DrawStringManager.drawString(textGraphics, gameOverString, screenCol / 2, screenRow / 2 - 10);

        String scoreString = DrawStringManager.convertNumberToString(score);
        DrawStringManager.drawString(textGraphics, scoreString, screenCol / 2, screenRow / 2);
    }
}
