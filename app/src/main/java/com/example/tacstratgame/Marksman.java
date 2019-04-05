package com.example.tacstratgame;

public class Marksman implements Unit {

    private int attack = 75;
    private int defense = 25;
    private int hp = 200;
    private int hpMax = 200;
    private int mvmt = 1;
    private int range = 3;
    private int x;
    private int y;
    private int image = R.drawable.lightning_circle;

    public Marksman(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getAttack() {
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    public int getHp() {
        return hp;
    }
    public int getHpMax() { return hpMax; }
    public int getMvmt(){
        return mvmt;
    }
    public int getRange(){
        return range;
    }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getImage(){ return image; }

    public void setAttack(int attack){
        this.attack = attack;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public void setHpMax(int hpMax) { this.hpMax = hpMax; }
    public void setMvmt(int mvmt){
        this.mvmt = mvmt;
    }
    public void setRange(int range){
        this.range = range;
    }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public void printStats( ) {
        System.out.printf( "Marksman Stats:\n Attack: %d\n Defense: %d\n Health Points: %d\n Movement: %d\n Attack Range: %d\n", attack, defense, hp, mvmt, range );

    }

    public static void main( String []args ) {
        Marksman mark = new Marksman(0,0);
        mark.printStats();
    }
}
