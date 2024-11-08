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

        int timbermanCol = screenCol / 2 - 2;
        int timbermanRow = 28;

        int colorsLength = colors.length;

        TextColor color =  new TextColor.RGB(
                colors[selectedColorIndex].getR(),
                colors[selectedColorIndex].getG(),
                colors[selectedColorIndex].getB());

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

        String left_arrow = """
                  __
                 / /
                < <\s
                 \\_\\""";

        String right_arrow = """
                __ \s
                \\ \\\s
                 > >
                /_/\s""";

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

        DrawStringManager.drawString(textGraphics, left_arrow, timbermanCol - 17, timbermanRow + 4);
        DrawStringManager.drawString(textGraphics, right_arrow, timbermanCol + 20, timbermanRow + 4);

        int leftColorIndex = (selectedColorIndex == 0) ? colorsLength - 1 : selectedColorIndex - 1;

        textGraphics.setBackgroundColor(
                new TextColor.RGB(
                    colors[leftColorIndex].getR(),
                    colors[leftColorIndex].getG(),
                    colors[leftColorIndex].getB()
                ));

        textGraphics.fillRectangle(
                new TerminalPosition(timbermanCol - 13, timbermanRow + 5),
                new TerminalSize(8,2),
                ' '
        );

        textGraphics.setBackgroundColor(color);
        textGraphics.fillRectangle(
                new TerminalPosition(timbermanCol - 2, timbermanRow + 5),
                new TerminalSize(8,2),
                ' '
        );

        int rightColorIndex = (selectedColorIndex == colorsLength - 1) ? 0 : selectedColorIndex + 1;

        textGraphics.setBackgroundColor(
                new TextColor.RGB(
                        colors[rightColorIndex].getR(),
                        colors[rightColorIndex].getG(),
                        colors[rightColorIndex].getB()
                ));

        textGraphics.fillRectangle(
                new TerminalPosition(timbermanCol + 9, timbermanRow + 5),
                new TerminalSize(8,2),
                ' '
        );

        textGraphics.setBackgroundColor(color);

        textGraphics.fillRectangle(
                new TerminalPosition(timbermanCol, timbermanRow - 5),
                new TerminalSize(6,5),
                ' '
        );
        textGraphics.putString(timbermanCol, timbermanRow, " ");
        textGraphics.putString(timbermanCol + 5, timbermanRow, " ");

        textGraphics.setBackgroundColor(new TextColor.RGB(255, 255, 255));
        textGraphics.putString(timbermanCol + 1, timbermanRow - 4, "    ");

        textGraphics.setBackgroundColor(new TextColor.RGB(0, 0, 0));
        textGraphics.fillRectangle(
                new TerminalPosition(timbermanCol - 2, timbermanRow - 5),
                new TerminalSize(2,4),
                ' '
        );

        textGraphics.putString(timbermanCol - 3, timbermanRow - 5, " ");
    }
}

