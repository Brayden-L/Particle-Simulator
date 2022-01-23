package com.mygdx.phys;

import java.math.BigDecimal;
import java.util.Arrays;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static jdk.nashorn.internal.objects.Global.NaN;


public class Velocity2 {
	int[] factors;
	double rise;
	double run;

	public Velocity2(int[] factors) {
		this.factors = factors;
		this.rise 	= factors[0];
		this.run	= factors[1];
		System.out.println("DEBUG HERE!!!!! "+Arrays.toString(factors));
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
	public void update(double gForce, BigDecimal fCoulomb, int[] direction) {
		if (gForce == Infinity || Double.isNaN(gForce)) gForce = 0;
		if (direction[0] == Infinity)  direction[0] = 0;
		if (direction[1] == Infinity)  direction[1] = 0;
		run	 += fCoulomb.add(BigDecimal.valueOf(direction[0] * gForce)).doubleValue();
		rise += fCoulomb.add(BigDecimal.valueOf(direction[1] * gForce)).doubleValue();
		System.out.println(gForce + "\n" + fCoulomb + "\n" + Arrays.toString(direction));
		System.out.println("vUpdate: " + run + " " + rise);
	}

}