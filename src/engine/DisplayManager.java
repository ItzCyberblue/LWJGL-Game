package engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final String TITLE = "LWJGL Window";
	private static final int FPS = 120;
	
	public static void createDisplay() {
		ContextAttribs attribs = new ContextAttribs(3,2);
		attribs.withForwardCompatible(true);
		attribs.withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle(TITLE);
			GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
		} catch (LWJGLException e) {
			System.err.println("Failed to create window!");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public static void updateDisplay() {
		Display.sync(FPS);
		Display.update();
	}
	
	public static void closeDisplay() {
		Display.destroy();
		System.out.println("Exited application");
		System.exit(0);
	}
}
