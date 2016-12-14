package com.ninja.game.Sprite;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.ninja.game.Calculate.AiBot;
import com.ninja.game.Interfaces.Element;
import com.ninja.game.Interfaces.State;
import com.ninja.game.State.EElements;
import com.ninja.game.State.EType;

import javax.xml.stream.events.EndElement;
import java.lang.*;

/**
 * Created by Aunpyz on 12/15/2016.
 */
public class SEnemy extends Sprite implements Element, State{
    protected ELEMENT element;
    protected DIR direction;
    protected Animation animation;
    protected Character self;
    protected AiBot ai;
    protected STATE state;
    protected TextureRegion idle[][];
    protected TextureRegion die[][];
    protected TextureRegion attack[][];
    protected TextureRegion walk[][];
    protected float hp;
    protected float delta;

    protected final float fps = 1f/30f;

    public SEnemy(Skin skin) {
        super(skin);
        delta = 0;
        direction = random();
        position = new Vector2((float)Math.random()*800, PlayerAnimation.groundLV);
        hp = 100f;
        self = new Enemy(hp, hp , 0, 0);
        ai = new AiBot(self);
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
