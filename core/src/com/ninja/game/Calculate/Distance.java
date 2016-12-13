package com.ninja.game.Calculate;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by ather on 9/12/2559.
 * this function for calculate distance of position of 2 objects
 */
public class Distance {
    Vector2 va;
    Vector2 vb;
    Distance(Vector2 va, Vector2 vb){
        this.va = va;
        this.vb = vb;
    }

    Distance(float vax, float vay, float vbx, float vby){
        this.va = new Vector2(vax, vay);
        this.vb = new Vector2(vbx, vby);
    }


}

