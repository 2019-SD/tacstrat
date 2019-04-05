package com.example.tacstratgame;

import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;

import static android.graphics.Color.LTGRAY;
import static android.graphics.Color.TRANSPARENT;

public class MenuSet extends FrameLayout {

    private float screenWidth = (float) Resources.getSystem().getDisplayMetrics().widthPixels;
    private float screenHeight = (float) Resources.getSystem().getDisplayMetrics().heightPixels;
    private LayoutParams actionParams;
    private LayoutParams tileParams;
    private LayoutParams enemyParams;
    private LayoutParams playerParams;

    private CommandMenu commandMenu;

    private ActionMenu actionMenu;
    private TileDisplay tileDisplay;
    private EnemyUnitDisplay enemyUnitDisplay;
    private PlayerUnitDisplay playerUnitDisplay;

    public MenuSet(Context context) {
        super(context);

        float x0 = screenWidth / 3;
        float y0 = screenHeight - (screenHeight / 4);
        commandMenu = new CommandMenu(x0, y0, 0, screenHeight);

        actionMenu = new ActionMenu(context);
        actionMenu.setMenuSet(this);
        tileDisplay = new TileDisplay(context);
        enemyUnitDisplay = new EnemyUnitDisplay(context);
        playerUnitDisplay = new PlayerUnitDisplay(context);

        tileDisplay.setBackgroundColor(TRANSPARENT | LTGRAY);
        tileDisplay.setTextSize(10);
        tileDisplay.setRotation(90);
        tileDisplay.setPadding(15, 15, 15, 15);
        playerUnitDisplay.setBackgroundColor(TRANSPARENT | LTGRAY);
        playerUnitDisplay.setRotation(90);
        //playerUnitDisplay.setPadding(15, 15, 15, 15);

        actionMenu.setVisibility(GONE);
        tileDisplay.setVisibility(GONE);
        enemyUnitDisplay.setVisibility(GONE);
        playerUnitDisplay.setVisibility(GONE);

        actionParams = new LayoutParams((int) (screenHeight / 4),(int) (screenWidth / 3));
        tileParams = new LayoutParams((int) (screenHeight / 6), (int) (screenWidth / 3));
        enemyParams = new LayoutParams((int) (screenWidth / 3), (int) (screenHeight / 6));
        //playerParams = new LayoutParams((int) screenHeight, (int) (screenWidth / 10));
        playerParams = new LayoutParams((int) (screenHeight / 6), (int) (screenWidth / 3));

        actionParams.leftMargin = 0;
        actionParams.topMargin = (int) (screenHeight - (screenHeight / 4));
        tileParams.leftMargin = 20;
        tileParams.topMargin = (int) screenHeight / 8;
        enemyParams.leftMargin = (int) (screenWidth / 3);
        enemyParams.topMargin = 0;
        //playerParams.leftMargin = (int) (screenWidth - (4 * (screenWidth / 10)));
        //playerParams.topMargin = 0;
        playerParams.leftMargin = (int) (screenWidth - (screenWidth / 3));
        playerParams.topMargin = (int) screenHeight / 8;

        this.addView(actionMenu, actionParams);
        this.addView(tileDisplay, tileParams);
        this.addView(enemyUnitDisplay, enemyParams);
        this.addView(playerUnitDisplay, playerParams);


    }

    public boolean getActionDrawValue() { return actionMenu.getDrawValue(); }
    public boolean getTileDrawValue() { return tileDisplay.getDrawValue(); }
    public boolean getEnemyDrawValue() { return enemyUnitDisplay.getDrawValue(); }
    public boolean getPlayerDrawValue() { return playerUnitDisplay.getDrawValue(); }

    public void setActionDrawValue(boolean value) { actionMenu.setDrawValue(value); }
    public void setTileDrawValue(boolean value) { tileDisplay.setDrawValue(value); }
    public void setEnemyDrawValue(boolean value) { enemyUnitDisplay.setDrawValue(value); }
    public void setPlayerDrawValue(boolean value) { playerUnitDisplay.setDrawValue(value); }
    public void setActionVisibility(int visibility) { actionMenu.setVisibility(visibility); }
    public void setTileVisibility(int visibility) { tileDisplay.setVisibility(visibility); }
    public void setEnemyVisibility(int visibility) { enemyUnitDisplay.setVisibility(visibility); }
    public void setPlayerVisibility(int visibility) { playerUnitDisplay.setVisibility(visibility); }
    public void setMap (Map map) { actionMenu.setMap(map); }
    public void setTile (Tile tile) { actionMenu.setTile(tile); }

    public void updatePlayerDisplay(Unit unit) { playerUnitDisplay.updateDisplay(unit); }

    public void updateVisibility() {
        if (getActionDrawValue()) {
            setActionVisibility(VISIBLE);
        } else {
            setActionVisibility(GONE);
        }
        if (getTileDrawValue()) {
            setTileVisibility(VISIBLE);
        } else {
            setTileVisibility(GONE);
        }
        if (getEnemyDrawValue()) {
            setEnemyVisibility(VISIBLE);
        } else {
            setEnemyVisibility(GONE);
        }
        if (getPlayerDrawValue()) {
            setPlayerVisibility(VISIBLE);
        } else {
            setPlayerVisibility(GONE);
        }
    }

    public void updateTileInfo(Tile tile) {
        tileDisplay.updateTileInfo(tile);
    }



}
