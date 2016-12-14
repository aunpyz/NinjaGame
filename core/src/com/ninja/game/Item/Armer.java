package com.ninja.game.Item;

/**
 * Created by ather on 14/12/2559.
 */
public class Armer extends Wearable {
    public Armer() {
    }

    public Armer(int atk, int def, int intel) {
        super(atk, def, intel);
    }

    public Armer(String name, EItem prop, int atk, int def, int intel) {
        super(name, prop, atk, def, intel);
    }
}
