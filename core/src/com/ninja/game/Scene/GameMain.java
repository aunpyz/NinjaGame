package com.ninja.game.Scene;

import com.badlogic.gdx.*;
import com.ninja.game.Scene.GameScreen;

public class GameMain extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen());
	}
}
