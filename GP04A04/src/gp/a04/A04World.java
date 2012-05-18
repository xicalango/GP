package gp.a04;

import gp.world.Entity;
import gp.world.World;
import gp.world.camera.Camera;
import gp.world.camera.EntityFollowerCamera;

import java.awt.event.KeyEvent;
import java.util.Random;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

public class A04World extends World {

	//private static final float DELTA = 0.07f;
	//private Camera camera;
	
	private Camera standardCamera;
	private EntityFollowerCamera efCamera;
	
	private Figure figure1;
	private Figure figure2;
	private Chessboard chessboard;
	private Treasure treasure;
	
	private int score[] = {0,0};
	
	private enum CamPos {
		TOP,
		FIGURE
	}
	
	private CamPos pos = CamPos.TOP;

	private ScoreUpdater scoreUpdater = new ScoreUpdater() {
		@Override
		public void updateScore(int score1, int score2) {
			// TODO Auto-generated method stub
			
		}
	};
	
	public ScoreUpdater getScoreUpdater() {
		return scoreUpdater;
	}

	public void setScoreUpdater(ScoreUpdater scoreUpdater) {
		this.scoreUpdater = scoreUpdater;
	}

	public A04World() {
		super();

		setMargins(-4, -4, 4, 4);
		
		figure1 = new Figure();
		figure1.setMargins(this);
		figure1.setX(0.5f);
		figure1.setY(0.5f);
		figure1.setZ(0f);
		add(figure1);
		
		figure2 = new Figure();
		figure2.setMargins(this);
		figure2.setX(-0.5f);
		figure2.setY(-0.5f);
		figure2.setZ(0f);
		
		figure2.setG(0.7f);
		
		add(figure2);
		
		treasure = new Treasure();
		displaceEntity(treasure);
		add(treasure);
		
		chessboard = new Chessboard();
		add(chessboard);
		
		standardCamera = new Camera();
		standardCamera.setEyeXYZ(0f, -3f, 7f);
		standardCamera.setViewUpXYZ(0f, 1f, 0f);
		
		setCamera(standardCamera);

		efCamera = new EntityFollowerCamera(figure1, 0, 0, 1.35f);
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
	public void update() {
		super.update();
		
		if(figure1.getX() == treasure.getX() && figure1.getY() == treasure.getY()) {
			score[0]++;
			displaceEntity(treasure);
			scoreUpdater.updateScore(score[0], score[1]);
		}

		if(figure2.getX() == treasure.getX() && figure2.getY() == treasure.getY()) {
			score[1]++;
			scoreUpdater.updateScore(score[0], score[1]);
			displaceEntity(treasure);
		}
		
		if(figure1.getX() == figure2.getX() && figure1.getY() == figure2.getY()) {
			displaceEntity(figure1);
			displaceEntity(figure2);
		}

	}
	
	@Override
	public void render(GL2 gl, GLU glu, GLUT glut) {
		super.render(gl, glu, glut);
	}
	
	private void displaceEntity(Entity entity) {
		Random r = new Random();
		
		boolean success;
		
		float x,y;
		
		do {
		
		success = true;
			
		x = r.nextInt(7)-3.5f;
		y = r.nextInt(7)-3.5f;
		
		if((figure1.getX() == x && figure1.getY() == y) || (figure2.getX() == x && figure2.getY() == y)) {
			success = false;
		}
		
		}while(!success);
		
		entity.setX(x);
		entity.setY(y);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {

		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			//toggleCamPos();
			break;
		}

		if( pos == CamPos.FIGURE) {
			
			switch(e.getKeyCode()) {				
			case KeyEvent.VK_LEFT:
				figure1.setAlpha(figure1.getAlpha()  + (float)Math.PI/2);
				break;
				
			case KeyEvent.VK_RIGHT:
				figure1.setAlpha(figure1.getAlpha()  - (float)Math.PI/2);
				break;
				
			case KeyEvent.VK_DOWN:
				figure1.setAlpha(figure1.getAlpha()  + (float)Math.PI);
				break;

			case KeyEvent.VK_D:
				figure1.moveRel( (float)Math.cos(figure1.getAlpha() - ((float)Math.PI/2)), (float)Math.sin(figure1.getAlpha() - ((float)Math.PI/2)), 0); 
				break;
				
			case KeyEvent.VK_A:
				figure1.moveRel( (float)Math.cos(figure1.getAlpha() + ((float)Math.PI/2)), (float)Math.sin(figure1.getAlpha() + ((float)Math.PI/2)), 0); 
				break;

			case KeyEvent.VK_UP:
			case KeyEvent.VK_W:
				figure1.moveRel( (float)Math.cos(figure1.getAlpha()), (float)Math.sin(figure1.getAlpha()), 0); 
				break;
			case KeyEvent.VK_S:
				figure1.moveRel( -(float)Math.cos(figure1.getAlpha()), -(float)Math.sin(figure1.getAlpha()), 0); 
				break;
			}
			
		}
		
		if( pos == CamPos.TOP) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				figure1.moveRel(-1, 0, 0);
				break;
			case KeyEvent.VK_RIGHT:
				figure1.moveRel(1, 0, 0);
				break;
				
			case KeyEvent.VK_UP:
				figure1.moveRel(0, 1, 0);
				break;
				
			case KeyEvent.VK_DOWN:				
				figure1.moveRel(0, -1, 0);
				break;
				
			case KeyEvent.VK_A:
				figure2.moveRel(-1, 0, 0);
				break;
			case KeyEvent.VK_D:
				figure2.moveRel(1, 0, 0);
				break;
				
			case KeyEvent.VK_W:
				figure2.moveRel(0, 1, 0);
				break;
				
			case KeyEvent.VK_S:				
				figure2.moveRel(0, -1, 0);
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
