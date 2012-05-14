package xx.graprog1.gui;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public final class Polygons {

	private Polygons() {	}
	
	public static List<Point> pointListFromPolygon(Polygon polygon) {
		final List<Point> points = new ArrayList<Point>();
		
		for( int i = 0; i < polygon.npoints; i++) {
			points.add(new Point(polygon.xpoints[i], polygon.ypoints[i]));
		}
		
		return points;
	}
	
	public static Polygon polygonFromPointList(List<Point> points) {
		final Polygon polygon = new Polygon();
		
		for( Point p : points) {
			polygon.addPoint(p.x, p.y);
		}
		
		return polygon;
	}
	
}
