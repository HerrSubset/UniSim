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
	
	public abstract int getBirthTurn();
	public abstract void setCurrentLocation(Place p);
	
	//returns the grade an entity got as a student
	protected abstract int getGrade() throws InvalidMethodInvocationException;
	
	
	
	
	//************************************************************************
	// Other functions
	//************************************************************************
	
	//returns the state of this entity
	public abstract EntityState getState();

	
	
	//returns the entity's history contained in the EntityCore
	public abstract List<String> getHistory();

	
	
	//returns the entity's id
	public abstract int getID();

	

	//add a string to this entity's history. The history resides in the
	//entity's EntityCore
	public abstract void addToHistory(String historyItem);
	
	
	
	//checks if the entity can be promoted. If it can, this function creates
	//a new role that wraps around the current entity. It then returns the
	//reference to this new role. If it can't be promoted, this function 
	//returns the reference to the current object. In case this function
	//happens to be called on a Entitycore object, an error is thrown.
	public abstract Entity promote(int turn) throws InvalidMethodInvocationException;




	public abstract String getCharacterRepresentation();



	//performs the task that an entity can do each turn
	public abstract void performActivity();




	public void retire(int turn) {
		this.addToHistory("Retired at turn " + turn);
	}
}
