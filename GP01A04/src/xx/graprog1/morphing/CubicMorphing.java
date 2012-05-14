package xx.graprog1.morphing;

import java.awt.Point;
import java.awt.Polygon;

public class CubicMorphing extends AbstractMorphing{

	private Polygon polygonC;
	private Polygon polygonD;
	
	public Polygon getPolygonC() {
		return polygonC;
	}

	public Polygon getPolygonD() {
		return polygonD;
	}

	public CubicMorphing(Polygon polygonA, Polygon polygonB, Polygon polygonC,
			Polygon polygonD) {
		super(polygonA, polygonB);
		
		if(polygonC.npoints != polygonD.npoints || polygonC.npoints != polygonA.npoints)
			throw new IllegalArgumentException("Polygons must have same number of vertices");
		
		this.polygonC = polygonC;
		this.polygonD = polygonD;
	}



	@Override
	public Point morphFn(Point a, Point b, int nPoint, double t) {
		final Point c = new Point(polygonC.xpoints[nPoint], polygonC.ypoints[nPoint]);
		final Point d = new Point(polygonD.xpoints[nPoint], polygonD.ypoints[nPoint]);
		
		final int x = (int)(
				(1-t)*(1-t)*(1-t)*a.x + 
				3*(1-t)*(1-t)*t*c.x +
				3*(1-t)*t*t*d.x +
				t*t*t*b.x);
		
		final int y = (int)(
				(1-t)*(1-t)*(1-t)*a.y + 
				3*(1-t)*(1-t)*t*c.y +
				3*(1-t)*t*t*c.y +
				t*t*t*b.y);
		
		return new Point(x, y);
	}

}
