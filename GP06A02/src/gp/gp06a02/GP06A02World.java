package gp.gp06a02;

import java.awt.event.KeyEvent;

import gp.world.World;
import gp.world.camera.SphereCamera;

public class GP06A02World extends World {

	private static final float DELTA = 0.07f;

	private SphereCamera camera;
	
	public GP06A02World() {

		HSVPyramid hsvp = new HSVPyramid();
		hsvp.setY(10);

		HLSPyramid hlsp = new HLSPyramid();
		hlsp.setY(-10);

		RGBCube rgbc = new RGBCube();
		
		add(hsvp);
		add(hlsp);
		add(rgbc);

		camera = new SphereCamera();
		camera.setRadius(10f);

		setCamera(camera);
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		// Laengengrad erhoehen
		case KeyEvent.VK_RIGHT:
			camera.rotateLng(DELTA);
			break;
		// Laengengrad erniedrigen
		case KeyEvent.VK_LEFT:
			camera.rotateLng(-DELTA);
			break;
		// Breitengrad erhoehen
		case KeyEvent.VK_UP:
			camera.rotateLat(DELTA);
			break;
		// Breitengrad erniedrigen
		case KeyEvent.VK_DOWN:
			camera.rotateLat(-DELTA);
			break;
		// view-up nach rechts rotieren
		case KeyEvent.VK_R:
			camera.rotateLR(DELTA);
			break;
		// view-up nach links rotieren
		case KeyEvent.VK_L:
			camera.rotateLR(-DELTA);
			break;
		}

	}
}
