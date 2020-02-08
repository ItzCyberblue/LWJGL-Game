package game;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

import engine.DisplayManager;
import engine.Renderer;
import models.RawModel;
import models.TexturedModel;
import shaders.StaticShader;
import textures.ModelTexture;
import util.Loader;

public class Main {
	public static int PLAYER_ID = (int) (Math.random() * 1000);
	
	public static void main(String[] args) {
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();
		
		float[] vertices = {
				-0.5f, 0.5f, 0f,
				-0.5f, -0.5f, 0f,
				0.5f, -0.5f, 0f,
				0.5f, 0.5f, 0f,
		};
		
		int[] indices = {
				0,1,3,
				3,1,2
		};
		
		float[] textureCoords = {
				0,0,
				0,1,
				1,1,
				1,0
		};
		
		RawModel model = loader.loadToVAO(vertices, textureCoords, indices);
		ModelTexture texture = new ModelTexture(loader.loadTexture("dev_texture"));
		TexturedModel texModel = new TexturedModel(model, texture);
		
		System.out.println("LWJGL Version: " + Sys.getVersion());
		System.out.println("Setting player: " + PLAYER_ID);
		
		while(!Display.isCloseRequested()) {
			renderer.prepare();
			shader.start();
			renderer.render(texModel);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		shader.clearAll();
		loader.clearAll();
		DisplayManager.closeDisplay();
	}
}