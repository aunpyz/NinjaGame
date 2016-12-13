package com.ninja.game.State;

/**
 * Created by ather on 14/12/2559.
 */
public enum EType {
    MONSTER(0), HERO(1), NPC(2);
    private int val;

    private EType(int val){
        this.val = val;
    }
}
