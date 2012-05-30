package gp.gp06a02;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

import gp.world.Entity;

public class RGBCube extends Entity {

	@Override
	protected void _render(GL2 gl, GLU glu, GLUT glut) {
		
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glColor3f(0, 0, 0);
		gl.glVertex3f(-1, -1, -1);

		gl.glColor3f(1, 0, 0);
		gl.glVertex3f(1, -1, -1);

		gl.glColor3f(1, 1, 0);
		gl.glVertex3f(1, 1, -1);

		gl.glColor3f(0, 1, 0);
		gl.glVertex3f(-1, 1, -1);
		
		
		gl.glColor3f(0, 0, 0);
		gl.glVertex3f(-1, -1, -1);

		gl.glColor3f(1, 0, 0);
		gl.glVertex3f(1, -1, -1);

		gl.glColor3f(1, 0, 1);
		gl.glVertex3f(1, -1, 1);

		gl.glColor3f(0, 0, 1);
		gl.glVertex3f(-1, -1, 1);
		
		
		gl.glColor3f(0, 0, 0);
		gl.glVertex3f(-1, -1, -1);

		gl.glColor3f(0, 1, 0);
		gl.glVertex3f(-1, 1, -1);

		gl.glColor3f(0, 1, 1);
		gl.glVertex3f(-1, 1, 1);

		gl.glColor3f(0, 0, 1);
		gl.glVertex3f(-1, -1, 1);
		
		
		gl.glColor3f(0, 0, 1);
		gl.glVertex3f(-1, -1, 1);

		gl.glColor3f(1, 0, 1);
		gl.glVertex3f(1, -1, 1);

		gl.glColor3f(1, 1, 1);
		gl.glVertex3f(1, 1, 1);

		gl.glColor3f(0, 1, 1);
		gl.glVertex3f(-1, 1, 1);
		
		
		gl.glColor3f(1, 0, 0);
		gl.glVertex3f(1, -1, -1);

		gl.glColor3f(1, 1, 0);
		gl.glVertex3f(1, 1, -1);

		gl.glColor3f(1, 1, 1);
		gl.glVertex3f(1, 1, 1);

		gl.glColor3f(1, 0, 1);
		gl.glVertex3f(1, -1, 1);
		
		
		gl.glColor3f(0, 1, 0);
		gl.glVertex3f(-1, 1, -1);

		gl.glColor3f(1, 1, 0);
		gl.glVertex3f(1, 1, -1);

		gl.glColor3f(1, 1, 1);
		gl.glVertex3f(1, 1, 1);

		gl.glColor3f(0, 1, 1);
		gl.glVertex3f(-1, 1, 1);
		
		gl.glEnd();
		
	}

}
