/**
UniSimEngine Class

this is the center of the simulation. This class and all it's modules contain
the rules that make up the simulation. 
**/

package domain;

public class UniSimEngine {
	private Map map;
	private Population population;
	
	
	public UniSimEngine(Map map){
		this.map = map;
		this.population = new Population();
	}

	public String currentStatusToString() {
		return "This is the current status";
	}

}
