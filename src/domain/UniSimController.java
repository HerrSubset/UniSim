/**
***UniSimController Class
***
***this class is the  entry point to the domain. It bundles all actions that a UI
***could need and dispatches the execution of these tasks to the correct classes.
**/

package domain;

import java.util.Hashtable;
import java.util.List;

import passables.EntityState;
import passables.SimulationStateSummary;

public class UniSimController {
	private Map map;
	private UniSimEngine engine;
	private Population population;
	private SimulationParameters sp = SimulationParameters.getInstance();
	
	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	//initialize the engine. Once the engine is initialized we can ask for the 
	//map and store it for faster access in the future.
	public void init(){
		this.engine = new UniSimEngine();
		engine.init();
		this.map = engine.getMap();
		this.population = engine.getPopulation();
	}
	
	
	public void init(Hashtable<String, Integer> params){
		if (params != null)
			this.loadParameters(params);
		else
			this.revertToDefaultSettings();
		
		this.init();
	}
	
	
	
	//initializes simulation with random parameters
	public void initRandom(){
		sp.applyRandomSettings();
		this.init();
	}
	
	
	
	//tell the engine to go forward a certain amount of turns
	public void simulate(int turns) throws InvalidMethodInvocationException{
		this.engine.simulate(turns);
	}
	
	
	
	//return a string that represents the current world map
	public List<String> getMapStrings() {
		return map.getStringList();
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
	
	
	
	//returns the settings in the form of a Hashtable
	public Hashtable<String, Integer> getParameterHash(){
		return sp.getParameterHash();
	}
	
	
	
	//update a parameter to a new value
	public void updateSetting(String parameter, int newVal) throws NonExistingParameterException{
		sp.updateParameter(parameter, newVal);
	}
	
	
	
	//revert all settings back to their default value
	public void revertToDefaultSettings(){
		sp.revertToDefaultSettings();
	}
	
	
	
	//pass given Hashtable to the settings
	public void loadParameters(Hashtable<String, Integer> params){
		sp.loadParameters(params);
	}
}
