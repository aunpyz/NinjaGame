package com.ninja.game.State;

/**
 * Created by ather on 14/12/2559.
 */
public enum EState {
        IDLE(0), WALK(1), ATTACK(3), FALLING(4), JUMMPING(5), DEAD(6);
        private int val;

        private EState(int val){
                this.val = val;
        }
}
