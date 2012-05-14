package xx.graprog1.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class PolygonCreateList extends JPanel {
	
	private PolygonPanel polygonPanel;
	
	private JList polygonList;
	private JTextField newPointField;
	private PolygonListModel polygonListModel;
	
	public PolygonCreateList(Polygon polygon) {
		setupGUI(polygon);
	}
	
	private void setupGUI(Polygon polygon) {
		setLayout(new BorderLayout());
		
		polygonPanel = new PolygonPanel(polygon);
		add(polygonPanel,BorderLayout.CENTER);
		
		JPanel eastPanel = new JPanel(new BorderLayout());
		
		polygonListModel = new PolygonListModel(polygon);
		polygonList = new JList(polygonListModel);
		polygonList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(polygonList.getSelectedIndex() == -1)
					return;
				
				polygonPanel.setSelectedVertex(polygonList.getSelectedIndex());
				
				newPointField.setText(polygonList.getSelectedValue().toString());
			}
		});
		polygonList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == 1 && e.getClickCount() == 2 && polygonList.getSelectedIndex() != -1) {
					modifyPoint(null);
				}
			}
		});
		
		polygonList.setPreferredSize(new Dimension(100,100));
		
		eastPanel.add(polygonList, BorderLayout.CENTER);
		
		newPointField = new JTextField();
		newPointField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final String newPointString = arg0.getActionCommand();
				final String[] div = newPointString.split(",");
				
				try {
					final int x = Integer.valueOf(div[0].trim());
					final int y = Integer.valueOf(div[1].trim());
					
					modifyPoint(new Point(x,y));
				} catch (NumberFormatException e) {
					// TODO: handle exception
					e.printStackTrace();
				} catch (ArrayIndexOutOfBoundsException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		});
		
		eastPanel.add(newPointField, BorderLayout.SOUTH);
		
		add(eastPanel, BorderLayout.WEST);
	}

	protected void modifyPoint(Point point) {
		if(polygonList.getSelectedIndex() == -1) {
			addPoint(point);
		} else if(point == null) {
			removePoint();
		} else {
			modifySelectedPoint(point);
		}
		
		polygonPanel.setPolygon(polygonListModel.getPolygon());
	}

	private void modifySelectedPoint(Point point) {
		final int si = polygonList.getSelectedIndex();
		polygonListModel.modify(si,point);
	}

	private void removePoint() {
		final int si = polygonList.getSelectedIndex();
		polygonListModel.remove(si);
	}

	private void addPoint(Point point) {
		polygonListModel.add(point);
	}

	public Polygon getPolygon() {
		return polygonListModel.getPolygon();
	}

}
