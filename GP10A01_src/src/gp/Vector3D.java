package gp;

import java.security.InvalidParameterException;


public class Vector3D {

	private float x;
	private float y;
	private float z;
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getZ() {
		return z;
	}
	public void setZ(float z) {
		this.z = z;
	}
	
	public Vector3D() {
		this(0f,0f,0f);
	}
	
	public Vector3D(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3D(Vector3D copy) {
		this.x = copy.x;
		this.y = copy.y;
		this.z = copy.z;
	}
	
	public float scalarProduct(Vector3D b) {
		return x * b.x + y * b.y + z * b.z;
	}
	
	public float getNormSquared() {
		return scalarProduct(this);
	}
	
	public double getNorm() {
		return Math.sqrt(getNormSquared());
	}
	
	public Vector3D vectorProduct(Vector3D b) {
		Vector3D result = new Vector3D();
		
		result.x = y * b.z - z * b.y;
		result.y = z * b.x - x * b.z;
		result.z = x * b.y - y * b.x;
		
		return result;
	}
	
	public Vector3D add(Vector3D b)  {
		Vector3D r = new Vector3D(this);
		
		r.x += b.x;
		r.y += b.y;
		r.z += b.z;
		
		return r;
	}
	
	public Vector3D sub(Vector3D b) {
		Vector3D r = new Vector3D(this);
		
		r.x -= b.x;
		r.y -= b.y;
		r.z -= b.z;
		
		return r;
	}
	
	public Vector3D neg() {
		Vector3D r = new Vector3D(this);
		
		r.x = -r.x;
		r.y = -r.y;
		r.z = -r.z;
		
		return r;
	}
	
	public float getComponent(int n) {
		switch(n) {
		case 0:
			return x;
		case 1:
			return y;
		case 2:
			return z;
		default:
			throw new InvalidParameterException();
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		result = prime * result + Float.floatToIntBits(z);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector3D other = (Vector3D) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z))
			return false;
		return true;
	}
	public float[] toArray() {
		return new float[] { x,y,z };
	}

	public static Vector3D fromArray(float[] a)  {
		return new Vector3D(a[0], a[1], a[2]);
	}
	
	public static Vector3D getBetween(Vector3D a, Vector3D b) {
		return b.sub(a);
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + "," + z + ")";
	}
	
	
}
