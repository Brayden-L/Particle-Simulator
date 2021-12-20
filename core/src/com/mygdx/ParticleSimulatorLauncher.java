/*
    Copyright (C) 2021  Brayden L.
*/

/*
CORE MAIN IS DEPRECATED!!!
DO NOT USE CORE BUILDS!!!
 */


package com.mygdx;

import com.moandjiezana.toml.Toml;
import com.mygdx.phys.Environment;
import com.mygdx.phys.physParticle;
import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;


public class ParticleSimulatorLauncher {

//    public String[] particleFactory(Toml tomlData) {
//        ArrayList particleArray = new ArrayList<>;

        /* Particle generator: */
/*        assert false;
        for (String item : tomlData) {
            new Thread(
                    new physParticle(
                            "",
                            "",
                            a,
                            b
                    )
            ).start();
        }

        return particleArray;
    }
*/
    public static void main(String[] args) {



        final File tomlSource;

        File tomlSource1;

        try {
            tomlSource1 = new File(Arrays.toString(args));
        } catch (Exception e) {
            tomlSource1 = null;
            e.printStackTrace();
        }

        tomlSource = tomlSource1;
        Toml tomlData = new Toml().read(tomlSource);

        System.out.println(tomlData);

//        Environment env = new Environment();





    }
}
