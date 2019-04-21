package com.example.tacstratgame;

public interface Unit {

    int getTeam();
    int getHasMoved();

    int getHasHealed();

    int getHasAttacked();
    int getHasDefended();
    int getAttack();
    int getDefense();
    int getHp();
    int getHpMax();
    int getMvmt();
    int getRange();
    int getX();
    int getY();
    int getImage();
    String getName();

    void setHasHealed( int hasHealed );
    void setHasAttacked(int hasAttacked);
    void setHasDefended(int hasDefended);
    void setHasMoved(int hasMoved);
    void setAttack(int attack);
    void setDefense(int defense);
    void setHp(int hp);
    void setHpMax(int hpMax);
    void setMvmt(int mvmt);
    void setRange(int range);
    void setX(int x);
    void setY(int y);
    void setName(String name);
}
