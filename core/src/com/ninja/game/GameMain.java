package com.ninja.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ninja.game.Scene.GameScreen;
import com.uwsoft.editor.renderer.SceneLoader;

public class GameMain extends Game {

	@Override
	public void create () {
		setScreen(new GameScreen());
	}
}