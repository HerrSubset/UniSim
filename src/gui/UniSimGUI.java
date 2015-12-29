package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UniSimGUI extends JFrame {

	public UniSimGUI(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("University Simulator");
		
		this.loadContentPanels();
		
		this.setVisible(true);
		this.pack();
	}
	
	
	
	//creates all the components that are part of the GUI and adds them
	//to the frame
	private void loadContentPanels(){
		this.getContentPane().removeAll();;
		
		MapPanel mapPanel = new MapPanel();
		this.getContentPane().add(mapPanel, BorderLayout.CENTER);
		
		UnitList list = new UnitList();
		this.getContentPane().add(list, BorderLayout.EAST);
		
		//create a new panel for simulation statistics and controls
		JPanel southPanel = new JPanel();
		this.getContentPane().add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new BorderLayout());
		
		StatisticsPanel stats = new StatisticsPanel();
		southPanel.add(stats, BorderLayout.CENTER);
		
		SimulationControls controls = new SimulationControls();
		southPanel.add(controls, BorderLayout.EAST);
		
		//add the menu bar
		SimulationMenu menu = new SimulationMenu();
		this.setJMenuBar(menu);
	}
}
