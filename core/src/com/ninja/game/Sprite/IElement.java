package com.ninja.game.Sprite;

/**
 * Created by Aunpyz on 11/22/2016.
 */
public interface IElement {
    enum ELEMENT{
        NORMAL,
        WATER,
        WOOD,
        GROUND,
        FIRE,
        METAL
    }
    ELEMENT getElement();
}
