package org.bob.view;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class ViewOld<T> {
    protected T model;

    protected ViewOld() {
    }

    public abstract void draw(TextGraphics textGraphics);
}
