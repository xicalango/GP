package gp;

import java.util.Arrays;
import java.util.Iterator;

public class Polygon3D implements Iterable<Vector3D> {

	private Vector3D[] points;
	
	public Polygon3D(Vector3D[] points) {
		this.points = points.clone(); 
	}

	public Vector3D[] getPoints() {
		return points;
	}

	public void setPoints(Vector3D[] points) {
		this.points = points;
	}
	
	public Vector3D getPoint(int n) {
		return points[n];
	}
	
	public float[][] toArray() {
		float[][] result = new float[points.length][3];
		
		for( int i = 0; i < points.length; i++ ) {
			result[i] = points[i].toArray();
		}
		
		return result;
	}
	
	public static Polygon3D fromArray(float[][] a) {
		Vector3D[] points = new Vector3D[a.length];
		
		for( int i = 0; i < a.length; i++ ) {
			points[i] = Vector3D.fromArray(a[i]);
		}
		
		return new Polygon3D(points);
	}
	
	public int getNumPoints() {
		return points.length;
	}

	@Override
	public Iterator<Vector3D> iterator() {
		return Arrays.asList(points).iterator();
	}
	
}
