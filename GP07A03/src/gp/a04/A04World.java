package gp.a04;

import gp.a04.Wall.Orientation;
import gp.world.TextureStore;
import gp.world.World;
import gp.world.camera.Camera;
import gp.world.camera.EntityFollowerCamera;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;

public class A04World extends World implements Labyrinth, Margins{

	//private static final float DELTA = 0.07f;
	//private Camera camera;
	
	private Camera standardCamera;
	private EntityFollowerCamera efCamera;
	
	private Figure figure;
	private Chessboard chessboard;
	
	private List<Wall> walls;
	
	private float marginX1 = -1f;
	private float marginY1 = -1f;
	private float marginX2 = 1f;
	private float marginY2 = 1f;

	private enum CamPos {
		TOP,
		FIGURE
	}
	
	private CamPos pos = CamPos.TOP;
	private boolean[][][] solidMask;

	public A04World() {
		super();
		setMargins(-4, -4, 4, 4);
	}

	@Override
	protected void initializeTextureStore(GL2 gl, GLU glu, GLUT glut, TextureStore store) {
		super.initializeTextureStore(gl, glu, glut, store);
		
		Texture tex;
		
		tex = store.putFromFile("ausflugschnitt.jpg");
        tex.setTexParameteri(gl,GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
        tex.setTexParameteri(gl,GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
        
        tex = store.putFromFile("pnglogo.png");
        tex.setTexParameteri(gl,GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
        tex.setTexParameteri(gl,GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
        
        tex = store.putFromFile("derp.jpg");
        tex.setTexParameteri(gl,GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
        tex.setTexParameteri(gl,GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
        
        tex = store.putFromFile("tile00.png","wall");
        tex.setTexParameteri(gl,GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
        tex.setTexParameteri(gl,GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
        tex.setTexParameteri(gl,GL.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
        tex.setTexParameteri(gl,GL.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
        
        tex = store.putFromFile("tile000.png", "wall2");
        tex.setTexParameteri(gl,GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
        tex.setTexParameteri(gl,GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
        tex.setTexParameteri(gl,GL.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
        tex.setTexParameteri(gl,GL.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);        
        
        tex = store.putFromFile("whiteMarble.jpg");
        tex.setTexParameteri(gl,GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
        tex.setTexParameteri(gl,GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
        
        tex = store.putFromFile("blackMarble.jpg");
        tex.setTexParameteri(gl,GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
        tex.setTexParameteri(gl,GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
        
	}

	@Override
	public void init(GL2 gl, GLU glu, GLUT glut) {
		walls = new ArrayList<Wall>();
		walls.addAll( Arrays.asList(
				new Wall(2.5f, 4f, 0f, Orientation.HORIZONTAL),
				new Wall(-2.5f, 3f, 0f, Orientation.HORIZONTAL),
				new Wall(-2.5f, 2f, 0f, Orientation.HORIZONTAL),
				new Wall(-3.5f, 2f, 0f, Orientation.HORIZONTAL),
				new Wall(-0.5f, 2f, 0f, Orientation.HORIZONTAL),
				new Wall(-2.5f, -3f, 0f, Orientation.HORIZONTAL),
				new Wall(1.5f, -3f, 0f, Orientation.HORIZONTAL),
				
				new Wall(-2f, 2.5f, 0f, Orientation.VERTICAL),
				new Wall(0f, 1.5f, 0f, Orientation.VERTICAL),
				new Wall(3f, 1.5f, 0f, Orientation.VERTICAL),
				new Wall(1f, -.5f, 0f, Orientation.VERTICAL),
				new Wall(-2f, -1.5f, 0f, Orientation.VERTICAL),
				new Wall(3f, -2.5f, 0f, Orientation.VERTICAL),
				new Wall(-3f, -3.5f, 0f, Orientation.VERTICAL),
				new Wall(1f, -3.5f, 0f, Orientation.VERTICAL)
				));
		
		addAll(walls);
		
		recalculateSolidMask();
		
		figure = new Figure();
		figure.setLabyrinth(this);
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
		
		super.init(gl, glu, glut);
	}
	
	public float getMarginX1() {
		return marginX1;
	}

	public void setMarginX1(float marginX1) {
		this.marginX1 = marginX1;
	}

	public float getMarginY1() {
		return marginY1;
	}

	public void setMarginY1(float marginY1) {
		this.marginY1 = marginY1;
	}

	public float getMarginX2() {
		return marginX2;
	}

	public void setMarginX2(float marginX2) {
		this.marginX2 = marginX2;
	}

	public float getMarginY2() {
		return marginY2;
	}

	public void setMarginY2(float marginY2) {
		this.marginY2 = marginY2;
	}
	
	@Override
	public void setMargins(float x1, float y1, float x2, float y2) {
		this.marginX1 = x1;
		this.marginY1 = y1;
		this.marginX2 = x2;
		this.marginY2 = y2;
	}
	
	private void recalculateSolidMask() {
		solidMask = new boolean[17][17][1];
		
		for( Wall w : walls ) {
			final int xPos = (int)((w.getX()*2)+8);
			final int yPos = (int)((w.getY()*2)+8);
			
			solidMask[xPos][yPos][0] = true;
		}
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

	@Override
	public boolean[][][] getSolidMask() {
		return solidMask;
	}

	@Override
	public Margins getMargins() {
		return this;
	}


}
