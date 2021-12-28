package com.mygdx.phys;

import com.badlogic.gdx.utils.Pool;

import java.util.Arrays;

class Atom implements Runnable, Pool.Poolable {
    physParticle[]  particles;
    double[]    position;
    int         charge;
    Velocity2   velocity;
    double      gravity;

    Atom(physParticle[]  particles, double[] position, Velocity2 velocity) {
        this.particles  = particles;
        this.position   = position;

        /* Calculate an Atom's charge and gravity: */
        for (physParticle particle : particles) {
            charge += particle.getCharge();
            gravity += particle.getGravity();
        }
        this.velocity   = velocity;
    }

    /* Getters: */

    public physParticle[] getParticles() {
        return particles;
    }

    public double[] getPosition() {
        return position;
    }

    public int getCharge() {
        return charge;
    }

    public Velocity2 getVelocity() {
        return velocity;
    }

    public double getGravity() {
        return gravity;
    }

    /* Setters: */

    public void setParticles(physParticle[] particles) {
        this.particles = particles;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public void setVelocity(Velocity2 velocity) {
        this.velocity = velocity;
    }

    /* Not recommended for actual physics, but if you want to have some fun, go for it. */
    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    /* Behavior: */

    public void updatePosition() {
        /* Update position according to velocity. */
        position[0] += velocity.getRun();
        position[1] += velocity.getRise();
    }

    void split() {
        // TODO write split
    }

    @Override
    public void run() {
        System.out.println("Atom created with " + Arrays.toString(particles) + " at " + Arrays.toString(position) + ".");
    }

    @Override
    public void reset() {
        physParticle[]  particles   = null;
        double[]    position        = null;
        int         charge          = 0;
        Velocity2   velocity        = null;
        double      gravity         = 0;
    }

    public void main() {
        this.updatePosition();
    }
}