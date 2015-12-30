package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SimulationMenu extends JMenuBar {
	private JMenuItem newSimulation;
	private JMenuItem saveSettings;
	private JMenuItem loadSettings;
	private JMenuItem mapCols;
	
	private UniSimGUI parent;

	public SimulationMenu(UniSimGUI parent){
		this.parent = parent;
		
		JMenu mainMenu = new JMenu("Menu");
		JMenu viewMenu = new JMenu("View");
		
		this.add(mainMenu);
		this.add(viewMenu);
		
		//menu items for main menu
		newSimulation = new JMenuItem("New Simulation");
		saveSettings = new JMenuItem("Save Current Settings");
		loadSettings = new JMenuItem("Load Settings");
		
		mainMenu.add(newSimulation);
		mainMenu.add(saveSettings);
		mainMenu.add(loadSettings);
		
		//menu items for view menu
		mapCols = new JMenuItem("Change number of map columns");
		viewMenu.add(mapCols);
		
		addMenuActions();
	}
	
	
	
	private void addMenuActions(){
		mapCols.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//set up and show input dialog
				String[] possibilities = {"1", "2", "3", "4", "5", "6"};
				String input = (String) (JOptionPane.showInputDialog(parent, "How many columns should be displayed?", "Change Map Columns", JOptionPane.PLAIN_MESSAGE, null, possibilities, "3"));
				
				//transform input to integer
				int cols = Integer.parseInt(input);
				
				parent.setCols(cols);
			}
		});
	}
}
