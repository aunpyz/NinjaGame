package com.ninja.game.Interfaces;

/**
 * Created by Aunpyz on 12/14/2016.
 */
public interface Element {
    enum ELEMENT{
        NORMAL,
        WATER,
        FIRE,
        WOOD
    }

    ELEMENT getElement();
    void setElement();
    String getStringElement();
}
