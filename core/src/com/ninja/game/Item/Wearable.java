package com.ninja.game.Item;

/**
 * Created by ather on 14/12/2559.
 */
public class Wearable extends Item {
    protected int atk;
    protected int def;
    protected int intel;

    public Wearable(){
        this.atk = 0;
        this.def = 0;
        this.intel = 0;
    }

    public Wearable(int atk, int def, int intel) {
        this.atk = atk;
        this.def = def;
        this.intel = intel;
    }

    public Wearable(String name, EItem prop, int atk, int def, int intel) {
        super(name, prop);
        this.atk = atk;
        this.def = def;
        this.intel = intel;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getIntel() {
        return intel;
    }
}
