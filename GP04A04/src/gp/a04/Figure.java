package gp.a04;

import gp.world.Entity;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;


public class Figure extends Entity {

	private float r = 0.7f;
	private float g = 0f;
	private float b = 0.07f;
	
	@Override
	public void _render(GL2 gl, GLU glu, GLUT glut) {
		
		setMaterial(r, g, b);
	
		//FUss
		gl.glTranslatef(0f, 0f, 0.001f);
		glut.glutSolidCylinder(.33, .25, 32, 5);
		gl.glTranslatef(0.0f, 0.0f, -0.001f);
		
		// Bauch
		gl.glTranslatef(0.0f, 0.0f, .25f);
		glut.glutSolidCone(.33, 1.33, 32, 32);

		// Kopf
		gl.glTranslatef(0f, 0f, 1.1f);
		glut.glutSolidSphere(.33, 32, 32);
		
		gl.glTranslatef(0f, 0f, -1.35f);
		
	}

	public float getR() {
		return r;
	}

	public void setR(float r) {
		this.r = r;
	}

	public float getG() {
		return g;
	}

	public void setG(float g) {
		this.g = g;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}



}
