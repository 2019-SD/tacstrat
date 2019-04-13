package com.example.tacstratgame;

/**
 * Class that holds the information for a specific tile on a map. Parameters can be changed
 * after instantiation of the Tile.
 *
 * Class will be tested with a local test. (Junit)
 */
public class Tile {
    private int picture; // The integer pointing to the image in drawable
    private int movementReduction; // The amount that traveling over this tile will reduce available movement
    private int effect; // Possible special effect of this tile
    private Unit unit = null; // Unit on this tile, null if no unit
    private int defenseBuff;

    public Tile(int picture, int movementReduction, int effect, int defenseBuff){
        this.picture = picture;
        this.movementReduction = movementReduction;
        this.effect = effect;
        this.defenseBuff = defenseBuff;
    }

    public int getPicture() {
        return picture;
    }

    public int getMovementReduction() {
        return movementReduction;
    }

    public int getEffect() {
        return effect;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit u) { unit = u; }

    public boolean hasUnit() { return unit !=null; }

    public int getDefenseBuff() { return defenseBuff; }
}
