package com.ninja.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ninja.game.GameMain;

public class DesktopLauncher {
	public static void main (String[] arg) {


//		TexturePacker.Settings settings = new TexturePacker.Settings();
//		settings.maxWidth = 4096;
//		settings.maxHeight = 4096;
//		settings.filterMag = Texture.TextureFilter.MipMapLinearLinear;
//		settings.filterMin = Texture.TextureFilter.MipMapLinearLinear;
//		TexturePacker.process(settings, "used sprite animation", "packed", "animation");

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1024;
		config.height = 600;
		new LwjglApplication(new GameMain(), config);
	}
}
