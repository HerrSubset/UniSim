/**
***MainMenu Class
***
***the main menu for the CLI.
**/

package consoleUI;

public class MainMenu extends Menu {
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public MainMenu(UniSimCLI parent){
		super(parent);
		menuItems.add("Start Simulation");
		menuItems.add("Settings");
	}

	
	
	
	//************************************************************************
	// Generic Functions
	//************************************************************************
	
	//implement the different menu actions
	@Override
	protected void performAction(int actionNumber) {
		if (actionNumber == 1)
			this.parentUI.startSimulation();
		
		else if (actionNumber ==2)
			this.parentUI.goToSettingsMenu();
		
		else if (actionNumber == 0)
			this.parentUI.stop();
	}
}
