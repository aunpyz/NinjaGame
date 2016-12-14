package com.ninja.game.Sprite;

import com.ninja.game.State.EType;

/**
 * Created by ather on 15/12/2559.
 */
public class Enemy extends Character {
    static int count=0;

    public Enemy(){
        super();
        super.create_character(10,100,4, 5, EType.MONSTER);
        super.setEnermy(true);
        count++;
        super.setName("Enemy"+count);
    }

    public Enemy(double hp, double maxHP, double mana, double maxStrack){
        super();
        super.create_character(hp, maxHP, mana, maxStrack, EType.MONSTER );
        super.setEnermy(true);
        count++;
        super.setName("Enemy"+count);

    }
}
