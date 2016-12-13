package com.ninja.game.State;

/**
 * Created by Aunpyz on 12/13/2016.
 */
public interface IState {
    enum STATE{
        IDLE,
        WALK,
        ATTCK,
        JUNP,
        DIE
    }

    STATE getState();
}
