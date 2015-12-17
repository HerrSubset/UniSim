/**
***SimulationMenu Class
***
***The CLI that lets you interact with a simulation.
**/

package consoleUI;

import java.util.List;

import domain.InvalidMethodInvocationException;
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
			printMap(simulationController.getMapStrings());
		
		else if (actionNumber == 4)
			printEntityHistories(simulationController.getEntityHistories());
	}
	
	
	//************************************************************************
	// Menu Actions
	//************************************************************************
	
	//Prints a small overview of the simulation state
	private void printCurrentStatus(SimulationStateSummary state){
		System.out.println("\nCurrent State:");
		System.out.format("-Turn:\t\t%d\n", state.turn);
		System.out.format("-Inhabitants:\t%d\n", state.inhabitantsNumber);
	}
	
	
	
	//tell the simulation engine to go forward a certain amount of turns
	private void runSimulation(){
		int input = this.getUserInt("\nHow many turns do you want to let the simulation run?");
		
		try{
			this.simulationController.simulate(input);
		} catch (InvalidMethodInvocationException e) {
			System.err.format("ERROR: %s", e.getMessage());
		}
	}
	
	
	
	//Get the string representation of every place on the map and print it to
	//the screen.
	private void printMap(List<String> places){
		int placesPerLine = 4;
		int longestString = getLongestString(places);
		
		for (int i = 0; i < places.size(); i += placesPerLine){
			for (int j = 0; j < placesPerLine ; j++){
				if ( (i +j) < places.size()){
					String output = stretch(places.get(i + j), longestString + 1);
					System.out.print(output);
				}
			}
			System.out.println();
		}
	}
	
	
	
	//take a list of string and return the length of the longest one
	private int getLongestString(List<String> stringList){
		int res = 0;
		
		for (int i = 0; i < stringList.size(); i++){
			if (stringList.get(i).length() > res)
				res = stringList.get(i).length();
		}
		
		return res;
	}
	
	
	
	//take a string and append spaces until it's the given length
	private String stretch(String s, int l){
		StringBuilder res = new StringBuilder(s);
		
		//calculate number of spaces that have to be appended
		int numberOfSpaces = l - s.length();
		
		for (int i = 0; i < numberOfSpaces; i++){
			res.append(" ");
		}
		
		return res.toString();
	}
	
	
	
	//print out all entities' histories
	private void printEntityHistories(List<EntityState> states){
		for (int i = 0; i < states.size(); i++ ){
			//set up some variables
			EntityState currentState = states.get(i);
			int id = currentState.id;
			String role = currentState.currentRole;
			
			//print entity title
			String format = "Entity %d (%s)\n";
			System.out.format(format, id, role);
			
			//print out the current entity's history
			for (int j = 0; j < currentState.history.size(); j++){
				System.out.format("\t%s\n", currentState.history.get(j));
			}
		}
	}
}
