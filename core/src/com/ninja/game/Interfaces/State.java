package com.ninja.game.Interfaces;

/**
 * Created by Aunpyz on 12/13/2016.
 */
public interface State {
    enum STATE{
        IDLE,
        DIE,
        ATTACK,
        ATTACKLOOP,
        ATTACKHOLDBACK,
        JUMP,
        FALLAIR,
        FALLGROUND,
        WALK,
        WALKCYA,
        WALKCYB,
        WALKSTA,
        WALKSTB
    }
    enum DIR{
        L,
        R
    }

    STATE getState();
    void setState(STATE state);
    void setDir(DIR dir);
    DIR getDir();
}
