package org.bob.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;

import java.util.ArrayList;
import java.util.List;

public class MenuView {

    private int width = 50;
    private int height = 20;

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

        textGraphics.setForegroundColor(TextColor.ANSI.BLACK_BRIGHT);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);

        ArrayList<String> options = new ArrayList<>(List.of("Graj", "Wyjdz"));

        for (int i = 0; i < options.size(); i++) {
            if(i == selectOption)
                textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
            else
                textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);

            textGraphics.putString(
                    new TerminalPosition(
                            screenCol / 2,
                            screenRow / 2 + i * 2),
                    options.get(i)
            );
        }



//        textGraphics.putString(
//                new TerminalPosition(
//                        screenCol / 2,
//                        screenRow / 2 + 2),
//                "Wyjdz"
//        );
//        textGraphics.drawImage(
//                new TerminalPosition(
//                        screenCol / 2 - 2,
//                        screenRow / 2 - 2
//                ),
//                new BasicTextImage(new TerminalSize(10, 10))
//
//        );
//        " _____ _____ _____ _____ _____ \n" +
//                "|   __|_   _|  _  | __  |_   _|\n" +
//                "|__   | | | |     |    -| | |  \n" +
//                "|_____| |_| |__|__|__|__| |_| "
    }

}
