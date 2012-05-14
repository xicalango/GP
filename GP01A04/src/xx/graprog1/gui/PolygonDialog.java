package xx.graprog1.gui;

import java.awt.GridLayout;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class PolygonDialog extends JFrame{


	private PolygonCreateList polygonPanelA;
	private PolygonCreateList polygonPanelB;
	
	private boolean valueValid = false;

	public boolean isValueValid() {
		return valueValid;
	}

	public void setValueValid(boolean valueValid) {
		this.valueValid = valueValid;
	}

	public PolygonDialog(Polygon a, Polygon b) {
		setupGUI(a,b);
		setVisible(true);
	}
	
	private void setupGUI(Polygon a, Polygon b) {
		JPanel p = new JPanel(new GridLayout(1, 2));
				
		polygonPanelA = new PolygonCreateList(a);
		p.add(polygonPanelA);

		polygonPanelB = new PolygonCreateList(b);
		p.add(polygonPanelB);

		setContentPane(p);
		pack();
		
	}
	
	
}
