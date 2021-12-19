package com.mygdx.phys;

class Velocity2 {
	double[] factors;
	double rise;
	double run;
	double scalarCoefficient;

	Velocity2(double[] factors) {
		this.rise 	= factors[0];
		this.run	= factors[1];
		this.scalarCoefficient	= factors[2];
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

	// TODO write util methods for velocity

}