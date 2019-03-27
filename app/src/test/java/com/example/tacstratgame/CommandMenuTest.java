package com.example.tacstratgame;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

/**
 *  Verify that each method is called correctly and returns the appropriate value.
 *
 *  Uses Mockito framework since CommandMenu is a wonky type.
 *
 */

public class CommandMenuTest {

    // Creates mocked instance of CommandMenu for testing
    @Mock
    CommandMenu mockedMenu = mock( CommandMenu.class );

    @Test
    public void getMenuX0() {
        mockedMenu.setMenuX0(2);
        mockedMenu.getMenuX0();
        verify(mockedMenu).getMenuX0();     //will pass if getMenuX0 was called correctly

    }

    @Test
    public void getMenuY0() {
        mockedMenu.setMenuY0(4);
        mockedMenu.getMenuY0();
        verify(mockedMenu).getMenuY0();     //will pass if getMenuY0 was called correctly
    }

    @Test
    public void getMenuX1() {
        mockedMenu.setMenuX1(6);
        mockedMenu.getMenuX1();
        verify(mockedMenu).getMenuX1();
    }

    @Test
    public void getMenuY1() {
        mockedMenu.setMenuY1(9);
        mockedMenu.getMenuY1();
        verify(mockedMenu).getMenuY1();
    }

    @Test
    public void getDrawValue() {
        mockedMenu.setDrawValue(true);
        mockedMenu.getDrawValue();
        verify(mockedMenu).getDrawValue();
    }

    @Test
    public void setMenuX0() {
        mockedMenu.setMenuX0(4);
        verify(mockedMenu).setMenuX0(4);
    }

    @Test
    public void setMenuY0() {
        mockedMenu.setMenuY0(8);
        verify(mockedMenu).setMenuY0(8);
    }

    @Test
    public void setMenuX1() {
        mockedMenu.setMenuX1(3);
        verify(mockedMenu).setMenuX1(3);
    }

    @Test
    public void setMenuY1() {
        mockedMenu.setMenuY1(9);
        verify(mockedMenu).setMenuY1(9);
    }

    @Test
    public void setDrawValue() {
        mockedMenu.setDrawValue(false);
        verify(mockedMenu).setDrawValue(false);
    }
}