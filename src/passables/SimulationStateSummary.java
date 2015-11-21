/**
***SimulationStateSummary Class
***
***this is an object that is passed from the domain to the UI to transfer some information.
***It's just a container of final variables without getters/setters, similar to a struct
***in C/C++
**/

package passables;

public class SimulationStateSummary {
	//************************************************************************
	// Variables
	//************************************************************************
	public final int mapWidth;
	public final int mapHeight;
	public final int inhabitantsNumber;
	public final int turn;
	
	
	//************************************************************************
	// Constructor
	//************************************************************************
	
	public SimulationStateSummary(int mapWidth, int mapHeight, int inhabitants, int turn){
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		this.inhabitantsNumber = inhabitants;
		this.turn = turn;
	}

}
