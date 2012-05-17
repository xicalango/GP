package gp.morphing;

public class LinearMorpher implements Morpher{

	public static class Factory implements MorphingFactory {

		@Override
		public Morpher getMorpher(float x1, float y1, float z1, float x2, float y2, float z2, float[][] midPoints) {
			return new LinearMorpher(x1, y1, z1, x2, y2, z2);
		}
		
	}
	
	private float x1;
	private float y1;
	private float z1;
	
	private float x2;
	private float y2;
	private float z2;
	
	public LinearMorpher(float x1, float y1, float z1, float x2, float y2, float z2) {
		this.x1 = x1;
		this.y1 = y1;
		this.z1 = z1;
		
		this.x2 = x2;
		this.y2 = y2;
		this.z2 = z2;
	}

	@Override
	public float[] morph(float t) {
		
		float[] result = new float[3];
		
		result[0] = (1-t) * x1 + t * x2;
		result[1] = (1-t) * y1 + t * y2;
		result[2] = (1-t) * z1 + t * z2;
		
		return result;
	}

}
