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
	private int turnCreated;
	private Entity core;
	
	
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Role(int turnCreated){
		super(turnCreated);
		EntityCore core = new EntityCore(turnCreated, this);
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
	@Override
	public EntityState getState() {
		List<String> history = core.getHistory();
		int id = core.getID();
		
		return new EntityState(id, getRoleString(), history);
	}
	
	public abstract String getRoleString();


	@Override
	public List<String> getHistory() {
		return core.getHistory();
	}

	@Override
	public int getID() {
		return core.getID();
	}
	
	@Override
	public void addToHistory(String historyItem) {
		core.addToHistory(historyItem);
	}

}
