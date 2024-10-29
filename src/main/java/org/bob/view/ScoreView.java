package org.bob.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.bob.Tools.DrawStringManager;

public class ScoreView {

    public void draw(TextGraphics textGraphics, int score){
        int screenCol = textGraphics.getSize().getColumns();
        int screenRow = textGraphics.getSize().getRows();

        int width = 25;
        int height = 5;

        textGraphics.setBackgroundColor(new TextColor.RGB(208, 205, 205));

        textGraphics.fillRectangle(
                new TerminalPosition(
                        screenCol / 2 - width / 2,
                        screenRow / 7),
                new TerminalSize(width, height),
                ' '
        );

        textGraphics.setForegroundColor(TextColor.ANSI.RED);
        DrawStringManager.drawString(
                textGraphics,
                DrawStringManager.convertNumberToString(score),
                screenCol / 2 ,
                screenRow/ 7);
    }
}
