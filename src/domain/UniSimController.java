/**
UniSimController Class

this class is the  entry point to the domain. It bundles all actions that a UI
could need and dispatches the execution of these tasks to the correct classes.
**/

package domain;

public class UniSimController {
	private Map map;
	private UniSimEngine engine;
	
	public UniSimController(){
		this.map = new Map();
		this.engine = new UniSimEngine();
	}
	
	public String getMapString() {
		return map.toString();
	}

	public String getCurrentStatusString() {
		return engine.currentStatusToString();
	}
}
