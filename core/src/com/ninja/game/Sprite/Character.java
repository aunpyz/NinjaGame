package com.ninja.game.Sprite;

/**
 * Created by ather on 19/11/2559.
 */
public class Character implements ICharater {
    protected nType type = nType.NORMAL;
    protected int element=0;
    protected boolean enermy=false;
    protected int health=1;
    protected int mana=1;
    protected int nstack=0;

    protected nState state = nState.STANDING;

    public Character(){

    }

    public void create_charater(int hp, int mp, int nst){
        setHealth(hp);
        hp = nType.DARK.val;
    }

    public void setHealth(int hp){
        this.health = (hp > 0)?hp: 0;
    }

    public void setType(nType nt){
        this.type = nt;
    }

    public enum nType{
        NORMAL(0), FIRE(1), GROUND(2), WIND(3), WATER(4), DARK(5), LIGHT(6);
        private int val;

        private  nType(int val){
            this.val = val;
        }

    }

    public enum nState{
        STANDING(0), FALLING(1), JUMMPING(2);
        private int val;

        private nState(int val){
            this.val = val;
        }
    }

    public boolean isDead(){
        return this.health <= 0;
    }

    public int getHealth(){
        return health;
    }

}
