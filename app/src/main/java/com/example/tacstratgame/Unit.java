package com.example.tacstratgame;

public interface Unit {
    int getAttack();
    int getDefense();
    int getHp();
    int getMvmt();
    int getRange();
    int getX();
    int getY();
    int getImage();

    void setAttack(int attack);
    void setDefense(int defense);
    void setHp(int hp);
    void setMvmt(int mvmt);
    void setRange(int range);
    void setX(int x);
    void setY(int y);
}
