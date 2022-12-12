package com.ae2dms.bubblebobble;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for the main class
 *
 * @author Ke Liu
 */

class MainTest {

    @Test
    void getSCENE_WIDTH() {
        assertEquals(855,Main.getSCENE_WIDTH() );
    }

    @Test
    void getSCENE_HEIGHT() {
        assertEquals(680,Main.getSCENE_HEIGHT() );
    }

    @Test
    void getUnitSize() {
        assertEquals(20,Main.getUnitSize() );
    }

}