package consoleUI;

import java.util.Enumeration;
import java.util.Hashtable;

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
		menuItems.add("Import Settings");
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
			System.out.print("\nFeature not implemented yet\n");
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
				controller.updateSetting(input, newVal);
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
	

}
