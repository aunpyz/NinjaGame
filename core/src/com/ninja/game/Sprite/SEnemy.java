package com.ninja.game.Sprite;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.ninja.game.Interfaces.Element;
import com.ninja.game.Interfaces.State;

import javax.xml.stream.events.EndElement;
import java.lang.*;

/**
 * Created by Aunpyz on 12/15/2016.
 */
public class SEnemy extends Sprite implements Element, State{
    protected ELEMENT element;
    protected DIR direction;
    protected STATE state;
    protected TextureAtlas idle[][];
    protected TextureAtlas die[][];
    protected TextureAtlas attack[][];
    protected TextureAtlas walk[][];
    protected float hp;

    public SEnemy(Skin skin) {
        super(skin);
        direction = random();
        position = new Vector2((float)Math.random()%800, PlayerAnimation.groundLV);
        hp = 100;
    }

    public static DIR random()
    {
        return  DIR.values()[(int)(Math.random()*DIR.values().length)];
    }

    @Override
    public ELEMENT getElement() {
        return element;
    }

    @Override
    public void setElement() {
        element = null;
    }

    @Override
    public String getStringElement() {
        return element.toString().toUpperCase();
    }

    @Override
    public void init() {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(SpriteBatch batch) {

    }

    @Override
    public void dispose() {

    }

    @Override
    public STATE getState() {
        return state;
    }

    @Override
    public void setState() {
        state = getState();
    }

    @Override
    public void setDir(DIR dir) {
        direction = dir;
    }

    @Override
    public DIR getDir() {
        return direction;
    }
}
