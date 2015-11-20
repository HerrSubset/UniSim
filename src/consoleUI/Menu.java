/**
Menu Class

this class represents a CLI menu. It's an abstract class so the different
subclasses implement the actual menu. This class only contains general
helper code.

**/

package consoleUI;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
	//************************************************************************
	// Variables
	//************************************************************************
	protected ArrayList<String> menuItems;
	UniSimCLI parentUI = null;
	Scanner sc = new Scanner(System.in);
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Menu(UniSimCLI parent){
		this.parentUI = parent;
		this.menuItems = new ArrayList<String>();
	}
	
	
	//************************************************************************
	// Generic Functions
	//************************************************************************
	
	//print out all the menu items to the screen and print the option to exit
	//on the last row
	public void printMenuItems(){
		for(int i=1; i <= menuItems.size(); i++){
			System.out.format("%d. %s\n", i, menuItems.get(i-1));
		}
		System.out.println("0. Exit");
	}
	
	
	//reads input from the user on what menu item to execute. It then calls an
	//abstract function to let the subclass handle the input.
	public void readAndExecuteAction(){
		System.out.format("Enter your choice: ");
		int input = sc.nextInt();
		
		performAction(input);
	}
	
	
	//function called by "ReadAndExecuteAction" to let the subclass execute things
	//according to user input
	protected abstract void performAction(int actionNumber);
}
