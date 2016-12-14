package com.ninja.game.State;

/**
 * Created by ather on 14/12/2559.
 */
public enum EElements {
    NORMAL(0), FIRE(1), GROUND(2), WOOD(3), WATER(4), MATAL(5);
    private int val;
    private  EElements(int val){
        this.val = val;
    }
}
