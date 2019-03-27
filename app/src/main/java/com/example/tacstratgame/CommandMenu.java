package com.example.tacstratgame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.DKGRAY;
import static android.graphics.Color.GRAY;
import static android.graphics.Color.LTGRAY;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

public class CommandMenu {

    private float menuX0;
    private float menuY0;
    private float menuX1;
    private float menuY1;
    private float dX;
    private float dY;
    float intervalY;
    float intervalX;
    private boolean drawValue;
    private Paint menuPaint;

    public CommandMenu(float menuX0, float menuY0, float menuX1, float menuY1) {
        this.menuX0 = menuX0;
        this.menuY0 = menuY0;
        this.menuX1 = menuX1;
        this.menuY1 = menuY1;
        dX = menuX0 - menuX1;
        dY = menuY1 - menuY0;
        intervalY = dY / 4;
        intervalX = dX / 3;
        drawValue = false;
        menuPaint = new Paint();
        menuPaint.setColor(DKGRAY);
        menuPaint.setStrokeWidth(10);
        menuPaint.setAntiAlias(true);
    }

    public float getMenuX0() { return menuX0; }
    public float getMenuY0() { return menuY0; }
    public float getMenuX1() { return menuX1; }
    public float getMenuY1() { return menuY1; }
    public boolean getDrawValue()  { return drawValue; }

    public void setMenuX0(float x) { menuX0 = x; }
    public void setMenuY0(float y) { menuY0 = y;}
    public void setMenuX1(float x) { menuX1 = x; }
    public void setMenuY1(float y) { menuY1 = y;}
    public void setDrawValue(boolean value)  { drawValue = value; }
    public void toggleDraw() {
        if (drawValue) {
            drawValue = false;
        } else {
            drawValue = true;
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(menuX0, menuY0, menuX1, menuY1, menuPaint);
        menuPaint.setStrokeWidth(0);
        menuPaint.setColor(LTGRAY);
        canvas.drawRect(menuX0 - 10, menuY0 + 10, menuX1 + 10, menuY1 - 10, menuPaint);
        menuPaint.setStrokeWidth(5);
        menuPaint.setColor(DKGRAY);
        canvas.drawLine(menuX0 - intervalX, menuY0, menuX1 + (2 * intervalX), menuY1, menuPaint);
        canvas.drawLine(menuX0 - (2 * intervalX), menuY0, menuX1 + intervalX, menuY1, menuPaint);
        menuPaint.setStrokeWidth(4);
        menuPaint.setStyle(Paint.Style.FILL);
        menuPaint.setColor(BLACK);
        menuPaint.setTextSize(34);
        intervalY = intervalY / 2;
        intervalX = intervalX / 2;
        canvas.save();
        canvas.rotate(90f, menuX0 - intervalX, menuY0 + intervalY);
        canvas.drawText("Attack", menuX0 - intervalX, menuY0 + intervalY, menuPaint);
        canvas.restore();
        canvas.save();
        canvas.rotate(90f, menuX0 - (5 * intervalX), menuY0 + intervalY);
        canvas.drawText("Defend", menuX0 - (5 * intervalX), menuY0 + intervalY, menuPaint);
        canvas.restore();
        canvas.save();
        canvas.rotate(90f, menuX0 - (9 * intervalX), menuY0 + intervalY);
        canvas.drawText("Move", menuX0 - (9 * intervalX), menuY0 + intervalY, menuPaint);
        canvas.restore();
    }
}
