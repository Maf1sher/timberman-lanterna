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

        int timerCol = screenCol / 2 - width / 2;
        int timerRow = screenRow / 10 - height / 2;

        textGraphics.setBackgroundColor(new TextColor.RGB(48, 48, 37));
        textGraphics.fillRectangle(new TerminalPosition(timerCol, timerRow), new TerminalSize(width, 3), ' ');

        textGraphics.setBackgroundColor(new TextColor.RGB(53, 53, 40));
        textGraphics.fillRectangle(new TerminalPosition(timerCol, timerRow), new TerminalSize(width, 2), ' ');

        textGraphics.setBackgroundColor(new TextColor.RGB(59, 59, 44));
        textGraphics.fillRectangle(new TerminalPosition(timerCol, timerRow), new TerminalSize(width, 1), ' ');

        textGraphics.setBackgroundColor(TextColor.ANSI.RED);

        textGraphics.setBackgroundColor(new TextColor.RGB(189, 45, 8));
        textGraphics.fillRectangle(new TerminalPosition(timerCol, timerRow),
                new TerminalSize(time / (100 / width), 3), ' ');

        textGraphics.setBackgroundColor(new TextColor.RGB(196, 45, 8));
        textGraphics.fillRectangle(new TerminalPosition(timerCol, timerRow),
                new TerminalSize(time / (100 / width), 2), ' ');

        textGraphics.setBackgroundColor(new TextColor.RGB(203, 45, 8));
        textGraphics.fillRectangle(new TerminalPosition(timerCol, timerRow),
                new TerminalSize(time / (100 / width), 1), ' ');
    }
}
