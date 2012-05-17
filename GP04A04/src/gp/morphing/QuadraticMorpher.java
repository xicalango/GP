package gp.morphing;

public class QuadraticMorpher implements Morpher {

	public static class Factory implements MorphingFactory {
		@Override
		public Morpher getMorpher(float x1, float y1, float z1, float x2, float y2, float z2, float[][] midPoints) {
			return new QuadraticMorpher(
					x1, y1, z1, 
					midPoints[0][0], midPoints[0][1], midPoints[0][2],
					x2, y2, z2);
		}
		
	}
	
	private float x1;
	private float y1;
	private float z1;
	
	private float x2;
	private float y2;
	private float z2;
	
	private float x3;
	private float y3;
	private float z3;
	
	private QuadraticMorpher(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3) {
		this.x1 = x1;
		this.y1 = y1;
		this.z1 = z1;
		this.x2 = x2;
		this.y2 = y2;
		this.z2 = z2;
		this.x3 = x3;
		this.y3 = y3;
		this.z3 = z3;
	}

	@Override
	public float[] morph(float t) {
		return new float[] {
			(1-t)*(1-t) * x1 + 2*(1-t)*t*x2 + t*t*x3,
			(1-t)*(1-t) * y1 + 2*(1-t)*t*y2 + t*t*z3,
			(1-t)*(1-t) * y1 + 2*(1-t)*t*y2 + t*t*z3,
		};
	}

}
