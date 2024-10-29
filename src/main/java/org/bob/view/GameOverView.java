package org.bob.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class GameOverView {

    public void draw(TextGraphics textGraphics, int score) {
        int screenCol = textGraphics.getSize().getColumns();
        int screenRow = textGraphics.getSize().getRows();

        int width = 50;
        int height = 20;

        textGraphics.setBackgroundColor(TextColor.ANSI.MAGENTA);

        textGraphics.fillRectangle(
                new TerminalPosition(
                        screenCol / 2 - width / 2,
                        screenRow / 2 - height / 2),
                new TerminalSize(width, height),
                ' '
        );

        String gameOverString =
                "   ____    _    __  __ _____ \n" +
                "  / ___|  / \\  |  \\/  | ____|\n" +
                " | |  _  / _ \\ | |\\/| |  _|  \n" +
                " | |_| |/ ___ \\| |  | | |___ \n" +
                "  \\____/_/   \\_\\_|__|_|_____|\n" +
                "  / _ \\ \\   / / ____|  _ \\   \n" +
                " | | | \\ \\ / /|  _| | |_) |  \n" +
                " | |_| |\\ V / | |___|  _ <   \n" +
                "  \\___/  \\_/  |_____|_| \\_\\  \n";

        textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
        drawString(textGraphics, gameOverString, screenCol / 2, screenRow / 2 - 10);

        textGraphics.setBackgroundColor(null);
        textGraphics.putString(
                new TerminalPosition(
                        screenCol / 2,
                        screenRow / 2 ),
                String.valueOf(score)
        );
    }

    private void drawString(TextGraphics textGraphics, String text, int x, int y){
        String[] lines = text.split("\n");
        for(int i = 0; i < lines.length; i++){
            textGraphics.putString(x - lines[i].length() / 2, y + i, lines[i]);
        }
    }
}
