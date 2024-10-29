package org.bob.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class BackgroundView {

    public void draw(TextGraphics textGraphics){
        textGraphics.setBackgroundColor(TextColor.ANSI.GREEN);
        textGraphics.fill(' ');
    }
}
