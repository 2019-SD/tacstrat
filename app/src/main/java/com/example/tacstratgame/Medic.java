package com.example.tacstratgame;

public class Medic implements Unit {

    // Set attributes
    private int attack = 0;
    private int heal = 50;
    private int defense = 20;
    private int hp = 150;
    private int hpMax = 150;
    private int mvmt = 2;
    private int range = 1;
    private int x;
    private int y;
    private int image = R.drawable.alien;

    public Medic(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Getters
    public int getHeal( ) {
        return heal;
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

    // Setters
    public void setHeal(int heal) {
        this.heal = heal;
    }

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
        System.out.printf( "Medic Stats:\n Heal: %d\n Attack: %d\n Defense: %d\n Health Points: %d\n Movement: %d\n Attack Range: %d\n", heal, attack, defense, hp, mvmt, range );

    }

    public static void main( String []args ) {
        Medic med = new Medic(0,0);
        med.printStats();
    }
}
