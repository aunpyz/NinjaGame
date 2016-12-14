package com.ninja.game;

import com.ninja.game.Item.ItemList.Arm_blackshild;
import com.ninja.game.Item.Wearable;
import com.ninja.game.Sprite.Character;
import com.ninja.game.State.EElements;

/**
 * Created by ather on 14/12/2559.
 */
public class testMain_unittest {
    public static void main(String[] args) {
        Wearable armer = new Arm_blackshild();
        System.out.println("armer getDefCal "+armer.getDefCal());

        Character jini = new Character();
        jini.create_status(10,0,10);
        jini.create_character(100,100, 5 ,4);
        jini.setElement(EElements.FIRE);
        System.out.println("jini "+jini.getResultDef());

        Character bobo = new Character();
        bobo.create_status(10,10,10);
        bobo.create_character(100,100, 5 ,4);
        bobo.setElement(EElements.WOOD);

        System.out.println("bobo.getHealth "+bobo.getHealth());
        jini.addItem(armer);

        System.out.println();
        jini.attack(bobo, 10);
        System.out.println("bobo.getHealth "+bobo.getHealth());
        System.out.println("jini getResultDef "+jini.getResultDef());

        System.out.println("");
        jini.attack(bobo, 2);
        System.out.println("bobo.getHealth "+bobo.getHealth());
        System.out.println("jini getResultDef "+jini.getResultDef());

        System.out.println("");
        jini.attack(bobo, 10);
        System.out.println("bobo.getHealth "+bobo.getHealth());
        System.out.println("jini getResultDef "+jini.getResultDef());




    }
}
