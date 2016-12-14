package com.ninja.game;

import com.ninja.game.Item.EItem;
import com.ninja.game.Item.Item;
import com.ninja.game.Item.ItemList.Arm_blackshild;
import com.ninja.game.Item.Wearable;
import com.ninja.game.Sprite.Character;

/**
 * Created by ather on 14/12/2559.
 */
public class testMain_unittest {
    public static void main(String[] args) {
        Item item;
        item = new Item("RRR", EItem.DAMAGE);
        Item item2 = new Item("ddd", EItem.HEAL);

        Wearable armer = new Arm_blackshild();
        System.out.println("armer getDefCal "+armer.getDefCal());

        Character jini = new Character();
        jini.create_status(10,0,10);
        jini.create_character(100,100, 5 ,4);
        System.out.println("jini "+jini.getResultDef());

        Character bobo = new Character();
        bobo.create_status(10,0,10);
        bobo.create_character(100,100, 5 ,4);

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



    }
}
