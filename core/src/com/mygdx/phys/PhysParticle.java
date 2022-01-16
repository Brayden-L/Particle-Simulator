package com.mygdx.phys;

import com.badlogic.gdx.utils.Pool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.lang.Math;

public class PhysParticle implements Runnable, Pool.Poolable {

    CyclicBarrier gate;
    String  type;
    double  mass;
    int     charge;
    UUID    id;
    double[] pos;
    Velocity2 vel;
    double gravity; // Gravitation Constant * (Mass1 * Mass2) / distance^2 [distance from particle, increment in for]
    ArrayList<PhysParticle> particles;
    double gForce = 0;

    public final double GRAVITYCONSTANT = 0.0000000000667408;
	public final double AMUKGC          = 0.0000000000000000000000000016605;

    public PhysParticle(CyclicBarrier gate, String type, UUID id, double[] pos, Velocity2 vel, ArrayList<PhysParticle> particles) {

        this.gate = gate;
        this.type   = type;

        switch (type) {
            case "proton":
                this.mass           = 1.000727;
                    this.charge     = 1;
                    this.gravity    = GRAVITYCONSTANT * (mass * AMUKGC);
                    break;
                case "neutron":
                    this.mass       = 1.000866;
                    this.charge     = 0;
                    this.gravity    = GRAVITYCONSTANT * (mass * AMUKGC);
                    break;
                case "electron":
                    this.mass       = 0.0005486;
                    this.charge     = -1;
                    this.gravity    = GRAVITYCONSTANT * (mass * AMUKGC);
                    break;
                default:
                    System.out.println("Error, invalid TYPE attribute ascribed to PARTICLE " + id + ".");
                    // TODO make ID an actual thing in generation
                    break;
            }

            this.id     = id;
            this.pos    = pos;
            this.vel    = vel;
            this.particles = particles;
    }
    // Getters and Setters take up needless space with line-breaks between them.
    /* Getters: */
    public String getType() {
        return type;
    }
    public double getMass() {
        return mass;
    }
    public double[] getPos() {
        return pos;
    }
    public int getCharge() {
        return charge;
    }
    public UUID getId() {
        return id;
    }
    public Velocity2 getVel() {
        return vel;
    }
    public double getGravity() {
        return gravity;
    }
    /* Setters: */
    public void setType(String type) {
        this.type = type;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }
    public void setPos(double[] pos) {
        this.pos = pos;
    }
    public void setCharge(int charge) {
        this.charge = charge;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public void setVel(Velocity2 vel) {
        this.vel = vel;
    }
    public void setGravity(double gravity) {
        this.gravity = gravity;
    }


    /* Util methods: */
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

    public void forceUpdate() { // TODO write gravity update
        for (PhysParticle part : particles) {
            // Distance = √((x2-x1)^2+(y2-y1)^2)
            // Force of Attraction = Gravitation Constant * (Mass1 * Mass2) / distance^2
            double distance =
                    Math.sqrt(
                            Math.pow(
                                    (part.pos[0] - this.pos[0]), 2
                            ) + Math.pow(
                                    (part.pos[1] - this.pos[1]), 2
                            )
                    );
            System.out.println("distance of " + id + " to " + part.id + ": " + distance);
            gForce   += (GRAVITYCONSTANT * (this.mass * part.mass)) / Math.pow(distance, 2);
            System.out.println("gForce of " + id + ": " + gForce); // debug, remove
 //           System.out.println(
 //                   "GRAV NUM THING "+(1.000727 * 0.0005486 * 0.0000000000667408) / Math.pow(43.80410939626555, 2)
 //           );
        }
        vel.update(gForce);
    }

    public void positionUpdate() {  // TODO move particle on screen & change position in environment[][].
        double[] cPos = this.pos;
        this.pos[0] += vel.getRun();
        this.pos[1] += vel.getRise();
        System.out.println("Moved particle " + id + " from " + Arrays.toString(cPos) + " to " + Arrays.toString(pos) + ".");
    }

    @Override
    public void run() {
        /* Count Particle toward CyclicBarrier: */
        try {
            gate.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        /* Print Particle Started to command-line. */
        System.out.println("Started particle <" + id + "> at " + Arrays.toString(pos) + ".");
        this.forceUpdate();
    }

    @Override
    public void reset() {
        String  name    = null;
        String  type    = null;
        double  mass    = 0;
        int     charge  = 0;
        String  id      = null;
        double[] pos    = null;
        Velocity2 vel   = null;
        double gravity  = 0;
    }

    public void main(String[] args) {
        /* Particle behavior: */
        this.forceUpdate();
        System.out.println("Main method, yay!");
    }

}