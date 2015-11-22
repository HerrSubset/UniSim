/**
***EntitySpawner Class
***
***this engine module handles the creation of new entities each turn. It also
***handles the retirement of entities. 
**/

package domain;

import java.util.Random;

public class EntitySpawner {
	private Population population;
	private Random rand;
	private UniSimEngine engine;
	
	public EntitySpawner(Population population, UniSimEngine engine){
		rand = new Random();
		this.population = population;
		this.engine = engine;
	}

	//adds new entities every turn, according to simulation parameters
	public void run() {
		int spawnChance = SimulationParameters.ENTITY_SPAWN_CHANCE;
		
		if (rand.nextInt(99) < spawnChance){
			spawnEntities();
		}
	}
	
	private void spawnEntities(){
		//create random number within spawn number range
		int lower = SimulationParameters.ENTITY_SPAWN_BOUNDARY_LOWER;
		int upper = SimulationParameters.ENTITY_SPAWN_BOUNDARY_UPPER;
		
		int amount = rand.nextInt(upper - lower + 1) + lower;
		System.out.format("Spawning %d entities\n", amount);
		
		for( int i = 0; i < amount; i++){
			this.population.add(new Entity(engine.getTurn()));
		}
	}

}
