package domain;

import java.util.List;
import java.util.Random;

public class EntityDistributor {
	private Map map;
	
	public EntityDistributor(Map map){
		this.map = map;
	}

	public void distribute(List<Entity> population) {
		map.clear();
		
		List<Place> places = map.getPlaces();
		
		for (int i = 0; i < population.size(); i++ ){
			//create random index to store the entity
			Random generator = new Random();
			int index = generator.nextInt(places.size());
			
			//store entity
			places.get(index).add(population.get(i));
		}
	}
}
