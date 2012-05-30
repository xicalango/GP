package gp.gp06a01;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

import gp.world.Entity;

public class RadiatingLinesExample extends Entity {

	@Override
	protected void _render(GL2 gl, GLU glu, GLUT glut) {
		
		
		gl.glScalef(.3f, .3f, 1);
		
		gl.glBegin(GL2.GL_QUADS);
		
		for( int i = 12; i >= 1; i-- ) {
						
			gl.glColor3f(1-(i/12f), 1-(i/12f), 1-(i/12f));
			
			gl.glVertex3f(-i,-i,0);
			gl.glVertex3f(i,-i,0);
			gl.glVertex3f(i,i,0);
			gl.glVertex3f(-i,i,0);
		}
		
		gl.glEnd();

	}

}
