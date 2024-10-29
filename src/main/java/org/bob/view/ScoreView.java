package org.bob.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class ScoreView {

    public void draw(TextGraphics textGraphics, int score){
        int screenCol = textGraphics.getSize().getColumns();
        int screenRow = textGraphics.getSize().getRows();
//        textGraphics.setBackgroundColor(TextColor.ANSI.GREEN);
        textGraphics.setForegroundColor(TextColor.Factory.fromString("red"));
        drawString(
                textGraphics,
                convertNumberToString(score),
                screenCol / 2 ,
                screenRow/ 7);
    }

    private String convertNumberToString(int number){

        String[][] numberString = {
                {" ___ ","|   |","| | |","|___|"},
                {" ___   ","|_  |  "," _| |_ ","|_____|"},
                {" ___ ","|_  |","|  _|","|___|"},
                {" ___ ","|_  |","|_  |","|___|"},
                {" ___ ","| | |","|_  |","  |_|"},
                {" ___ ","|  _|","|_  |","|___|"},
                {" ___ ","|  _|","| . |","|___|"},
                {" ___ ","|_  |","  | |","  |_|"},
                {" ___ ","| . |","| . |","|___|"},
                {" ___ ","| . |","|_  |","|___|"}
        };

        char[] arrCharOfNumber = String.valueOf(number).toCharArray();
        String[] linesOfTest = {"","","",""};
        for(Character c : arrCharOfNumber){
            int index = Integer.parseInt(c.toString());
            String[] aa = numberString[index];
            for (int i = 0; i < 4; i++) {
                linesOfTest[i] += aa[i];
            }
        }
        String text = "";
        for(String s : linesOfTest){
            text += s + "\n";
        }

        return text;
    }

    private void drawString(TextGraphics textGraphics, String text, int x, int y){
        String[] lines = text.split("\n");
        for(int i = 0; i < lines.length; i++){
            textGraphics.putString(x - lines[i].length() / 2, y + i, lines[i]);
        }
    }
}
