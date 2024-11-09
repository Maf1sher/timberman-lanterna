package org.bob.model;

import org.bob.enums.RGBColorEnums;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTimberman {
    private Timberman timberman;

    @BeforeEach
    public void setUp() {
        timberman = new Timberman();
    }

    @Test
    public void testSide(){
        assertTrue(timberman.isLeftSide());
        assertFalse(timberman.isRightSide());
    }

    @Test
    public void testSwitchSide(){
        assertTrue(timberman.isLeftSide());
        assertFalse(timberman.isRightSide());
        timberman.switchSide();
        assertFalse(timberman.isLeftSide());
        assertTrue(timberman.isRightSide());
    }

    @Test
    public void testSetLeftSide(){
        timberman.setRightSide();
        timberman.setLeftSide();
        assertTrue(timberman.isLeftSide());
        assertFalse(timberman.isRightSide());
    }

    @Test
    public void testSetRightSide(){
        timberman.setLeftSide();
        timberman.setRightSide();
        assertFalse(timberman.isLeftSide());
        assertTrue(timberman.isRightSide());
    }

    @Test
    public void testGetSide(){
        assertTrue(timberman.getSide());
        timberman.switchSide();
        assertFalse(timberman.getSide());
    }

    @Test
    public void testGetAndSetColor(){
        assertEquals(RGBColorEnums.RED, timberman.getColor());
        timberman.setColor(RGBColorEnums.GREEN);
        assertEquals(RGBColorEnums.GREEN, timberman.getColor());
    }

}
