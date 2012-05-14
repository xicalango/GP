package xx.graprog1.gui;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;

public class PolygonListModel extends AbstractListModel implements Iterable<Point> {

	private static class PointToStringWrapper {
		private Point point;

		public Point getPoint() {
			return point;
		}

		public PointToStringWrapper(Point point) {
			super();
			this.point = point;
		}
		
		@Override
		public String toString() {
			return point.x+", " + point.y;
		}
	}
	
	private List<Point> points;
	
	public PolygonListModel(Polygon polygon) {
		super();
		
		points = Polygons.pointListFromPolygon(polygon);
	}

	public Polygon getPolygon() {
		return Polygons.polygonFromPointList(points);
	}
	
	@Override
	public Object getElementAt(int index) {
		return new PointToStringWrapper(points.get(index));
	}

	@Override
	public int getSize() {
		return points.size();
	}

	public boolean add(Point e) {
		boolean result = points.add(e);
		fireIntervalAdded(this, getSize(), getSize());
		return result;
	}

	public Point get(int index) {
		return points.get(index);
	}

	@Override
	public Iterator<Point> iterator() {
		return points.iterator();
	}

	public void add(int arg0, Point arg1) {
		points.add(arg0, arg1);
		fireIntervalAdded(this, arg0, arg0);
	}
	
	public void modify(int index, Point e) {
		points.remove(index);
		points.add(index,e);
		fireContentsChanged(this, index, index);
	}
	
	public Point remove(int index) {
		Point result = points.remove(index);
		fireIntervalRemoved(this, index, index);
		return result;
	}
	
	


}
