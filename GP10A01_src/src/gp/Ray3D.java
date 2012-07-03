package gp;

public class Ray3D {

	private Vector3D start;
	private Vector3D dir;
	
	private Ray3D(Vector3D start, Vector3D dir) {
		super();
		this.start = start;
		this.dir = dir;
	}
	public Vector3D getStart() {
		return start;
	}
	public void setStart(Vector3D start) {
		this.start = start;
	}
	public Vector3D getDir() {
		return dir;
	}
	public void setDir(Vector3D dir) {
		this.dir = dir;
	}
	
	public Vector3D[] intersect( Intersectionable is ) {
		return is.getIntersections(this);
	}
	
	public static Ray3D fromArrays( float[] startArray, float[] dirArray ) {
		Vector3D start = Vector3D.fromArray(startArray);
		Vector3D dir = Vector3D.fromArray(dirArray);
		
		return new Ray3D(start, dir);
	}
	
}
