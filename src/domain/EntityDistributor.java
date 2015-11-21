/**
EntityDistributor Class

This is a module of the engine. It's task is to take a list of entities
and distribute it over the world map. In doing this, it needs to take into
account the target location preferences of the simulated entities in case such
preferences are present.
**/

package domain;

import java.util.List;
import java.util.Random;

public class EntityDistributor {
	//************************************************************************
	// Variables
	//************************************************************************
	private Map map;
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public EntityDistributor(Map map){
		this.map = map;
	}
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************

	//this function takes a list of entities and distributes them over the 
	//world map
	public void distribute(List<Entity> population) {
		//remove all entities from the map
		map.clear();
		
		List<Place> places = map.getPlaces();
		
		
		//distribute entities over all places
		for (int i = 0; i < population.size(); i++ ){
			//create random index to store the entity
			Random generator = new Random();
			int index = generator.nextInt(places.size());
			
			//store entity
			places.get(index).add(population.get(i));
		}
	}
}
