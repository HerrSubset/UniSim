/**
***UniSimCLI Class
***
***this class represents the CLI interface for the simulator. It talks directly
***to the UniSimController in the domain package and dispatches all UI tasks to
***several Menu objects.
**/

package consoleUI;

import domain.UniSimController;

public class UniSimCLI {
	//************************************************************************
	// Variables
	//************************************************************************	
	private Menu currentMenu;
	private boolean stop = false;
	private UniSimController simulationController;
	
	
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public UniSimCLI(){
		this.simulationController = new UniSimController();
		//set default menu
		goToMainMenu();
	}
	
	
	
	
	//************************************************************************
	// Generic Functions
	//************************************************************************
	
	//start the main menu loop
	public void start(){		
		while (!stop){
			System.out.println("\n-----------------------------------------");
			currentMenu.printMenuItems();
			currentMenu.readAndExecuteAction();
		}
	}
	
	
	
	//stops the main loop the next time it performs
	//its while-check
	public void stop(){
		this.stop = true;
	}
	
	
	
	//sets the current menu item to be the simulation menu. It also makes sure
	//the simulation is initialized
	public void startSimulation(){
		this.currentMenu = new SimulationMenu(this, this.simulationController);
		simulationController.init();
	}
	
	
	
	//sets the main menu as current menu
	public void goToMainMenu(){
		this.currentMenu = new MainMenu(this);
	}
	
	
	
	//sets the settings menu as the current menu
	public void goToSettingsMenu(){
		this.currentMenu = new SettingsMenu(this, simulationController);
	}
	
}
