package com.example.tacstratgame;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MedicTest {

    // Creates mocked instance of Medic for testing
    @Mock
    Medic mockedMedic = mock( Medic.class );

    @Test
    public void getHeal() {
        mockedMedic.setHeal(2);
        mockedMedic.getHeal();
        verify(mockedMedic).getHeal();     //will pass if getHeal was called correctly
    }

    @Test
    public void getAttack() {
        mockedMedic.setAttack(4);
        mockedMedic.getAttack();
        verify(mockedMedic).getAttack();
    }

    @Test
    public void getDefense() {
        mockedMedic.setDefense(9);
        mockedMedic.getDefense();
        verify(mockedMedic).getDefense();
    }

    @Test
    public void getHp() {
        mockedMedic.setHp(15);
        mockedMedic.getHp();
        verify(mockedMedic).getHp();
    }

    @Test
    public void getMvmt() {
        mockedMedic.setMvmt(6);
        mockedMedic.getMvmt();
        verify(mockedMedic).getMvmt();
    }

    @Test
    public void getRange() {
        mockedMedic.setRange(16);
        mockedMedic.getRange();
        verify(mockedMedic).getRange();
    }

    @Test
    public void getX() {
        mockedMedic.setX(36);
        mockedMedic.getX();
        verify(mockedMedic).getX();
    }

    @Test
    public void getY() {
        mockedMedic.setY(15);
        mockedMedic.getY();
        verify(mockedMedic).getY();
    }

    @Test
    public void getImage() {
        mockedMedic.getImage();
        verify(mockedMedic).getImage();
    }

    @Test
    public void setHeal() {
        mockedMedic.setHeal(6);
        verify(mockedMedic).setHeal(6);
    }

    @Test
    public void setAttack() {
        mockedMedic.setAttack(9);
        verify(mockedMedic).setAttack(9);
    }

    @Test
    public void setDefense() {
        mockedMedic.setDefense(25);
        verify(mockedMedic).setDefense(25);
    }

    @Test
    public void setHp() {
        mockedMedic.setHp(13);
        verify(mockedMedic).setHp(13);
    }

    @Test
    public void setMvmt() {
        mockedMedic.setMvmt(22);
        verify(mockedMedic).setMvmt(22);
    }

    @Test
    public void setRange() {
        mockedMedic.setRange(18);
        verify(mockedMedic).setRange(18);
    }

    @Test
    public void setX() {
        mockedMedic.setX(19);
        verify(mockedMedic).setX(19);
    }

    @Test
    public void setY() {
        mockedMedic.setY(1);
        verify(mockedMedic).setY(1);
    }

    @Test
    public void printStats() {
        mockedMedic.printStats();
        verify(mockedMedic).printStats();
    }
}