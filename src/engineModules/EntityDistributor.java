/**
***EntityDistributor Class
***
***This is a module of the engine. It's task is to take a list of entities
***and distribute it over the world map. In doing this, it needs to take into
***account the target location preferences of the simulated entities in case such
***preferences are present.
**/

package engineModules;

import java.util.List;
import java.util.Random;

import domain.Entity;
import domain.Map;
import domain.Place;
import domain.UniSimEngine;

public class EntityDistributor {
	//************************************************************************
	// Variables
	//************************************************************************
	private Map map;
	private UniSimEngine engine;
	
	
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public EntityDistributor(Map map, UniSimEngine engine){
		this.map = map;
		this.engine = engine;
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
			//the random number is in the range 0 - places.size()
			Random generator = new Random();
			int index = generator.nextInt(places.size());
			
			//entity will be stored in this place
			Place p = places.get(index);
			Entity e = population.get(i);
			
			//add new history item to entity saying it moved
			String name = map.getPlaceName(p);
			String historyItem = "Turn " + engine.getTurn() + ": moved to "
						+ name;
			e.addToHistory(historyItem);
			
			//store entity
			p.add(e);
		}
	}
}
