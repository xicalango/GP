package gp.planets;


public class Earth extends Planet {

	private final float decline = 23.44f;
	private final float rx = (float) Math.cos(decline);
	private final float rz = (float) Math.sin(decline);
	
	public Earth() {
		super("earth");
		
		setRadius(1);
		
		setRotationVelocity(-1f);
		
		setRz(1f);
		
		setDecline(23.44f);
		
	}

}
