package com.peter.boggle;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Boggle";
		cfg.useGL30 = true;
		cfg.width = 600;
		cfg.height = 400;
		
		new LwjglApplication(new Boggle(), cfg);
	}
}
