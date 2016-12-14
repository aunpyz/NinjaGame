package com.ninja.game.Item;

/**
 * Created by ather on 14/12/2559.
 */
public class Item implements IItem {
    String name;
    String imgUrl;
    EItem prop;
    static int count=0;

    public Item(){
        //Empty Construct
    }

    public Item(String name, EItem prop, String url){
        count++;
        this.name = name;
        this.prop = prop;
        this.imgUrl = url;
    }

    public int count(){
        return count;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public EItem getProp() {
        return prop;
    }

}
