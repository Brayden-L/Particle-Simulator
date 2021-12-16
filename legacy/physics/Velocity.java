class Velocity {
    /*
     Vectors created with this class are already normalized,
     as they increment position on a per-loop-iteration basis.
     */
    double[] vel;
    double x;
    double y;

    Velocity(double[] vel) {
        this.vel = vel;

        this.x = vel[0];
        this.y = vel[1];
    }

    gravity() {

    }

    electromagnetism() {

    }

}

