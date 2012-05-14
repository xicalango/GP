package xx.graprog1.morphing;

import java.awt.Point;
import java.awt.Polygon;

public class QuadraticMorphing extends AbstractMorphing {

	private Polygon polygonC;
	
	public Polygon getPolygonC() {
		return polygonC;
	}

	public QuadraticMorphing(Polygon polygonA, Polygon polygonB,
			Polygon polygonC) {
		super(polygonA, polygonB);
		
		if(polygonC.npoints != polygonA.npoints)
			throw new IllegalArgumentException("Polygons must have same number of vertices");
		
		this.polygonC = polygonC;
	}
	
	public QuadraticMorphing(Polygon polygonA, Polygon polygonB) {
		super(polygonA, polygonB);
		
		polygonC = new Polygon();
		
		for( int i = 0; i < polygonA.npoints; i++) {
			polygonC.addPoint(
					(polygonA.xpoints[i] + polygonB.xpoints[i])/2, 
					(polygonA.ypoints[i] + polygonB.ypoints[i])/2
					);
		}
	}
	
	@Override
	public Point morphFn(Point a, Point b, int nPoint, double t) {
		final Point c = new Point(polygonC.xpoints[nPoint], polygonC.ypoints[nPoint]);
		
		final int x = (int)((1-t)*(1-t)*a.x + 2*(1-t)*t*c.x + t*t*b.x);
		final int y = (int)((1-t)*(1-t)*a.y + 2*(1-t)*t*c.y + t*t*b.y);
		
		return new Point(x, y);
	}

	
}
