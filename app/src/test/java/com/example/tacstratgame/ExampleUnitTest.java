package com.example.tacstratgame;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void infantryValues() {
        Infantry inf = new Infantry( 50,50 );
        assertEquals( inf.getAttack(), 100 );
        assertEquals( inf.getDefense(), 50 );
        assertEquals( inf.getHp(), 200 );
        assertEquals( inf.getMvmt(), 3 );
        assertEquals( inf.getRange(), 1 );
        assertEquals( inf.getX(), 50 );
        assertEquals( inf.getY(), 50 );

        inf.setAttack( 110 );
        assertEquals( inf.getAttack(), 110 );

        inf.setHp( 225 );
        assertEquals( inf.getHp(), 225);

        inf.setDefense( 60 );
        assertEquals( inf.getDefense(), 60 );

        inf.setMvmt( 4 );
        assertEquals( inf.getMvmt(), 4 );

        inf.setRange( 2 );
        assertEquals( inf.getRange(), 2 );

        inf.setX( 75 );
        assertEquals(inf.getX(), 75 );

        inf.setY( 75 );
        assertEquals( inf.getY(), 75 );
    }

    @Test
    public void marksmanValues() {
        Marksman mrk = new Marksman( 50,50 );
        assertEquals( mrk.getAttack(), 75 );
        assertEquals( mrk.getDefense(), 25 );
        assertEquals( mrk.getHp(), 200 );
        assertEquals( mrk.getMvmt(), 1 );
        assertEquals( mrk.getRange(), 3 );
        assertEquals( mrk.getX(), 50 );
        assertEquals( mrk.getY(), 50 );

        mrk.setAttack( 110 );
        assertEquals( mrk.getAttack(), 110 );

        mrk.setHp( 225 );
        assertEquals( mrk.getHp(), 225);

        mrk.setDefense( 60 );
        assertEquals( mrk.getDefense(), 60 );

        mrk.setMvmt( 2 );
        assertEquals( mrk.getMvmt(), 2 );

        mrk.setRange( 2 );
        assertEquals( mrk.getRange(), 2 );

        mrk.setX( 75 );
        assertEquals(mrk.getX(), 75 );

        mrk.setY( 75 );
        assertEquals( mrk.getY(), 75 );
    }

    @Test
    public void medicValues() {
        Medic med = new Medic( 50,50 );
        assertEquals( med.getHeal() , 50 );
        assertEquals( med.getAttack(), 10 );
        assertEquals( med.getDefense(), 20 );
        assertEquals( med.getHp(), 150 );
        assertEquals( med.getMvmt(), 2 );
        assertEquals( med.getRange(), 1 );
        assertEquals( med.getX(), 50 );
        assertEquals( med.getY(), 50 );

        med.setHeal( 60 );
        assertEquals( med.getHeal(), 60 );

        med.setAttack( 20 );
        assertEquals( med.getAttack(), 20 );

        med.setHp( 160 );
        assertEquals( med.getHp(), 160);

        med.setDefense( 30 );
        assertEquals( med.getDefense(), 30 );

        med.setMvmt( 2 );
        assertEquals( med.getMvmt(), 2 );

        med.setRange( 2 );
        assertEquals( med.getRange(), 2 );

        med.setX( 75 );
        assertEquals(med.getX(), 75 );

        med.setY( 75 );
        assertEquals( med.getY(), 75 );
    }

    @Test
    public void cavalryValues() {
        Cavalry inf = new Cavalry( 50,50 );
        assertEquals( inf.getAttack(), 120 );
        assertEquals( inf.getDefense(), 60 );
        assertEquals( inf.getHp(), 400 );
        assertEquals( inf.getMvmt(), 4 );
        assertEquals( inf.getRange(), 1 );
        assertEquals( inf.getX(), 50 );
        assertEquals( inf.getY(), 50 );

        inf.setAttack( 110 );
        assertEquals( inf.getAttack(), 110 );

        inf.setHp( 350 );
        assertEquals( inf.getHp(), 350);

        inf.setDefense( 75 );
        assertEquals( inf.getDefense(), 75 );

        inf.setMvmt( 3 );
        assertEquals( inf.getMvmt(), 3 );

        inf.setRange( 2 );
        assertEquals( inf.getRange(), 2 );

        inf.setX( 75 );
        assertEquals(inf.getX(), 75 );

        inf.setY( 75 );
        assertEquals( inf.getY(), 75 );
    }

    @Test
    public void artilleryValues() {
        Artillery inf = new Artillery( 50,50 );
        assertEquals( inf.getAttack(), 150 );
        assertEquals( inf.getDefense(), 70 );
        assertEquals( inf.getHp(), 400 );
        assertEquals( inf.getMvmt(), 0 );
        assertEquals( inf.getRange(), 3 );
        assertEquals( inf.getX(), 50 );
        assertEquals( inf.getY(), 50 );

        inf.setAttack( 140 );
        assertEquals( inf.getAttack(), 140 );

        inf.setHp( 300 );
        assertEquals( inf.getHp(), 300);

        inf.setDefense( 60 );
        assertEquals( inf.getDefense(), 60 );

        inf.setMvmt( 1 );
        assertEquals( inf.getMvmt(), 1 );

        inf.setRange( 2 );
        assertEquals( inf.getRange(), 2 );

        inf.setX( 75 );
        assertEquals(inf.getX(), 75 );

        inf.setY( 75 );
        assertEquals( inf.getY(), 75 );
    }
}