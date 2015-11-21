/**
Population Class

this is a container class for all entities. This way they are grouped and more
more easily manageable for the engine.

**/

package domain;

import java.util.ArrayList;
import java.util.List;

public class Population {
	
	private List<Entity> population;
	
	public Population(){
		this.population = new ArrayList<Entity>();
	}

	public void add(Entity entity) {
		population.add(entity);
	}

	public List<Entity> getPopulation() {
		return this.population;
	}

	public int size() {
		return this.population.size();
	}

}
