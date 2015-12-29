package gui;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class StatisticsPanel extends JPanel {

	public StatisticsPanel(){
		Border b = BorderFactory.createTitledBorder("Statistics");
		this.setBorder(b);
		
		JLabel label = new JLabel("look at all dem stats");
		this.add(label);
	}
}
