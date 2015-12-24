package consoleUI;

import java.util.Enumeration;
import java.util.Hashtable;

import db.ParameterIOHandler;
import domain.NonExistingParameterException;
import domain.UniSimController;

public class SettingsMenu extends Menu {
	
	private UniSimController controller = null;
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public SettingsMenu(UniSimCLI parent, UniSimController controller){
		super(parent);
		this.controller = controller;
		menuItems.add("Change Settings");
		menuItems.add("Revert to Default Settings");
		menuItems.add("Import Settings");
		menuItems.add("Save Current Settings");
	}

	
	
	
	//************************************************************************
	// Constructors
	//************************************************************************

	@Override
	protected void performAction(int actionNumber) {
		if (actionNumber == 0)
			this.parentUI.goToMainMenu();
		
		if (actionNumber == 1)
			this.changeSettings();
		
		if (actionNumber == 2)
			this.controller.revertToDefaultSettings();
		
		if (actionNumber == 3)
			System.out.print("\nFeature not implemented yet\n");
		
		if (actionNumber == 4)
			storeSettings();
	}
	
	
	
	
	//************************************************************************
	// Change Settings Functions
	//************************************************************************
	
	//main function for the change settings functionality
	private void changeSettings(){
		Hashtable<String, Integer> parameters = this.controller.getParameterHash();
		String input = "";
		String message = "\nEnter the setting name you wish to change or 'quit' to exit";
		String intMessage = "\nEnter a new value for this setting";
		
		//let the user change settings until he types "quit"
		while( !input.equals("quit")){
			printParameters(parameters);
			input = getUserString(message);
			
			if ( !input.equals("quit")){
				int newVal = getUserInt(intMessage);
				try {
					controller.updateSetting(input, newVal);
				} catch (NonExistingParameterException e) {
					System.out.println("ERROR: " + e.getMessage());
					
					//make sure user sees the message by waiting 4 seconds
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
	
	
	
	//prints the parameters hash to screen
	private void printParameters(Hashtable<String, Integer> parameters){
		Enumeration<String> keys = parameters.keys();
		
		while (keys.hasMoreElements()){
		       String nextKey = keys.nextElement();
		       int keyValue = parameters.get(nextKey);
		       
		       System.out.format("-%s :\t %d\n", nextKey, keyValue);
		}
	}
	
	
	
	
	//************************************************************************
	// Settings I/O Functions
	//************************************************************************
	
	//hands parameter hash to db module to save it
	private void storeSettings(){
		Hashtable<String, Integer> parameters = this.controller.getParameterHash();
		
		String storagePath = getUserString("Enter the path to the savefile:");
		
		ParameterIOHandler.saveParameters(storagePath, parameters);
	}

}
