package gp.gp06a01;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

import gp.world.Entity;

public class StepTabExample extends Entity {

	@Override
	protected void _render(GL2 gl, GLU glu, GLUT glut) {

		gl.glBegin(GL2.GL_QUADS);

		for( int i = 0; i < 7; i++) {
		
			gl.glColor3f(.7f-(i/10f), .7f-(i/10f), .7f-(i/10f));
			gl.glVertex3f(i, 0, 0);
			gl.glVertex3f(i+1, 0, 0);
			gl.glVertex3f(i+1, 2, 0);
			gl.glVertex3f(i, 2, 0);
		
		}

		gl.glEnd();

	}

}
