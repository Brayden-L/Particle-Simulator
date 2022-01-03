package com.mygdx.phys;

import com.mygdx.phys.physParticle;

import java.util.Arrays;

public class Environment {
	physParticle[][] environment;

	Environment(physParticle[][] environment) {
		this.environment = environment;
		System.out.println("Environment initialized.");
	}

	public physParticle getParticle(int x, int y) {
		return environment[x][y];
	}

	public void setParticle(int x, int y, physParticle particle) {
		environment[x][y] = particle;
		System.out.println("Set particle " + particle.id + " to " + Arrays.toString(particle.getPos()));
	}

	public void moveParticle(int oX, int oY, int nX, int nY) {
		environment[nX][nY] = environment[oX][oY];
		environment[oX][oX] = null;
	}

}

