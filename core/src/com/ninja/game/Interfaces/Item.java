package com.ninja.game.Interfaces;

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