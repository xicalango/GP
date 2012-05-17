package gp.world;


import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;


public abstract class Entity implements Renderable {

	protected float x;
	protected float y;
	protected float z;
	
	protected float alpha; //blickrichtung
	
	private GL2 gl;
	private GLU glu;
	private GLUT glut;

	public Entity() {
		this(0f,0f,0f,0f);
	}
	
	public Entity(float x, float y, float z, float alpha) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.alpha = alpha;
	}

	public Entity(float x, float y, float z) {
		this(x,y,z,0f);
	}
	
	@Override
	public void render(GL2 gl, GLU glu, GLUT glut) {
		
//		gl.glLoadIdentity();
		
		gl.glTranslatef(x, y, z);
		gl.glRotatef(alpha, 0f, 0f, 1f);
		
		this.gl = gl;
		this.glu = glu;
		this.glut = glut;
		
		_render(gl, glu, glut);
		
		//gl.glTranslatef(-x, -y, -z);
	}

	protected abstract void _render(GL2 gl, GLU glu, GLUT glut);
	
	protected void setMaterial(float r, float g, float b) {
		float mat_ambient[] = { r / 3f, g / 3f, b / 3f, 1.0f };
		float mat_diffuse[] = { r, g, b, 1.0f };
		float mat_specular[] = { 0.70f, 0.70f, 0.70f, 1.0f };
		float mat_shininess = 32f;

		gl.glMaterialfv(GL.GL_FRONT, GL2.GL_AMBIENT, mat_ambient, 0);
		gl.glMaterialfv(GL.GL_FRONT, GL2.GL_DIFFUSE, mat_diffuse, 0);
		gl.glMaterialfv(GL.GL_FRONT, GL2.GL_SPECULAR, mat_specular, 0);
		gl.glMaterialf(GL.GL_FRONT, GL2.GL_SHININESS, mat_shininess);

	}
	
	
	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}
	
	public float getDirX() {
		return x + (float)Math.cos(alpha);
	}
	
	public float getDirY() {
		return y + (float)Math.sin(alpha);
	}

}
