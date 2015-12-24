/**
***CLILauncher Class
***
***this class starts the CLI
**/


package launchers;

import consoleUI.UniSimCLI;;

public class CLILauncher {

	public static void main(String[] args) {
		//create user interface
		UniSimCLI cli = new UniSimCLI();
		
		//start interface
		cli.start();
	}

}
