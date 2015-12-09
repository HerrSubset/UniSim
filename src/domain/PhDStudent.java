/**
***PhDStudent Class
***
***this subclass of Role represents a PhD student.
**/

package domain;

public class PhDStudent extends Role {
	
	private int thesisProgression = 0;
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public PhDStudent(int turnCreated){
		super(turnCreated);
		addToHistory("Became a PhD student in turn " + turnCreated);
	}
	
	public PhDStudent(int turnCreated, Entity core){
		super(turnCreated, core);
		addToHistory("Became a PhD student in turn " + turnCreated);
	}

	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	//returns a string representation of the class name
	@Override
	public String getRoleString() {
		return "PhD Student";
	}

	
	
	//checks if the entity can be promoted. If it can, this function creates
	//a new role that wraps around the current entity. It then returns the
	//reference to this new role. If it can't be promoted, this function 
	//returns the reference to the current object. In case this function
	//happens to be called on a Entitycore object, an error is thrown.
	@Override
	public Entity promote(int turn) {
		Entity res = this;
		
		if (thesisProgression >= 100)
			res = new Academic(turn, this);
		
		return res;
	}



	// return an "S", the abbreviation for student in this simulation
	@Override
	public String getCharacterRepresentation() {
		return "Ps";
	}

	
	
	//advance the phdstudent's thesis progression
	@Override
	public void performActivity() {
		this.thesisProgression += 5;
	}
}
