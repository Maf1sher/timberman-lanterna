package org.bob.Tools;

import com.googlecode.lanterna.graphics.TextGraphics;

public class DrawStringManager {

    public static void drawString(TextGraphics textGraphics, String text, int x, int y){
        String[] lines = text.split("\n");
        for(int i = 0; i < lines.length; i++){
            textGraphics.putString(x - lines[i].length() / 2, y + i, lines[i]);
        }
    }

    public static String convertNumberToString(int number){

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
        StringBuilder text = new StringBuilder();
        for(String s : linesOfTest){
            text.append(s).append("\n");
        }

        return text.toString();
    }
}
