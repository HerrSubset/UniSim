/**
***Role Class
***
***this abstract class is the superclass of all the roles an entity can have.
**/

package domain;

public abstract class Role {
	//************************************************************************
	// Variables
	//************************************************************************
	private int turnCreated;
	
	
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Role(int turnCreated){
		this.turnCreated = turnCreated;
	}
	
	
	
	
	//************************************************************************
	// Getters/Setters
	//************************************************************************
	public int getTurnCreated(){
		return this.turnCreated;
	}


}
