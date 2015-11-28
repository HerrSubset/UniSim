/**
***Role Class
***
***this abstract class is the superclass of all the roles an entity can have.
**/

package domain;

import java.util.List;

import passables.EntityState;

public abstract class Role extends Entity {
	//************************************************************************
	// Variables
	//************************************************************************
	protected Entity core;
	
	
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Role(int turnCreated){
		super(turnCreated);
		this.core = new EntityCore(turnCreated, this);
	}
	
	public Role(int turnCreated, Entity core){
		super(turnCreated);
		this.core = core;
	}
	
	
	
	
	//************************************************************************
	// Getters/Setters
	//************************************************************************
	public int getTurnCreated(){
		return this.turnCreated;
	}
	
	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	//returns the state of this entity
	@Override
	public EntityState getState() {
		List<String> history = core.getHistory();
		int id = core.getID();
		
		return new EntityState(id, getRoleString(), history);
	}
	
	
	
	//returns a string representation of the class name
	public abstract String getRoleString();

	
	
	//returns the entity's history contained in the EntityCore
	@Override
	public List<String> getHistory() {
		return core.getHistory();
	}

	
	
	//returns the entity's id
	@Override
	public int getID() {
		return core.getID();
	}
	
	
	
	//add a string to this entity's history. The history resides in the
	//entity's EntityCore
	@Override
	public void addToHistory(String historyItem) {
		core.addToHistory(historyItem);
	}

}
