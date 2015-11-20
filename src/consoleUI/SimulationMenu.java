/**
SimulationMenu Class

The CLI that lets you interact with a simulation.

**/

package consoleUI;

public class SimulationMenu extends Menu {
	
	public SimulationMenu(UniSimCLI parent){
		super(parent);
		this.menuItems.add("Jump Forward");
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
			System.out.println("Printing the map");
		
		else if (actionNumber == 3)
			System.out.println("Printing entity histories");
	}

}
