package gp.a04;

import gp.world.Camera;
import gp.world.Entity;
import gp.world.SphereCamera;
import gp.world.World;

import java.awt.event.KeyEvent;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

public class A04World extends World<Entity> {

	private static final float DELTA = 0.07f;
	private Camera camera;
	private Figure figure;
	private Chessboard chessboard;
	
	private enum CamPos {
		TOP,
		FIGURE
	}
	
	private CamPos pos = CamPos.TOP;

	public A04World() {
		super();
		
		camera = new Camera();
		camera.setEyeXYZ(10.00f, 0f, 0.0f);
		
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

		switch(e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			toggleCamPos();
			break;
		}

		
	}

	private void toggleCamPos() {
		if(pos == CamPos.TOP) {
			pos = CamPos.FIGURE;
			
			
		} else if(pos == CamPos.FIGURE) {
			pos = CamPos.TOP;
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
