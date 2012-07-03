package gp;

import java.util.Arrays;

public class GP10 {

	public static void log(String... text) {
		for(String t : text) {
			System.out.println(t);
		}
	}
	
	public static float[] Schnittpunkte_Zylinder(float[] Aufpunkt, float[] Richtungsvektor) {
		Ray3D axis = Ray3D.fromArrays(Aufpunkt, Richtungsvektor);
		
		Vector3D[] result = axis.intersect(new Cylinder());
		
		return Vectors.vectorArrayToFloatArray(result);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		float[] sz = Schnittpunkte_Zylinder(new float[] {-2 , 0, 1}, new float[] {1,0,0});
		
		System.out.println(Arrays.toString(sz));

	}

}
