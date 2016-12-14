package com.ninja.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Aunpyz on 12/14/2016.
 */
public class PlayerAnimation {
    SpriteBatch batch;
    private TextureAtlas textureAtlas;
    private float elapsedTime = 0f;

    public PlayerAnimation()
    {
        batch = new SpriteBatch();
        textureAtlas = new TextureAtlas(Gdx.files.internal("packed/animation.atlas"));
    }
}
