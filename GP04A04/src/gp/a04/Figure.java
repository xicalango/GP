package gp.a04;

import gp.world.Entity;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;


public class Figure extends Entity {

	@Override
	public void _render(GL2 gl, GLU glu, GLUT glut) {
		
		setMaterial(0.7f, 0f, 0.07f);
	
		gl.glTranslatef(0f, 0f, 0.001f);
		
		glut.glutSolidCylinder(.33, .25, 32, 5);
		gl.glTranslatef(0.0f, 0.0f, -0.001f);
		gl.glTranslatef(0.0f, 0.0f, .25f);
		// Bauch
		glut.glutSolidCone(.33, 1.33, 32, 32);
		gl.glTranslatef(0f, 0f, 1.1f);
		// Kopf
		glut.glutSolidSphere(.33, 32, 32);
		
		gl.glTranslatef(0f, 0f, -1.35f);
		
	}


}
