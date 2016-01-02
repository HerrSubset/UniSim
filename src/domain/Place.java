/**
***Place Class
***
***This class represents a place on the world map where entities can be located.
**/

package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Place {
	//************************************************************************
	// Variables
	//************************************************************************
	protected List<Entity> inhabitants;
	
	
	
	
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
		return getCharacterRepresentation() + "|" + getInhabitantString();
	}
	
	
	
	//returns class name as a string
	public String classnameToString(){
		return "Place";
	}
	
	
	
	//get representation of this class on the map
	protected String getCharacterRepresentation(){
		return "P";
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
		entity.setCurrentLocation(this);
	}
	
	
	
	//calculates the influence in this place and then applies it to all entities
	public void applyInfluence(){
		int influence = this.calculateInfluence();
		
		Iterator<Entity> iterator = inhabitants.iterator();
		while ( iterator.hasNext() ){
			Entity e = iterator.next();
			e.influence(influence);
		}
	}
	
	
	
	//calculates the influence of all entities in this place
	public int calculateInfluence(){
		int res = 0;
		Iterator<Entity> iterator = inhabitants.iterator();
		
		while ( iterator.hasNext() ){
			Entity e = iterator.next();
			res += e.getInfluence();
		}
		
		return res;
	}
}
