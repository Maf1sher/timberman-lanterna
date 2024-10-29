package org.bob.model;

public class Timberman {
    //true = left side
    //false = right side
    private boolean side;

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
