package com.mygdx.phys;
/**
 * The idea behind this 2d Velocity implementation comes in three parts:
 * 	[RISE, RUN, SCALAR]
 * These components translate to SLOPE and DISTANCE, which in turn translate to the DIRECTION and MAGNITUDE vector
 * components.
 * **/
public class Velocity2 {
	double[] factors;
	double rise;
	double run;
	double scalarCoefficient;

	public Velocity2(double[] factors) {
		this.rise 	= factors[0];
		this.run	= factors[1];
		this.scalarCoefficient	= factors[2];
		// slope
		double m = (rise / run) * scalarCoefficient;

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
	public double getScalarCoefficient() {
		return scalarCoefficient;
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
	public void setScalarCoefficient(double scalarCoefficient) {
		this.scalarCoefficient = scalarCoefficient;
	}

	/* Utility methods: */

	// https://stackoverflow.com/questions/5124743/algorithm-for-simplifying-decimal-to-fractions
	public int[] doubleToFraction(double x) {
		double errorMargin = 0.000001;
		int[] fraction = new int[2];
		int n = (int) Math.floor(x);
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
}