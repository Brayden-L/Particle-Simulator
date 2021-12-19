package com.mygdx.phys;

import com.badlogic.gdx.utils.Pool;

public class physParticle implements Runnable, Pool.Poolable {
    /* The structure of particleID will be:  */
    String  name;
    String  type;   //
    double  mass;   //
    int     charge; //
    String  id;     //
    double[] pos;   //
    Velocity2 vel;
    double gravity;

    public physParticle(String name, String type, double[] pos, Velocity2 vel) {

        this.type   = type;

        switch (type) {
            case "proton":
                this.mass   = 1.000727;
                    this.charge = 1;
                    break;
                case "neutron":
                    this.mass   = 1.000866;
                    this.charge = 0;
                    break;
                case "electron":
                    this.mass   = 0.0005486;
                    this.charge = -1;
                    break;
                default:
                    System.out.println("Error, invalid TYPE attribute ascribed to PARTICLE " + id + ".");
                    // TODO make ID an actual thing in generation
                    break;
            }

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

    public String getId() {
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

    public void setId(String id) {
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

    @Override
    public void run() {
        System.out.println("Created particle <" + id + "> at " + pos + ".");
    }

    @Override
    public void reset() {

    }

    static void main() {

        } // TODO write particle behavior



}