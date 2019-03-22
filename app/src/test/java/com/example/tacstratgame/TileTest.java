package com.example.tacstratgame;

import org.junit.Test;

import static org.junit.Assert.*;
import com.example.tacstratgame.Tile;

/**
 *  Verify that each value is loaded in the right slot and check the other two values
 *      to ensure no overload.
 */

public class TileTest {

    @Test
    public void getPictureTest() {
        Tile testTile = new Tile(4, 2, 3);
        assertEquals(4, testTile.getPicture() );
        assertNotEquals(2, testTile.getPicture() );
        assertNotEquals(3, testTile.getPicture() );
    }

    @Test
    public void getMovementReduction() {
        Tile testTile = new Tile(4, 2, 3 );
        assertEquals(2, testTile.getMovementReduction() );
        assertNotEquals(4, testTile.getMovementReduction() );
        assertNotEquals(3, testTile.getMovementReduction());
    }

    @Test
    public void getEffect() {
        Tile testTile = new Tile(4, 2, 3 );
        assertEquals(3, testTile.getEffect() );
        assertNotEquals(2, testTile.getEffect() );
        assertNotEquals(4, testTile.getEffect() );
    }
}