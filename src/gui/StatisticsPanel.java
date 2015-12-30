package gui;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class StatisticsPanel extends JPanel {

	public StatisticsPanel(){
		Border b = BorderFactory.createTitledBorder("Statistics");
		this.setBorder(b);
		
		this.setLayout(new GridLayout(3, 5));
		
		StatPanel turn = new StatPanel("Turn: ");
		this.add(turn);
		
		StatPanel entities = new StatPanel("# of Entities: ");
		this.add(entities);
	}
}
