package gp.gp06a01;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

import gp.world.Entity;

public class SimultaneousContrastExample extends Entity {

	@Override
	protected void _render(GL2 gl, GLU glu, GLUT glut) {
		
		gl.glBegin(GL2.GL_QUADS);

		for( int i = 0; i < 5; i++) {
		
			gl.glColor3f((i/10f)+.2f, (i/10f)+.2f, (i/10f)+.2f);
			gl.glVertex3f(2*i, 0, 0);
			gl.glVertex3f(2*i+2, 0, 0);
			gl.glVertex3f(2*i+2, 2, 0);
			gl.glVertex3f(2*i, 2, 0);
			
		}

		gl.glEnd();

		gl.glColor3f(.8f, .8f, .8f);
		
		gl.glTranslatef(1, 1, 0);
		
		for( int i = 0; i < 5; i++ ) {

			glut.glutSolidCylinder(.5, 1, 20, 1);
			
			gl.glTranslatef(2, 0, 0);
		}
		
	}

}
