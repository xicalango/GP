package gp.a04;

import gp.world.Entity;
import gp.world.SphereCamera;
import gp.world.World;

import java.awt.event.KeyEvent;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

public class A04World extends World<Entity> {

	private static final float DELTA = 0.07f;
	private SphereCamera camera;
	private Figure figure;
	private Chessboard chessboard;

	public A04World() {
		super();
		
		camera = new SphereCamera();
		setCamera(camera);
		
		figure = new Figure();
		figure.setX(0.5f);
		figure.setY(0.5f);
		add(figure);
		
		chessboard = new Chessboard();
		add(chessboard);
		
		
	}

	@Override
	protected void setupWorld( GL2 gl, GLU glu, GLUT glut) {
		// Beleuchtung
		float light_pos[] = { 0, 1, 1, 0 };
		float light_color_am[] = { 1, 1, 1, 1 };
		float light_color_diff[] = { 1, 1, 1, 1 };
		float light_color_spec[] = { 1, 1, 1, 1 };

		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, light_pos, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, light_color_am, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, light_color_diff, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, light_color_spec, 0);
		gl.glEnable(GL2.GL_LIGHTING);
		gl.glEnable(GL2.GL_LIGHT0);
		gl.glEnable(GL2.GL_SMOOTH);

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

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
