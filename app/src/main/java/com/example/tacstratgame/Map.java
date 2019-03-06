/*
  Class will be tested with a local test. (Junit)
 */

package com.example.tacstratgame;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import static android.graphics.Color.WHITE;

public class Map {
    private Tile[][] map;
    private Resources resources;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    private int interval;
    private int unusedPix;
    private int startheight;
    private int width;
    private int height;
    private float[] grid;
    private Paint gridPaint;

    public Map(int mapNum, Resources res) {
        resources = res;
        loadMap(mapNum);
        grid = new float[(width+1)*4+(height+1)*4];
        interval = ((screenWidth-(width+1))/width)+1; //The distance from one gridline to the next
        unusedPix = screenWidth - (((interval-1) * width) + width+1); //The number of pixels that will be unused for the width (range from 0 to width-1)
        int gridPointer = 0; //Current position in the grid array

        //Sets the start and end points of the lines of the grid
        startheight = (screenHeight/2)-(interval * (height/2)); //The smallest y position for an even height map
        if(height % 2 == 1) {
            startheight -= (interval / 2 + 1); //The smallest y position for an odd height map
        }
        for (int i = 0; i <= height; i++) {
            int yPosition = startheight + (i * interval);
            grid[gridPointer] = 0 + (unusedPix/2); //(Smaller) Half of the unused pixels at the start
            gridPointer++;
            grid[gridPointer] = yPosition;
            gridPointer++;
            grid[gridPointer] = screenWidth - ((unusedPix/2) + (unusedPix%2) + 1); //(Larger) Half of the unused pixels at the end
            gridPointer++;
            grid[gridPointer] = yPosition;
            gridPointer++;
        }
        for (int i = unusedPix/2; i < screenWidth; i+= interval) {
            grid[gridPointer] = i;
            gridPointer++;
            grid[gridPointer] = startheight;
            gridPointer++;
            grid[gridPointer] = i;
            gridPointer++;
            grid[gridPointer] = startheight + (height * interval);
            gridPointer++;
        }
        gridPaint = new Paint();
        gridPaint.setColor(WHITE);
    }
    public void setTile(int x, int  y,Tile tile){
        map[x][y] = tile;
    }
    public Tile getTile(int x, int y){
        return map[x][y];
    }

    public void draw(Canvas canvas) {
        canvas.drawLines(grid, gridPaint);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Bitmap bit = BitmapFactory.decodeResource(resources, map[i][j].getPicture());
                bit = Bitmap.createScaledBitmap(bit, interval-1, interval-1, false); // Resize the image to all be the same size
                canvas.drawBitmap(bit, 1 + (unusedPix/2) + (interval*i), 1 + startheight + (interval*j), null);
            }
        }
    }
    public void update() {

    }

    /**
     * Loads all the tiles from the given map number into the map global variable
     * @param mapNum Number of the map to load from arrays.xml
     * @return 0 if successful, -1 otherwise
     */
    public int loadMap(int mapNum){
        TypedArray level;

        //Case statement can be expanded to include more levels as made
        switch (mapNum){
            case 0:
                level = resources.obtainTypedArray(R.array.map0);
                break;
            case 1:
                level = resources.obtainTypedArray(R.array.test10);
                break;
            case 2:
                level = resources.obtainTypedArray(R.array.test11);
                break;
            case 3:
                level = resources.obtainTypedArray(R.array.rect11x15);
                break;
            default:
                return -1;
        }

        int index = 0;
        width =level.getInt(index,-1);
        index++;
        height = level.getInt(index, -1);
        index++;
        if(width < 1 || height < 1){ //If the numbers given were invalid or failed to load
            return -1;
        }
        map = new Tile[width][height];
        int column = 0;
        int row = 0;
        String tile;
        while (index < level.length()){
            tile = level.getString(index);

            // Each letter represents a different type of tile
            switch(tile){
                case "s":
                    map[row][column] = new Tile(R.drawable.sand_tile, 2, 2);
                    break;
                case "b":
                    map[row][column] = new Tile(R.drawable.building_tile, -1, 1);
                    break;
                case "f":
                    map[row][column] = new Tile(R.drawable.standard_tile, 1, 0);
                    break;
                case "w":
                    map[row][column] = new Tile(R.drawable.water_tile, 3, 0);
                    break;
                default:
                    map[row][column] = new Tile(R.drawable.lightning_circle,-1,-1);
            }
            index++;
            column++;
            if(column >= height){
                column = 0;
                row++;
            }
        }
        return 0;
    }
}