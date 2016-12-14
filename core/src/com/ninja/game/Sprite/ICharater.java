package com.ninja.game.Sprite;

import com.ninja.game.Item.Wearable;
import com.ninja.game.State.EType;

/**
 * Created by ather on 19/11/2559.
 */
public interface ICharater {
    public double getHealth();
    public double getMana();
    public double getStack();
    public double getDamage();

    double def2PercentDamage(double dmg, double multi);
    void percenHP2RawHP();
    double getResultDef();
    void addItem(Wearable item);
    void create_status(double atk, double def, double intel);
    void create_character(double hp, double maxHp, double mp, double maxStack, EType type);
    void create_character(double hp, double maxHp,  double mp, double maxStack);

    //Action
    void attack(Character character, double dmg);
    //void attacked(double dmg);
    void heal(double hpStack);
}
