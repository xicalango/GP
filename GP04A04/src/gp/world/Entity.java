package gp.world;


import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;


public abstract class Entity implements Renderable {

	protected float x;
	protected float y;
	protected float z;
	
	protected float rx;
	protected float ry;
	protected float rz;
	
	private GL2 gl;
	private GLU glu;
	private GLUT glut;

	public Entity() {
		this(0f,0f,0f,0f,0f,0f);
	}
	
	public Entity(float x, float y, float z, float rx, float ry, float rz) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.rx = rx;
		this.ry = ry;
		this.rz = rz;
	}

	public Entity(float x, float y, float z) {
		this(x,y,z,0f,0f,0f);
	}
	
	@Override
	public void render(GL2 gl, GLU glu, GLUT glut) {
		
//		gl.glLoadIdentity();
		
		gl.glTranslatef(x, y, z);
		
		this.gl = gl;
		this.glu = glu;
		this.glut = glut;
		
		_render(gl, glu, glut);
		
		gl.glTranslatef(-x, -y, -z);
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
	

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public void setRx(float rx) {
		this.rx = rx;
	}

	public void setRy(float ry) {
		this.ry = ry;
	}

	public void setRz(float rz) {
		this.rz = rz;
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

	public float getRx() {
		return rx;
	}

	public float getRy() {
		return ry;
	}

	public float getRz() {
		return rz;
	}

}
