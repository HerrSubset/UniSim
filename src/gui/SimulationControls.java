package gui;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class SimulationControls extends JPanel {
	
	public SimulationControls(){
		this.setLayout(new GridLayout(2, 1));
		Border b = BorderFactory.createTitledBorder("Controls");
		this.setBorder(b);
		
		JButton run = new JButton("Run Simulation");
		this.add(run);
		
		JButton exit = new JButton("Exit");
		this.add(exit);
	}
}
