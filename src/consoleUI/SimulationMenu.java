/**
***SimulationMenu Class
***
***The CLI that lets you interact with a simulation.
**/

package consoleUI;

import java.util.List;

import domain.UniSimController;
import passables.EntityState;
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
			printEntityHistories(simulationController.getEntityHistories());
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
	
	private void printEntityHistories(List<EntityState> states){
		for (int i = 0; i < states.size(); i++ ){
			EntityState currentState = states.get(i);
			
			int id = currentState.id;
			String role = currentState.currentRole;
			int created = currentState.turnCreated;
			
			String format = "Entity %d\n\t-role:\t%s\n\t-turn created:\t%d\n";
			System.out.format(format, id, role, created);
		}
	}
}
