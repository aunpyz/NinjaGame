package com.ninja.game;

/**
 * Created by Aunpyz on 12/8/2016.
 */
public interface Item{
    String getName();
    //weapon
    double getAttack();
    //for potion
    double getHP();
    boolean isHealable();
}