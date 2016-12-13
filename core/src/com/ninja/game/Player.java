package com.ninja.game;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.uwsoft.editor.renderer.components.TransformComponent;
import com.uwsoft.editor.renderer.scripts.IScript;
import com.uwsoft.editor.renderer.utils.ComponentRetriever;

/**
 * Created by Aunpyz on 12/10/2016.
 */
public class Player implements IScript{

    private Entity player;
    private TransformComponent transformComponent;

    private Vector2 speed;
    private float gravity = 15f;
    private final float jumpS = 10f;

    @Override
    public void init(Entity entity) {
        player = entity;
        transformComponent = ComponentRetriever.get(entity, TransformComponent.class);
        speed = new Vector2(10f, 0);
    }

    @Override
    public void act(float delta) {

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            transformComponent.x -= speed.x*delta;
            transformComponent.scaleX = -1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            transformComponent.x += speed.x*delta;
            transformComponent.scaleX = 1;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
            speed.y = jumpS;
        }

        speed.y -= gravity*delta;
        transformComponent.y += speed.y*delta;
        if(transformComponent.y < 1.15f)
        {
            speed.y = 0;
            transformComponent.y = 1.15f;
        }

    }

    @Override
    public void dispose() {

    }
}
