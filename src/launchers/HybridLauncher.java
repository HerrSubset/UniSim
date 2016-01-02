/**
***HybridLauncher Class
***
***lets the user choose between a CLI or GUI. It then starts the chosen
***user interface.
**/


package launchers;

import java.util.Scanner;

import consoleUI.UniSimCLI;
import gui.UniSimGUI;;

public class HybridLauncher {

	public static void main(String[] args) {
		System.out.println("1. CLI");
		System.out.println("2. Graphical UI");
		System.out.println("Enter your choice:");
		
		@SuppressWarnings("resource")	//TODO can't close scanner or CLI menu doesn't work
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		if ( input == 1){
			//start CLI
			UniSimCLI cli = new UniSimCLI();
			cli.start();
		} else if (input == 2){
			new UniSimGUI();
		}
	}

}