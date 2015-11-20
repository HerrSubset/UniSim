/**
UniSimController Class

this class is the  entry point to the domain. It bundles all actions that a UI
could need and dispatches the execution of these tasks to the correct classes.
**/

package domain;

public class UniSimController {
	private Map map;
	private UniSimEngine engine;
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public UniSimController(){
		this.map = new Map(4,4);
		this.engine = new UniSimEngine(map);
	}
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	public String getMapString() {
		return map.toString();
	}

	public String getCurrentStatusString() {
		return engine.currentStatusToString();
	}
}
