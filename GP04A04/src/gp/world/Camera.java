package gp.world;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.gl2.GLUT;

public class Camera {

	// x-Position der Kamera
	protected float eyeX;
	// y-Position der Kamera
	protected float eyeY;
	// z-Position der Kamera
	protected float eyeZ;
	// x-Position der Kamera
	protected float centerX;
	// y-Position der Kamera
	protected float centerY;
	// z-Position der Kamera
	protected float centerZ;
	// x-Koordinate des view-up-Vektors
	protected float viewUpX = 0;
	// y-Koordinate des view-up-Vektors
	protected float viewUpY = 0;
	// z-Koordinate des view-up-Vektors
	protected float viewUpZ = 1;
	// x-Endpunkt der Kimme
		
	public float getEyeX() {
		return eyeX;
	}
	
	public void setEyeX(float eyeX) {
		this.eyeX = eyeX;
	}
	
	public float getEyeY() {
		return eyeY;
	}
	
	public void setEyeY(float eyeY) {
		this.eyeY = eyeY;
	}
	
	public float getEyeZ() {
		return eyeZ;
	}
	
	public void setEyeZ(float eyeZ) {
		this.eyeZ = eyeZ;
	}
	
	public float getCenterX() {
		return centerX;
	}

	public void setCenterX(float centerX) {
		this.centerX = centerX;
	}

	public float getCenterY() {
		return centerY;
	}

	public void setCenterY(float centerY) {
		this.centerY = centerY;
	}

	public float getCenterZ() {
		return centerZ;
	}

	public void setCenterZ(float centerZ) {
		this.centerZ = centerZ;
	}

	public float getViewUpX() {
		return viewUpX;
	}
	
	public void setViewUpX(float viewUpX) {
		this.viewUpX = viewUpX;
	}
	
	public float getViewUpY() {
		return viewUpY;
	}
	
	public void setViewUpY(float viewUpY) {
		this.viewUpY = viewUpY;
	}
	
	public float getViewUpZ() {
		return viewUpZ;
	}
	
	public void setViewUpZ(float viewUpZ) {
		this.viewUpZ = viewUpZ;
	}
	
	public float getViewUpEndX() {
		return eyeX + viewUpX;
	}

	public float getViewUpEndY() {
		return eyeY + viewUpY;
	}

	public float getViewUpEndZ() {
		return eyeZ + viewUpZ;
	}
	
	public void setViewUpEndX( float viewUpEndX ) {
		viewUpX = viewUpEndX - eyeX;
	}

	public void setViewUpEndY( float viewUpEndY ) {
		viewUpY = viewUpEndY - eyeY;
	}

	public void setViewUpEndZ( float viewUpEndZ ) {
		viewUpZ = viewUpEndZ - eyeZ;
	}

	public void setEyeXYZ(float x, float y, float z) {
		eyeX = x;
		eyeY = y;
		eyeZ = z;
	}
	
	public void setCenterXYZ(float x, float y, float z) {
		centerX = x;
		centerY = y;
		centerZ = z;
	}
	
	public void setViewUpXYZ(float x, float y, float z) {
		viewUpX = x;
		viewUpY = y;
		viewUpZ = z;
	}
	
	public void printCameraInfo() {
		float produkt = eyeX * viewUpX + eyeY * viewUpY + eyeZ * viewUpZ;
		float length_eye = (float) Math.sqrt(eyeX * eyeX + eyeY * eyeY + eyeZ * eyeZ);
		float length_view_up = (float) Math.sqrt(viewUpX * viewUpX + viewUpY * viewUpY + viewUpZ * viewUpZ);
		float angle = (float) Math.acos(produkt / (length_eye * length_view_up));
		System.out.println("Winkel zwischen Blickrichtung und view-up-Vektor: " + angle / Math.PI * 180);
	}
	
	public void prepare(GL2 gl, GLU glu, GLUT glut) {
		System.out.println("Eye:    " + eyeX+ ", " + eyeY+ ", " + eyeZ);
		System.out.println("Center: " + centerX+ ", " + centerY+ ", " + centerZ);
		System.out.println("ViewUp: " +viewUpX+ ", " + viewUpY+ ", " + viewUpZ);
		glu.gluLookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, viewUpX, viewUpY, viewUpZ);
	}

	public void init() { }
	
	
}
