/**
***UniSimEngine Class
***
***this is the center of the simulation. This class and all it's modules contain
***the rules that make up the simulation. 
**/

package domain;

import engineModules.EntityDistributor;
import engineModules.EntitySpawner;
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
	private PopulationFactory popFact;
	
	
	
	
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
	
	public int getTurn(){
		return this.turn;
	}
	
	public Population getPopulation(){
		return this.population;
	}
	
	
	
	
	//************************************************************************
	// Initialization
	//************************************************************************
	
	//initialize the engine. This consists of creating all engine modules,
	//creating an initial population and distributing it over the world
	public void init(){
		//load modules
		this.map = new Map();
		this.popFact = new PopulationFactory(this);
		this.population = popFact.getInitialPopulation();
		this.spawner = new EntitySpawner(population, this);
		this.distributor = new EntityDistributor(map, this);
		
		//create initial population
		distributePopulation();
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
	public void simulate(int turns) throws InvalidMethodInvocationException{
		for (int i = 0; i < turns; i++){
			this.turn++;
			
			//retire all entities that are eligible
			population.handleRetirements(this.turn);
			
			//promote the entities that are eligible
			population.executePromotions(this.turn);
			
			//let all entities execute their activity for this turn
			population.performActivities();
			
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
