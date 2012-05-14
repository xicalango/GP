package xx.graprog1.morphing;

import java.awt.Polygon;

public class StaticMorphing implements Morphing {

	private Polygon polygon;
	
	
	
	public StaticMorphing() {
		super();
		// TODO Auto-generated constructor stub
	}



	public StaticMorphing(Polygon polygon) {
		super();
		this.polygon = polygon;
	}



	public Polygon getPolygon() {
		return polygon;
	}



	public void setPolygon(Polygon polygon) {
		this.polygon = polygon;
	}



	@Override
	public Polygon morph(double t) {
		return polygon;
	}

}
