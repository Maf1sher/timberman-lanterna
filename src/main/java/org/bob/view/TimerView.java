package org.bob.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class TimerView {

    public TimerView(){

    }

    public void draw(TextGraphics textGraphics, int time){
        int screenCol = textGraphics.getSize().getColumns();
        int screenRow = textGraphics.getSize().getRows();

        int width = 25;
        int height = 3;

        textGraphics.setBackgroundColor(new TextColor.RGB(81, 78, 59));

        textGraphics.fillRectangle(
                new TerminalPosition(
                        screenCol / 2 - width / 2,
                        screenRow / 10 - height / 2),
                new TerminalSize(width, height),
                ' '
        );

        textGraphics.setBackgroundColor(TextColor.ANSI.RED);

        textGraphics.fillRectangle(
                new TerminalPosition(
                        screenCol / 2 - width / 2,
                        screenRow / 10 - height / 2),
                new TerminalSize(time / (100 / width), height),
                ' '
        );
    }
}
