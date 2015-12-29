package gui;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UniSimGUI extends JFrame {
	private MapPanel mapPanel;
	private UnitList list;
	private JPanel southPanel;
	private StatisticsPanel stats;
	private SimulationControls controls;
	private SimulationMenu menu;

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
		
		mapPanel = new MapPanel();
		this.getContentPane().add(mapPanel, BorderLayout.CENTER);
		
		list = new UnitList();
		this.getContentPane().add(list, BorderLayout.EAST);
		
		//create a new panel for simulation statistics and controls
		southPanel = new JPanel();
		this.getContentPane().add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new BorderLayout());
		
		stats = new StatisticsPanel();
		southPanel.add(stats, BorderLayout.CENTER);
		
		controls = new SimulationControls(this);
		southPanel.add(controls, BorderLayout.EAST);
		
		//add the menu bar
		menu = new SimulationMenu();
		this.setJMenuBar(menu);
	}
	
	
	
	//close the frame
	public void exit(){
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
