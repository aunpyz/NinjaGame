package com.ninja.game.Sprite;

import com.ninja.game.Item.Wearable;
import com.ninja.game.State.EElements;
import com.ninja.game.State.EState;
import com.ninja.game.State.EType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ather on 19/11/2559.
 */
public class Character implements ICharater {

    //interface prop
    String name;

    // Class Prop
    protected EType type = EType.HERO;
    protected EElements element = EElements.NORMAL;
    protected boolean enermy = false;
    protected int health = 1;
    protected int mana = 1;
    protected int maxStack = 4;
    protected int currentStack = 0;
    protected EState state = EState.IDLE;

    //Item Status
    List<Wearable> wearableList = new ArrayList<Wearable>();
    protected double sumItemAtk;
    protected double sumItemDef=0;

    //Status
    protected int atk = 0;
    protected int def = 0;
    protected int intel = 0;


    /*------------- Coder ----------------*/

    public Character() {
        create_character(10, 10, 1);
        create_status(1, 0, 0);
    }

    public void create_character(int hp, int mp, int maxStack) {
        setHealth(hp);
        setMana(mp);

    }
    public void create_character(int hp, int mp, int maxStack, EType type) {
        create_character(hp, mp, maxStack);
        setType(type);
    }

    public void create_status(int atk, int def, int intel){
        setAtk(atk);
        setIntel(intel);
        setDef(def);
    }

    public void addItem(Wearable item){
        wearableList.add(item);
    }

    public void itemCalculateDef(){
        for (Wearable itemDef : wearableList){
            sumItemDef += itemDef.getDefCal();
        }
    }



    @Override
    public void attack(Character character, int dmg) {
        character.setHealth((character.getHealth()+def));
    }

    @Override
    public void attacked(int dmg) {

    }

    @Override
    public void heal(int hpStack) {

    }

    @Override
    public int getHealth() {
        return health;
    }


    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public int getStack() {
        return currentStack;
    }

    @Override
    public double getDamage() {
        return 0;
    }

    // Geter Setter

    public boolean isDead() {
        return this.health <= 0;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public void setHealth(int hp) {
        this.health = (hp > 0) ? hp : 0;
    }

    public void setType(EType type) {
        this.type = type;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setMaxStack(){
        this.maxStack = maxStack;
    }

    public int getDefValue(){
        return this.getDef();
    }
}
