package xx.graprog1.morphing;

import java.awt.Point;
import java.awt.Polygon;

public class SimpleMorphing extends AbstractMorphing {

	public SimpleMorphing(Polygon polygonA, Polygon polygonB) {
		super(polygonA, polygonB);
	}

	@Override
	public Point morphFn(Point a, Point b, int npoint, double t) {
		final int x = (int)((1-t)*a.x + t*b.x);
		final int y = (int)((1-t)*a.y + t*b.y);
		
		return new Point(x, y);
	}
	
}
