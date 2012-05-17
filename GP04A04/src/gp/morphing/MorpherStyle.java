package gp.morphing;

public enum MorpherStyle {
	LINEAR(new LinearMorpher.Factory()),
	QUADRATIC(new QuadraticMorpher.Factory());
	
	private MorphingFactory factory;

	private MorpherStyle(MorphingFactory factory) {
		this.factory = factory;
	}

	public MorphingFactory getFactory() {
		return factory;
	}
	
	
}
