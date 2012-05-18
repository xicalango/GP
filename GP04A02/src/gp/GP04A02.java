package gp;

import java.util.ArrayList;
import java.util.List;

public class GP04A02 {

	public static boolean same_side(float[][] polygon1, float[][] polygon2) {

		Polygon3D p1 = Polygon3D.fromArray(polygon1);
		Polygon3D p2 = Polygon3D.fromArray(polygon2);

		System.out.println(p1);
		System.out.println(p2);
		
		Vector3D p11 = p1.getPoint(0);
		Vector3D p12 = p1.getPoint(1);
		Vector3D p13 = p1.getPoint(2);

		System.out.println(p11);
		System.out.println(p12);
		System.out.println(p13);
		
		Vector3D v12 = Vector3D.getBetween(p11, p12);
		Vector3D v13 = Vector3D.getBetween(p11, p13);
		
		System.out.println(v12);
		System.out.println(v13);

		Vector3D n = v12.vectorProduct(v13);
		
		System.out.println(n);
		
		Vector3D[] p2points = p2.getPoints();

		float s = Math.signum(n.scalarProduct(Vector3D.getBetween(p11, p2points[0])));

		System.out.println(s);
		
		for (int i = 1; i < p2points.length; i++) {

			System.out.println(n.scalarProduct(Vector3D.getBetween(p11, p2points[i])));
			if (Math.signum(n.scalarProduct(Vector3D.getBetween(p11, p2points[i]))) != s) {
				return false;
			}

		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<float[]> p1 = new ArrayList<float[]>();
		List<float[]> p2 = new ArrayList<float[]>();

		List<float[]> cur = null;

		float[] vec = new float[3];

		int c = 0;

		for (String a : args) {

			if (a.equals("p1")) {
				cur = p1;
			} else if (a.equals("p2")) {
				cur = p2;
			} else {
				float cf = Float.valueOf(a);
				
				vec[c] = cf;
				
				c++;
				if(c==3) {
					cur.add(vec);
					vec = new float[3];
					c=0;
				}
			}

		}
		
		float[][] p1a = p1.toArray(new float[0][]);
		float[][] p2a = p2.toArray(new float[0][]);
		
		System.out.println("Same Side: " + same_side(p1a, p2a));

	}

}