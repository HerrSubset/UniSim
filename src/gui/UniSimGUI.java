package gui;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domain.InvalidMethodInvocationException;
import domain.UniSimController;
import passables.EntityState;
import passables.SimulationStateSummary;

@SuppressWarnings("serial")
public class UniSimGUI extends JFrame {
	//visual components
	private MapPanel mapPanel;
	private UnitList list;
	private JPanel southPanel;
	private StatisticsPanel stats;
	private SimulationControls controls;
	private SimulationMenu menu;
	
	//controller for the domain
	private UniSimController controller;


	public UniSimGUI(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("University Simulator");
		
		//set visual components
		this.loadContentPanels();
		
		//set up the controller
		controller = new UniSimController();
		controller.init();
		
		//make components display relevant information
		updateInfo();
		
		this.setVisible(true);
		this.pack();
	}
	
	
	
	//creates all the components that are part of the GUI and adds them
	//to the frame
	private void loadContentPanels(){
		this.getContentPane().removeAll();;
		
		mapPanel = new MapPanel();
		this.getContentPane().add(mapPanel, BorderLayout.CENTER);
		
		list = new UnitList(this);
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
		menu = new SimulationMenu(this);
		this.setJMenuBar(menu);
	}
	
	
	
	//close the frame
	public void exit(){
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
	
	
	//give each component the information that has to be displayed on it
	private void updateInfo(){
		mapPanel.updateInfo(controller.getMapStrings());
		
		SimulationStateSummary state = controller.getCurrentStatus();
		stats.updateValues(state);
		
		List<EntityState> states = controller.getEntityHistories();
		this.list.updateList(states);
	}



	//runs simulation for a given amount of turns and then updates all panels
	public void runSimulation(int turns) {
		try {
			controller.simulate(turns);
		} catch (InvalidMethodInvocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.updateInfo();
	}



	public void setCols(int cols) {
		mapPanel.setCols(cols);
	}
	
	
	
	public Hashtable<String, Integer> getParams(){
		return controller.getParameterHash();
	}
	
	
	
	//reset the simulation and load the new parameters if they are present
	public void resetSimulation(Hashtable<String, Integer> settings){
		controller.init();
		
		if (settings != null)
			controller.loadParameters(settings);
			
		this.updateInfo();
	}
	
	
	
	public void openEntityInfoScreen(EntityState state){
		//create title for new window
		String title = "History of " + state.toString();
		
		//create a string containing the history
		Iterator<String> it = state.history.iterator();
		StringBuilder history = new StringBuilder();
		
		while (it.hasNext()){
			history.append(it.next());
			history.append("\n");
		}
		
		JOptionPane.showMessageDialog(this, history.toString(), title, JOptionPane.PLAIN_MESSAGE);
	}
}
