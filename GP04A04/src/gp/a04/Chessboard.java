package gp.a04;

import gp.world.Entity;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;


public class Chessboard extends Entity {

	@Override
	public void _render(GL2 gl, GLU glu, GLUT glut) {
			
		// Schachbrett zeichnen
		int z = 0;
		for (int i = -4; i < 4; i += 1) {
			for (int j = -4; j < 4; j += 1) {
				if (z % 2 == 0)
					setMaterial(0.2f, 0.17f, 0.15f);
				else
					setMaterial(1f, .98f, .9f);
				// geschlossenen Linienzug beginnen
				gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
				gl.glBegin(GL2.GL_POLYGON);
				// Punkte setzen
				gl.glVertex3f(i, j, 0f);
				gl.glVertex3f(i + 1f, j, 0f);
				gl.glVertex3f(i + 1f, j + 1f, 0f);
				gl.glVertex3f(i, j + 1f, 0f);
				// Linienzug beenden
				gl.glEnd();

				z++;
			}
			z++;
		}

		// Rahmen zeichnen
		// Material setzen
		setMaterial(1f, 1f, 0.f);
		// an die richtige Stelle verschieben
		gl.glTranslatef(4.25f, 0f, 0f);
		// und skalieren, damit der Wuerfel ein Quader wird
		gl.glScalef(1f, 16f, 1f);
		glut.glutSolidCube(.5f); // rechts

		gl.glTranslatef(-8.5f, 0f, 0f);
		glut.glutSolidCube(.5f); // links

		gl.glTranslatef(4.25f, 0f, 0f);
		gl.glScalef(18f, 1f / 16f, 1f);
		gl.glTranslatef(0.f, 4.25f, 0f);
		glut.glutSolidCube(.5f); // oben

		gl.glTranslatef(0.f, -8.5f, 0f);
		glut.glutSolidCube(0.5f); // unten

	}


}
