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
		return "P|" + getInhabitantString();
	}
	
	
	
	//return a string representing the inhabitants of this place.
	//E.g. SSPS means there's 3 Students and one PhD
	private String getInhabitantString(){
		//TODO do this with stringbuilder
		String res = "";
		
		for (int i = 0; i < inhabitants.size(); i++){
			res += inhabitants.get(i).getCharacterRepresentation();
		}
		
		return res;
	}


	//remove the entities that are present in this place
	public void clear() {
		this.inhabitants.clear();
	}

	//add an entity to this place
	public void add(Entity entity) {
		this.inhabitants.add(entity);
	}
}
