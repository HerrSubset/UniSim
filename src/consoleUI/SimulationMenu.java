/**
SimulationMenu Class

The CLI that lets you interact with a simulation.

**/

package consoleUI;

import domain.UniSimController;

public class SimulationMenu extends Menu {
	private UniSimController simulationController;
	
	public SimulationMenu(UniSimCLI parent, UniSimController sc){
		super(parent);
		this.simulationController = sc;
		this.menuItems.add("Jump Forward");
		this.menuItems.add("Show current turn overview");
		this.menuItems.add("Print Map");
		this.menuItems.add("Print Histories");
	}

	
	//implement menu actions
	@Override
	protected void performAction(int actionNumber) {
		if (actionNumber == 0)
			this.parentUI.goToMainMenu();
		
		else if (actionNumber == 1)
			System.out.println("Jumping forward in time");
		
		else if (actionNumber == 2)
			System.out.println(simulationController.getCurrentStatusString());
		
		else if (actionNumber == 3)
			System.out.println(simulationController.getMapString());
		
		else if (actionNumber == 4)
			System.out.println("Printing entity histories");
	}

}
