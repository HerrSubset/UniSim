/**
***Population Class
***
***this is a container class for all entities. This way they are grouped and more
***more easily manageable for the engine.
**/

package domain;

import java.util.ArrayList;
import java.util.List;

import passables.EntityState;

public class Population {
	//************************************************************************
	// Variables
	//************************************************************************
	private List<Entity> population;
	private SimulationParameters params = SimulationParameters.getInstance();
	
	
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Population(){
		this.population = new ArrayList<Entity>();
	}

	
	
	
	//************************************************************************
	// Getters/Setters
	//************************************************************************
	
	//add entity to the simulated population
	public void add(Entity entity) {
		population.add(entity);
	}

	
	
	public List<Entity> getPopulation() {
		return this.population;
	}

	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	//return the amount of entities being simulated
	public int size() {
		return this.population.size();
	}
	
	
	
	//return a list of EntityStates. These contain the state and histories of
	//all the entities in the population.
	public List<EntityState> getEntityHistories(){
		ArrayList<EntityState> res = new ArrayList<EntityState>();
		
		for (int i = 0; i < this.population.size(); i++){
			res.add(this.population.get(i).getState());
		}
		
		return res;
	}



	//loop through all entities and run their promote() function. This function
	//promotes them in case they are eligible.
	public void executePromotions(int turn) throws InvalidMethodInvocationException {
		for (int i = 0; i < this.population.size(); i++){
			Entity e = population.get(i);

			population.set(i, e.promote(turn));
		}
	}



	//loop through all entities and perform their activity for this turn
	public void performActivities() {
		for (int i = 0; i < this.population.size(); i++){
			Entity e = population.get(i);

			e.performActivity();
		}
	}
	
	
	
	//loop through all entities and retire them if they're old enough
	public void handleRetirements(int turn){
		for (int i = 0; i < this.population.size(); i++){
			Entity e = population.get(i);
			
			//check if e is old enough for retirement
			int retirementAge = params.getParamValue("retirementAge");
			if ((turn - e.getBirthTurn()) >= retirementAge){
				this.retire(e, turn, i);
				i--;
			}
		}
	}
	
	
	
	//remove the given entity from the simulation
	private void retire(Entity e, int turn, int index){
		e.retire(turn);
		this.population.remove(index);
	}

}
