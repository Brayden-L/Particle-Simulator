class Lorentz {
/*
    The Lorentz force is the force on a charged particle due to electric and magnetic fields.
    Formula: Force = charge * velocity x magnetic field density
    https://www.brightstorm.com/science/physics/magnetism/lorentz-force/

*/
    int             charge;
    Velocity        velocity;
    MagneticField   magneticField;

    Lorentz(double electricField, double magneticField) {
        this.electricField = electricField;
        this.magneticField = magneticField;
    }

    crossproduct(electricField, magneticField) {
        
    }

}
/*
do a perp dot product
make a new vector 90 degrees to the left with the magnitude of the scalar you get from (v0.x*v1.y)-(v0.y*v1.x)
 */
/*
Angular momentum    = mass * velocity * radius
Angular velocity    = change in angular motion / change in time
Moment of inertia   = angular momentum / angular velocity
 */