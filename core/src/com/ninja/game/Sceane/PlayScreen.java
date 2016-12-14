package com.ninja.game.Sceane;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.ninja.game.GameMain;
import com.sun.prism.image.ViewPort;
import javafx.stage.Stage;

/**
 * Created by ather on 9/12/2559.
 */
public class PlayScreen implements Screen{
    private GameMain game;

    //Basic PLayscreen
    private OrthographicCamera gameCam;
    private ViewPort gamePort;

    //Screen variable
    private OrthographicCamera gamecam;
    private ViewPort gameViewPort;
    private Stage stage;
    PlayScreen(Stage stage){
        this.stage = stage;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
