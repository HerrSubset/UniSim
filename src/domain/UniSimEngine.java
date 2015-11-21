/**
***UniSimEngine Class
***
***this is the center of the simulation. This class and all it's modules contain
***the rules that make up the simulation. 
**/

package domain;

import passables.SimulationStateSummary;

public class UniSimEngine {
	//************************************************************************
	// Variables
	//************************************************************************
	private Map map;
	private Population population;
	private int turn;
	
	//engine modules
	private EntityDistributor distributor;
	private EntitySpawner spawner;
	
	
	
	
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
	
	//initialize the engine. This consists of creating all engine modules,
	//creating an initial population and distributing it over the world
	public void init(){
		this.map = new Map();
		this.population = new Population();
		this.spawner = new EntitySpawner(population);
		this.distributor = new EntityDistributor(map);
		createPopulation();
		distributePopulation();
	}
	
	//create a number of entities, according to how the simulation's
	//parameters are configured. Then add the entities to the population
	private void createPopulation(){
		int entitiesAmount = SimulationParameters.NUMBER_OF_ENITIES;
		
		for (int i = 0; i < entitiesAmount ; i++ ){
			this.population.add(new Entity());
		}
	}
	
	//call the engine's distributor module to distribute the population over
	//the world map
	private void distributePopulation(){
		this.distributor.distribute(this.population.getPopulation());
	}
	
	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	//move the simulation forward by a certain amount of turns
	public void simulate(int turns){
		for (int i = 0; i < turns; i++){
			this.turn++;
			//spawn new entities
			spawner.run();
			
			//distribute entities over world map
			distributePopulation();
		}
	}
	
	//create and return a passable object that summarizes the simulation's
	//current status
	public SimulationStateSummary getCurrentStatus() {
		int w = map.getMapWidth();
		int h = map.getMapHeight();
		int inh = this.population.size();
		
		return new SimulationStateSummary(w, h, inh, turn);
	}
	

}
