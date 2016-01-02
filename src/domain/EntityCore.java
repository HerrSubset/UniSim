/**
***EntityCore Class
***
***this is the core of every entity. All the role classes wrap around this
***class to provide extra functionality. All the basic information is stored
***here however. To get a good idea of how this works, look up the 
***decorator pattern
**/

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
	private int influence = 0;		//how much influence this entity has on students
	//int from 0-99. Closer to zero means preference for academic career
	private int careerPreference;
	private int grade;
	
	
	
	
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
	protected int getGrade() {
		return this.grade;
	}
	
	
	
	@Override
	protected void setGrade(int grade) {
		this.grade = grade;
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
	
	
	
	@Override
	public int getInfluence() {
		return this.influence;
	}



	@Override
	protected void setInfluence(int influence) {
		this.influence = influence;
	}
	
	
	
	@Override
	protected int getCareerPreference() {
		return this.careerPreference;
	}



	@Override
	protected void setCareerPreference(int preference) {
		this.careerPreference = preference;
	}
	
	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************

	//add a new string to the entity's history
	public void addToHistory(String historyItem) {
		this.history.add(historyItem);
	}
	
	
	
	//change the careerPreference by a given amount
	@Override
	public void influence(int influence) {
		this.careerPreference += influence;
		
		//make sure careerPreference doesn't get too big
		if ( this.careerPreference > 99)
			this.careerPreference = 99;
		
		//make sure careerPreference doesn't get too small
		else if ( this.careerPreference < 0 )
			this.careerPreference = 0;
	}


	
	//************************************************************************
	// Empty Functions
	//
	// Because of the design with the Entity superclass, sometimes this class
	// has to implement functions that are not useful for it. These functions
	// are usually left empty and can be found underneath.
	//************************************************************************
	
	//this method can not be called on EntityCore objects
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
