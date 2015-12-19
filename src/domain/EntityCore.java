package domain;

import java.util.ArrayList;
import java.util.List;

import passables.EntityState;

public class EntityCore extends Entity{
	protected Place currentLocation;
	private static int entityCount = 0;
	
	private List<String> history;
	private int id;
	private Role originalRole;
	private int drunkTurns = 0;
	
	
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
	// Setters/Getters
	//************************************************************************
	@Override
	public void setCurrentLocation(Place p){
		this.currentLocation = p;
	}
	
	
	
	@Override
	public Place getCurrentLocation(){
		return this.currentLocation;
	}
	
	
	
	//return the history belonging to this entity
	@Override
	public List<String> getHistory() {
		return this.history;
	}
	
	
	
	//returns the state of this entity
	@Override
	public EntityState getState() {
		return new EntityState(id, "Entity Core", history);
	}



	@Override
	public int getID() {
		return this.id;
	}
	
	
	
	//return the grade this entity got as a student
	@Override
	protected int getGrade() throws InvalidMethodInvocationException {
		throw new InvalidMethodInvocationException("Tried retrieving grade from entity core");
	}
	
	
	
	//return "Ec", the abbreviation for EntityCore in this simulation
	@Override
	public String getCharacterRepresentation() {
		return "Ec";
	}
	
	
	
	@Override
	public int getBirthTurn() {
		return this.turnCreated;
	}
	
	
	
	@Override
	public void setDrunkTurns(int turns) {
		this.drunkTurns = turns;		
	}



	@Override
	public int getDrunkTurns() {
		return this.drunkTurns;
	}
	
	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************

	//add a new string to the entity's history
	public void addToHistory(String historyItem) {
		this.history.add(historyItem);
	}


	
	//************************************************************************
	// Empty Functions
	//
	// Because of the design with the Entity superclass, sometimes this class
	// has to implement functions that are not useful for it. These functions
	// are usuall left empty and can be found underneath.
	//************************************************************************
	
	//this method can not be called on EntityCore objects
	//TODO write own InvalidMethodException
	@Override
	public Entity promote(int turn) throws InvalidMethodInvocationException {
		throw new InvalidMethodInvocationException("Tried promoting entity core on turn " + turn);
	}



	//an entity core has no activity so leave this blank
	@Override
	public void performActivity() {}



	//entitycores don't drink, hence the empty function
	@Override
	public void drink() {}



	//entitycores don't do anything, hence the empty function
	@Override
	public void handleSpecificActivity() {}
}
