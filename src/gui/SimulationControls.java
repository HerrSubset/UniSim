package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;


@SuppressWarnings("serial")
public class SimulationControls extends JPanel {
	private UniSimGUI parent;
	private JButton run;
	private JButton exit;
	
	public SimulationControls(UniSimGUI parent){
		this.parent = parent;
		this.setLayout(new GridLayout(2, 1));
		Border b = BorderFactory.createTitledBorder("Controls");
		this.setBorder(b);
		
		run = new JButton("Run Simulation");
		this.add(run);
		
		exit = new JButton("Exit");
		this.add(exit);
		
		addButtonActions();
	}
	
	
	
	private void addButtonActions(){
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.exit();
			}
		});
		
		run.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.runSimulation(1);
			}
		});
	}
}
