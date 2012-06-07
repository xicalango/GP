package gp.planets;

import gp.world.Entity;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;

public class Planet extends Entity {

	private static final int NUM_STACKS = 32;
	private static final int NUM_SLICES = 32;
	
	
	private final String planetName;
	private double radius = 1.0;
	
	private float rotationVelocity = 0f;
	private float rotPhi = 0f;
	private float rx,ry,rz;
	
	private float decline = 0f;
	private float declineRx = (float) Math.cos(decline);
	private float declineRz = (float) Math.sin(decline);
	

	public Planet(String planetName) {
		this.planetName = planetName;
	}
	
	public String getPlanetName() {
		return planetName;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public float getRotationVelocity() {
		return rotationVelocity;
	}

	public void setRotationVelocity(float rotationVelocity) {
		this.rotationVelocity = rotationVelocity;
	}

	public float getRx() {
		return rx;
	}

	public void setRx(float rx) {
		this.rx = rx;
	}

	public float getRy() {
		return ry;
	}

	public void setRy(float ry) {
		this.ry = ry;
	}

	public float getRz() {
		return rz;
	}

	public void setRz(float rz) {
		this.rz = rz;
	}

	@Override
	protected void _render(GL2 gl, GLU glu, GLUT glut) {
		
		bindTexture(gl, planetName);
		
		gl.glRotatef(decline, 1f, 0, 1f);
		
		gl.glRotatef(rotPhi, rx, ry, rz);
		
		GLUquadric sphereQuadric = glu.gluNewQuadric();
        glu.gluQuadricTexture(sphereQuadric, true);
        glu.gluQuadricDrawStyle(sphereQuadric, GLU.GLU_FILL);
        glu.gluQuadricNormals(sphereQuadric, GLU.GLU_SMOOTH);
        
        glu.gluSphere(sphereQuadric, radius, NUM_SLICES, NUM_STACKS);
		
		unbindTexture(gl);
	}

	public float getDecline() {
		return decline;
	}

	public void setDecline(float decline) {
		this.decline = decline;
		
		declineRx = (float) Math.cos(decline);
		declineRz = (float) Math.sin(decline);
	}

	@Override
	public void update() {
		super.update();
		
		rotPhi += rotationVelocity;
	}
	
}
