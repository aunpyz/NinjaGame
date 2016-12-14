package com.ninja.game.Sprite;

/**
 * Created by ather on 19/11/2559.
 */
public interface ICharater {
    public int getHealth();
    public int getMana();
    public int getStack();
    public double getDamage();

    //Action
    void attack(Character character, int dmg);
    void attacked(int dmg);
    void heal(int hpStack);
}
