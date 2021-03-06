package gp.a04;

import gp.world.World;
import gp.world.camera.Camera;
import gp.world.camera.EntityFollowerCamera;

import java.awt.event.KeyEvent;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

public class A04World extends World {

	//private static final float DELTA = 0.07f;
	//private Camera camera;
	
	private Camera standardCamera;
	private EntityFollowerCamera efCamera;
	
	private Figure figure;
	private Chessboard chessboard;
	
	
	private enum CamPos {
		TOP,
		FIGURE
	}
	
	private CamPos pos = CamPos.TOP;

	public A04World() {
		super();

		setMargins(-4, -4, 4, 4);
		
		figure = new Figure();
		figure.setMargins(this);
		figure.setX(0.5f);
		figure.setY(0.5f);
		figure.setZ(0f);
		add(figure);
		
		chessboard = new Chessboard();
		add(chessboard);
		
		standardCamera = new Camera();
		standardCamera.setEyeXYZ(0f, -3f, 7f);
		standardCamera.setViewUpXYZ(0f, 1f, 0f);
		
		setCamera(standardCamera);

		efCamera = new EntityFollowerCamera(figure, 0, 0, 1.35f);
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

		if( pos == CamPos.FIGURE) {
			
			switch(e.getKeyCode()) {				
			case KeyEvent.VK_LEFT:
				figure.setAlpha(figure.getAlpha()  + (float)Math.PI/2);
				break;
				
			case KeyEvent.VK_RIGHT:
				figure.setAlpha(figure.getAlpha()  - (float)Math.PI/2);
				break;
				
			case KeyEvent.VK_DOWN:
				figure.setAlpha(figure.getAlpha()  + (float)Math.PI);
				break;

			case KeyEvent.VK_D:
				figure.moveRel( (float)Math.cos(figure.getAlpha() - ((float)Math.PI/2)), (float)Math.sin(figure.getAlpha() - ((float)Math.PI/2)), 0); 
				break;
				
			case KeyEvent.VK_A:
				figure.moveRel( (float)Math.cos(figure.getAlpha() + ((float)Math.PI/2)), (float)Math.sin(figure.getAlpha() + ((float)Math.PI/2)), 0); 
				break;

			case KeyEvent.VK_W:
				figure.moveRel( (float)Math.cos(figure.getAlpha()), (float)Math.sin(figure.getAlpha()), 0); 
				break;
			case KeyEvent.VK_S:
				figure.moveRel( -(float)Math.cos(figure.getAlpha()), -(float)Math.sin(figure.getAlpha()), 0); 
				break;
			}
			
		}
		
		if( pos == CamPos.TOP) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				figure.moveRel(-1, 0, 0);
				break;
			case KeyEvent.VK_RIGHT:
				figure.moveRel(1, 0, 0);
				break;
				
			case KeyEvent.VK_UP:
				figure.moveRel(0, 1, 0);
				break;
				
			case KeyEvent.VK_DOWN:				
				figure.moveRel(0, -1, 0);
				break;

			default:
				break;
			}
		}

		

		
	}

	private void toggleCamPos() {
		if(pos == CamPos.TOP) {
			pos = CamPos.FIGURE;
			setCamera(efCamera);
		} else if(pos == CamPos.FIGURE) {
			pos = CamPos.TOP;
			setCamera(standardCamera);
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
