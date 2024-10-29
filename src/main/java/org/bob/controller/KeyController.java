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
        synchronized (KeyController.class) {
            if (leftPressed && !leftProcessed) {
                leftProcessed = true;
                return true;
            }
            return false;
        }
    }
    public static boolean isRightPressed() {
        synchronized (KeyController.class) {
            if (rightPressed && !rightProcessed) {
                rightProcessed = true;
                return true;
            }
            return false;
        }
    }

    public static boolean isUpProcessed() {
        synchronized (KeyController.class) {
            if (upPressed && !upProcessed) {
                upProcessed = true;
                return true;
            }
            return false;
        }
    }

    public static boolean isDownProcessed() {
        synchronized (KeyController.class) {
            if (downPressed && !downProcessed) {
                downProcessed = true;
                return true;
            }
            return false;
        }
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
                synchronized (KeyController.class) {
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
            }
        });
    }
}