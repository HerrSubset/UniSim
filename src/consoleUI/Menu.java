/**
***Menu Class
***
***this class represents a CLI menu. It's an abstract class so the different
***subclasses implement the actual menu. This class only contains general
***helper code.
**/

package consoleUI;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
		int input = -1;
		
		input = getUserIntInRange("Enter choice:", 0 , menuItems.size());
		
		performAction(input);
	}
	
	
	//uses the scanner attribute to get an int from the user. The scanner
	//attribute is the message that is displayed to the user
	protected int getUserInt(String message){
		int res;
		
		while(true){
			System.out.println(message);			
			
			try {
				res = sc.nextInt();
			} catch (InputMismatchException e){
				System.out.println("Invalid input (not a number), try again:");
				sc.next(); //clear scanner buffer
				continue;
			} 
			
			break;
		}
		
		return res;
	}
	
	//get an int from the user within a certain range. To achieve this it uses
	//the getUserInt function. Afterwards it checks if it is in range.
	private int getUserIntInRange(String message, int lower, int upper){
		int res;
		
		while(true){
			res = getUserInt(message);
			
			if (res > upper || res < lower){
				//bad input
				System.out.println("Invalid input (invalid option), try again");
				continue;
			} else {
				//good input
				break;
			}
		}
		
		return res;
	}
	
	
	//function called by "ReadAndExecuteAction" to let the subclass execute things
	//according to user input
	protected abstract void performAction(int actionNumber);
}
