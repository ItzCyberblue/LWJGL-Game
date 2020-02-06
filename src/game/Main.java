package game;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

import engine.DisplayManager;

public class Main {
	public static void main(String[] args) {
		DisplayManager.createDisplay();
		
		System.out.println("LWJGL Version " + Sys.getVersion());
		
		while(!Display.isCloseRequested()) {
			DisplayManager.updateDisplay();
		}
		DisplayManager.closeDisplay();
	}
}