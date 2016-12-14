package com.ninja.game.Interfaces;

/**
 * Created by Aunpyz on 12/13/2016.
 */
public interface State {
    enum STATE{
        IDLE,
        DIE,
        ATTACK,
        JUMP,
        FALLAIR,
        FALLGROUND,
        WALK,
        CYCLE,
        STOP
    }
    enum DIR{
        L,
        R
    }

    STATE getState();
    void setState();
    void setDir(DIR dir);
    DIR getDir();
}
