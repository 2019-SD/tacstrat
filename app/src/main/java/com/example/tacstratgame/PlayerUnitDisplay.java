package com.example.tacstratgame;

import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.Gravity.CENTER;
import static android.view.Gravity.CENTER_HORIZONTAL;

public class PlayerUnitDisplay extends LinearLayout {

    private float screenWidth = (float) Resources.getSystem().getDisplayMetrics().widthPixels;
    private float screenHeight = (float) Resources.getSystem().getDisplayMetrics().heightPixels;
    private boolean drawValue;
    private TextView playerName;
    private TextView healthPoints;
    private TextView defensePoints;
    private TextView attackPoints;
    private TextView movePoints;
    private String nameStr;
    private String healthStr;
    private String defenseStr;
    private String attackStr;
    private String moveStr;

    public PlayerUnitDisplay(Context context) {
        super(context);

        this.setOrientation(LinearLayout.HORIZONTAL);
        drawValue = false;

        playerName = new TextView(context);
        healthPoints = new TextView(context);
        defensePoints = new TextView(context);
        attackPoints = new TextView(context);
        movePoints = new TextView(context);

        playerName.setWidth((int) screenHeight / 6);
        playerName.setHeight((int) screenWidth / 12);
        healthPoints.setWidth((int) screenHeight / 6);
        healthPoints.setHeight((int) screenWidth / 12);
        defensePoints.setWidth((int) screenHeight / 6);
        defensePoints.setHeight((int) screenWidth / 12);
        attackPoints.setWidth((int) screenHeight / 6);
        attackPoints.setHeight((int) screenWidth / 12);
        movePoints.setWidth((int) screenHeight / 6);
        movePoints.setHeight((int) screenWidth / 12);

        nameStr = null;
        healthStr = null;
        defenseStr = null;
        attackStr = null;
        moveStr = null;

        playerName.setText(nameStr);
        playerName.setTextSize(16);
        playerName.setGravity(CENTER | CENTER_HORIZONTAL);
        healthPoints.setText(healthStr);
        healthPoints.setTextSize(12);
        healthPoints.setGravity(CENTER | CENTER_HORIZONTAL);
        defensePoints.setText(defenseStr);
        defensePoints.setTextSize(12);
        defensePoints.setGravity(CENTER | CENTER_HORIZONTAL);
        attackPoints.setText(attackStr);
        attackPoints.setTextSize(12);
        attackPoints.setGravity(CENTER | CENTER_HORIZONTAL);
        movePoints.setText(moveStr);
        movePoints.setTextSize(12);
        movePoints.setGravity(CENTER | CENTER_HORIZONTAL);

        LinearLayout.LayoutParams pnLoparams = new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 0.2f);
        LinearLayout.LayoutParams hpLoparams = new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 0.2f);
        LinearLayout.LayoutParams dpLoparams = new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 0.2f);
        LinearLayout.LayoutParams apLoparams = new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 0.2f);
        LinearLayout.LayoutParams mpLoparams = new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 0.2f);

        this.setWeightSum(1.0f);
        playerName.setLayoutParams(pnLoparams);
        healthPoints.setLayoutParams(hpLoparams);
        defensePoints.setLayoutParams(dpLoparams);
        attackPoints.setLayoutParams(apLoparams);
        movePoints.setLayoutParams(mpLoparams);

        this.addView(playerName);
        this.addView(healthPoints);
        this.addView(defensePoints);
        this.addView(attackPoints);
        this.addView(movePoints);
    }

    public boolean getDrawValue()  { return drawValue; }

    public void setDrawValue(boolean value)  { drawValue = value; }

    public void updateDisplay(Unit unit) {
        if (unit != null) {
            nameStr = unit.getName();
            healthStr = "Health: " + Integer.toString(unit.getHp()) + " / " + Integer.toString(unit.getHpMax());
            defenseStr = "Defense: " + Integer.toString(unit.getDefense());
            attackStr = "Attack: " + Integer.toString(unit.getAttack());
            moveStr = "Move: " + Integer.toString(unit.getMvmt());

            playerName.setText(nameStr);
            healthPoints.setText(healthStr);
            defensePoints.setText(defenseStr);
            attackPoints.setText(attackStr);
            movePoints.setText(moveStr);
        } else {
            nameStr = null;
            healthStr = null;
            defenseStr = null;
            attackStr = null;
            moveStr = null;

            playerName.setText(nameStr);
            healthPoints.setText(healthStr);
            defensePoints.setText(defenseStr);
            attackPoints.setText(attackStr);
            movePoints.setText(moveStr);
        }
    }
}
