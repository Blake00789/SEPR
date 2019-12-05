package io.github.jordan00789.sepr.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import io.github.jordan00789.sepr.Kroy;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.width = 1920;
		config.height = 1080;
		new Lwjgl3Application(new Kroy(), config);
	}
}
