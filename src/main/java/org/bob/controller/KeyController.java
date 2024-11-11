package org.bob.controller;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyController {
    private static volatile boolean leftPressed = false;
    private static volatile boolean rightPressed = false;
    private static volatile boolean upPressed = false;
    private static volatile boolean downPressed = false;
    private static volatile boolean enterPressed = false;

    private static volatile boolean leftProcessed = false;
    private static volatile boolean rightProcessed = false;
    private static volatile boolean upProcessed = false;
    private static volatile boolean downProcessed = false;
    private static volatile boolean enterProcessed = false;

    public static boolean isLeftPressed() {
        if (leftPressed && !leftProcessed) {
            leftProcessed = true;
            return true;
        }
        return false;
    }
    public static boolean isRightPressed() {
        if (rightPressed && !rightProcessed) {
            rightProcessed = true;
            return true;
        }
        return false;
    }

    public static boolean isUpProcessed() {
        if (upPressed && !upProcessed) {
            upProcessed = true;
            return true;
        }
        return false;
    }

    public static boolean isDownProcessed() {
        if (downPressed && !downProcessed) {
            downProcessed = true;
            return true;
        }
        return false;
    }

    public static boolean isEnternProcessed() {
        synchronized (KeyController.class) {
            if (enterPressed && !enterProcessed) {
                enterProcessed = true;
                return true;
            }
            return false;
        }
    }

    public static void controller_override() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent mykey) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                switch (mykey.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        if (mykey.getKeyCode() == KeyEvent.VK_LEFT) {
                            leftPressed = true;
                        }
                        else if (mykey.getKeyCode() == KeyEvent.VK_RIGHT) {
                            rightPressed = true;
                        }
                        else if (mykey.getKeyCode() == KeyEvent.VK_UP) {
                            upPressed = true;
                        }
                        else if (mykey.getKeyCode() == KeyEvent.VK_DOWN) {
                            downPressed = true;
                        }
                        else if (mykey.getKeyCode() == KeyEvent.VK_ENTER) {
                            enterPressed = true;
                        }
                        break;

                    case KeyEvent.KEY_RELEASED:
                        if (mykey.getKeyCode() == KeyEvent.VK_LEFT) {
                            leftPressed = false;
                            leftProcessed = false;
                        }
                        else if (mykey.getKeyCode() == KeyEvent.VK_RIGHT) {
                            rightPressed = false;
                            rightProcessed = false;
                        }
                        else if (mykey.getKeyCode() == KeyEvent.VK_UP) {
                            upPressed = false;
                            upProcessed = false;
                        }
                        else if (mykey.getKeyCode() == KeyEvent.VK_DOWN) {
                            downPressed = false;
                            downProcessed = false;
                        }
                        else if (mykey.getKeyCode() == KeyEvent.VK_ENTER) {
                            enterPressed = false;
                            enterProcessed = false;
                        }
                        break;
                }
                return false;
            }
        });
    }
}