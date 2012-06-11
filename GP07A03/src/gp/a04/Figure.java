package gp.a04;

import gp.world.Entity;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.gl2.GLUT;


public class Figure extends Entity {

	private Labyrinth labyrinth;
	
	@Override
	public void init(GL2 gl, GLU glu, GLUT glut) {
		super.init(gl, glu, glut);
			
	}
	
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
			
		final Margins margins = labyrinth.getMargins();
		
		if(margins != null) {
			if(gx < margins.getMarginX1() || gx > margins.getMarginX2()) {
				return false;
			}
			if(gy < margins.getMarginY1() || gy > margins.getMarginY2()) {
				return false;
			}
		}
		
		final boolean[][][] solidMask = labyrinth.getSolidMask();
		
		final int xPos = (int)(x + gx + 8);
		final int yPos = (int)(y + gy + 8);
		final int zPos = 0; //TODO zPos berücksichtigen
		
		return !solidMask[xPos][yPos][zPos];
	}

	@Override
	public void _render(GL2 gl, GLU glu, GLUT glut) {
	
		//FUss
		gl.glTranslatef(0f, 0f, 0.001f);
		
		bindTexture(gl, "ausflugschnitt.jpg");
		
		GLUquadric cylinderQuadric = glu.gluNewQuadric();
		glu.gluQuadricTexture(cylinderQuadric, true);
        glu.gluQuadricDrawStyle(cylinderQuadric, GLU.GLU_FILL);
        glu.gluQuadricNormals(cylinderQuadric, GLU.GLU_SMOOTH);
        glu.gluCylinder(cylinderQuadric, .33, .33, .25, 32, 5);

        gl.glTranslatef(0.0f, 0.0f, -0.001f);
		
        
		// Bauch
		gl.glTranslatef(0.0f, 0.0f, .25f);
		
		GLUquadric coneQuadric = glu.gluNewQuadric();
		glu.gluQuadricTexture(coneQuadric, true);
        glu.gluQuadricDrawStyle(coneQuadric, GLU.GLU_FILL);
        glu.gluQuadricNormals(coneQuadric, GLU.GLU_SMOOTH);
        glu.gluCylinder(coneQuadric, .33, 0, 1.33, 32, 32);
		
		//glut.glutSolidCone(.33, 1.33, 32, 32);

        bindTexture(gl, "derp.jpg");
        
		// Kopf
		gl.glTranslatef(0f, 0f, 1.1f);
		
		GLUquadric sphere_quadric = glu.gluNewQuadric();
        glu.gluQuadricTexture(sphere_quadric, true);
        glu.gluQuadricDrawStyle(sphere_quadric, GLU.GLU_FILL);
        glu.gluQuadricNormals(sphere_quadric, GLU.GLU_SMOOTH);
        glu.gluSphere(sphere_quadric, 0.33f, 32, 32);
		
		//glut.glutSolidSphere(.33, 32, 32);
		
		gl.glTranslatef(0f, 0f, -1.35f);
		
        unbindTexture(gl);
	}



}
