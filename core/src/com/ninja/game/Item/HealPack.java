package com.ninja.game.Item;

import com.ninja.game.Sprite.Character;

/**
 * Created by ather on 14/12/2559.
 * Create Object and set active went use
 */
public class HealPack extends Item {
    Item item;
    Character player;

    private int healStack = 30;

    public HealPack(){
        super("HealPack", EItem.HEAL, "item/healthPack.png");
    }

    public HealPack(Character player){
        super("HealPack", EItem.HEAL, "item/healthPack.png");
        this.player = player;
    }

    public void set_player(Character player){
        this.player = player;
    }

    public void active(){
        player.setHealth(player.getHealth()+healStack);
    }
}
