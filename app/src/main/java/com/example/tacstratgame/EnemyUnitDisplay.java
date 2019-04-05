package com.example.tacstratgame;

import android.content.Context;
import android.widget.LinearLayout;

public class EnemyUnitDisplay extends LinearLayout {

    private boolean drawValue;

    public EnemyUnitDisplay(Context context) {
        super(context);

        drawValue = false;

    }

    public boolean getDrawValue()  { return drawValue; }

    public void setDrawValue(boolean value)  { drawValue = value; }

}
