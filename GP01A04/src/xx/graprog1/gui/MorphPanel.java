package xx.graprog1.gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import xx.graprog1.morphing.Morphing;

public class MorphPanel extends JPanel{

	private Morphing morphing;
	private double t = 0;
	
	public MorphPanel() {
		this(null);
	}
	
	public MorphPanel(Morphing morphing) {
		this.morphing = morphing;
		
		setPreferredSize(new Dimension(640, 480));
	}

	public double getT() {
		return t;
	}

	public void setT(double t) {
		this.t = t;
		repaint();
	}

	public Morphing getMorphing() {
		return morphing;
	}

	public void setMorphing(Morphing morphing) {
		this.morphing = morphing;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(morphing != null)
			g.drawPolygon(morphing.morph(t));
	}
	
}
