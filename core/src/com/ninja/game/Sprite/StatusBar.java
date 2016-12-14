package com.ninja.game.Sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by ather on 19/11/2559.
 */
public class StatusBar {
    ShapeRenderer shapeRenderer;
    SpriteBatch batch;
    BitmapFont font = new BitmapFont(Gdx.files.internal("fonts/arial.fnt"));
    float scale = 0.3f;

    public StatusBar(SpriteBatch batch){
        shapeRenderer = new ShapeRenderer();
        this.batch = batch;
    }

    void show(float x, float y, float hp, float mp, String text){
        float maxHP = (hp/150)*100;
        float maxMP = (mp/150)*100;
        batch.begin();
        font.draw(this.batch, text, x+(140-text.length())/2, y+30);
        font.getData().setScale(0.5f,0.5f);
        batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.identity();
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.rect(x-4f, y-4f, 154, 18);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(x-2f, y-2f, 152, 15);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(x, y, maxMP,5);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(x,y+5, maxHP ,5);
        shapeRenderer.end();
    }

}
