/**
***EntitySpawner Class
***
***this engine module handles the creation of new entities each turn. It also
***handles the retirement of entities. 
**/

package engineModules;

import java.util.Random;

import domain.Population;
import domain.SimulationParameters;
import domain.Student;
import domain.UniSimEngine;

public class EntitySpawner {
	private Population population;
	private Random rand;
	private UniSimEngine engine;
	private SimulationParameters params = SimulationParameters.getInstance();
	
	public EntitySpawner(Population population, UniSimEngine engine){
		rand = new Random();
		this.population = population;
		this.engine = engine;
	}

	//adds new entities every turn, according to simulation parameters
	public void run() {
		int spawnChance = params.getEntitySpawnChance();
		
		if (rand.nextInt(99) < spawnChance){
			spawnEntities();
		}
	}
	
	//add new entities to the population. The amount depends on parameters
	//given in the SimulationParameters class.
	private void spawnEntities(){
		//create random number within spawn number range
		int lower = params.getEntitySpawnBoundaryLower();
		int upper = params.getEntitySpawnBoundaryUpper();
		
		int amount = rand.nextInt(upper - lower + 1) + lower;
		System.out.format("Spawning %d entities\n", amount);
		
		for( int i = 0; i < amount; i++){
			this.population.add(new Student(engine.getTurn()));
		}
	}

}
