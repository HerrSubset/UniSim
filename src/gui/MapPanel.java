package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MapPanel extends JPanel {
	
	public MapPanel() {
		JLabel label = new JLabel("This is where the map goes");
		this.add(label);
	}
}
