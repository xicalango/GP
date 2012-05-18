package gp;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ControlPanel extends JPanel implements ParabelController {

	private JSpinner angleSpinner;
	private JSpinner velocitySpinner;
	private JSpinner timeSpinner;
	private JSpinner gravitySpinner;
	private JButton resetButton;
	private JButton startStopButton;
	private ParabelController parabelFrame;
	
	private ParabelTimerThread ptt;
	
	public ControlPanel(final ParabelController parabelFrame)  {
		this.parabelFrame = parabelFrame;

		setLayout(new BorderLayout());
		
		JPanel componentPanel = new JPanel(new GridLayout(5, 2));
		
		angleSpinner = new JSpinner();
		angleSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				int v = (Integer)angleSpinner.getValue();
				parabelFrame.setAngle(v/10.0f);
//				timeSpinner.setValue(0);
			}
		});
		componentPanel.add(new JLabel("Angle*10:"));
		componentPanel.add(angleSpinner);

		velocitySpinner = new JSpinner();
		velocitySpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				int v = (Integer)velocitySpinner.getValue();
				parabelFrame.setVelocity(v);	
//				timeSpinner.setValue(0);
			}
		});
		componentPanel.add(new JLabel("Velocity:"));
		componentPanel.add(velocitySpinner);
		
		gravitySpinner = new JSpinner();
		gravitySpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				int v = (Integer)gravitySpinner.getValue();
				parabelFrame.setGravity(v);	
//				timeSpinner.setValue(0);
			}
		});
		componentPanel.add(new JLabel("Gravity:"));
		componentPanel.add(gravitySpinner);
		
		timeSpinner = new JSpinner();
		timeSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				int v = (Integer)timeSpinner.getValue();

				parabelFrame.setTime(v/10.0f);
			}
		});
		componentPanel.add(new JLabel("Time*10:"));
		componentPanel.add(timeSpinner);

		startStopButton = new JButton("Start");
		startStopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand().equals("Start")) {
					
					startStopButton.setText("Stop");
					
					ptt = new ParabelTimerThread(ControlPanel.this, 20);
					ptt.start();
					
				} else if(arg0.getActionCommand().equals("Stop"))  {
					
					startStopButton.setText("Start");
					
					ptt.stop();
					ptt = null;
				}
			}
		});
		componentPanel.add(startStopButton);
		
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timeSpinner.setValue(0);
			}
		});
		componentPanel.add(resetButton);
		
		
		add(componentPanel, BorderLayout.NORTH);
		
		setTime(0);
		setAngle(45);
		setVelocity(100);
		setGravity(100);
		
	}

	@Override
	public void setTime(float v) {
		timeSpinner.setValue((int)(v*10));
	}

	@Override
	public void setVelocity(float v) {
		velocitySpinner.setValue((int)(v));
	}

	@Override
	public void setAngle(float v) {
		angleSpinner.setValue((int)(v*10));
	}

	@Override
	public void setGravity(float v) {
		gravitySpinner.setValue((int)(v));
	}
	
}
