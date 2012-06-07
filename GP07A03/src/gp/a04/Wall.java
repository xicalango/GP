package gp.a04;

import gp.utils.TexturedSolidCube;
import gp.world.Entity;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

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

//		gl.glEnable(GL2.GL_TEXTURE_GEN_S);
//	    gl.glEnable(GL2.GL_TEXTURE_GEN_T);
		
	    TexturedSolidCube cube = new TexturedSolidCube();
	    
		bindTexture(gl, "wall");
		
		if(orientation == Orientation.HORIZONTAL) {
			gl.glScalef(1f, 0.1f, height);
			cube.render(gl, glu, glut);
			//glut.glutSolidCube(1f);
			
		} else if(orientation == Orientation.VERTICAL) {
			gl.glScalef(0.1f, 1f, height);
			cube.render(gl, glu, glut);
			//glut.glutSolidCube(1f);
			
		}
		
//		gl.glDisable(GL2.GL_TEXTURE_GEN_S);
//	    gl.glDisable(GL2.GL_TEXTURE_GEN_T);
		
		unbindTexture(gl);
	}

}
