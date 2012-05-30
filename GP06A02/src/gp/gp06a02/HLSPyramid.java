package gp.gp06a02;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

import gp.world.Entity;

public class HLSPyramid extends Entity{
	
	private float height = 1.5f;
	
	@Override
	protected void _render(GL2 gl, GLU glu, GLUT glut) {
		
		gl.glBegin(GL2.GL_TRIANGLES);
		
		//schwarz-blau-magenta
		gl.glColor3f(0, 0, 0); 
		gl.glVertex3f(0, 0, -height);
		
		gl.glColor3f(0, 0, 1);
		gl.glVertex3f(-1, -2, 0);

		gl.glColor3f(1, 0, 1);
		gl.glVertex3f(1, -2, 0);


		//schwarz-magenta-rot
		gl.glColor3f(0, 0, 0);
		gl.glVertex3f(0, 0, -height);
		
		gl.glColor3f(1, 0, 1);
		gl.glVertex3f(1, -2, 0);

		gl.glColor3f(1, 0, 0);
		gl.glVertex3f(2, 0, 0);


		//schwarz-rot-gelb
		gl.glColor3f(0, 0, 0);
		gl.glVertex3f(0, 0, -height);
		
		gl.glColor3f(1, 0, 0);
		gl.glVertex3f(2, 0, 0);

		gl.glColor3f(1, 1, 0);
		gl.glVertex3f(1, 2, 0);


		//schwarz-gelb-grün
		gl.glColor3f(0, 0, 0);
		gl.glVertex3f(0, 0, -height);
		
		gl.glColor3f(1, 1, 0);
		gl.glVertex3f(1, 2, 0);

		gl.glColor3f(0, 1, 0);
		gl.glVertex3f(-1, 2, 0);


		//schwarz-grün-cyan
		gl.glColor3f(0, 0, 0);
		gl.glVertex3f(0, 0, -height);
		
		gl.glColor3f(0, 1, 0);
		gl.glVertex3f(-1, 2, 0);

		gl.glColor3f(0, 1, 1);
		gl.glVertex3f(-2, 0, 0);


		//schwarz-cyan-blau
		gl.glColor3f(0, 0, 0);
		gl.glVertex3f(0, 0, -height);
		
		gl.glColor3f(0, 1, 1);
		gl.glVertex3f(-2, 0, 0);

		gl.glColor3f(0, 0, 1);
		gl.glVertex3f(-1, -2, 0);

		
		
		
		//weiß-blau-magenta
		gl.glColor3f(1, 1, 1); 
		gl.glVertex3f(0, 0, height);
		
		gl.glColor3f(0, 0, 1);
		gl.glVertex3f(-1, -2, 0);

		gl.glColor3f(1, 0, 1);
		gl.glVertex3f(1, -2, 0);


		//weiß-magenta-rot
		gl.glColor3f(1, 1, 1); 
		gl.glVertex3f(0, 0, height);
		
		gl.glColor3f(1, 0, 1);
		gl.glVertex3f(1, -2, 0);

		gl.glColor3f(1, 0, 0);
		gl.glVertex3f(2, 0, 0);


		//weiß-rot-gelb
		gl.glColor3f(1, 1, 1); 
		gl.glVertex3f(0, 0, height);
		
		gl.glColor3f(1, 0, 0);
		gl.glVertex3f(2, 0, 0);

		gl.glColor3f(1, 1, 0);
		gl.glVertex3f(1, 2, 0);


		//weiß-gelb-grün
		gl.glColor3f(1, 1, 1); 
		gl.glVertex3f(0, 0, height);
		
		gl.glColor3f(1, 1, 0);
		gl.glVertex3f(1, 2, 0);

		gl.glColor3f(0, 1, 0);
		gl.glVertex3f(-1, 2, 0);


		//weiß-grün-cyan
		gl.glColor3f(1, 1, 1); 
		gl.glVertex3f(0, 0, height);
		
		gl.glColor3f(0, 1, 0);
		gl.glVertex3f(-1, 2, 0);

		gl.glColor3f(0, 1, 1);
		gl.glVertex3f(-2, 0, 0);


		//weiß-cyan-blau
		gl.glColor3f(1, 1, 1); 
		gl.glVertex3f(0, 0, height);
		
		gl.glColor3f(0, 1, 1);
		gl.glVertex3f(-2, 0, 0);

		gl.glColor3f(0, 0, 1);
		gl.glVertex3f(-1, -2, 0);

		
		gl.glEnd();
		
	}
	
}
