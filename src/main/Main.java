/**
Main Class

this class is the entry point for the program. It does all the initial setups
like loading the simulation engine and starting up the correct UI

**/


package main;

import consoleUI.UniSimCLI;;

public class Main {

	public static void main(String[] args) {
		UniSimCLI cli = new UniSimCLI();
		
		cli.start();
	}

}
