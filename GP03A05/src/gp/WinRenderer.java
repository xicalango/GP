package gp;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.fixedfunc.GLMatrixFunc;
import javax.media.opengl.glu.GLU;

public class WinRenderer extends GLCanvas implements GLEventListener {

	private static final long serialVersionUID = 1L;

	private Renderable toRender;

	public WinRenderer(Renderable toRender) {
		addGLEventListener(this);

		this.toRender = toRender;
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void display(GLAutoDrawable drawable) {

		GL2 gl = drawable.getGL().getGL2();
		GLU glu = new GLU();

		gl.glClear(GL.GL_COLOR_BUFFER_BIT);

		gl.glLoadIdentity();

		glu.gluLookAt(3, 0, 1, 0, 0, 0, 0, 0, 1);

		toRender.render(gl, glu);

		gl.glFlush();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		final GL2 gl = drawable.getGL().getGL2();
		final GLU glu = new GLU();

		gl.glViewport(0, 0, width, height);

		gl.glMatrixMode(GLMatrixFunc.GL_PROJECTION);

		gl.glLoadIdentity();

		glu.gluPerspective(70.0, 1, 0.0, 40.0);
		//gl.glOrtho(-1, 1, -1, 1, -1, 1);

		gl.glMatrixMode(GLMatrixFunc.GL_MODELVIEW);

	}

}