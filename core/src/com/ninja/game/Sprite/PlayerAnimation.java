package com.ninja.game.Sprite;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
    private TextureRegion attackLoop[][];
    private TextureRegion attackHoldBack[][];
    private TextureRegion jump[][];
    private TextureRegion fallAir[][];
    private TextureRegion fallGround[][];
    private TextureRegion walk[][];
    private TextureRegion walkCycleA[][];
    private TextureRegion walkCycleB[][];
    private TextureRegion walkStopA[][];
    private TextureRegion walkStopB[][];

    private Animation animation;
    private STATE playerState;
    private DIR direction;

    public PlayerAnimation(Skin skin) {
        super(skin);
    }

    @Override
    public void init() {
        idle = new TextureRegion[2][30];
        die = new TextureRegion[2][41];
        attack = new TextureRegion[2][11];
        attackLoop = new TextureRegion[2][11];
        attackHoldBack = new TextureRegion[2][10];
        jump = new TextureRegion[2][11];
        fallAir = new TextureRegion[2][6];
        fallGround = new TextureRegion[2][14];
        walk = new TextureRegion[2][3];
        walkCycleA = new TextureRegion[2][16];
        walkCycleB = new TextureRegion[2][15];
        walkStopA = new TextureRegion[2][15];
        walkStopB = new TextureRegion[2][16];

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<30; j++)
            {
                idle[i][j] = resource.getRegion("sprite/Idle/"+(i==0?"F/pfi":"B/pbi")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<41; j++)
            {
                die[i][j] = resource.getRegion("sprite/Die/"+(i==0?"F/pfd":"B/pbd")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<11; j++)
            {
                attack[i][j] = resource.getRegion("sprite/Attack-hit/"+(i==0?"F/pffh":"B/pbfh")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<11; j++)
            {
                attackLoop[i][j] = resource.getRegion("sprite/Attack-hit-loop/"+(i==0?"F/pfoh":"B/pboh")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<10; j++)
            {
                attackHoldBack[i][j] = resource.getRegion("sprite/Attack-hold-back/"+(i==0?"F/pfhh":"B/pbhh")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<11; j++)
            {
                attackHoldBack[i][j] = resource.getRegion("sprite/Attack-hold-back/"+(i==0?"F/pfhh":"B/pbhh")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<11; j++)
            {
                jump[i][j] = resource.getRegion("sprite/Jump/"+(i==0?"F/pfj":"B/pbj")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<6; j++)
            {
                fallAir[i][j] = resource.getRegion("sprite/Fall-in-Air/"+(i==0?"F/pffa":"B/pbfa")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<14; j++)
            {
                fallGround[i][j] = resource.getRegion("sprite/Fall-to-land/"+(i==0?"F/pffl":"B/pbfl")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<3; j++)
            {
                walk[i][j] = resource.getRegion("sprite/Run-start/"+(i==0?"F/pfsr":"B/pbsr")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<16; j++)
            {
                walkCycleA[i][j] = resource.getRegion("sprite/Run-cycle-A/"+(i==0?"F/pfrca":"B/pbrca")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<15; j++)
            {
                walkCycleB[i][j] = resource.getRegion("sprite/Run-cycle-B/"+(i==0?"F/pfrcb":"B/pbrcb")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<15; j++)
            {
                walkStopA[i][j] = resource.getRegion("sprite/Run-stop-A/"+(i==0?"F/pfsra":"B/pbsrb")+String.format("%02d", j+1));
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<16; j++)
            {
                walkStopB[i][j] = resource.getRegion("sprite/Run-stop-B/"+(i==0?"F/pfsrb":"B/pbsrb")+String.format("%02d", j+1));
            }
        }

        setState(STATE.IDLE);
        setDir(DIR.R);
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void render(SpriteBatch batch) {

    }

    @Override
    public void dispose() {
        for(int i=0; i<2; i++)
        {
            for(int j=0; j<30; j++)
            {
                idle[i][j].getTexture().dispose();
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<41; j++)
            {
                die[i][j].getTexture().dispose();
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<11; j++)
            {
                attack[i][j].getTexture().dispose();
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<11; j++)
            {
                attackLoop[i][j].getTexture().dispose();
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<10; j++)
            {
                attackHoldBack[i][j].getTexture().dispose();
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<11; j++)
            {
                attackHoldBack[i][j].getTexture().dispose();
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<11; j++)
            {
                jump[i][j].getTexture().dispose();
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<6; j++)
            {
                fallAir[i][j].getTexture().dispose();
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<14; j++)
            {
                fallGround[i][j].getTexture().dispose();
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<3; j++)
            {
                walk[i][j].getTexture().dispose();
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<16; j++)
            {
                walkCycleA[i][j].getTexture().dispose();
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<15; j++)
            {
                walkCycleB[i][j].getTexture().dispose();
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<15; j++)
            {
                walkStopA[i][j].getTexture().dispose();
            }
        }

        for(int i=0; i<2; i++)
        {
            for(int j=0; j<16; j++)
            {
                walkStopB[i][j].getTexture().dispose();
            }
        }
    }

    @Override
    public STATE getState() {
        return playerState;
    }

    @Override
    public void setState(STATE state) {
        playerState = state;
        switch (playerState)
        {
            case IDLE:
                animation = new Animation(1f/30f, getDir()==DIR.R?idle[0]:idle[1]);
                animation.setPlayMode(Animation.PlayMode.LOOP);
                break;
            case DIE:
                animation = new Animation(1f/30f, getDir()==DIR.R?die[0]:die[1]);
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case ATTACK:
                animation = new Animation(1f/30f, getDir()==DIR.R?attack[0]:attack[1]);
                //to holdback
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case ATTACKLOOP:
                animation = new Animation(1f/30f, getDir()==DIR.R?attackLoop[0]:attackLoop[1]);
                //loop or to hold back
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case ATTACKHOLDBACK:
                animation = new Animation(1f/30f, getDir()==DIR.R?attackHoldBack[0]:attackHoldBack[1]);
                //to idle or attack
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case JUMP:
                animation = new Animation(1f/30f, getDir()==DIR.R?jump[0]:jump[1]);
                //to 2nd jump or fall air
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case FALLAIR:
                animation = new Animation(1f/30f, getDir()==DIR.R?fallAir[0]:fallAir[1]);
                //to 2dn jump or fall ground
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case FALLGROUND:
                animation = new Animation(1f/30f, getDir()==DIR.R?fallGround[0]:fallGround[1]);
                //to idle
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case WALK:
                animation = new Animation(1f/30f, getDir()==DIR.R?walk[0]:walk[1]);
                //to stop a or cycle a
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case WALKCYA:
                animation = new Animation(1f/30f, getDir()==DIR.R?walkCycleA[0]:walkCycleA[1]);
                //to cycle b or stop b
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case WALKCYB:
                animation = new Animation(1f/30f, getDir()==DIR.R?walkCycleB[0]:walkCycleB[1]);
                //to cycle a or stop a
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case WALKSTA:
                animation = new Animation(1f/30f, getDir()==DIR.R?walkStopA[0]:walkStopA[1]);
                //to idle
                animation.setPlayMode(Animation.PlayMode.NORMAL);
                break;
            case WALKSTB:
                animation = new Animation(1f/30f, getDir()==DIR.R?walkStopB[0]:walkStopB[1]);
                //to idle
                animation.setPlayMode(Animation.PlayMode.LOOP);
                break;
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
}
