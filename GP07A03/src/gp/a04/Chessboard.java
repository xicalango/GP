package gp.a04;

import gp.utils.TexturedSolidCube;
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
					bindTexture(gl, "blackMarble.jpg");
				else
					bindTexture(gl, "whiteMarble.jpg");
				// geschlossenen Linienzug beginnen
				gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
				gl.glBegin(GL2.GL_POLYGON);
				// Punkte setzen
				gl.glTexCoord2f(0, 0); gl.glVertex3f(i, j, 0f);
				gl.glTexCoord2f(1, 0); gl.glVertex3f(i + 1f, j, 0f);
				gl.glTexCoord2f(1, 1); gl.glVertex3f(i + 1f, j + 1f, 0f);
				gl.glTexCoord2f(0, 1); gl.glVertex3f(i, j + 1f, 0f);
				// Linienzug beenden
				gl.glEnd();

				z++;
			}
			z++;
		}
		
		unbindTexture(gl);

		// Rahmen zeichnen
		
		TexturedSolidCube tsc = new TexturedSolidCube();
		tsc.setSize(.5f);
		
		bindTexture(gl, "wall2");
		
		// an die richtige Stelle verschieben
		gl.glTranslatef(4.25f, 0f, 0f);

		// und skalieren, damit der Wuerfel ein Quader wird
		gl.glScalef(1f, 16f, 3f);
		
		tsc.render(gl, glu, glut);// rechts

		gl.glTranslatef(-8.5f, 0f, 0f);
		tsc.render(gl, glu, glut);// links

		gl.glTranslatef(4.25f, 0f, 0f);
		gl.glScalef(18f, 1f / 16f, 1f);
		gl.glTranslatef(0.f, 4.25f, 0f);
		tsc.render(gl, glu, glut);// oben

		gl.glTranslatef(0.f, -8.5f, 0f);
		tsc.render(gl, glu, glut);// unten

		unbindTexture(gl);
		
	}


}
