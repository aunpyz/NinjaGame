package com.ninja.game.Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ninja.game.Scene.StageController;
import com.ninja.game.Sprite.PlayerAnimation;
import com.uwsoft.editor.renderer.SceneLoader;

/**
 * Created by Aunpyz on 12/14/2016.
 */
public class GameScreen extends ScreenAdapter {
    //background
    private Camera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private AssetManager assetManager;
    private StageController stageController;
    private Skin resource;
    private PlayerAnimation player;
    private Scene scene;

    private final float WORLD_WIDTH = 12.8f;
    private final float WORLD_HEIGHT = 7.5f;

    @Override
    public void show () {
        batch = new SpriteBatch();
        stageController = new StageController();
        assetManager = new AssetManager();
        assetManager.load("packed/scene.atlas",TextureAtlas.class);
        assetManager.finishLoading();
        assetManager.load("packed/animation.atlas", TextureAtlas.class);
        resource = new Skin();
        //wait until finish loading
        assetManager.finishLoading();
        resource.addRegions(assetManager.get("packed/scene.atlas", TextureAtlas.class));

        resource.addRegions(assetManager.get("packed/animation.atlas", TextureAtlas.class));
        scene = new Scene(resource);
        player = new PlayerAnimation(resource);

        //camera and viewport initialize
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(WORLD_WIDTH/2, WORLD_HEIGHT/2, 0);
        camera.update();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT,camera);
    }

    @Override
    public void render (float delta) {
        batch.begin();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        sceneLoader.getEngine().update(delta);
//        camera.position.set(player.getPosition().x, player.getPosition().y, 0);
//        camera.update();

        scene.update(delta);
        scene.setPosition(player.getPosition());
        scene.render(batch);
        player.update(delta);
        player.render(batch);
        batch.end();
    }
}
