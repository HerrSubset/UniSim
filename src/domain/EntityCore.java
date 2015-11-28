package domain;

import java.util.ArrayList;
import java.util.List;

import passables.EntityState;

public class EntityCore extends Entity{
	private static int entityCount = 0;
	
	private List<String> history;
	private int id;
	private Role originalRole;
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public EntityCore(int turnCreated, Role role){
		super(turnCreated);
		this.history = new ArrayList<String>();
		this.originalRole = role;
		
		this.id = EntityCore.entityCount;
		entityCount++;
		
		//add first history entry
		String birthMessage = "Turn " + turnCreated + ": born as "
				+ this.originalRole.getRoleString();
		this.history.add(birthMessage);
	}
	
	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************

	//add a new string to the entity's history
	public void addToHistory(String historyItem) {
		this.history.add(historyItem);
	}



	//returns the state of this entity
	@Override
	public EntityState getState() {
		return new EntityState(id, "Entity Core", history);
	}


	
	//return the history belonging to this entity
	@Override
	public List<String> getHistory() {
		return this.history;
	}



	@Override
	public int getID() {
		return this.id;
	}


	
	//this method can not be called on EntityCore objects
	//TODO write own InvalidMethodException
	@Override
	public Entity promote(int turn) throws InvalidMethodInvocationException {
		throw new InvalidMethodInvocationException("Tried promoting entity core on turn " + turn);
	}



	//return "Ec", the abbreviation for EntityCore in this simulation
	@Override
	public String getCharacterRepresentation() {
		return "Ec";
	}
}
