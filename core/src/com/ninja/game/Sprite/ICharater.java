package com.ninja.game.Sprite;

/**
 * Created by ather on 19/11/2559.
 */
public interface ICharater {
    public double getHealth();
    public double getMana();
    public double getStack();
    public double getDamage();

    //Action
    void attack(Character character, double dmg);
    //void attacked(double dmg);
    void heal(double hpStack);
}
