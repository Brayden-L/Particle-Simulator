/*
    Copyright (C) 2021  Brayden L.
*/

package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.moandjiezana.toml.Toml;
import com.mygdx.phys.Environment;
import com.mygdx.phys.physParticle;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

public class ParticleSimulatorClass extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

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
	public ParticleSimulatorClass(/*String arg*/) {

		// https://www.w3schools.com/java/java_files_read.asp
		// https://github.com/mwanji/toml4j
/*
		File tomlFile;
		Toml toml = null;
		try {
			tomlFile = new File(arg);
			toml = new Toml().read(tomlFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
		File tomlFile = new File("/home/fruitcake/Projects/Particle-Simulator/core/src/com/mygdx/example.toml");
		Map<String, Object> tomlMap = new Toml().read(tomlFile).toMap();
		//Toml toml = new Toml().read(tomlFile);

		System.out.println(tomlMap);
//        Environment env = new Environment();

	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public void main() {

	}

}
