package com.example.tacstratgame;

import android.content.Context;
import android.widget.TextView;

public class TileDisplay extends TextView {

    private boolean drawValue;
    private Tile oldTile;
    private Tile newTile;
    private String description;
    private String movementReduction;
    private String effect;

    public TileDisplay(Context context) {
        super(context);

        oldTile = null;
        newTile = null;
        description = null;
        movementReduction = null;
        effect = null;
        drawValue = false;
    }

    public boolean getDrawValue()  { return drawValue; }

    public void setDrawValue(boolean value)  { drawValue = value; }

    public void toggleDraw() {
        if (drawValue) {
            drawValue = false;
        } else {
            drawValue = true;
        }
    }

    public void updateTileInfo(Tile tile) {
        switch (tile.getPicture()) {
            case R.drawable.sand_tile_3:
                description = "Sand";
                break;
            case R.drawable.sand_tile_2:
                description = "Sand";
                break;
            case R.drawable.sand_tile:
                description = "Sand";
                break;
            case R.drawable.building_tile:
                description = "Buildings";
                break;
            case R.drawable.building_tile_2:
                description = "Buildings";
                break;
            case R.drawable.standard_tile:
                description = "Plains";
                break;
            case R.drawable.water_tile_3:
                description = "Water";
                break;
            case R.drawable.water_tile_2:
                description = "Water";
                break;
            case R.drawable.water_tile:
                description = "Water";
                break;
            default:
                description = null;
                break;
        }

        movementReduction = "Move Penalty: " + Integer.toString(tile.getMovementReduction());

        switch (tile.getEffect()) {
            case 0:
                effect = "Effect: None";
                break;
            case 1:
                effect = "Effect: Defense Buff";
                break;
            case 2:
                effect = "Effect: Defense Debuff";
                break;
            default:
                effect = null;
                break;
        }

        this.setText(description + "\n\n\n\n" + movementReduction + "\n\n\n\n" + effect);

        //If the tile is reclicked, turn off menu. If a new tile is clicked (newtile != oldtile)
        //then draw it.
        newTile = tile;
        if (newTile == oldTile) {
            this.toggleDraw();
        } else {
            drawValue = true;
        }
        oldTile = tile;
    }
}
