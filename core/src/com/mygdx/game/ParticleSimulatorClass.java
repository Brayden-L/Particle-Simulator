/*
    Copyright (C) 2021-2022  Brayden L.
*/

package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;

import com.mygdx.phys.PhysParticle;
import com.mygdx.phys.Velocity2;
import com.moandjiezana.toml.Toml;
import java.io.File;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ParticleSimulatorClass implements ApplicationListener {
	SpriteBatch batch;
	CyclicBarrier gate;
	File toml;
	Map<String, Object> pMap;
	Toml pToml;
	public ArrayList<PhysParticle> particles = new ArrayList<>();
	public HashMap<String, Texture> textureMap = new HashMap<>();

	public int w;
	public int h;

	public ParticleSimulatorClass(int width, int height) {

		this.w = width 	/ 2;
		this.h = height / 2;

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
		// fill out texture map
		// Gdx.files.internal
		textureMap.put("proton", new Texture("proton.png"));
		textureMap.put("neutron", new Texture("neutron.png"));
		textureMap.put("electron", new Texture("electron.png"));

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
	public void resize(int width, int height) {

	}

	@Override
	public void render () { // basically the "main loop"
		// clears screen and sets a color
		ScreenUtils.clear(0, 0, 0, 1);
		// draws the stuff
		batch.begin();
		for (PhysParticle part : particles) {
			/* Offset position to screen position */
			int x = (int) part.getPos()[0] + w;
			int y = (int) part.getPos()[1] + h;
			batch.draw(textureMap.get(part.getType()), x, y);
		}
		batch.end();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
