package com.ninja.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.math.Vector2;
import com.ninja.game.Calculate.CollisionLayer;
import com.ninja.game.Calculate.Distance;
import com.ninja.game.Sprite.Character;
import com.ninja.game.Sprite.Enemy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ather on 14/12/2559.
 */
public class testmain_testDistanct extends ApplicationAdapter {
    public static void main(String[] args) {
        Vector2 v1 = new Vector2(2.0f, 9.0f);
        Vector2 v2 = new Vector2(2.0f, 5.0f);

        Distance distance = new Distance(v1, v2);
        System.out.println(distance.distanct());

        // Test find Enemy

        Character enemy1 = new Enemy();
        enemy1.setPos(3, 4);
        Character enemy2 = new Enemy();
        enemy2.setPos(5, 6);
        Character enemy3 = new Enemy();
        enemy3.setPos(1, 3);

        Character player = new Enemy();
        player.setPos(1, 2);

        List<Character> enermyList = new ArrayList<Character>();
        enermyList.add(enemy1);
        enermyList.add(enemy2);
        enermyList.add(enemy3);

        CollisionLayer collisionLayer;

        for (Character el : enermyList){
            collisionLayer = new CollisionLayer(player, el);
            if (collisionLayer.findNearest(3.1)){
                System.out.println("Fuck nearest");
            }
        }
    }
}
