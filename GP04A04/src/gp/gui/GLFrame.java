package gp.gui;

import javax.swing.JFrame;

public class GLFrame extends JFrame {

	private WinRenderer renderer;

	public GLFrame(WinRenderer renderer) {
		this.renderer = renderer;
		
		setSize(640,480);
		
		add(renderer);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
		renderer.requestFocus();
	}
	
	
	
}
