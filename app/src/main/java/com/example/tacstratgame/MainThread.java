/*
  Class will be tested with a instrumented test (or no test).
 */

package com.example.tacstratgame;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

    private Game game;
    private GameView gameView;
    private SurfaceHolder surfaceHolder;
    private MenuSet menuSet;
    private boolean running;
    public static Canvas canvas;

    public MainThread(Game game, GameView gameView, MenuSet menuSet) {
        super();

        this.game = game;
        this.gameView = gameView;
        this.surfaceHolder = gameView.getHolder();
        this.menuSet = menuSet;

        //Menus need to be setup by this point.
        game.addView(gameView);
        game.addView(menuSet);
    }

    @Override
    public void run() {
        while (running) {
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized(surfaceHolder) {
                    this.gameView.update();
                    this.gameView.draw(canvas);
                }
            } catch (Exception e) {} finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void setRunning(boolean isRunning) {
        running = isRunning;
    }
}
