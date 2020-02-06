package game;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

import engine.DisplayManager;
import engine.Renderer;
import models.RawModel;
import util.Loader;

public class Main {
	public static void main(String[] args) {
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
		float[] vertices = {
				-0.5f, 0.5f, 0f,
			    -0.5f, -0.5f, 0f,
			    0.5f, -0.5f, 0f,
			    0.5f, -0.5f, 0f,
			    0.5f, 0.5f, 0f,
			    -0.5f, 0.5f, 0f
		};
		
		RawModel model = loader.loadToVAO(vertices);
		
		System.out.println("LWJGL Version " + Sys.getVersion());
		
		while(!Display.isCloseRequested()) {
			renderer.prepare();
			renderer.render(model);
			
			DisplayManager.updateDisplay();
		}
		DisplayManager.closeDisplay();
	}
}