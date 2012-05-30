package gp.world.camera;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

public class ParallelCamera extends Camera {

	@Override
	public void prepare(GL2 gl, GLU glu, GLUT glut) {
		gl.glOrtho(-1, 1, -1, 1, -1, 1);
	}
	
}
