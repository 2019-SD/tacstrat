package com.example.tacstratgame;

public class Artillery implements Unit {

    private int attack = 150;
    private int defense = 70;
    private int hp = 300;
    private int mvmt = 0;
    private int range = 3;

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
        System.out.printf( "Artillery Stats:\n Attack: %d\n Defense: %d\n Health Points: %d\n Movement: %d\n Attack Range: %d\n", attack, defense, hp, mvmt, range );

    }

    public static void main( String []args ) {
        Artillery art = new Artillery();
        art.printStats();
    }
}
