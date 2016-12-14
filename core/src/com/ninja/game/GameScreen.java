package com.ninja.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.utils.ItemWrapper;
import javafx.stage.Screen;

/**
 * Created by Aunpyz on 12/14/2016.
 */
public class GameScreen extends ScreenAdapter {
    private SceneLoader sceneLoader;
    private Camera camera;
    private Viewport viewport;
    private Player player;

    private ItemWrapper root;

    private final float WORLD_WIDTH = 12.8f;
    private final float WORLD_HEIGHT = 7.5f;

    @Override
    public void show () {
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        sceneLoader = new SceneLoader();
        sceneLoader.loadScene("Lake", viewport);

//        Player player = new Player();
        player = new Player();
        root = new ItemWrapper(sceneLoader.getRoot());
        root.getChild("Water").addScript(player);

        //camera and viewport initialize
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(WORLD_WIDTH/2, WORLD_HEIGHT/2, 0);
        camera.update();
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sceneLoader.getEngine().update(Gdx.graphics.getDeltaTime());
        camera.position.x += 10;
        camera.update();

        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER))
        {
            root.getChild("mainch").addScript(player);
        }
    }
}
