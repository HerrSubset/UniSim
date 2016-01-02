/**
***SimulationMenu Class
***
***This is the menu on top of the screen.
**/

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import db.ParameterIOHandler;

@SuppressWarnings("serial")
public class SimulationMenu extends JMenuBar {
	private JMenuItem newSimulation;
	private JMenuItem newCustomSimulation;
	private JMenuItem saveSettings;
	private JMenuItem loadSettings;
	private JMenuItem mapCols;
	private JMenuItem viewSettings;

	private UniSimGUI parent;


	
	
	// ************************************************************************
	// Constructor
	// ************************************************************************
	
	public SimulationMenu(UniSimGUI parent) {
		this.parent = parent;

		JMenu mainMenu = new JMenu("Menu");
		JMenu viewMenu = new JMenu("View");

		this.add(mainMenu);
		this.add(viewMenu);

		// menu items for main menu
		newSimulation = new JMenuItem("New Default Simulation");
		newCustomSimulation = new JMenuItem("New Custom Simulation");
		saveSettings = new JMenuItem("Save Current Settings");
		loadSettings = new JMenuItem("Load Settings");
		viewSettings = new JMenuItem("View Current Settings");

		mainMenu.add(newSimulation);
		mainMenu.add(newCustomSimulation);
		mainMenu.add(saveSettings);
		mainMenu.add(loadSettings);
		mainMenu.addSeparator();
		mainMenu.add(viewSettings);

		// menu items for view menu
		mapCols = new JMenuItem("Change number of map columns");
		viewMenu.add(mapCols);

		addMenuActions();
	}
	
	
	
	
	// ************************************************************************
	// Menu Actions
	// ************************************************************************
	
	//add an action for every menu item
	private void addMenuActions() {

		addMapColsAction();
		addSaveSettingsAction();
		addLoadSettingsAction();
		addNewSimAction();
		addNewCustomSimAction();
		addViewSettingsAction();
	}

	
	
	//Ask the user how many columns should be displayed. Then tell the parent
	//to apply this change
	private void addMapColsAction() {
		mapCols.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// set up and show input dialog
				String[] possibilities = { "1", "2", "3", "4", "5", "6" };
				String input = (String) (JOptionPane.showInputDialog(parent, "How many columns should be displayed?",
						"Change Map Columns", JOptionPane.PLAIN_MESSAGE, null, possibilities, "3"));

				// transform input to integer
				int cols = Integer.parseInt(input);

				parent.setCols(cols);
			}
		});
	}
	
	
	
	//select file to save to. Pass this and the current settings to the db module
	private void addSaveSettingsAction(){
		saveSettings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(parent);
				
				if (returnVal == JFileChooser.APPROVE_OPTION){
					String path = fc.getSelectedFile().getPath();
					ParameterIOHandler.saveParameters(path, parent.getParams(), false);
				}
			}
		});
	}
	
	
	
	//select file to load, pass the path to the db module and give the 
	//resulting parameters to the parent.
	private void addLoadSettingsAction(){
		loadSettings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(parent);
				
				if (returnVal == JFileChooser.APPROVE_OPTION){
					String path = fc.getSelectedFile().getPath();
					Hashtable<String, Integer> params = ParameterIOHandler.loadParameters(path);
					parent.resetSimulation(params);
				}
			}
		});
	}
	
	
	
	//start a new simulation with default parameters
	private void addNewSimAction(){
		newSimulation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.resetSimulation(null);
			}
		});
	}
	
	
	
	//ask the user to input custom parameters and use them to start 
	//a new simulation
	private void addNewCustomSimAction(){
		newCustomSimulation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.openSettingsPanel(true);
			}
		});
	}
	
	
	
	//open a window that shows the current settings
	private void addViewSettingsAction(){
		viewSettings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.openSettingsPanel(false);
			}
		});
	}
	
	

}
