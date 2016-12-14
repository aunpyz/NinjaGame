package com.ninja.game;

<<<<<<< HEAD
import com.badlogic.gdx.*;
import com.ninja.game.Scene.GameScreen;

public class GameMain extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen());
=======
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uwsoft.editor.renderer.SceneLoader;

public class GameMain extends ApplicationAdapter {
	private SceneLoader sceneLoader;Player player = new Player();
//
//		ItemWrapper root = new ItemWrapper(sceneLoader.getRoot());
//		root.getChild("Lake

	
	@Override
	public void create () {
		Viewport viewport = new FitViewport(12.8f, 7.5f);
		sceneLoader = new SceneLoader();
		sceneLoader.loadScene("Lake", viewport);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		sceneLoader.getEngine().update(Gdx.graphics.getDeltaTime());
		System.out.println();


>>>>>>> 60b11992c0c1948fdfcd59232597e2e83f92480e
	}
}
