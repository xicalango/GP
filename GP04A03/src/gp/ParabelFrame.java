package gp;
import java.awt.BorderLayout;

import javax.swing.JFrame;


public class ParabelFrame extends JFrame implements ParabelController {

	private ParabelPanel pp;
	private ControlPanel cp;
	
	public ParabelFrame() {
		
		pp = new ParabelPanel(100, 45);
		add(pp,BorderLayout.CENTER);
		
		cp = new ControlPanel(this);
		add(cp,BorderLayout.EAST);
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pack();
	}

	@Override
	public void setTime(float v) {
		pp.setTime(v);
	}

	@Override
	public void setVelocity(float v) {
		pp.setV0(v);
	}

	@Override
	public void setAngle(float v) {
		pp.setBeta(v);
	}

	@Override
	public void setGravity(float v) {
		pp.setG(v);
	}
	
	
	
}
