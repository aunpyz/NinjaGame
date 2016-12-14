package com.ninja.game.Sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ai.steer.behaviors.Jump;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.ninja.game.Interfaces.*;

import java.lang.*;

/**
 * Created by Aunpyz on 12/14/2016.
 */
public class PlayerAnimation extends Sprite implements State{
    private TextureRegion idle[][];
    private TextureRegion die[][];
    private TextureRegion attack[][];
    private TextureRegion jump[][];
    private TextureRegion fallAir[][];
    private TextureRegion fallGround[][];
    private TextureRegion walk[][];
    private TextureRegion loop[][];
    private TextureRegion stop[][];

    public Animation animation;
    private STATE previousState;
    private STATE playerState;
    private DIR direction;

    private float elapsed;
    private float delta;
    private final float fps = 1f/30f;
    private final float distance = 3f;
    private final float gravity = -0.5f;
    private final float scale = 0.5f;
    private final float groundLV = 40;

    private double hp;
    private String name;
    private boolean isATK;
    private boolean isGround;

    public PlayerAnimation(Skin skin) {
        super(skin);
        hp = 100;
        name = "Ninja";
        position = new Vector2(1, 0);
        velocity = new Vector2(0, 0);
        delta = 0;
        isATK = false;
    }

    @Override
    public void init() {
        idle = new TextureRegion[2][30];
        die = new TextureRegion[2][41];
        attack = new TextureRegion[2][32];
        jump = new TextureRegion[2][11];
        fallAir = new TextureRegion[2][6];
        fallGround = new TextureRegion[2][14];
        walk = new TextureRegion[2][19];
        loop = new TextureRegion[2][15];
        stop = new TextureRegion[2][15];

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<30; j++)
            {
                idle[i][j] = resource.getRegion((i==0?"pfi":"pbi")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<41; j++)
            {
                die[i][j] = resource.getRegion((i==0?"pfd":"pbd")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<11; j++)
            {
                attack[i][j] = resource.getRegion((i==0?"pffh":"pbfh")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<11; j++)
            {
                attack[i][j+11] = resource.getRegion((i==0?"pfoh":"pboh")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<10; j++)
            {
                attack[i][j+22] = resource.getRegion((i==0?"pfhh":"pbhh")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<11; j++)
            {
                jump[i][j] = resource.getRegion((i==0?"pfj":"pbj")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<6; j++)
            {
                fallAir[i][j] = resource.getRegion((i==0?"pffa":"pbfa")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<14; j++)
            {
                fallGround[i][j] = resource.getRegion((i==0?"pffl":"pbfl")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<3; j++)
            {
                walk[i][j] = resource.getRegion((i==0?"pfsr":"pbsr")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<16; j++)
            {
                walk[i][j+3] = resource.getRegion((i==0?"pfrca":"pbrca")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<15; j++)
            {
                loop[i][j] = resource.getRegion((i==0?"pfrcb":"pbrcb")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<15; j++)
            {
                stop[i][j] = resource.getRegion((i==0?"pfsra":"pbsra")+String.format("%02d", j+1));
            }
        }

        setDir(DIR.R);
        playerState = STATE.IDLE;
        previousState = playerState;
    }

    @Override
    public void update(float delta) {
        this.delta += delta;
//        if(hp <= 0 || Gdx.input.isKeyPressed(Input.Keys.ENTER) || playerState == STATE.DIE)
//        {
//            if(playerState == STATE.DIE)
//                return;
//            setState(STATE.DIE);
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
//        {
//            setDir(DIR.L);
//            setState(STATE.WALK);
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
//        {
//            setDir(DIR.R);
//            setState(STATE.WALK);
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && playerState != STATE.JUMP)
//        {
//            setState(STATE.JUMP);
//        }
//        if(Gdx.input.isKeyJustPressed(Input.Keys.Z) && playerState != STATE.ATTACK)
//        {
//            setState(STATE.ATTACK);
//        }
//        else
//        {
//            if(this.delta >= animation.getAnimationDuration())
//            {
//                setState(STATE.IDLE);
//            }
//        }
        if(hp > 0)
        {
            position.x += velocity.x;
            if(position.x < -100)
                position.x = -100;
            else if(position.x > 850)
                position.x = 850;
            position.y += velocity.y;
            if(position.y <= groundLV)
            {
                position.y = groundLV;
                isGround = true;
            }
            velocity.y += gravity;
            velocity.x = 0;
            if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && isGround)
            {
                isGround = false;
                velocity.y = distance*5;
                isATK = false;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            {
                velocity.x = -distance;
                direction = DIR.L;
                isATK = false;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            {
                velocity.x = distance;
                direction = DIR.R;
                isATK = false;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.Z))
            {
                isATK = true;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.ENTER))
            {
                hp =0;
            }
            setState();
        }
    }


    @Override
    public void render(SpriteBatch batch) {
//        System.out.println(this.delta);
        batch.draw(animation.getKeyFrame(delta),position.x,position.y);
    }

    @Override
    public void dispose() {
        for(int i = 0; i<2; i++)
        {
            for(int j = 0; j<15; j++)
            {
                stop[i][j].getTexture().dispose();
            }
        }
        for(int i = 0; i<2; i++)
        {
            for(int j = 0; j<15; j++)
            {
                loop[i][j].getTexture().dispose();
            }
        }
        for(int i = 0; i<2; i++)
        {
            for(int j = 0; j<19; j++)
            {
                walk[i][j].getTexture().dispose();
            }
        }
        for(int i = 0; i<2; i++)
        {
            for(int j = 0; j<14; j++)
            {
                fallGround[i][j].getTexture().dispose();
            }
        }
        for(int i = 0; i<2; i++)
        {
            for(int j = 0; j<6; j++)
            {
                fallAir[i][j].getTexture().dispose();
            }
        }
        for(int i = 0; i<2; i++)
        {
            for(int j = 0; j<30; j++)
            {
                idle[i][j].getTexture().dispose();
            }
        }
        for(int i = 0; i<2; i++)
        {
            for(int j = 0; j<41; j++)
            {
                die[i][j].getTexture().dispose();
            }
        }
        for(int i = 0; i<2; i++)
        {
            for(int j = 0; j<32; j++)
            {
                attack[i][j].getTexture().dispose();
            }
        }
        for(int i = 0; i<2; i++)
        {
            for(int j = 0; j<11; j++)
            {
                jump[i][j].getTexture().dispose();
            }
        }
    }

    @Override
    public STATE getState() {
        if(isATK)
            return STATE.ATTACK;
        if(velocity.x != 0 && position.y <= groundLV)
            return STATE.CYCLE;
//        else if((previousState == STATE.WALK && position.y <= 1) || previousState == STATE.CYCLE && velocity.x != 0)
//            return STATE.CYCLE;
//        else if(velocity.x == 0 && velocity.y <= 1 && (previousState == STATE.CYCLE || previousState == STATE.WALK))
//            return STATE.STOP;
        else if(velocity.y > 0)
            return  STATE.JUMP;
        else if((velocity.y <= 0 && previousState == STATE.JUMP) || position.y > groundLV)
            return STATE.FALLAIR;
        else if(position.y <= groundLV+10 && previousState == STATE.FALLAIR)
            return STATE.FALLGROUND;
        else if(hp <= 0)
            return STATE.DIE;
        else return STATE.IDLE;
    }

    @Override
    public void setState() {
//        delta = 0;
        previousState = playerState;
        playerState = getState();
        switch (playerState)
        {
            case IDLE:
                animation = new Animation(fps, getDir()==DIR.R?idle[0]:idle[1]);
                animation.setPlayMode(Animation.PlayMode.LOOP);
                break;
            case DIE:
                this.delta = 0;
                animation = new Animation(fps, getDir()==DIR.R?die[0]:die[1]);
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case ATTACK:
//                delta = 0;
                animation = new Animation(fps/1.5f, getDir()==DIR.R?attack[0]:attack[1]);
                animation.setPlayMode(Animation.PlayMode.LOOP);
                break;
            case JUMP:
//                delta = 0;
                animation = new Animation(fps, getDir()==DIR.R?jump[0]:jump[1]);
                //to 2nd jump or fall air
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case FALLAIR:
//                delta = 0;
                animation = new Animation(fps, getDir()==DIR.R?fallAir[0]:fallAir[1]);
                //to 2dn jump or fall ground
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case FALLGROUND:
//                delta = 0;
                animation = new Animation(fps, getDir()==DIR.R?fallGround[0]:fallGround[1]);
                //to idle
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case WALK:
//                delta = 0;
                animation = new Animation(fps, getDir()==DIR.R?walk[0]:walk[1]);
                //to stop a or cycle a
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case CYCLE:
//                delta = 0;
                animation = new Animation(fps, getDir()==DIR.R?loop[0]:loop[1]);
                animation.setPlayMode(Animation.PlayMode.LOOP);
                break;
            case STOP:
//                delta = 0;
                animation = new Animation(fps, getDir()==DIR.R?stop[0]:stop[1]);
                animation.setPlayMode(Animation.PlayMode.NORMAL);
        }
    }

    @Override
    public void setDir(DIR dir) {
        direction = dir;
    }

    @Override
    public DIR getDir() {
        return direction;
    }

    public Vector2 getPosition()
    {
        return position;
    }
}
