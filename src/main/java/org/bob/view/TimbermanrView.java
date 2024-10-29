package org.bob.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.bob.model.Timberman;

public class TimbermanrView {


//    @Override
    public void draw(TextGraphics textGraphics, Timberman timberman) {

        int screenCol = textGraphics.getSize().getColumns();
        textGraphics.setBackgroundColor(new TextColor.RGB(166, 13, 31));

        textGraphics.fillRectangle(
                new TerminalPosition(timberman.getSide() ? screenCol / 2 - 11 : screenCol / 2 + 5, 39),
                new TerminalSize(6,5),
                ' '
        );
        textGraphics.putString(timberman.getSide() ? screenCol / 2 - 11 : screenCol / 2 + 5, 44, " ");
        textGraphics.putString(timberman.getSide() ? screenCol / 2 - 11 + 5 : screenCol / 2 + 5 + 5, 44, " ");

        textGraphics.setBackgroundColor(new TextColor.RGB(255, 255, 255));
        textGraphics.putString(timberman.getSide() ? screenCol / 2 - 11 + 1 : screenCol / 2 + 5 + 1, 40, "    ");

        textGraphics.setBackgroundColor(new TextColor.RGB(0, 0, 0));
        textGraphics.fillRectangle(
                new TerminalPosition(timberman.getSide() ? screenCol / 2 - 11 - 2 : screenCol / 2 + 5 + 6, 39),
                new TerminalSize(2,4),
                ' '
        );

        textGraphics.putString(timberman.getSide() ? screenCol / 2 - 11 - 3 : screenCol / 2 + 5 + 8, 39, " ");
    }
}
