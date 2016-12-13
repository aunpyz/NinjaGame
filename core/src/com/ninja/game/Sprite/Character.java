package com.ninja.game.Sprite;

/**
 * Created by ather on 19/11/2559.
 */
public class Character implements ICharater{
    protected nType type = nType.HERO;
    protected nElement element = nElement.NORMAL;
    protected boolean enermy = false;
    protected int health = 1;
    protected int mana = 1;
    protected int maxStack = 4;
    protected int currentStack = 0;
    protected nCState state = nCState.STANDING;



    /*------------- Coder ----------------*/

    public Character(){
        create_character(10,10,1);
    }

    public void create_character(int hp, int mp, int maxStack){
        setHealth(hp);
    }

    public void setHealth(int hp){
        this.health = (hp > 0)?hp: 0;
    }

    public void setType(nType nt){
        this.type = nt;
    }

    public enum nElement{
        NORMAL(0), FIRE(1), GROUND(2), WIND(3), WATER(4), DARK(5), LIGHT(6);
        private int val;

        private  nElement(int val){
            this.val = val;
        }

    }

    public enum nType{
        MONSTER(0), HERO(1), NPC(2);
        private int val;

        private nType(int val){
            this.val = val;
        }
    }

    public enum nCState{
        STANDING(0), FALLING(1), JUMMPING(2), ATTACK(3), DEAD(4);
        private int val;

        private nCState(int val){
            this.val = val;
        }
    }

    public boolean isDead(){
        return this.health <= 0;
    }



    @Override
    public int getHealth(){
        return health;
    }

    public nType getType() {
        return type;
    }

    public nElement getElement() {
        return element;
    }

    public void setElement(nElement element) {
        this.element = element;
    }

    public boolean isEnermy() {
        return enermy;
    }

    public void setEnermy(boolean enermy) {
        this.enermy = enermy;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public int getStack() {
        return currentStack;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getNstack() {
        return currentStack;
    }

    public void setNstack(int nstack) {
        this.currentStack = nstack;
    }

    public nCState getState() {
        return state;
    }

    public void setState(nCState state) {
        this.state = state;
    }

    @Override
    public double getDamage() {
        return 0;
    }
}
