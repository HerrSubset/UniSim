package consoleUI;

public class SettingsMenu extends Menu {
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public SettingsMenu(UniSimCLI parent){
		super(parent);
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
	
	
	private void changeSettings(){
		System.out.println("\nFeature not available yet");
	}

}
