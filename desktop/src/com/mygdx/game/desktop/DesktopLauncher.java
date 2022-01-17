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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DesktopLauncher  {

	public static void main(String[] args) {

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Particle Simulator";

		Toml toml = new Toml().read(new File("/home/fruitcake/Projects/Particle-Simulator/core/src/com/mygdx/simulator.toml"));
		// This part was repeated, ergo I found it more efficient to replace it with a single line and multiple references.
		Toml configToml = toml.getTable("configuration");

		config.width 	= Math.round(configToml.getLong("width"));
		config.height 	= Math.round(configToml.getLong("height"));

		int[] rgb 	= new int[3];
		rgb [0] 	= Math.round(configToml.getLong("rgb[0]"));
		rgb [1] 	= Math.round(configToml.getLong("rgb[1]"));
		rgb [2] 	= Math.round(configToml.getLong("rgb[2]"));

		try {
//			new LwjglApplication(new ParticleSimulatorClass(args[0]), config);
			new LwjglApplication(new ParticleSimulatorClass(config.width, config.height, toml, rgb), config);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}
