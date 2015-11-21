/**
***Place Class
***
***This class represents a place on the world map where entities can be located.
**/

package domain;

import java.util.ArrayList;
import java.util.List;

public class Place {
	//************************************************************************
	// Variables
	//************************************************************************
	private List<Entity> inhabitants;
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Place(){
		inhabitants = new ArrayList<Entity>();
	}
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	public String toString(){
		return "P|" + inhabitants.size();
	}


	//remove the entities that are present in this place
	public void clear() {
		this.inhabitants.clear();
	}


	public void add(Entity entity) {
		this.inhabitants.add(entity);
	}
}
