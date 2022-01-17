/*
    Copyright (C) 2022  Brayden L.
*/

package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.moandjiezana.toml.Toml;
import com.mygdx.game.ParticleSimulatorClass;
import java.lang.Math;

import java.io.File;

public class DesktopLauncher  {

	public static void main(String[] args) {

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Particle Simulator";

		Toml toml = new Toml().read("/home/fruitcake/Projects/Particle-Simulator/core/src/com/mygdx/example.toml");
		
		config.width = Math.toIntExact(toml.getTable("configuration").getLong("width"));
		config.height = 1080;

		try {
//			new LwjglApplication(new ParticleSimulatorClass(args[0]), config);
			new LwjglApplication(new ParticleSimulatorClass(config.width, config.height, toml), config);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}
