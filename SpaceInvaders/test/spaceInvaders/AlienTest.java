package spaceInvaders;
/*
* Katherine Watkins
* SDEV 301
* */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienTest {

    @Test
    void transformInt() {
        Alien test = new Alien(960);
        Alien test2 = new Alien(0);
        assertEquals("      XXXX      ", test.transformInt());
        assertEquals("                ", test2.transformInt());
    }


    @Test
    void testToString() {
        Alien test = new Alien(960);
        assertEquals("960 = '      XXXX      '", test.toString());
    }
}