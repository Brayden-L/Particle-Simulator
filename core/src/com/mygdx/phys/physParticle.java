package com.mygdx.phys;

import com.badlogic.gdx.math.Vector2;



public class physParticle implements Runnable {
    /* The structure of particleID will be:  */
    String  name;
    String  type;   //
    double  mass;   //
    int     charge; //
    String  id;     //
    double[] pos;   //
    Vector2 vel;
    //float   gravity;

    public physParticle(String name, String type, double[] pos, Vector2 vel) {

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

    public Vector2 getVel() {
        return vel;
    }

    /* Setters: */

    public void setName(String name) {
        this.name = name;
    }

    public void setPos(double[] pos) {
        this.pos = pos;
    }

    public void setVel(Vector2 vel) {
        this.vel = vel;
    }

    @Override
    public void run() {
        System.out.println("Created particle " + id + ".");
    }

    static void main() {

        }


}