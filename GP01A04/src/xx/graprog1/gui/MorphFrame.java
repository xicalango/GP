package xx.graprog1.gui;

import java.awt.BorderLayout;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import xx.graprog1.morphing.CubicMorphing;
import xx.graprog1.morphing.MorphingFactory;

public class MorphFrame extends JFrame implements MorphListener{

	private static final Polygon DEFAULT_POLYGON_A = new Polygon(
			new int[] { 10, 10, 100, 100 },
			new int[] { 10, 100,100, 10 },
			4);

	private static final Polygon DEFAULT_POLYGON_B = new Polygon(
			new int[] { 10, 100, 10, 100 },
			new int[] { 10, 10, 100, 100 },
			4);
	
	private static final Polygon DEFAULT_POLYGON_C = new Polygon(
			new int[] { 25, 75, 25, 75 },
			new int[] { 75, 75, 25, 25 },
			4);
	
	private static final Polygon DEFAULT_POLYGON_D = new Polygon(
			new int[] { 75, 25, 75, 25 },
			new int[] { 75, 75, 25, 25 },
			4);

	private MorphingFactory morphingFactory = new MorphingFactory.Cubic();

	private MorphPanel morphPanel;
	private MorphControlPanel morphControlPanel;
	
	public MorphFrame() {
		setupGUI();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void setupGUI() {
		JPanel p = new JPanel(new BorderLayout());
		
		morphPanel = new MorphPanel(morphingFactory.getMorphing(DEFAULT_POLYGON_A,DEFAULT_POLYGON_B,DEFAULT_POLYGON_C,DEFAULT_POLYGON_D));
		p.add(morphPanel, BorderLayout.CENTER);
		
		morphControlPanel = new MorphControlPanel(this);
		p.add(morphControlPanel, BorderLayout.SOUTH);
		
		setContentPane(p);
		pack();

	}

	@Override
	public void tChanged(double newT) {
		morphPanel.setT(newT);
	}

	@Override
	public void requestNewPolygon() {
		
		//XXX JOptionPane.showInputDialog(this, "Select Morphing", "Morphing", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Linear", "Quadratic", "Cubic" }, "Linear");
		
		new PolygonDialog(DEFAULT_POLYGON_A, DEFAULT_POLYGON_B);
		
	}

	@Override
	public void requestQuit() {
		setVisible(false);
		dispose();
	}
	
}
