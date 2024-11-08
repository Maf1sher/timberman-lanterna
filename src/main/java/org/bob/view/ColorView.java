package org.bob.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.bob.Tools.DrawStringManager;
import org.bob.enums.RGBColorEnums;

public class ColorView {

    public void draw(TextGraphics textGraphics, int selectedColorIndex, RGBColorEnums[] colors) {

        int screenCol = textGraphics.getSize().getColumns();
        int screenRow = textGraphics.getSize().getRows();

        int width = 60;
        int height = 40;

        String colorString = """
                   _____      _           \s
                  / ____|    | |          \s
                 | |     ___ | | ___  _ __\s
                 | |    / _ \\| |/ _ \\| '__|
                 | |___| (_) | | (_) | |  \s
                  \\_____\\___/|_|\\___/|_|  \s
                                          \s
                                          \s
                
                """;

        textGraphics.setBackgroundColor(TextColor.ANSI.CYAN);

        textGraphics.fillRectangle(
                new TerminalPosition(
                        screenCol / 2 - width / 2,
                        screenRow / 2 - height / 2),
                new TerminalSize(width, height),
                ' '
        );

        textGraphics.setForegroundColor(TextColor.ANSI.BLACK);

        DrawStringManager.drawString(textGraphics,  colorString, screenCol / 2, screenRow / 4 - 5);

        for (int i = 0; i < colors.length; i++) {
            if (i == selectedColorIndex) {
                textGraphics.setBackgroundColor(TextColor.ANSI.WHITE_BRIGHT);
            } else {
                textGraphics.setBackgroundColor(TextColor.ANSI.DEFAULT);
            }

            textGraphics.setForegroundColor(new TextColor.RGB(colors[i].getR(), colors[i].getG(), colors[i].getB()));
            String colorOption = "Color " + (i + 1);

            textGraphics.putString(screenCol / 2 - 10, screenRow / 2 + i, colorOption);
        }

        textGraphics.setBackgroundColor(TextColor.ANSI.DEFAULT);
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
    }
}

