package com.mygdx.phys;

import com.badlogic.gdx.utils.Pool;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.CyclicBarrier;

public class physParticle implements Runnable, Pool.Poolable {

    CyclicBarrier gate;

    String  name;
    String  type;   //
    double  mass;   //
    int     charge; //
    UUID    id;     //
    double[] pos;   //
    Velocity2 vel;
    double gravity; // Gravitation Constant * Mass1 * Mass2 / distance^2

    public final double gc      = 0.0000000000667408;
	public final double amuKgC  = 0.0000000000000000000000000016605;

    public physParticle(CyclicBarrier gate, String name, String type, UUID id, double[] pos, Velocity2 vel) {

        this.type   = type;

        switch (type) {
            case "proton":
                this.mass           = 1.000727;
                    this.charge     = 1;
                    this.gravity    = gc * (mass * amuKgC);
                    break;
                case "neutron":
                    this.mass       = 1.000866;
                    this.charge     = 0;
                    this.gravity    = gc * (mass * amuKgC);
                    break;
                case "electron":
                    this.mass       = 0.0005486;
                    this.charge     = -1;
                    this.gravity    = gc * (mass * amuKgC);
                    break;
                default:
                    System.out.println("Error, invalid TYPE attribute ascribed to PARTICLE " + id + ".");
                    // TODO make ID an actual thing in generation
                    break;
            }

            this.id     = id;
            this.pos    = pos;
            this.vel    = vel;
    }

    /* Getters: */

    public String getName() {
        return name;
    }

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

    public void setName(String name) {
        this.name = name;
    }

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

    public void bind() { // TODO write bind method

    }

    public void gravityPositionUpdate() {
        this.pos[0] += 0;
        this.pos[1] += 0;
    }

    @Override
    public void run() {
        gate.await();
        System.out.println("Created particle <" + id + "> at " + Arrays.toString(pos) + ".");
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

    static void main() {

    } // TODO write particle behavior

}