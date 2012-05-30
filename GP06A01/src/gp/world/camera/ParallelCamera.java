package gp.world.camera;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

public class ParallelCamera implements Camera {

	private float left = -1;
	private float right = 1;
	private float bottom = -1;
	private float top = 1;
	private float near = -1;
	private float far = 1;
	
	public void setParameters(float left, float right, float bottom, float top, float near, float far) {
		this.left = left;
		this.right = right;
		this.bottom = bottom;
		this.top = top;
		this.near = near;
		this.far = far;
	}
	
	public float getLeft() {
		return left;
	}



	public void setLeft(float left) {
		this.left = left;
	}



	public float getRight() {
		return right;
	}



	public void setRight(float right) {
		this.right = right;
	}



	public float getBottom() {
		return bottom;
	}



	public void setBottom(float bottom) {
		this.bottom = bottom;
	}



	public float getTop() {
		return top;
	}



	public void setTop(float top) {
		this.top = top;
	}



	public float getNear() {
		return near;
	}



	public void setNear(float near) {
		this.near = near;
	}



	public float getFar() {
		return far;
	}



	public void setFar(float far) {
		this.far = far;
	}



	@Override
	public void prepare(GL2 gl, GLU glu, GLUT glut) {
		gl.glOrtho(left,right,bottom,top,near,far);
	}



	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
}
