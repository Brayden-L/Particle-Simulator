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
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import com.mygdx.phys.physParticle;
import com.mygdx.phys.Velocity2;
import com.moandjiezana.toml.Toml;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ParticleSimulatorClass extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	CyclicBarrier gate;
	File toml;
	Map<String, Object> pMap;
	Toml pToml;
	physParticle[] particles;

	public ParticleSimulatorClass() {
		// https://www.w3schools.com/java/java_files_read.asp
		// https://github.com/mwanji/toml4j
		/* Loads TOML file as a File object. */ // TODO change to `./config/particles.toml` for Alpha Build.
		toml	= new File("/home/fruitcake/Projects/Particle-Simulator/core/src/com/mygdx/example.toml");
		/* These load the File as TOML. pToml gets set to a Table of Particles, pMap gets set to a Map of pToml. */
		pToml 	= new Toml().read(toml).getTable("particles");
		pMap 	= pToml.toMap();
		//gate = new CyclicBarrier((pMap.size() + 1));
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		AssetManager manager = new AssetManager();
		manager.load("electron.png", Texture.class);
		manager.load("neutron.png", Texture.class);
		manager.load("proton.png", Texture.class);
		/* This loads the Particles from the particles.toml file: */
		int itr = 0;
		for (String key : pMap.keySet()) {
			new UUID(128, 128);
			UUID id = UUID.randomUUID();
			pToml.getTable("particle").toMap().get(key);
			double[] pos = new double[1];
			for(int i = 0; i < pToml.getList("particles[" + itr + "].pos").size(); i++) {
				pos[i] = (double) pToml.getList(
						"particles[" + itr + "].pos").get(i);
			} // might be able to replace this ^ with pos[0,1] = pToml.getList("particles[" + itr + "].pos").get(0,1);
			double[] velArr = new double[2];
			for (int i = 0; i < 3; i++) {
				velArr[i] = (double) pToml.getList("particles[" + itr + "].vel").get(i);
			}
			Velocity2 vel = new Velocity2(velArr);
			physParticle particle = new physParticle(gate, pToml.getString("particles[" + itr + "].name"),
					pToml.getString("particles[" + itr + "].type"), id, pos, vel, particles);
			particles[itr] = particle;
			new Thread(particle).start();
			System.out.println("Created particle <" + id + "> at " + Arrays.toString(pos) + ".");
			itr++;
		}
	}

	@Override
	public void render () { // https://github.com/libgdx/libgdx/wiki
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
		 //gate.await();

	}

}
