package com.ninja.game.Sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by Aunpyz on 12/14/2016.
 */
public abstract class Sprite {
    protected Skin resource;
    protected Vector2 position;
    protected Vector2 velocity;

    public Sprite(Skin skin)
    {
        resource = skin;
        position = new Vector2();
        velocity = new Vector2();
        init();
    }

    public abstract void init();

    public abstract void update(float delta);

    public abstract void render(SpriteBatch batch);

    public abstract void dispose();
}
