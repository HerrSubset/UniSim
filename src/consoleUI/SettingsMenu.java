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

	@Override
	protected void performAction(int actionNumber) {
		if (actionNumber == 0)
			this.parentUI.goToMainMenu();
	}

}
