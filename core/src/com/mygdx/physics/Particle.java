class Particle implements Runnable {
    /* The structure of particleID will be:  */
    String  type;   //
    double  mass;   //
    int     charge; //
    int     id;     //
    float[] pos;    //
    Velocity vel;   // Velocity.java
    float   gravity;    //

    Particle(int id, String type, float[] pos, Velocity vel) {

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

    fuse() {
        /* Join proximal particles together to form an atom, occurs after a series of checks and force exertions. */
        if
    }

    static void main() {
        while (true) {
            pos[x] = vel.x;
            pos[y] = vel.y;
        }
    }



}