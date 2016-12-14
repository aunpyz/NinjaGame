package com.ninja.game.Calculate;

import com.badlogic.gdx.math.Vector2;
import com.ninja.game.Sprite.Character;

import java.math.BigDecimal;

/**
 * Created by ather on 15/12/2559.
 */
public class AiBot extends Character{
    Character me;
    Character target;

    Vector2 vMe;
    Vector2 vTarget;

    EAiBehavior behavior = EAiBehavior.NORMAL;

    public AiBot(Character me){
        this.me = me;
    }

    public void setTarget(Character target){
        this.target = target;
        vMe = new Vector2(BigDecimal.valueOf(me.getX()).floatValue(), BigDecimal.valueOf(me.getY()).floatValue());
        vTarget = new Vector2(BigDecimal.valueOf(target.getX()).floatValue(), BigDecimal.valueOf(target.getY()).floatValue());
    }

    public double chk_distant(){
        return vMe.dst2(vTarget);
    }

    public double chk_angle(){
        double x = vTarget.y - vMe.y;
        double y = vTarget.x - vMe.x;
        System.out.println(x +" : "+y);
        return Math.toDegrees(Math.atan2(x, y));
    }

    public void emotion(){
       if (chk_angle() > 70 && chk_angle() < 120){
           behavior = EAiBehavior.SCARE;
       }else if (chk_distant() < 40){
           behavior = EAiBehavior.ANGRY;
       }else {
           behavior = EAiBehavior.STUPID;
       }

    }

    public void runBehavior(){
        switch (behavior){
            case NORMAL:{

            }
        }
    }

    public void walk(float dt){

    }


    public void update(Character target){
        setTarget(target);
        emotion();
    }
}
