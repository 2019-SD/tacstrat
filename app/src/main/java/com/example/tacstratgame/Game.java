package com.example.tacstratgame;

import android.content.Context;
import android.widget.FrameLayout;

public class Game extends FrameLayout {

    private GameView gameView;
    private MenuSet menuSet;

    public MenuSet getMenuSet(){
        return menuSet;
    }

    public Game(Context context, MainActivity ref, int level) {
        super(context);

        menuSet = new MenuSet (context);
        gameView = new GameView(context, this, menuSet, ref, level);

    }


}
