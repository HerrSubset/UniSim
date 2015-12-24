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
	protected SimulationParameters params = SimulationParameters.getInstance();
	
	
	
	
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
	public abstract Place getCurrentLocation();
	public abstract void setDrunkTurns(int turns);
	public abstract int getDrunkTurns();
	public abstract int getInfluence();
	protected abstract void setInfluence(int influence);
	
	//returns the grade an entity got as a student
	protected abstract int getGrade() throws InvalidMethodInvocationException;
	
	
	
	
	//************************************************************************
	// Abstract functions
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
	
	
	
	public abstract void drink();
	
	
	
	//callback for the performActivity() method for when it can't handle
	//general behavior. This function lets the subclasses implement 
	//behavior that's specific for them.
	public abstract void handleSpecificActivity();



	
	//************************************************************************
	// Other functions
	//************************************************************************
	
	//check if the entity is drunk. If this is not the case handle some common
	//behavior like drinking. Otherwise, let the subclass handle the activity.
	public void performActivity(){
		int drunkTurns = this.getDrunkTurns();
		
		if ( drunkTurns == 0 ){
			if (this.getCurrentLocation() instanceof Bar ) {
				this.drink();
			} else
				this.handleSpecificActivity();
		} else {
			this.setDrunkTurns(drunkTurns - 1);	//reduce drunk turns by one
			this.addToHistory("Too drunk to do anything!");
		}
	}



	//add to the history that the entity retired in a certain turn
	public void retire(int turn) {
		this.addToHistory("Retired at turn " + turn);
	}
}
