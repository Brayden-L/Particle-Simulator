package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.ParticleSimulatorClass;

public class DesktopLauncher  {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Particle Simulator";
		config.width = 1800;
		config.height = 900;
		new LwjglApplication(new ParticleSimulatorClass(), config);


	}
}
