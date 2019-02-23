package com.example.tacstratgame;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import static android.graphics.Color.WHITE;

// To-Do: Comment, clean
public class Map {
    private Tile[][] map;
    private Resources resources;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    int interval;
    private int width;
    private int height;
    private float[] grid;
    private Paint gridPaint;

    public Map(int mapNum, Resources res) {
        resources = res;
        loadMap(mapNum);
        grid = new float[(width+1)*4+(height+1)*4];
        interval = screenWidth/width; //Size of each of the tiles
        int gridPointer = 0; //Current position in the grid array

        //Sets the start and end points of the lines of the grid
        for (int i = -4; i <= ((height + 1)/2); i++) {
            int yPosition = (screenHeight / 2) + (i * interval);
            grid[gridPointer] = 0;
            gridPointer++;
            grid[gridPointer] = yPosition;
            gridPointer++;
            grid[gridPointer] = screenWidth;
            gridPointer++;
            grid[gridPointer] = yPosition;
            gridPointer++;
        }
        for (int i = -4; i <= ((width + 1)/2); i++) {
            int xPosition = (screenWidth / 2) + (i * interval);
            if (i == -4) xPosition += 1;
            if (i == 4) xPosition += -1;
            grid[gridPointer] = xPosition;
            gridPointer++;
            grid[gridPointer] = (screenHeight / 2) - (4 * interval);
            gridPointer++;
            grid[gridPointer] = xPosition;
            gridPointer++;
            grid[gridPointer] = (screenHeight / 2) + (4 * interval);
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
        canvas.drawLines(grid,gridPaint);
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                Bitmap bit = BitmapFactory.decodeResource(resources,map[i][j].getPicture());
                bit = Bitmap.createScaledBitmap(bit,130,130,false); // Resize the image to all be the same size
                canvas.drawBitmap(bit, (screenWidth -1) -(i*interval) -bit.getWidth(),(screenHeight / 2) + ((j - 4) * interval)+1, null);
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

        //If statement can be expanded to include more levels as made
        if (mapNum == 0){
            level = resources.obtainTypedArray(R.array.map0);
        }else{
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
            if(tile.equals("l")){
                map[row][column] = new Tile(R.drawable.lightning_circle, 1, 2);
            }else if (tile.equals("k")){
                map[row][column] = new Tile(R.drawable.kbpix, 2, 1);
            }else if (tile.equals("f")) {
                map[row][column] = new Tile(R.drawable.fivepix, 5, 0);
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