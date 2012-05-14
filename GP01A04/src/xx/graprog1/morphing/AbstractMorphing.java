package xx.graprog1.morphing;

import java.awt.Point;
import java.awt.Polygon;

public abstract class AbstractMorphing implements Morphing, MorphFn{
	
	private Polygon polygonA;
	private Polygon polygonB;
	
	public AbstractMorphing(Polygon polygonA, Polygon polygonB) {
		super();
		
		if(polygonA.npoints != polygonB.npoints)
			throw new IllegalArgumentException("Polygons must have same number of vertices");
		
		this.polygonA = polygonA;
		this.polygonB = polygonB;
	}
	
	public Polygon getPolygonA() {
		return polygonA;
	}
	
	public Polygon getPolygonB() {
		return polygonB;
	}

	public int getNumPoints() {
		return polygonA.npoints;
	}
	
	public Point getPolygonAPoint(int n) {
		return new Point(polygonA.xpoints[n], polygonA.ypoints[n]);
	}
	
	public Point getPolygonBPoint(int n) {
		return new Point(polygonB.xpoints[n], polygonB.ypoints[n]);
	}

	@Override
	public Polygon morph(double t) {
		
		Polygon p = new Polygon();

		for( int i = 0; i < getNumPoints(); i++) {
			final Point a = getPolygonAPoint(i);
			final Point b = getPolygonBPoint(i);
			
			final Point newPoint = morphFn(a, b, i, t);
			
			p.addPoint(newPoint.x, newPoint.y);
		}
			
		return p;
	}
	
}
