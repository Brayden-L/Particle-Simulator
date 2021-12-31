package com.mygdx.phys;

import com.mygdx.phys.physParticle;

public class Environment {
	physParticle[][] environment;

	Environment(physParticle[][] environment) {
		this.environment = environment;
		System.out.println("Environment initialized.");
	}

}
