/*
    Copyright (C) 2021  Brayden L.
*/

package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.mygdx.phys.PhysParticle;
import com.mygdx.phys.Velocity2;
import com.moandjiezana.toml.Toml;
import java.io.File;
import java.util.ArrayList;
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
	public ArrayList<PhysParticle> particles = new ArrayList<>();

	public ParticleSimulatorClass() {
		// https://www.w3schools.com/java/java_files_read.asp
		// https://github.com/mwanji/toml4j
		/* Loads TOML file as a File object. */ // TODO change to `./config/particles.toml` for Alpha Build.
		toml	= new File("/home/fruitcake/Projects/Particle-Simulator/core/src/com/mygdx/example.toml");
		/* These load the File as TOML. pToml gets set to a Table of Particles, pMap gets set to a Map of pToml. */
		pToml 	= new Toml().read(toml).getTable("particles");
		pMap 	= new Toml().read(pToml).toMap();
		System.out.println(pMap);
		System.out.println(pMap.keySet()); // yields [e1, p1]
		gate = new CyclicBarrier((pMap.size() + 1));
	}

	@Override
	public void create()  {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		AssetManager manager = new AssetManager();
		manager.load("electron.png", Texture.class);
		manager.load("neutron.png", Texture.class);
		manager.load("proton.png", Texture.class);
		/* This loads the Particles from the particles.toml file: */
		for (String key : pMap.keySet()) {
			String name = pToml.getString(key + ".name");
			String type = pToml.getString(key + ".type");
			new UUID(128, 128);
			UUID id = UUID.randomUUID();
			double[] pos = new double[2];						// Despite "magic numbers" being discouraged, the solutions
			pos[0] = pToml.getDouble(key + ".pos[0]"); 	// here, in my opinion, are cleaner and more readable than
			pos[1] = pToml.getDouble(key + ".pos[1]"); 	// using a "for" loop to fill out the values.
			double[] velArr = new double[3];
			velArr[0] = pToml.getDouble(key + ".vel[0]");
			velArr[1] = pToml.getDouble(key + ".vel[1]");
			velArr[2] = pToml.getDouble(key + ".vel[2]");
			Velocity2 vel = new Velocity2(velArr);				// This basically casts the vel from the TOML to Velocity2.
			PhysParticle particle = new PhysParticle(
					gate,
					name,
					type,
					id,
					pos,
					vel,
					particles	// Don't worry about reference or value, it'll probably work.
			);
			particles.add(particle);
			new Thread(particle).start();
			System.out.println("Created particle <" + id + "> at " + Arrays.toString(pos) + ".");
		}
		try {
			gate.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
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
}
