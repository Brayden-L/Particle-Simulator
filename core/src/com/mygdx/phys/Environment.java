package com.mygdx.phys;

public class Environment {
    int[]       dimensions;
    String[]    particles;

    public Environment(int[] dimensions, String[] particles) {
        this.dimensions = dimensions;
        this.particles = particles;
    }


}

/*
 def attraction(par1, par2) -> int:
    '''GMm/R**2'''
    dist = Distance(par1, par2)
    f = (GRAVRATE * par1.mass * par2.mass) / dist.dsq
    return Velocity(
        (f * dist.dx / dist.dr) / par1.mass,
        (f * dist.dy / dist.dr) / par1.mass
    )
*/