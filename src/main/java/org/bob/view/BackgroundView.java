package org.bob.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class BackgroundView {

    public void draw(TextGraphics textGraphics){

        textGraphics.setBackgroundColor(TextColor.ANSI.GREEN);
        textGraphics.fill(' ');

        fillScreenPercent(textGraphics, 70, new TextColor.RGB(222, 152, 14));
        fillScreenPercent(textGraphics, 60, new TextColor.RGB(240, 160, 11));
        fillScreenPercent(textGraphics, 50, new TextColor.RGB(255, 174, 9));
        fillScreenPercent(textGraphics, 40, new TextColor.RGB(242, 212, 16));
        fillScreenPercent(textGraphics, 30, new TextColor.RGB(249, 219, 32));
        fillScreenPercent(textGraphics, 20, new TextColor.RGB(250, 221, 70));
        fillScreenPercent(textGraphics, 10, new TextColor.RGB(255, 236, 105));

    }

    private void fillScreenPercent(TextGraphics textGraphics, int percent, TextColor color){
        int screenRow = textGraphics.getSize().getRows();
        int screenCol = textGraphics.getSize().getColumns();

        textGraphics.setBackgroundColor(color);
        textGraphics.fillRectangle(
                new TerminalPosition(0,0),
                new TerminalSize(screenCol, (int) (screenRow * (percent / 100.0))),
                ' '
                );
    }
}
