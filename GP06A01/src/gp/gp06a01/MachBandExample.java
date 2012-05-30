package gp.gp06a01;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

import gp.world.Entity;

public class MachBandExample extends Entity{

	@Override
	protected void _render(GL2 gl, GLU glu, GLUT glut) {

		gl.glBegin(GL2.GL_QUADS);
		
		gl.glColor3f(.55f, .55f, .55f);

		gl.glVertex3f(0, 0, 0);
		gl.glVertex3f(5, 0, 0);
		gl.glVertex3f(5, 2, 0);
		gl.glVertex3f(0, 2, 0);
		
		gl.glEnd();
		
		gl.glScalef(.9f, .8f, 1);
		
		gl.glTranslatef(.1f, .2f, 0);
		
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glColor3f(0, 0, 0);
		gl.glVertex3f(0, 0, 0);
		gl.glVertex3f(2, 0, 0);
		gl.glVertex3f(2, 2, 0);
		gl.glVertex3f(0, 2, 0);
		
		gl.glColor3f(0, 0, 0);
		gl.glVertex3f(2, 0, 0);
		gl.glVertex3f(2, 2, 0);
		
		gl.glColor3f(1, 1, 1);
		gl.glVertex3f(3, 2, 0);
		gl.glVertex3f(3, 0, 0);
		
		gl.glColor3f(1, 1, 1);
		gl.glVertex3f(3, 0, 0);
		gl.glVertex3f(5, 0, 0);
		gl.glVertex3f(5, 2, 0);
		gl.glVertex3f(3, 2, 0);
		
		gl.glEnd();
		
	}

}
