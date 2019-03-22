package com.example.tacstratgame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.view.MotionEvent;
import android.content.res.Resources;
import java.util.ArrayList;


public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private float screenWidth = (float) Resources.getSystem().getDisplayMetrics().widthPixels;
    private float screenHeight = (float) Resources.getSystem().getDisplayMetrics().heightPixels;

    private MainThread thread;
    private Map map;
    private CommandMenu commandMenu;

    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
        float x0 = screenWidth / 3;
        float y0 = screenHeight - (screenHeight / 4);
        commandMenu = new CommandMenu(x0, y0, 0, screenHeight);

    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }
    public void update() {
        map.update();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        map = new Map(3, getResources()); // Makes and loads a map number
        ArrayList<Unit> unit = map.getUnitArray(); //Testing for movement
        map.move(unit.get(3)); //Testing for movement
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
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
                commandMenu.toggleDraw();
                invalidate();

        }

        return true;
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        map.draw(canvas);
        if(commandMenu.getDrawValue()){
            commandMenu.draw(canvas);
        }

    }


}
