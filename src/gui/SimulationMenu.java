package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class SimulationMenu extends JMenuBar {

	public SimulationMenu(){
		JMenu mainMenu = new JMenu("Menu");
		JMenu viewMenu = new JMenu("View");
		
		this.add(mainMenu);
		this.add(viewMenu);
		
		//menu items for main menu
		JMenuItem newSimulation = new JMenuItem("New Simulation");
		JMenuItem saveSettings = new JMenuItem("Save Current Settings");
		JMenuItem loadSettings = new JMenuItem("Load Settings");
		
		mainMenu.add(newSimulation);
		mainMenu.add(saveSettings);
		mainMenu.add(loadSettings);
		
		//menu items for view menu
		JMenuItem mapCols = new JMenuItem("Change number of map columns");
		viewMenu.add(mapCols);
	}
}
