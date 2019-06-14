package com.theinvader360.tutorial.libgdx.google.ads;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
		cfg.setTitle("tutorial-libgdx-google-ads");
		cfg.setWindowedMode(480, 320);

		new Lwjgl3Application(new AdTutorial(new ActionResolverDesktop()), cfg);
	}
}
