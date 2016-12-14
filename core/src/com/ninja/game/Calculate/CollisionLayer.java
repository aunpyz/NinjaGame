package com.ninja.game.Calculate;

import com.badlogic.gdx.math.Vector2;
import com.ninja.game.Sprite.Character;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ather on 15/12/2559.
 * ช้ในการตรวจจับวัตถุในรหัสมีการตรวจสอบ
 */
public class CollisionLayer {
    Character player;
    Character other;
    List<Character> characterList;
    public CollisionLayer(){
        player = new Character();
        other = new Character();
        characterList = new ArrayList<Character>();
    }

    public CollisionLayer(Character player, Character other){
        this.player = player;
        this.other = other;
    }

    public CollisionLayer(Character player, List<Character> others){
        this.player = player;
        this.characterList = others;
    }

    public boolean findNearest(double nearest){
        Vector2 v1, v2;
        Distance distance;
        v1 = new Vector2(BigDecimal.valueOf(player.getX()).floatValue(), BigDecimal.valueOf(player.getY()).floatValue());
        v2 = new Vector2(BigDecimal.valueOf(other.getX()).floatValue(), BigDecimal.valueOf(other.getY()).floatValue());
        distance = new Distance(v1, v2);
        double xs = distance.distanct();
        return (xs < nearest);
    }
}
