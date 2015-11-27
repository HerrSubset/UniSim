/**
***UniSimController Class
***
***this class is the  entry point to the domain. It bundles all actions that a UI
***could need and dispatches the execution of these tasks to the correct classes.
**/

package domain;

import java.util.List;

import passables.EntityState;
import passables.SimulationStateSummary;

public class UniSimController {
	private Map map;
	private UniSimEngine engine;
	private Population population;
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public UniSimController(){
		this.engine = new UniSimEngine();
	}
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	//initialize the engine. Once the engine is initialized we can ask for the 
	//map and store it for faster access in the future.
	public void init(){
		engine.init();
		this.map = engine.getMap();
		this.population = engine.getPopulation();
	}
	
	//tell the engine to go forward a certain amount of turns
	public void simulate(int turns){
		this.engine.simulate(turns);
	}
	
	//return a string that represents the current world map
	public String getMapString() {
		return map.toString();
	}

	//get the current status of the simulation
	public SimulationStateSummary getCurrentStatus() {
		return this.engine.getCurrentStatus();
	}
	
	//return a list of EntityState objects. These represent all 
	//the entities present in the population.
	public List<EntityState> getEntityHistories(){
		return this.population.getEntityHistories();
	}
}
