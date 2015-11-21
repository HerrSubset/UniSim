/**
UniSimController Class

this class is the  entry point to the domain. It bundles all actions that a UI
could need and dispatches the execution of these tasks to the correct classes.
**/

package domain;

import passables.SimulationStateSummary;

public class UniSimController {
	private Map map;
	private UniSimEngine engine;
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public UniSimController(){
		this.engine = new UniSimEngine();
	}
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	public void init(){
		engine.init();
		this.map = engine.getMap();
	}
	
	
	public String getMapString() {
		return map.toString();
	}


	public SimulationStateSummary getCurrentStatus() {
		return this.engine.getCurrentStatus();
	}
}
