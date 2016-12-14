package com.ninja.game.Item;

/**
 * Created by ather on 14/12/2559.
 */
public class Wearable extends Item implements IWearable{
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
    @Override
    public double getAtk() {
        return atk;
    }

    @Override
    public double getDef() {
        return def;
    }

    @Override
    public double getIntel() {
        return intel;
    }

    @Override
    public double getDefCal() {
        return 0.3*def+1;
    }
}
