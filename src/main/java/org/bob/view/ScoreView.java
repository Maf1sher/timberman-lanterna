package org.bob.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.bob.Tools.DrawStringManager;

public class ScoreView {

    public void draw(TextGraphics textGraphics, int score){
        int screenCol = textGraphics.getSize().getColumns();
        int screenRow = textGraphics.getSize().getRows();
//        textGraphics.setBackgroundColor(TextColor.ANSI.GREEN);
        textGraphics.setForegroundColor(TextColor.Factory.fromString("red"));
        DrawStringManager.drawString(
                textGraphics,
                DrawStringManager.convertNumberToString(score),
                screenCol / 2 ,
                screenRow/ 7);
    }
}
