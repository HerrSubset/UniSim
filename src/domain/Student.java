/**
***Student Class
***
***this subclass of Role represents a student.
**/

package domain;

public class Student extends Role {
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Student(int turnCreated){
		super(turnCreated);
	}

	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	//returns a string representation of the class name
	@Override
	public String getRoleString() {
		return "Student";
	}

	
	
	//checks if the entity can be promoted. If it can, this function creates
	//a new role that wraps around the current entity. It then returns the
	//reference to this new role. If it can't be promoted, this function 
	//returns the reference to the current object. In case this function
	//happens to be called on a Entitycore object, an error is thrown.
	@Override
	public Entity promote(int turn) {
		Entity res = this;
		
		int age = turn - this.turnCreated;
		if (age == SimulationParameters.STUDENT_GRADUATION_AGE)
			this.addToHistory("Graduated in turn " + turn);
		
		return res;
	}
}
