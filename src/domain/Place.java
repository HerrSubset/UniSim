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


	public void clear() {
		this.inhabitants.clear();
	}


	public void add(Entity entity) {
		this.inhabitants.add(entity);
	}
}
