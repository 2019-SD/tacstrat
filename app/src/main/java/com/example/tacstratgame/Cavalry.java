package com.example.tacstratgame;

public class Cavalry implements Unit {

    private int attack = 120;
    private int defense = 60;
    private int hp = 400;
    private int mvmt = 4;
    private int range = 1;

    public int getAttack() {
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    public int getHp() {
        return hp;
    }
    public int getMvmt(){
        return mvmt;
    }
    public int getRange(){
        return range;
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
    public void setMvmt(int mvmt){
        this.mvmt = mvmt;
    }
    public void setRange(int range){
        this.range = range;
    }

    public void printStats( ) {
        System.out.printf( "Cavalry Stats:\n Attack: %d\n Defense: %d\n Health Points: %d\n Movement: %d\n Attack Range: %d\n", attack, defense, hp, mvmt, range );

    }

    public static void main( String []args ) {
        Cavalry cal = new Cavalry();
        cal.printStats();
    }
}
