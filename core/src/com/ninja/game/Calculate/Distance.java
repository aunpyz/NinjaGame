package com.ninja.game.Calculate;

import com.badlogic.gdx.math.Vector2;

import java.math.BigDecimal;

/**
 * Created by ather on 9/12/2559.
 * this function for calculate distance of position of 2 objects
 */
public class Distance {
    Vector2 va;
    Vector2 vb;
    public Distance(Vector2 va, Vector2 vb){
        this.va = va;
        this.vb = vb;
    }

    Distance(float vax, float vay, float vbx, float vby){
        this.va = new Vector2(vax, vay);
        this.vb = new Vector2(vbx, vby);
    }

    public Vector2 delta(){
        return va.sub(vb);
    }

    public Double distanct(){
        return (double) va.dst2(vb);
    }

    public Vector2 findCenterOfRect(double xa, double ya, double width, double height){
        double x, y;
        x = xa + (width/2);
        y = ya + (height/2);
        float d = BigDecimal.valueOf(x).floatValue();
        float f = BigDecimal.valueOf(y).floatValue();
        return new Vector2(d,f);
    }


}

