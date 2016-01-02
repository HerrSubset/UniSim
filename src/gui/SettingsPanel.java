package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class SettingsPanel extends JFrame {
	private List<SettingEntry> entries;
	private JButton save;
	private JButton cancel;
	private UniSimGUI parent;

	
	
	
	// ************************************************************************
	// Constructor & Setup Functions
	// ************************************************************************

	// constructor
	public SettingsPanel(UniSimGUI parent, Hashtable<String, Integer> settings, boolean hasSaveButton) {
		this.parent = parent;
		entries = new ArrayList<SettingEntry>();

		// create the setting entries and add them to the frame
		this.createSettingEntries(settings);
		this.addSettingEntriesToScreen();

		// add buttons to the bottom of the screen
		this.addButtons(hasSaveButton);
		this.addButtonActions();
		
		this.setVisible(true);
		this.pack();

	}

	
	
	//takes the settings hash and creates a settingEntry object for 
	//every parameter
	private void createSettingEntries(Hashtable<String, Integer> settings) {
		Enumeration<String> en = settings.keys();

		// create entry for each setting and add it to the entries list
		while (en.hasMoreElements()) {
			String key = en.nextElement();
			int value = settings.get(key);

			SettingEntry entry = new SettingEntry(key, value);

			entries.add(entry);
		}
	}

	
	
	private void addSettingEntriesToScreen() {
		// put scrollpane in center of the borderlayout. Use a gridlayout on the
		// panel and set the # of rows equal to the # of items in the entries
		// list
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(entries.size(), 1));

		// add all setting entries to the panel
		Iterator<SettingEntry> it = entries.iterator();

		while (it.hasNext())
			panel.add(it.next());

		// add panel to the frame inside scrollpane
		this.add(new JScrollPane(panel));
	}
	
	
	
	private void addButtons(boolean addSaveButton){
		//create the buttons
		save = new JButton("Save Settings");
		cancel = new JButton("Cancel");
		
		//add buttons to the frame;
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(cancel);
		
		if (addSaveButton)
			buttonPanel.add(save);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	
	
	
	// ************************************************************************
	// Button Actions
	// ************************************************************************
	
	private void addButtonActions(){
		this.addCancelAction();
		this.addSaveAction();
	}
	
	
	
	//makes cancel button close the settings screen
	private void addCancelAction(){
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
	}
	
	
	
	//closes the current screen
	private void exit(){
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
	
	
	//makes the save button create a new settings hash. It is then passed on to
	//the parent element (the simulation GUI) so that a new simulation can be
	//started. The settings screen is then closed.
	private void addSaveAction(){
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Hashtable<String, Integer> settings = createNewSettingsHash();
					startNewSimulation(settings);
				} catch (NumberFormatException err){
					showErrorMessage();
				}
			}
		});
	}
	
	
	
	//loops through all setting entries and creates a key-value pair for them
	private Hashtable<String, Integer> createNewSettingsHash() throws NumberFormatException{
		Hashtable<String, Integer> res = new Hashtable<String, Integer>();
		Iterator<SettingEntry> it = entries.iterator();
		
		while (it.hasNext()){
			SettingEntry tmp = it.next();
			
			String key = tmp.getKey();
			int value = tmp.getValue();
			
			res.put(key, value);
		}
		
		return res;
	}
	
	
	private void showErrorMessage(){
		JOptionPane.showMessageDialog(parent, "All fields must be numerical", "error", JOptionPane.ERROR_MESSAGE);
	}
	
	
	
	//resets the simulation and passes the newly made settings hash.
	//Then close this frame
	private void startNewSimulation(Hashtable<String, Integer> settings){
		parent.resetSimulation(settings);
		this.exit();
	}

}
