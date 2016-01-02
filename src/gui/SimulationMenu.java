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

	
	
	private void addMenuActions() {

		addMapColsAction();
		addSaveSettingsAction();
		addLoadSettingsAction();
		addNewSimAction();
		addNewCustomSimAction();
		addViewSettingsAction();
	}

	
	
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
	
	
	
	private void addNewSimAction(){
		newSimulation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.resetSimulation(null);
			}
		});
	}
	
	
	
	private void addNewCustomSimAction(){
		newCustomSimulation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.openSettingsPanel(true);
			}
		});
	}
	
	
	private void addViewSettingsAction(){
		viewSettings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.openSettingsPanel(false);
			}
		});
	}
	
	

}
