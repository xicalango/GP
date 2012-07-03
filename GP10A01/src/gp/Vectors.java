package gp;

public final class Vectors {
	private Vectors() {}
	
	public static float[] vectorArrayToFloatArray(Vector3D[] vs) {
		float result[] = new float[vs.length*3];
		
		int i = 0;
		
		for( Vector3D v : vs ) {
			result[i++] = v.getX();
			result[i++] = v.getY();
			result[i++] = v.getZ();
		}

		return result;
	}
}
