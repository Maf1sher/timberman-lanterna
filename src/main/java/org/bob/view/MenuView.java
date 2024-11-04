package org.bob.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.bob.Tools.DrawStringManager;

import java.util.ArrayList;
import java.util.List;


public class MenuView {

    private final int width = 50;
    private final int height = 25;

    public MenuView() {

    }

    public void draw(TextGraphics textGraphics, int selectOption) {
        int screenCol = textGraphics.getSize().getColumns();
        int screenRow = textGraphics.getSize().getRows();

//        textGraphics.setBackgroundColor(TextColor.ANSI.CYAN);
        textGraphics.setBackgroundColor(new TextColor.RGB(208, 205, 205));
        textGraphics.fillRectangle(
                new TerminalPosition(
                        screenCol / 2 - width / 2,
                        screenRow / 2 - height / 2),
                new TerminalSize(width, height),
                ' '
        );

//        String timbermanString = """
//                ___          __   ___  __                 \s
//                 |  |  |\\/| |__) |__  |__)  |\\/|  /\\  |\\ |\s
//                 |  |  |  | |__) |___ |  \\  |  | /~~\\ | \\|\s
//        """;

        String timbermanString =
                """
                         _______ _____ __  __ ____  ______ _____  __  __          _   _\s
                         |__   __|_   _|  \\/  |  _ \\|  ____|  __ \\|  \\/  |   /\\   | \\ | |
                            | |    | | | \\  / | |_) | |__  | |__) | \\  / |  /  \\  |  \\| |
                            | |    | | | |\\/| |  _ <|  __| |  _  /| |\\/| | / /\\ \\ | . ` |
                            | |   _| |_| |  | | |_) | |____| | \\ \\| |  | |/ ____ \\| |\\  |
                            |_|  |_____|_|  |_|____/|______|_|  \\_\\_|  |_/_/    \\_\\_| \\_|\
                        """;

        textGraphics.setBackgroundColor(new TextColor.RGB(149, 91, 25));
        textGraphics.setForegroundColor(TextColor.ANSI.BLACK);

        DrawStringManager.drawString(textGraphics,  timbermanString, screenCol / 2, screenRow / 4 - 5);

//        textGraphics.setForegroundColor(TextColor.ANSI.BLACK_BRIGHT);
//        textGraphics.setBackgroundColor(TextColor.ANSI.CYAN);
        textGraphics.setForegroundColor(TextColor.ANSI.RED);
        textGraphics.setBackgroundColor(new TextColor.RGB(208, 205, 205));

        ArrayList<String> optionsString = new ArrayList<>(List.of(
                """
                         __   __              \s
                        / _` |__)  /\\     |   \s
                        \\__> |  \\ /~~\\ \\__/   \s""",
                """
                                              \s
                        |  | \\ / |\\ | | |__/ |\s
                        |/\\|  |  | \\| | |  \\ |\s""",
                """
                   __   __   __        ___\s
                  /  \\ |__) /  `    | |__ \s
                  \\__/ |    \\__, \\__/ |___\s 
                """,
                """
                                       __  __ \s
                        |  | \\ /    | |  \\  / \s
                        |/\\|  |  \\__/ |__/ /_ \s"""));

        DrawStringManager.drawString(textGraphics,
                """
                        __ \s
                        \\ \\\s
                         > >
                        /_/\s""",
                screenCol / 2 - 15, screenRow / 2 + selectOption * 4 - 6);

        for (int i = 0; i < optionsString.size(); i++) {
            DrawStringManager.drawString(textGraphics, optionsString.get(i), screenCol / 2, screenRow / 2 + i * 4 - 5);
        }
    }

}
