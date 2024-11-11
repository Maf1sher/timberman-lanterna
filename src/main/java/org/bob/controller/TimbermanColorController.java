package org.bob.controller;

import org.bob.enums.RGBColorEnums;
import org.bob.model.Timberman;
import org.bob.view.GameUI;

public class TimbermanColorController {

    private final RGBColorEnums[] colors = {
            RGBColorEnums.RED,
            RGBColorEnums.GREEN,
            RGBColorEnums.BLUE,
            RGBColorEnums.YELLOW,
            RGBColorEnums.ORANGE
    };

    public void changeTimbermanColor(GameUI gameUI, GameController gameController) {
        int selectedColorIndex = 0;
        while (true) {
            gameUI.drawBackground();
            gameUI.drawColorMenu(selectedColorIndex, colors);
            gameUI.update();

            if (KeyController.isLeftPressed()) {
                selectedColorIndex = (selectedColorIndex - 1 + colors.length) % colors.length;
            }

            if (KeyController.isRightPressed()) {
                selectedColorIndex = (selectedColorIndex + 1) % colors.length;
            }

            if (KeyController.isEnternProcessed()) {
                Timberman timberman = gameController.getTimberman();
                timberman.setColor(colors[selectedColorIndex]);
                break;
            }
        }
    }
}
