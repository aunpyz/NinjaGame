package com.ninja.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.utils.ItemWrapper;
import javafx.stage.Screen;

/**
 * Created by Aunpyz on 12/14/2016.
 */
public class GameScreen extends ScreenAdapter {
    //background
    private SceneLoader sceneLoader;
    private Camera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private AssetManager assetManager;
    private StageController stageController;

    private final float WORLD_WIDTH = 12.8f;
    private final float WORLD_HEIGHT = 7.5f;

    @Override
    public void show () {
        stageController = new StageController();
        assetManager = new AssetManager();
        assetManager.load("packed/animation.atlas", TextureAtlas.class);

        //camera and viewport initialize
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(WORLD_WIDTH/2, WORLD_HEIGHT/2, 0);
        camera.update();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT,camera);

        sceneLoader = new SceneLoader();
        sceneLoader.loadScene(stageController.getStringElement(), viewport);
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sceneLoader.getEngine().update(Gdx.graphics.getDeltaTime());
//        camera.position.x += 10;
//        camera.update();

        //change stage test
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE ))
        {
            stageController.setElement();
            sceneLoader.loadScene(stageController.getStringElement(), viewport);
        }
    }
}
