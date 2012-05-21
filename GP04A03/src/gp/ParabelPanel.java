package gp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class ParabelPanel extends JPanel {

	private int width = 800;
	private int height = 600;
	
	private float time = 0;

	private float G = 10f;
	
	private float v0;
	private float beta;
	
	private float spearLength = 50;
	private float spearHeight = 5;
	
	public ParabelPanel(float v0, float beta) {
		setPreferredSize(new Dimension(width, height));
		
		this.v0 = v0;
		setBeta(beta);
	}

	public float getG() {
		return G;
	}


	public void setG(float g) {
		G = g;
		repaint();
	}
	
	public float getV0() {
		return v0;
	}


	public void setV0(float v0) {
		this.v0 = v0;
		repaint();
	}


	public float getBeta() {
		return beta;
	}


	public void setBeta(float beta) {
		this.beta = (float)Math.toRadians(beta);
		repaint();
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawHorizont(g);
		
		drawAccVector(g);
		
		drawSpear(g);
		
		drawParable(g);
	}

	private void drawParable(Graphics g) {
		
		for( float i = 0; i < width; i+=0.1) {
			
			final float[] pos = getPos(i);
			final float[] asc = getGradient(i);

			if( (height/2) -(int)pos[1] > (height/2)) break;
			
			//g.drawOval((int)pos[0], (height/2)-(int)asc[1], 2, 2);
			
			g.setColor(Color.GRAY);
			
			g.drawOval((int)pos[0], (height/2) -(int)pos[1], 1, 1);
			
		}
		
	}

	private void drawSpear(Graphics g) {
		final float[] pos = getPos(time);
		
		final float x = pos[0];
		final float y = (height/2) - pos[1] > (height/2) ? (height/2) : (height/2) - pos[1];
		
		final float phi = (float)Math.atan(getGradient(time)[1])/2.0f; //Steigungswinkel der Wurfparabel zum Zeitpunkt 'time'
		
		final float x1 = x - (float)Math.cos(phi) * (spearLength/2);
		final float y1 = y + (float)Math.sin(phi) * (spearLength/2); //Punkt des hinteren Endes des Speers 

		final float x2 = x + (float)Math.cos(phi) * (spearLength/2);
		final float y2 = y - (float)Math.sin(phi) * (spearLength/2); //Punkt des vorderen Endes des Speers
		
		g.setColor(Color.RED);
		
		g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);

		g.setColor(Color.GRAY);
		
		g.drawOval((int)(x-5), (int)(y-5), 2, 2);
	}

	private void drawAccVector(Graphics g) {
		final float xv = v0 * (float)Math.cos(beta);
		final float yv = v0 * (float)Math.sin(beta);
		
		g.setColor(Color.green);
		
		g.drawLine(0, (height/2), (int)xv, (int)((height/2) -yv));
	}

	private void drawHorizont(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(0, (height/2), width, (height/2));
	}
	
	private float[] getGradient(float t) { //Ableitungsfunktion der Wurfparabel 
		return new float[] {
				v0 * (float)Math.cos(beta),
				v0 * (float)Math.sin(beta) - G * t
		};
	}
	
	private float[] getPos(float t) { //Positionsfunktion der Wurfparabel
		return new float[] {
				v0 * t * (float)Math.cos(beta),
				v0 * t * (float)Math.sin(beta) - (G/2 * t * t)
		};
	}


	public void setTime(float v) {
		time = v;
		repaint();
	}


	
}
