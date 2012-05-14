package xx.graprog1.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import xx.graprog1.morphing.StaticMorphing;

public class PolygonPanel extends MorphPanel {

	private StaticMorphing morphing;
	
	private int selectedVertex = -1;
	
	public PolygonPanel() {
		super();
		
		morphing = new StaticMorphing();
		setMorphing(morphing);
		
		setPreferredSize(new Dimension(200, 200));
	}

	public PolygonPanel(Polygon polygon) {
		super();
		
		morphing = new StaticMorphing(polygon);
		setMorphing(morphing);
		
		setPreferredSize(new Dimension(200, 200));
	}

	public Polygon getPolygon() {
		return morphing.getPolygon();
	}

	public void setPolygon(Polygon polygon) {
		morphing.setPolygon(polygon);
		repaint();
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(selectedVertex <= -1) return; 
		
		final Polygon p = getPolygon();
		
		g.setColor(Color.RED);
		g.drawOval(p.xpoints[selectedVertex] - 3, p.ypoints[selectedVertex] - 3, 6, 6);
	}

	public int getSelectedVertex() {
		return selectedVertex;
	}

	public void setSelectedVertex(int selectedVertex) {
		if(selectedVertex >= getPolygon().npoints)
			throw new IllegalArgumentException(); //TODO Message
		
		this.selectedVertex = selectedVertex;
		repaint();
	}
	
}
