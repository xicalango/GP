package gp.a04;

import gp.world.Entity;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;


public class Figure extends Entity {

	private Labyrinth labyrinth;
	
	public Labyrinth getLabyrinth() {
		return labyrinth;
	}

	public void setLabyrinth(Labyrinth labyrinth) {
		this.labyrinth = labyrinth;
	}
	
	@Override
	protected boolean canWalkTo(float gx, float gy, float gz) {
		if(labyrinth == null)
			return super.canWalkTo(gx, gy, gz);
		
		boolean[][][] solidMask = labyrinth.getSolidMask();
		
		final int xPos = (int)(x + gx + 8);
		final int yPos = (int)(y + gy + 8);
		final int zPos = 0; //TODO zPos berücksichtigen
		
		return !solidMask[xPos][yPos][zPos];
	}

	@Override
	public void _render(GL2 gl, GLU glu, GLUT glut) {
		
		setMaterial(0.7f, 0f, 0.07f);
	
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



}
