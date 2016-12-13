package com.ninja.game.Item;

/**
 * Created by Aunpyz on 12/8/2016.
 */
public interface IItem {
    String getName();
    //weapon
    double getAttack();
    //for potion
    double getHP();
    boolean isHealable();
}