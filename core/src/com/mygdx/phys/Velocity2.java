package com.mygdx.phys;

import java.util.Arrays;


/* This is just slope. */

public class Velocity2 {
	int[] factors;
	double rise;
	double run;

	public Velocity2(int[] factors) {
		this.factors = factors;
		this.rise 	= factors[0];
		this.run	= factors[1];
		System.out.println("DEBUG HERE!!!!! "+Arrays.toString(factors));
		/*
		* TODO
		*  FIX THIS:
		 	DEBUG HERE!!!!! [3.14, 69.42, 8.0]
			dtf input: 0.04523192163641602
			math floor: 0
			DEBUG DTF OUTPUT HERE!!!!! [0.0, 0.0, 8.0]
			Created particle <aae0738b-b59c-4254-aff0-2df566923592> at [-500, 300].
			DEBUG HERE!!!!! [3.14, 69.42, 8.0]
			dtf input: 0.04523192163641602
			math floor: 0
			DEBUG DTF OUTPUT HERE!!!!! [0.0, 0.0, 8.0]

		*/
	}

	/* Getters: */
	public int[] getFactors() {
		return factors;
	}
	public double getRise() {
		return rise;
	}
	public double getRun() {
		return run;
	}
	/* Setters: */
	public void setFactors(int[] factors) {
		this.factors = factors;
	}
	public void setRise(double rise) {
		this.rise = rise;
	}
	public void setRun(double run) {
		this.run = run;
	}

	/* Utility methods: */
	public void update(double gForce, double fCoulomb, int[] direction) {
		System.out.println("VELOCITY UPDATE INPUTS: " + gForce + "\n" + fCoulomb + "\n" + Arrays.toString(direction));
		this.run	+= (direction[0] * gForce) + fCoulomb;
		this.rise 	+= (direction[1] * gForce) + fCoulomb;
		System.out.println("vUpdate: " + Arrays.toString(factors));
	}

}