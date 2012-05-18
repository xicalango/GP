package gp.a04;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

import gp.world.Entity;

public class Treasure extends Entity {

	@Override
	protected void _render(GL2 gl, GLU glu, GLUT glut) {
		
		setMaterial(0.5f, 0.5f, 0.01f);
		
		glut.glutSolidCube(0.3f);

	}

}
