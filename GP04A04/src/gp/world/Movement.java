package gp.world;

import gp.morphing.Morpher;
import gp.morphing.MorpherStyle;

public class Movement implements Updateable{
	
	private float x1;
	private float y1;
	private float z1;	
	private float x2;
	private float y2;
	private float z2;
	
	public float getX2() {
		return x2;
	}


	public float getY2() {
		return y2;
	}


	public float getZ2() {
		return z2;
	}

	public float getX1() {
		return x1;
	}


	public float getY1() {
		return y1;
	}


	public float getZ1() {
		return z1;
	}

	private float t = 0;
	
	private float v;
	
	private Morpher morpher;
	
	public Movement(float x1, float y1, float z1, float x2, float y2, float z2, float v, MorpherStyle style) {
		this.x1 = x1;
		this.y1 = y1;
		this.z1 = z1;
		this.x2 = x2;
		this.y2 = y2;
		this.z2 = z2;
		this.v = v;
		morpher = style.getFactory().getMorpher(x1, y1, z1, x2, y2, z2, null);
	}

	
	public Movement(float x1, float y1, float z1, float x2, float y2, float z2) {
		this(x1,y1,z1,x2,y2,z2, 0.1f, MorpherStyle.LINEAR);
		
	}
	
	public Movement(float x1, float y1, float z1, float x2, float y2, float z2, float v) {
		this(x1,y1,z1,x2,y2,z2, v, MorpherStyle.LINEAR);
		
	}


	@Override
	public void update() {
		if(t < 1) {
			t += v;
			if( t > 1 ) {
				t = 1;
			}
		}
			
	}
	
	public boolean isFinished() {
		return t >= 1;
	}
	
	public float[] getCurrentPos() {
		return morpher.morph(t);
	}
	
}
