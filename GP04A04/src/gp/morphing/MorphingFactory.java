package gp.morphing;

public interface MorphingFactory {

	Morpher getMorpher( float x1, float y1, float z1, float x2, float y2, float z2, float[][] midPoints);
	
}
