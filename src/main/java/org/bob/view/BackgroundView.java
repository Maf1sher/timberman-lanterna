package org.bob.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class BackgroundView {

    public void draw(TextGraphics textGraphics){

        int screenRows = textGraphics.getSize().getRows();
        int grasslevel = (int) (screenRows * 0.7);


        fillScreenPercent(textGraphics, 100, new TextColor.RGB(69, 185, 40));
        fillScreenPercent(textGraphics, 95, new TextColor.RGB(70, 191, 40));
        fillScreenPercent(textGraphics, 90, new TextColor.RGB(72, 196, 41));
        fillScreenPercent(textGraphics, 85, new TextColor.RGB(74, 202, 43));
        fillScreenPercent(textGraphics, 80, new TextColor.RGB(77, 208, 44));
        fillScreenPercent(textGraphics, 75, new TextColor.RGB(81, 213, 47));

        fillScreenPercent(textGraphics, 70, new TextColor.RGB(222, 152, 14));
        fillScreenPercent(textGraphics, 65, new TextColor.RGB(230, 157, 13));
        fillScreenPercent(textGraphics, 60, new TextColor.RGB(240, 160, 11));
        fillScreenPercent(textGraphics, 55, new TextColor.RGB(248, 167, 10));
        fillScreenPercent(textGraphics, 50, new TextColor.RGB(255, 174, 9));
        fillScreenPercent(textGraphics, 45, new TextColor.RGB(249, 192, 12));
        fillScreenPercent(textGraphics, 40, new TextColor.RGB(242, 212, 16));
        fillScreenPercent(textGraphics, 35, new TextColor.RGB(247, 217, 24));
        fillScreenPercent(textGraphics, 30, new TextColor.RGB(249, 219, 32));
        fillScreenPercent(textGraphics, 25, new TextColor.RGB(249, 219, 55));
        fillScreenPercent(textGraphics, 20, new TextColor.RGB(250, 221, 70));

        textGraphics.setBackgroundColor(new TextColor.RGB(105, 80, 37));
        textGraphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(7, grasslevel), ' ');
        textGraphics.fillRectangle(new TerminalPosition(15,0), new TerminalSize(5, grasslevel), ' ');
        textGraphics.fillRectangle(new TerminalPosition(30,0), new TerminalSize(5, grasslevel), ' ');
        textGraphics.fillRectangle(new TerminalPosition(45,0), new TerminalSize(5, grasslevel), ' ');
        textGraphics.fillRectangle(new TerminalPosition(55,0), new TerminalSize(5, grasslevel), ' ');
        textGraphics.fillRectangle(new TerminalPosition(70,0), new TerminalSize(7, grasslevel), ' ');

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
