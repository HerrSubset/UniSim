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
	protected abstract int getCareerPreference();
	protected abstract void setCareerPreference(int preference);
	protected abstract int getGrade();
	protected abstract void setGrade(int grade);
	public abstract EntityState getState();
	public abstract List<String> getHistory();
	public abstract int getID();
	
	
	//************************************************************************
	// Other Abstract Functions
	//************************************************************************
	
	//add a string to this entity's history. The history resides in the
	//entity's EntityCore
	public abstract void addToHistory(String historyItem);
	
	
	
	//checks if the entity can be promoted. If it can, this function creates
	//a new role that wraps around the current entity. It then returns the
	//reference to this new role. If it can't be promoted, this function 
	//returns the reference to the current object. In case this function
	//happens to be called on a Entitycore object, an error is thrown.
	public abstract Entity promote(int turn) throws InvalidMethodInvocationException;



	//returns the string that has to be used to represent this entity
	//on the map
	public abstract String getCharacterRepresentation();
	
	
	
	//makes the entity drunk based on the simulation parameters
	public abstract void drink();
	
	
	
	//callback for the performActivity() method for when it can't handle
	//general behavior. This function lets the subclasses implement 
	//behavior that's specific for them.
	public abstract void handleSpecificActivity();
	
	
	
	//influence the entity by a given amount
	public abstract void influence(int influence);



	
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
