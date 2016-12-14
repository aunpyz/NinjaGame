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

    //Life of charector
    protected double health = 1;
    protected double percenHP = 100;
    protected double maxHealth = 1;
    protected double mana = 1;
    protected double maxStack = 4;
    protected double currentStack = 0;
    protected EState state = EState.IDLE;

    //Item Status
    List<Wearable> wearableList = new ArrayList<Wearable>();
    protected double sumItemAtk;
    protected double sumItemDef=0;

    //Status
    protected double atk = 0;
    protected double def = 0;
    protected double intel = 0;

    //Position
    protected double x;
    protected double y;


    /*------------- Coder ----------------*/

    public Character() {
        create_character(10, 10, 10, 1);
        create_status(1, 0, 0);
    }

    public void create_character(double hp, double maxHp,  double mp, double maxStack) {
        setHealth(hp);
        setMaxHealth(maxHp);
        setMana(mp);
        Health2Percent();

    }
    public void create_character(double hp, double maxHp, double mp, double maxStack, EType type) {
        create_character(hp, maxHp, mp, maxStack);
        setType(type);
    }

    public void create_status(double atk, double def, double intel){
        setAtk(atk);
        setIntel(intel);
        setDef(def);
    }

    public void addItem(Wearable item){
        wearableList.add(item);
    }

    private void itemCalculateDef(){
        sumItemDef = 0;
        for (Wearable itemDef : wearableList){
            sumItemDef += itemDef.getDefCal();
        }
    }

    public double getResultDef(){
        // Calculate Every Called
        this.itemCalculateDef();
        System.out.println("Item.Def: "+this.sumItemDef+ " +Char.Def "+this.def+ " = "+(double)(this.sumItemDef+this.def));
        return this.sumItemDef+this.def;
    }

    private void Health2Percent(){
        this.maxHealth = (this.maxHealth > 0) ? this.maxHealth:1;
        this.percenHP = (this.health / this.maxHealth) *100;
        if(this.percenHP < 0){
            this.percenHP = 0;
        }
    }

    public void percenHP2RawHP(){
        this.health = (percenHP/100)*maxHealth;
        if(this.health < 0){
            this.health = 0;
        }
    }

    public double def2PercentDamage(double dmg){
        double defChk = this.getResultDef();
        if(defChk <= 0 )defChk = 1;
        return ((this.atk+dmg)/defChk)*Math.abs(Math.random())*10;
    }

    private void healthUpdate(){
        this.percenHP2RawHP();
        this.Health2Percent();

    }


    @Override
    public void attack(Character character, double dmg) {
        healthUpdate();
        System.out.println(character.getPercenHP() + " perc2dmg: "+def2PercentDamage(dmg));
        character.attacked(dmg);
//        character.setPercenHP((character.getPercenHP() - def2PercentDamage(dmg)));
//        character.healthUpdate();
    }

    @Override
    public void attacked(double dmg) {
        healthUpdate();
        System.out.println(getPercenHP() + " perc2dmg: "+def2PercentDamage(dmg));
        setPercenHP((getPercenHP() - def2PercentDamage(dmg)));
        healthUpdate();
    }

    @Override
    public void heal(double hpStack) {

    }

    @Override
    public double getHealth() {
        return health;
    }


    @Override
    public double getMana() {
        return mana;
    }

    @Override
    public double getStack() {
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

    public double getAtk() {
        return atk;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    private double getDef() {
        return def;
    }

    private void setDef(double def) {
        this.def = def;
    }

    public double getIntel() {
        return intel;
    }

    public void setIntel(double intel) {
        this.intel = intel;
    }

    public void setHealth(double hp) {
        this.health = (hp > 0) ? hp : 0;
    }

    public void setType(EType type) {
        this.type = type;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public void setMaxStack(){
        this.maxStack = maxStack;
    }

    public double getDefValue(){
        return this.getDef();
    }

    public void setMaxHealth(double maxHp){
        this.maxHealth = maxHp;
    }

    public double getPercenHP() {
        return percenHP;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setPercenHP(double percenHP) {
        this.percenHP = percenHP;
    }
}
