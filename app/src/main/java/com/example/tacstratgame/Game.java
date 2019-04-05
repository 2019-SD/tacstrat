package com.example.tacstratgame;

import android.content.Context;
import android.widget.FrameLayout;

public class Game extends FrameLayout {

    private GameView gameView;
    private MenuSet menuSet;


    public Game(Context context) {
        super(context);

        menuSet = new MenuSet (context);
        gameView = new GameView(context, this, menuSet);

    }


}
