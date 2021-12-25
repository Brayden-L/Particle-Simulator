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
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.mygdx.phys.physParticle;
import com.moandjiezana.toml.Toml;
import java.util.HashMap;
import java.io.File;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CyclicBarrier;

public class ParticleSimulatorClass extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	/* Particle generator: */
/*        assert false;
        for (String item : tomlData) {
            new Thread(
                    new physParticle(
                            "",
                            "",
                            a,
                            b
                    )
            ).start();
        }

        return particleArray;
    }
*/
	public ParticleSimulatorClass(/*String arg*/) {

		// https://www.w3schools.com/java/java_files_read.asp
		// https://github.com/mwanji/toml4j
/*
		File tomlFile;
		Toml toml = null;
		try {
			tomlFile = new File(arg);
			toml = new Toml().read(tomlFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
		File tomlFile 				= new File("/home/fruitcake/Projects/Particle-Simulator/core/src/com/mygdx/example.toml");
		Hash
		Map<String, Object> tomlMap = new Toml().read(tomlFile).toMap();
		Toml tomlToml 				= new Toml().read(tomlFile);

		/* Pause particle threads to ensure simultaneous concurrent execution. */
		final CyclicBarrier gate = new CyclicBarrier((tomlMap.size() + 1));

		HashMap<UUID, physParticle> environment = new HashMap<UUID, physParticle>();

		for (String key : tomlMap.keySet()) {
			new UUID(128, 128);
			UUID id = UUID.randomUUID();
			environment.put(id, tomlMap.get(key));
		}

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

	public void main() {

	}

}
