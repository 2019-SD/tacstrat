package com.example.tacstratgame;

import org.junit.Test;

import static org.junit.Assert.*;
import com.example.tacstratgame.Tile;

public class TileTest {

    @Test
    public void getPictureTest() {
        Tile testTile = new Tile(4, 2, 3);
        assertEquals(4, testTile.getPicture() );
    }

    @Test
    public void getMovementReduction() {
        Tile testTile = new Tile(4, 2, 3 );
        assertEquals(2, testTile.getMovementReduction() );
    }

    @Test
    public void getEffect() {
        Tile testTile = new Tile(4, 2, 3 );
        assertEquals(3, testTile.getEffect() );
    }
}