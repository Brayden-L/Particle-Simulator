/*
    Copyright (C) 2021  Brayden L.
*/


package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.phys.*;
import com.moandjiezana.toml.Toml;
import com.mygdx.phys.Environment;
import com.mygdx.phys.physParticle;
import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;

public class DesktopLauncher  {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Particle Simulator";
		config.width = 1800;
		config.height = 900;

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
// 	WE DON'T TALK ABOUT THIS......
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

//        Environment env = new Environment();

		new LwjglApplication(new DesktopLauncher(), config);
	}
}
