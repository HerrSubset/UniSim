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
	
	
	
	public int getBirthTurn(){
		return core.getBirthTurn();
	}
	
	
	
	//return the grade this entity got as a student
	@Override
	protected int getGrade() {
		int res = 0;
		
		try {
			res = this.core.getGrade();
		} catch (InvalidMethodInvocationException e){
			//this error is thrown if the entity never was a student
			//(the call reaches the EntityCore object)
			System.out.println(e.getMessage());
		}
		
		return res;
	}
	
	
	
	@Override
	public void setCurrentLocation(Place p){
		this.core.setCurrentLocation(p);
	}
	
	
	
	@Override
	public Place getCurrentLocation(){
		return this.core.getCurrentLocation();
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
	
	
	
	//add a string to this entity's history. The history resides in the
	//entity's EntityCore
	@Override
	public void addToHistory(String historyItem) {
		core.addToHistory(historyItem);
	}
	
	
	
	//calculate a modifier that changes the rate at which the trainee gains
	//experience. The modifier equals 1 + ((grade - referenceGrade)/100)
	protected double getGradeModifier(int referenceGrade, int grade){
		double res = 0.0;
		int diff = grade - referenceGrade;
		
		res = ((double)diff / 100.0) + 1;
		
	
		return res;
	}
}
