package com.example.tacstratgame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.view.MotionEvent;
import android.content.res.Resources;
import android.view.View;


public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private float screenWidth = (float) Resources.getSystem().getDisplayMetrics().widthPixels;
    private float screenHeight = (float) Resources.getSystem().getDisplayMetrics().heightPixels;

    private MainThread mainThread;
    private Map map;
    private CommandMenu commandMenu;
    private Game game;
    private MenuSet menuSet;
    private static int turn = 1;

    public GameView(Context context, Game game, MenuSet menuSet) {
        super(context);

        getHolder().addCallback(this);
        this.game = game;
        this.menuSet = menuSet;
        map = new Map(1, getResources());
        this.menuSet.setMap(map);
        mainThread = new MainThread(game, this, menuSet);
        setFocusable(true);
        float x0 = screenWidth / 3;
        float y0 = screenHeight - (screenHeight / 4);
        commandMenu = new CommandMenu(x0, y0, 0, screenHeight);


    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    public static int getTurn() {
        return turn;
    }

    public void setTurn( int turn ) {
        this.turn = turn;
    }

    public void update() {
        map.update();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mainThread.setRunning(true);
        mainThread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                mainThread.setRunning(false);
                mainThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }


    /*
     * UI Elements start here. Work in progress.
     */
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        //Gets input details from the touch screen when activity is detected.
        //Use ACTION_DOWN for a tap.
        //Still need to detect collision.

        float x = e.getX();
        float y = e.getY();

        //Do different things depending on action of MotionEvent.
        switch(e.getAction()) {
            //When user first touches the screen.
            case MotionEvent.ACTION_DOWN:
                menuSet.setActionDrawValue(false);
                menuSet.setEnemyDrawValue(false);
                menuSet.setPlayerDrawValue(false);

                Tile tile = map.getTile(x,y);
                menuSet.setTile(tile);
                if (tile == null){
                    map.stopDrawingMove();
                } else {
                    menuSet.updateTileInfo(tile);
                    menuSet.updatePlayerDisplay(tile.getUnit());
                    if(map.drawingMove()){
                        if (map.canMove(map.getX(x),map.getY(y))){
                            map.moveUnit(map.getX(x), map.getY(y));
                            menuSet.setTileDrawValue(false);
                            menuSet.updateVisibility();
                            game.invalidate();
                            return true;
                        } else{
                            map.stopDrawingMove();
                        }
                    } else if( map.drawingAttack()){
                        map.attack(map.getX(x), map.getY(y));
                        menuSet.setTileDrawValue(false);
                        menuSet.updateVisibility();
                        game.invalidate();
                        return true;
                    } else if( map.drawingSpecial()){
                        map.special(map.getX(x), map.getY(y));
                        menuSet.setTileDrawValue(false);
                        menuSet.updateVisibility();
                        game.invalidate();
                        return true;
                    }
                    else if(tile.hasUnit()){
                        menuSet.setActionDrawValue(true);
                        menuSet.setPlayerDrawValue(true);
                    }
                }

                menuSet.updateVisibility();
                game.invalidate();

        }

        return true;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        map.draw(canvas);
    }


}
