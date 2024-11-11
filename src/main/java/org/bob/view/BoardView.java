package org.bob.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.bob.model.Board;
import org.bob.model.TupleBoolean;

import java.util.List;

public class BoardView{

    private final int trunkWidth = 8;
    private final int trunkHeight = 5;

    public void draw(TextGraphics textGraphics, Board board) {
        List<TupleBoolean> list = board.getTree();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getValue1())
                drawBranch(textGraphics, 0, i, false);

            drawTrunk(textGraphics, i);

            if(list.get(i).getValue2())
                drawBranch(textGraphics, 2, i, true);

        }
    }


    private void drawTrunk(TextGraphics textGraphics, int col){

        int screenCol = textGraphics.getSize().getColumns();
        int screenRow = textGraphics.getSize().getRows();

        textGraphics.setBackgroundColor(new TextColor.RGB(61, 43, 13));
        textGraphics.fillRectangle(
                new TerminalPosition(
                        (screenCol / 2) - trunkWidth / 2,
                        screenRow - 10 - col * trunkHeight
                ),
                new TerminalSize(trunkWidth, trunkHeight),
                ' '
        );
    }

    private void drawBranch(TextGraphics textGraphics, int col, int row, boolean reverse){
        int screenCol = textGraphics.getSize().getColumns();
        int screenRow = textGraphics.getSize().getRows();


        int branchWidth = 15;
        int branchHeight = 1;

        textGraphics.setBackgroundColor(new TextColor.RGB(61, 43, 13));
        textGraphics.drawRectangle(
                new TerminalPosition(
                        reverse ? (screenCol / 2) + trunkWidth / 2 : (screenCol / 2) - branchWidth - trunkWidth / 2,
                        screenRow - 10 - row * trunkHeight + trunkWidth / 4
                ),
                new TerminalSize(branchWidth,branchHeight),
                ' '
        );

        textGraphics.setBackgroundColor(new TextColor.RGB(27, 142, 14));
        textGraphics.drawRectangle(
                new TerminalPosition(
                        reverse ? (screenCol / 2) + trunkWidth / 2 + branchWidth - 4: (screenCol / 2) - branchWidth - trunkWidth / 2,
                        screenRow - 10 - row * trunkHeight + trunkWidth / 4 -1

                ),
                new TerminalSize(4,1),
                ' '
        );
    }
}
