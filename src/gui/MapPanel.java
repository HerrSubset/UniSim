package gui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class MapPanel extends JTextArea {
	
	public MapPanel() {
		Border b = BorderFactory.createTitledBorder("Map");
		this.setBorder(b);
		this.setPreferredSize(new Dimension(300, 300));
	}
}
