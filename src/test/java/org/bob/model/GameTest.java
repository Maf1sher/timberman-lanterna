package org.bob.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testInitVal(){
        assertNotNull(game.board);
        assertNotNull(game.timberman);
        assertEquals(0, game.score);
        assertEquals(100, game.timer);
        assertEquals(0, game.tick);
    }

    @Test
    public void testCalculateTime(){
        game.score = 300;
        game.tick = 20;

        game.calculateTime();

        int expectedTimer = 100 - (game.score/100 + 1);
        assertEquals(expectedTimer, game.timer);
        assertEquals(0, game.tick);
    }

    @Test
    public void testCalculateTimeBefore20Tick(){
        game.score = 300;
        game.tick = 19;

        int initialTimer = game.timer;
        game.calculateTime();

        assertEquals(initialTimer, game.timer);
        assertEquals(19, game.tick);
    }
}
