package gp;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public interface Renderable {
	public void render( GL2 gl, GLU glu );
}
