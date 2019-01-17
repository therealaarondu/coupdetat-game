package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Main;

public class DesktopLauncher {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.setFromDisplayMode(LwjglApplicationConfiguration.getDesktopDisplayMode());
		new LwjglApplication(new Main(), config);



	}
}
