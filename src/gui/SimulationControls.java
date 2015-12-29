package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.Border;


@SuppressWarnings("serial")
public class SimulationControls extends JPanel {
	private UniSimGUI parent;
	private JButton run;
	private JButton exit;
	private JSpinner spinner;
	
	public SimulationControls(UniSimGUI parent){
		this.parent = parent;
		this.setLayout(new GridLayout(3, 1));
		Border b = BorderFactory.createTitledBorder("Controls");
		this.setBorder(b);
		
		JPanel numberPanel = new JPanel();
		numberPanel.setLayout(new GridLayout(1, 2));
		JLabel label = new JLabel("# of turns");
		spinner = new JSpinner();
		
		numberPanel.add(label);
		numberPanel.add(spinner);
		this.add(numberPanel);
		
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
				int turns = (int) spinner.getValue();
				parent.runSimulation(turns);
			}
		});
	}
}
