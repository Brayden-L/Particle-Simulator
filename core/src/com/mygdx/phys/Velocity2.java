package com.mygdx.phys;

import java.util.Arrays;

/* This is just slope. */

public class Velocity2 {
	double[] factors;
	double rise;
	double run;

	public Velocity2(double[] factors) {
		this.factors = factors;
		this.rise 	= factors[0];
		this.run	= factors[1];
		System.out.println("DEBUG HERE!!!!! "+Arrays.toString(factors));
		// normalize slope for the first time
		double slope = rise / run;
		int[] tmp = doubleToFraction(slope);
		factors[0] = tmp[0];
		factors[1] = tmp[1];
		System.out.println("DEBUG DTF OUTPUT HERE!!!!! "+Arrays.toString(factors));
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
	public double[] getFactors() {
		return factors;
	}
	public double getRise() {
		return rise;
	}
	public double getRun() {
		return run;
	}
	/* Setters: */
	public void setFactors(double[] factors) {
		this.factors = factors;
	}
	public void setRise(double rise) {
		this.rise = rise;
	}
	public void setRun(double run) {
		this.run = run;
	}

	/* Utility methods: */

	// https://stackoverflow.com/questions/5124743/algorithm-for-simplifying-decimal-to-fractions
	public int[] doubleToFraction(double x) {
		double errorMargin = 0.00000000000001;
		System.out.println("dtf input: "+x);
		int[] fraction = new int[2];
		int n = (int) Math.floor(x);
		System.out.println("math floor: " + n);
		x -= n;
		if (x < errorMargin) {
			fraction[0] = n;
			fraction[1] = 1;
		} else if (1 - errorMargin < x) {
			fraction[0] = n + 1;
			fraction[1] = 1;
		}
		return fraction;
	}

	public void update(double gForce, double gForceCoefficient) {
		double slope = rise / run;
		gForce *= gForceCoefficient;
		int[] tmp = doubleToFraction(slope);
		System.out.println(Arrays.toString(tmp));
		rise 	= tmp[0];
		run		= tmp[1];

		int[] newVel = doubleToFraction(gForce);
		System.out.println(Arrays.toString(newVel));
		this.rise *= newVel[0];
		this.run *= newVel[1];
	}

}