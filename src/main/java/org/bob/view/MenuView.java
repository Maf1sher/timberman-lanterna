package org.bob.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.bob.Tools.DrawStringManager;

import java.util.ArrayList;
import java.util.List;

public class MenuView {

    private final int width = 50;
    private final int height = 20;

    public MenuView() {

    }

    public void draw(TextGraphics textGraphics, int selectOption) {
        int screenCol = textGraphics.getSize().getColumns();
        int screenRow = textGraphics.getSize().getRows();

        textGraphics.setBackgroundColor(TextColor.ANSI.CYAN);
        textGraphics.fillRectangle(
                new TerminalPosition(
                        screenCol / 2 - width / 2,
                        screenRow / 2 - height / 2),
                new TerminalSize(width, height),
                ' '
        );

        String timbermanString = """
                 _______ _           _                                    \s
                |__   __(_)         | |                                   \s
                   | |   _ _ __ ___ | |__   ___ _ __ _ __ ___   __ _ _ __ \s
                   | |  | | '_ ` _ \\| '_ \\ / _ \\ '__| '_ ` _ \\ / _` | '_ \\\s
                   | |  | | | | | | | |_) |  __/ |  | | | | | | (_| | | | |
                   |_|  |_|_| |_| |_|_.__/ \\___|_|  |_| |_| |_|\\__,_|_| |_|
        """;

        textGraphics.setBackgroundColor(TextColor.ANSI.GREEN);

        DrawStringManager.drawString(textGraphics,  timbermanString, screenCol / 2 - 5, screenRow / 4 - 5);

        textGraphics.setForegroundColor(TextColor.ANSI.BLACK_BRIGHT);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);

        ArrayList<String> options = new ArrayList<>(List.of("Graj", "Wyniki" ,"Wyjdz"));

        for (int i = 0; i < options.size(); i++) {
            if(i == selectOption)
                textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
            else
                textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);

            textGraphics.putString(
                    new TerminalPosition(
                            screenCol / 2 - 2,
                            screenRow / 2 + i * 2 - 3),
                    options.get(i)
            );
        }
    }

}
