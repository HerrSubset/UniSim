/**
***Entity Class
***
***Entities represent people in the simulated world
**/

package domain;

import java.util.List;

import passables.EntityState;

public abstract class Entity {
	//************************************************************************
	// Variables
	//************************************************************************
	protected Role nextRole;
	protected int turnCreated;
	
	
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Entity(int turnCreated){
		this.turnCreated = turnCreated;
	}
	
	
	
	
	//************************************************************************
	// Getters/Setters
	//************************************************************************
	public Role getNextRole(){
		return this.nextRole;
	}
	
	public int getTurnCreated(){
		return this.turnCreated;
	}
	
	
	
	
	//************************************************************************
	// Other functions
	//************************************************************************
	public abstract EntityState getState();




	public abstract List<String> getHistory();

	public abstract int getID();


	public abstract void addToHistory(String historyItem);

}
