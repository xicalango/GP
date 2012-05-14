package xx.graprog1.morphing;

import java.awt.Polygon;

public interface MorphingFactory {

	public static class Linear implements MorphingFactory {

		@Override
		public Morphing getMorphing(Polygon... polygons) {
			if(polygons.length < 2) throw new IllegalArgumentException(); //TODO Message;
			
			return new SimpleMorphing(polygons[0], polygons[1]);
		}
		
	}
	
	public static class Quadratic implements MorphingFactory {

		@Override
		public Morphing getMorphing(Polygon... polygons) {
			if(polygons.length < 3) throw new IllegalArgumentException(); //TODO Message;

			return new QuadraticMorphing(polygons[0], polygons[1], polygons[2]);
		}
		
	}
	
	public static class Cubic implements MorphingFactory {

		@Override
		public Morphing getMorphing(Polygon... polygons) {
			if(polygons.length < 4) throw new IllegalArgumentException(); //TODO Message;

			return new CubicMorphing(polygons[0], polygons[1], polygons[2], polygons[3]);
		}
		
	}
	
	public Morphing getMorphing(Polygon... polygons);
	
}
