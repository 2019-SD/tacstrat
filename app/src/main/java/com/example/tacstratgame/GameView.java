package com.example.tacstratgame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import java.util.ArrayList;


public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private Map map;
    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
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
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        map.draw(canvas);
    }
}
