package com.ninja.game;

import com.ninja.game.Item.EItem;
import com.ninja.game.Item.Item;
import com.ninja.game.Item.ItemList.Arm_blackshild;
import com.ninja.game.Item.Wearable;

/**
 * Created by ather on 14/12/2559.
 */
public class testMain_unittest {
    public static void main(String[] args) {
        Item item;
        item = new Item("RRR", EItem.DAMAGE);
        Item item2 = new Item("ddd", EItem.HEAL);

        Wearable armer = new Arm_blackshild();
        System.out.println(armer.getDefCal());
    }
}
