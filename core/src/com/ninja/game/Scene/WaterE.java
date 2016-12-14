package com.ninja.game.Scene;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.ninja.game.Sprite.SEnemy;

/**
 * Created by Aunpyz on 12/15/2016.
 */
public class WaterE extends SEnemy {
    public WaterE(Skin skin) {
        super(skin);
    }

    @Override
    public void init()
    {
        idle = new TextureAtlas[][];
        die = new TextureAtlas[][];
        attack = new TextureAtlas[][];
        walk = new TextureAtlas[][];

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<30; j++)
            {
                idle[i][j] = resource.getRegion((i==0?"pfi":"pbi")+String.format("%02d", j+1));
            }
        }
    }
}
