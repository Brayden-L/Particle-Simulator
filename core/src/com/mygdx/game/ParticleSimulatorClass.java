/*
    Copyright (C) 2021  Brayden L.
*/

package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.mygdx.phys.physParticle;
import com.moandjiezana.toml.Toml;
import java.util.HashMap;
import java.io.File;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ParticleSimulatorClass extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	CyclicBarrier gate;
	File tomlFile;
	Map<String, Object> tomlMap;
	Toml tomlToml;

	public ParticleSimulatorClass(/*String arg*/) {

		// https://www.w3schools.com/java/java_files_read.asp
		// https://github.com/mwanji/toml4j
/*
		try {
			tomlFile = new File(arg);
			toml = new Toml().read(tomlFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
		tomlFile 	= new File("/home/fruitcake/Projects/Particle-Simulator/core/src/com/mygdx/example.toml");
		tomlMap 	= new Toml().read(tomlFile).toMap();
		tomlToml 	= new Toml().read(tomlFile);

		gate = new CyclicBarrier((tomlMap.size() + 1));

		//HashMap<UUID, physParticle> environment = new HashMap<UUID, physParticle>();

		System.out.println(tomlMap);

	}


	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		AssetManager manager = new AssetManager();
		manager.load("electron.png", Texture.class);
		manager.load("neutron.png", Texture.class);
		manager.load("proton.png", Texture.class);

		for (String key : tomlMap.keySet()) {
			new UUID(128, 128);
			UUID id = UUID.randomUUID();
			new Thread(
					new physParticle(
							gate,
							tomlMap.get(key), 	// TODO FINISH GETTING ATTRIBUTES
							"",			// https://www.geeksforgeeks.org/map-get-method-in-java-with-examples/
							id,
							b					// lol
					)
			).start();
		}
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public void main() throws BrokenBarrierException, InterruptedException {
		gate.await();
	}

}
