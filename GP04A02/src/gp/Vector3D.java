package gp;

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
	
	
	public float[] toArray() {
		return new float[] { x,y,z };
	}

	public static Vector3D fromArray(float[] a)  {
		return new Vector3D(a[0], a[1], a[2]);
	}
	
	
	
}
