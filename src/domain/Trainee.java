/**
***Trainee Class
***
***this subclass of Role represents a trainee.
**/

package domain;

public class Trainee extends Role {
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Trainee(int turnCreated){
		super(turnCreated);
		addToHistory("Became a Trainee in turn " + turnCreated);
	}
	
	public Trainee(int turnCreated, Entity core){
		this(turnCreated);
		this.core = core;
	}

	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	//returns a string representation of the class name
	@Override
	public String getRoleString() {
		return "Trainee";
	}

	
	
	//checks if the entity can be promoted. If it can, this function creates
	//a new role that wraps around the current entity. It then returns the
	//reference to this new role. If it can't be promoted, this function 
	//returns the reference to the current object. In case this function
	//happens to be called on a Entitycore object, an error is thrown.
	@Override
	public Entity promote(int turn) {
		Entity res = this;
		

		
		return res;
	}



	// return an "S", the abbreviation for student in this simulation
	@Override
	public String getCharacterRepresentation() {
		return "T";
	}

	
	//TODO
	@Override
	public void performActivity() {
		// TODO Auto-generated method stub
		
	}
}
