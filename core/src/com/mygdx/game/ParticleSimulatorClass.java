/*
    Copyright (C) 2022  Brayden L.
*/

package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.phys.PhysParticle;
import com.mygdx.phys.Velocity2;
import com.moandjiezana.toml.Toml;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.lang.Math;
import java.util.concurrent.TimeUnit;


public class ParticleSimulatorClass implements ApplicationListener {
	SpriteBatch batch;
	CyclicBarrier gate;
	Toml toml;
	public List<Toml> pTables;
	public ArrayList<PhysParticle> particles 	= new ArrayList<>();
	public HashMap<String, Texture> textureMap 	= new HashMap<>();
	public int width;
	public int height;
	public int w;
	public int h;
	public int r;
	public int g;
	public int b;
	public int delay;
	double 	GRAVITYCONSTANT;
	double 	AMUKGC;
	int 	FARADAY;
	BigDecimal COULOMB;
	double 	ELECTRIC;
	double 	PI;

	public ParticleSimulatorClass(int width, int height, Toml toml, int[] rgb, int delay, double GRAVITYCONSTANT, double AMUKGC, int FARADAY,
								  BigDecimal COULOMB, double ELECTRIC, double PI) {
		// window configuration
		this.width = width;
		this.height = height;
		this.w = width 	/ 2;	// divided by 2 to give a +- range
		this.h = height / 2;	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		this.r = rgb[0];
		this.g = rgb[1];
		this.b = rgb[2];
		// set delay
		this.delay = delay;
		// https://www.w3schools.com/java/java_files_read.asp
		// https://github.com/mwanji/toml4j
		/* Loads TOML file as a File object. */
		this.toml = toml;
		try {
			pTables = new Toml().read(toml).getTables("particles");
		} catch (NullPointerException e) {
			System.out.println("No particles in [particles] in simulator.toml");
			e.printStackTrace();
		}
		System.out.println(pTables + " with sizeof "+pTables.size());
		gate = new CyclicBarrier((pTables.size() + 1));
		System.out.println(
				new Toml().read(toml).toMap()
		);
	}

	@Override
	public void create()  {
		batch = new SpriteBatch();
		// fill out texture map
		textureMap.put("proton", 	new Texture("proton.png"));
		textureMap.put("neutron", 	new Texture("neutron.png"));
		textureMap.put("electron", 	new Texture("electron.png"));
		/* This loads the Particles from the particles.toml file: */
		int itr = 0;
		for (Toml ignored : pTables) {
			Toml currPart = new Toml().read(pTables.get(itr));
			String type = currPart.getString("type");
			new UUID(32, 32);
			UUID id = UUID.randomUUID();
			int[] pos = {
					Math.round(currPart.getLong("pos[0]")),
					Math.round(currPart.getLong("pos[1]"))
			};
			int[] velArr = {
					Math.round(currPart.getLong("vel[0]")),
					Math.round(currPart.getLong("vel[1]")),
			};
			Velocity2 vel = new Velocity2(velArr);    // This basically casts the vel from the TOML to Velocity2.
			PhysParticle particle = new PhysParticle(
					gate,
					type,
					id,
					pos,
					vel,
					particles,
					delay,
					GRAVITYCONSTANT,
					AMUKGC,
					FARADAY,
					COULOMB,
					ELECTRIC,
					PI
			);
			particles.add(particle);
			new Thread(particle).start();
			System.out.println("Created particle <" + id + "> at " + Arrays.toString(pos) + ".");
			itr++;
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

	/* render() acts as a main loop: */
	@Override
	public void render() {
		// clears screen and sets a color
		ScreenUtils.clear(r, g, b, 1);
		// draws the stuff
		batch.begin();
		for (PhysParticle part : particles) {
			/* Offset position to screen position: */
			int x = part.getPos()[0] + w;
			int y = part.getPos()[1] + h;
			System.out.println("mod x: " + x + "\nmod y: " + y);
			/* Window wrap for particles: */
			if (x > w) x = x % width;
			if (y > h) y = y % height;
			if (x < -w) x = -x % width;
			if (y < -w) y = -y % width;
			/* Render each particle: */
			batch.draw(textureMap.get(part.getType()), x, y);
			part.forceUpdate();
			part.positionUpdate();
			try {
				TimeUnit.MILLISECONDS.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}
		batch.end();
		System.out.println(">>>>>>>>>>>>>>>>>>>>CALLED RENDERER<<<<<<<<<<<<<<<<<<<<");
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
