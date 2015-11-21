/**
***SimulationMenu Class
***
***The CLI that lets you interact with a simulation.
**/

package consoleUI;

import domain.UniSimController;
import passables.SimulationStateSummary;

public class SimulationMenu extends Menu {
	//************************************************************************
	// Variables
	//************************************************************************
	private UniSimController simulationController;
	
	
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public SimulationMenu(UniSimCLI parent, UniSimController sc){
		super(parent);
		this.simulationController = sc;
		this.menuItems.add("Run Simulation");
		this.menuItems.add("Show current turn overview");
		this.menuItems.add("Print Map");
		this.menuItems.add("Print Histories");
	}
	
	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	//implement abstract performAction method to dispatch the different
	//menu options to their respective actions
	@Override
	protected void performAction(int actionNumber) {
		if (actionNumber == 0)
			this.parentUI.goToMainMenu();
		
		else if (actionNumber == 1)
			runSimulation();
		
		else if (actionNumber == 2)
			printCurrentStatus(simulationController.getCurrentStatus());
		
		else if (actionNumber == 3)
			System.out.println(simulationController.getMapString());
		
		else if (actionNumber == 4)
			System.out.println("Printing entity histories");
	}
	
	
	//************************************************************************
	// Menu Actions
	//************************************************************************
	private void printCurrentStatus(SimulationStateSummary state){
		System.out.println("\nCurrent State:");
		System.out.format("-Turn:\t\t%d\n", state.turn);
		System.out.format("-Map height:\t%d\n", state.mapHeight);
		System.out.format("-Map Width:\t%d\n", state.mapWidth);
		System.out.format("-Inhabitants:\t%d\n", state.inhabitantsNumber);
	}
	
	private void runSimulation(){
		int input = this.getUserInt("\nHow many turns do you want to let the simulation run?");
		
		this.simulationController.simulate(input);
	}
}
