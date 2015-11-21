/**
UniSimEngine Class

this is the center of the simulation. This class and all it's modules contain
the rules that make up the simulation. 
**/

package domain;

import passables.SimulationStateSummary;

public class UniSimEngine {
	private Map map;
	private Population population;
	private EntityDistributor distributor;
	private int turn;
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public UniSimEngine(){
		this.turn = 0;
	}
	
	
	//************************************************************************
	// Getters/Setters
	//************************************************************************
	public Map getMap(){
		return this.map;
	}
	
	
	//************************************************************************
	// Initialization
	//************************************************************************
	public void init(){
		this.map = new Map();
		this.population = new Population();
		this.distributor = new EntityDistributor(map);
		createPopulation();
		distributePopulation();
	}
	
	private void createPopulation(){
		int entitiesAmount = SimulationParameters.NUMBER_OF_ENITIES;
		
		for (int i = 0; i < entitiesAmount ; i++ ){
			this.population.add(new Entity());
		}
	}
	
	private void distributePopulation(){
		this.distributor.distribute(this.population.getPopulation());
	}
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	public void simulate(int turns){
		for (int i = 0; i < turns; i++){
			this.turn++;
			distributePopulation();
		}
	}
	
	
	
	public String currentStatusToString() {
		return "This is the current status";
	}


	public SimulationStateSummary getCurrentStatus() {
		int w = map.getMapWidth();
		int h = map.getMapHeight();
		int inh = this.population.size();
		
		return new SimulationStateSummary(w, h, inh, turn);
	}
	

}
