package com.example.tacstratgame;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import static android.view.Gravity.CENTER;
import static android.view.Gravity.CENTER_HORIZONTAL;

public class ActionMenu extends ScrollView {

    private float screenWidth = (float) Resources.getSystem().getDisplayMetrics().widthPixels;
    private float screenHeight = (float) Resources.getSystem().getDisplayMetrics().heightPixels;

    private boolean drawValue;
    private MenuSet menuSet;
    private Map map;
    private Tile tile;
    private LinearLayout layout;
    private Button attack;
    private Button move;
    private Button defend;
    private Button endTurn;
    private Button special;

    public ActionMenu(Context context) {
        super(context);

        menuSet = null;
        map = null;
        tile = null;
        layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        drawValue = false;

        //Setup buttons.
        attack = new Button(context);
        move = new Button(context);
        defend = new Button(context);
        endTurn = new Button(context);
        special = new Button(context);

        attack.setWidth((int) (screenHeight / 4));
        attack.setHeight((int) (screenWidth / 9));
        move.setWidth((int) (screenHeight / 4));
        move.setHeight((int) (screenWidth / 9));
        defend.setWidth((int) (screenHeight / 4));
        defend.setHeight((int) (screenWidth / 9));
        endTurn.setWidth((int) (screenHeight / 4));
        endTurn.setHeight((int) (screenWidth / 9));
        special.setWidth((int) (screenHeight / 4));
        special.setHeight((int) (screenWidth / 9));

        attack.setText("Attack");
        attack.setTextSize(18);
        attack.setGravity(CENTER | CENTER_HORIZONTAL);
        move.setText("Move");
        move.setTextSize(18);
        move.setGravity(CENTER | CENTER_HORIZONTAL);
        defend.setText("Defend");
        defend.setTextSize(18);
        defend.setGravity(CENTER | CENTER_HORIZONTAL);
        endTurn.setText("End Turn");
        endTurn.setTextSize(18);
        endTurn.setGravity(CENTER | CENTER_HORIZONTAL);
        special.setText("Special");
        special.setTextSize(18);
        special.setGravity(CENTER | CENTER_HORIZONTAL);

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawValue = false;
                map.move(tile.getUnit());
                menuSet.setTileDrawValue(false);
                menuSet.setPlayerDrawValue(false);
                menuSet.updateVisibility();
            }
        });

        attack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawValue = false;
                map.attackRange(tile.getUnit());
                menuSet.setTileDrawValue(false);
                menuSet.setPlayerDrawValue(false);
                menuSet.updateVisibility();
            }
        });
        defend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawValue = false;
                map.defend(tile.getUnit());
                menuSet.setTileDrawValue(false);
                menuSet.setPlayerDrawValue(false);
                menuSet.updateVisibility();
            }
        });
        endTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawValue = false;
                map.defend(tile.getUnit());
                menuSet.setTileDrawValue(false);
                menuSet.setPlayerDrawValue(false);
                menuSet.updateVisibility();
            }
        });
        special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawValue = false;
                map.attackRange(tile.getUnit(), 3); //Draws medic's heal range in green
                menuSet.setTileDrawValue(false);
                menuSet.setPlayerDrawValue(false);
                menuSet.updateVisibility();
            }
        });

        //Add buttons to linear layout.
        layout.addView(attack);
        layout.addView(move);
        layout.addView(defend);
        layout.addView(endTurn);
        this.addView(layout);
        this.setRotation(90);
    }

    public boolean getDrawValue()  { return drawValue; }
    public Map getMap() { return map; }
    public Tile getTile() { return tile; }

    public void setDrawValue(boolean value)  {
        if(value) { //Adds the special button if the menu is being drawn and a medic is selected
            if (tile != null && tile.getUnit() instanceof Medic) {
                layout.removeView(special); //Have to remove it before it is added to make sure multiple don't get added
                special.setText("Heal");
                layout.addView(special);
                this.setScrollbarFadingEnabled(false);
            } else {
                layout.removeView(special); //Will remove the button or do nothing if it is not already added
                special.setText("Special");
                this.setScrollbarFadingEnabled(true);
            }
        }
        drawValue = value;

    }
    public void setMap (Map map) { this.map = map; }
    public void setMenuSet(MenuSet menuSet) { this.menuSet = menuSet; }
    public void setTile (Tile tile) { this.tile = tile; }

    public void toggleDraw() {
        if (drawValue) {
            drawValue = false;
        } else {
            drawValue = true;
        }
    }

}
