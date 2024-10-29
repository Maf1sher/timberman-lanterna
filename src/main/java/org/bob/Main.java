package org.bob;


import org.bob.controller.KeyController;
import org.bob.controller.MenuController;
import org.bob.view.GameUI;
import org.bob.view.GameUILanterna;

public class Main {
    public static void main(String[] args) {
        KeyController.controller_override();
        GameUI gameUI = new GameUILanterna();
        MenuController menuController = new MenuController(gameUI);
        menuController.run();
    }
}