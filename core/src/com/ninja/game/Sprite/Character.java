package com.ninja.game.Sprite;

import com.ninja.game.State.EElements;
import com.ninja.game.State.EState;
import com.ninja.game.State.EType;

/**
 * Created by ather on 19/11/2559.
 */
public class Character implements ICharater {
    protected EType type = EType.HERO;
    protected EElements element = EElements.NORMAL;
    protected boolean enermy = false;
    protected int health = 1;
    protected int mana = 1;
    protected int maxStack = 4;
    protected int currentStack = 0;
    protected EState state = EState.IDLE;



    /*------------- Coder ----------------*/

    public Character() {
        create_character(10, 10, 1);
    }

    public void create_character(int hp, int mp, int maxStack) {
        setHealth(hp);
    }

    public void setHealth(int hp) {
        this.health = (hp > 0) ? hp : 0;
    }

    public void setType(EType nt) {
        this.type = nt;
    }


    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public int getMana() {
        return 0;
    }

    @Override
    public int getStack() {
        return 0;
    }

    @Override
    public double getDamage() {
        return 0;
    }

    public boolean isDead() {
        return this.health <= 0;
    }
}
