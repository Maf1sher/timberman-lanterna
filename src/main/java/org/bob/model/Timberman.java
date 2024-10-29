package org.bob.model;

import com.googlecode.lanterna.TextColor;

public class Timberman {
    //true = left side
    //false = right side
    private boolean side;
    private TextColor color = new TextColor.RGB(166, 13, 31); // 166, 13, 31

    public TextColor getColor() {
        return color;
    }

    public void setColor(TextColor color) {
        this.color = color;
    }

    public Timberman() {
        side = true;
    }

    public void switchSide(){
        side = !side;
    }

    public void setLeftSide(){
        side = true;
    }

    public void setRightSide(){
        side = false;
    }

    public boolean isLeftSide(){
        return side;
    }

    public boolean isRightSide(){
        return !side;
    }

    public boolean getSide(){
        return side;
    }
}
