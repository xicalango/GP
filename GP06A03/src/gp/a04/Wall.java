package gp.a04;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

import gp.world.Entity;

public class Wall extends Entity {

	public static enum Orientation
	{
		HORIZONTAL,
		VERTICAL
	}
	
	private Orientation orientation;
	private float height = 1.5f;
	
	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Wall(float x, float y, float z, Orientation orientation) {
		super(x, y, z);
		
		this.orientation = orientation;
	}

	@Override
	protected void _render(GL2 gl, GLU glu, GLUT glut) {
		
		setMaterial(0.3f, 0.6f, 1);
		
		if(orientation == Orientation.HORIZONTAL) {
			gl.glScalef(1f, 0.1f, height);
			glut.glutSolidCube(1f);
			
		} else if(orientation == Orientation.VERTICAL) {
			gl.glScalef(0.1f, 1f, height);
			glut.glutSolidCube(1f);
			
		}
		
	}

}
