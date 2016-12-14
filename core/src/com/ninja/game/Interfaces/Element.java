package com.ninja.game.Interfaces;

/**
 * Created by Aunpyz on 11/22/2016.
 */
public interface Element {
    enum ELEMENT{
        NORMAL,
        WATER,
        WOOD,
        GROUND,
        FIRE,
        METAL
    }
    void setElement();
    ELEMENT getElement();
    String getStringElement();
}
