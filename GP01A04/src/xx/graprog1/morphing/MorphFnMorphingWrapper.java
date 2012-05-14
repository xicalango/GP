package xx.graprog1.morphing;

import java.awt.Point;
import java.awt.Polygon;

public class MorphFnMorphingWrapper extends AbstractMorphing {

	private MorphFn morphFn;
	
	public MorphFnMorphingWrapper(Polygon polygonA, Polygon polygonB, MorphFn morphFn) {
		super(polygonA, polygonB);
		
		this.morphFn = morphFn;
	}

	@Override
	public Point morphFn(Point a, Point b, int nPoint, double t) {
		return morphFn.morphFn(a, b, nPoint, t);
	}

}
