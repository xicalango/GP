package xx.graprog1.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MorphControlPanel extends JPanel {

	private JSlider posSlider;
	private JTextField posTextField;
	private JTextField divTextField;
	
	private int div = 10000;
	
	private MorphListener listener;
	
	public MorphControlPanel(MorphListener listener) {
		this.listener = listener;
		
		setupGUI();
		listener.tChanged(getT());
	}
	
	private void setupGUI() {
		
		setLayout(new GridLayout(4, 2));
		
		add(new JLabel("Position:"));
		posSlider = new JSlider(0, 10000);
		posSlider.setValue(0);
		posSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				listener.tChanged(getT());
				posTextField.setText(""+getT());
			}
		});
		add(posSlider);
		
		add(new JLabel("Position Value:"));
		posTextField = new JTextField();
		posTextField.setEditable(false);
		posTextField.setText(""+getT());
		add(posTextField);
		
		add(new JLabel("Divisions:"));
		divTextField = new JTextField(""+div);
		divTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setDivToFieldValue();
			}
		});
		add(divTextField);
		
		JButton setPolygonsButton = new JButton("New Polygons");
		setPolygonsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.requestNewPolygon();
			}
		});
		
		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.requestQuit();
			}
		});
		
		add(setPolygonsButton);
		add(quitButton);
	}

	private double getT() {
		return (double)posSlider.getValue()/(double)div;
	}

	private void setDivToFieldValue() {
		try {
			div = Integer.valueOf(divTextField.getText());
			posSlider.setMaximum(div);
		} catch (NumberFormatException e1) {
			//Ignore
		}
	}
	
}
