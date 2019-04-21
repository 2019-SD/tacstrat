package com.example.tacstratgame;

import android.content.Context;
import android.widget.FrameLayout;

public class Game extends FrameLayout {

    private GameView gameView;
    private MenuSet menuSet;

    public MenuSet getMenuSet(){
        return menuSet;
    }

    public GameView getGameView() {
        return gameView;
    }

    public Game(Context context, int i) {
        super(context);

        menuSet = new MenuSet (context);
        gameView = new GameView(context, i, this, menuSet);

    }


}
