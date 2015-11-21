/**
***Population Class
***
***this is a container class for all entities. This way they are grouped and more
***more easily manageable for the engine.
**/

package domain;

import java.util.ArrayList;
import java.util.List;

public class Population {
	//************************************************************************
	// Variables
	//************************************************************************
	private List<Entity> population;
	
	
	
	
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

}
