package com.example.tacstratgame;

public interface Unit {
    int getAttack();
    int getDefense();
    int getHp();
    int getMvmt();
    int getRange();

    void setAttack(int attack);
    void setDefense(int defense);
    void setHp(int hp);
    void setMvmt(int mvmt);
    void setRange(int range);
}
