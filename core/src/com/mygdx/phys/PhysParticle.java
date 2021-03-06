/*
    Copyright (C) 2022 Brayden L.
*/

package com.mygdx.phys;

import com.badlogic.gdx.utils.Pool;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.lang.Math;

import static jdk.nashorn.internal.objects.Global.Infinity;

public class PhysParticle implements Runnable, Pool.Poolable {

    CyclicBarrier gate;
    String  type;
    double  mass;
    int     charge;
    UUID    id;
    public int[] pos;
    public Velocity2 vel;
    ArrayList<PhysParticle> particles;
    double gForce = 0;
    BigDecimal fCoulomb = BigDecimal.valueOf(0);
    int[] direction;
    int delay;

    public double GRAVITYCONSTANT;
	public double AMUKGC;
    public int    FARADAY;
    public BigDecimal COULOMB;
    public double ELECTRIC;
    public double PI;

    public PhysParticle(
            CyclicBarrier           gate,
            String                  type,
            UUID                    id,
            int[]                   pos,
            Velocity2               vel,
            ArrayList<PhysParticle> particles,
            int                     delay,
            double                  GRAVITYCONSTANT,
            double                  AMUKGC,
            int                     FARADAY,
            BigDecimal COULOMB,
            double                  ELECTRIC,
            double                  PI
    ) {

        this.gate = gate;
        this.type = type;
        switch (type) {
            case "proton":
                this.mass           = 1.000727;
                    this.charge     = 1;
                    break;
                case "neutron":
                    this.mass       = 1.000866;
                    this.charge     = 0;
                    break;
                case "electron":
                    this.mass       = 0.0005486;
                    this.charge     = -1;
                    break;
                default:
                    System.out.println("Error, invalid TYPE attribute ascribed to PARTICLE " + id + ".");
                    // TODO make ID an actual thing in generation
                    break;
            }
            this.id                 = id;
            this.pos                = pos;
            this.vel                = vel;
            this.particles          = particles;
            this.delay              = delay;
            this.GRAVITYCONSTANT    = GRAVITYCONSTANT;
            this.AMUKGC             = AMUKGC;
            this.FARADAY            = FARADAY;
            this.COULOMB            = BigDecimal.valueOf(Long.parseLong("8990000000")); // "TEMPORARY" FIX.
            this.ELECTRIC           = ELECTRIC;
            this.PI                 = PI;
    }
    // Getters and Setters take up needless space with line-breaks between them.
    /* Getters: */
    public String getType() {
        return type;
    }
    public double getMass() {
        return mass;
    }
    public int[] getPos() {
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
    /* Setters: */
    public void setType(String type) {
        this.type = type;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }
    public void setPos(int x, int y) {
        this.pos[0] = x;
        this.pos[1] = y;
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

    /* Util methods: */

    public void forceUpdate() {
        for (PhysParticle part : particles) {
            // distance = ???((x2-x1)^2+(y2-y1)^2)
            if (this.id != part.id) {
                double distance = Math.sqrt(Math.pow((part.pos[0] - this.pos[0]), 2) + Math.pow((part.pos[1] - this.pos[1]), 2));
                direction = new int[]{
                        pos[1] - part.getPos()[1],
                        pos[0] - part.getPos()[0]
                };
                // Force of Attraction = Gravitation Constant * (Mass1 * Mass2) / distance^2
                // this uses the += operator to cache the result of all gForces
                if (distance == 0) distance = 0.0001;
                gForce += GRAVITYCONSTANT * (this.mass * part.mass) / (Math.pow(distance, 2));
                if (gForce == Infinity) { // Hack to work around gForce breaking due to double type limit.
                    gForce = 0;
                } // coulomb force, electrostatic
                BigDecimal ch1 = BigDecimal.valueOf(this.charge);
                BigDecimal ch2 = BigDecimal.valueOf(part.charge);
                BigDecimal ch = ch1.multiply(ch2);
                BigDecimal di = BigDecimal.valueOf(Math.pow(distance, 2));
                BigDecimal chDi = ch.divide(di, 15, RoundingMode.HALF_DOWN);
                  fCoulomb = fCoulomb.add(COULOMB.multiply(chDi));
            }
        }
        vel.update(gForce, fCoulomb, direction);
        // Forces no longer needs to be cached for final results.
        gForce = 0;
        fCoulomb = BigDecimal.valueOf(0);
    }

    public void positionUpdate() {
        this.pos[0] += vel.getRun();
        this.pos[1] += vel.getRise();
        System.out.println("rise: " + vel.getRise() + " run: " + vel.getRun());
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
    }

    @Override
    public void reset() {
        String  name    = null;
        String  type    = null;
        double  mass    = 0;
        int     charge  = 0;
        String  id      = null;
        int[]   pos     = null;
        Velocity2 vel   = null;
        double gravity  = 0;
    }

}