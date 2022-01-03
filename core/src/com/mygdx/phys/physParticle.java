package com.mygdx.phys;

import com.badlogic.gdx.utils.Pool;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.CyclicBarrier;
import java.lang.Math;
import com.mygdx.phys.Velocity2;

public class physParticle implements Runnable, Pool.Poolable {

    CyclicBarrier gate;
    String  name;
    String  type;   //
    double  mass;   //
    int     charge; //
    UUID    id;     //
    double[] pos;   //
    Velocity2 vel;
    double gravity; // Gravitation Constant * (Mass1 * Mass2) / distance^2 [distance from particle, increment in for]
    physParticle[] particles;

    public final double GRAVITYCONSTANT = 0.0000000000667408;
	public final double AMUKGC          = 0.0000000000000000000000000016605;

    public physParticle(CyclicBarrier gate, String name, String type, UUID id, double[] pos, Velocity2 vel,
                        physParticle[] particles) {

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
    }
    // Getters and Setters take up needless space with line-breaks between them.
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

    public void forceUpdate() { // TODO write gravity update
        for (physParticle part : particles) {
            // Distance = √((x2-x1)^2+(y2-y1)^2)
            // Force of Attraction = Gravitation Constant * (Mass1 * Mass2) / distance^2
            double distance = Math.sqrt(Math.pow((part.pos[0] - this.pos[0]) ,2) + Math.pow((part.pos[1] - this.pos[1]), 2));
            double gForce   = (GRAVITYCONSTANT * (this.mass * part.mass)) / Math.pow(distance, 2);
            System.out.println(gForce); // debug, remove
        }
        //vel.setRise();  // TODO adjust velocity accordingly
        //vel.setRun();
    }

    public void positionUpdate() {  // TODO move particle on screen & change position in environment[][].
        double[] cPos = this.pos;
        this.pos[0] += vel.getRun();
        this.pos[1] += vel.getRise();
        System.out.println("Moved particle " + id + " from " + Arrays.toString(cPos) + " to " + Arrays.toString(pos) + ".");
    }

    @Override
    public void run() {
        //gate.await();
        System.out.println("Started particle <" + id + "> at " + Arrays.toString(pos) + ".");
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

    void main() {
        // Gravitation Constant * (Mass1 * Mass2) / distance^2 [distance from particle, increment # in for loop]
        this.forceUpdate();
    } // TODO write particle behavior

}