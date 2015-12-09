/**
***Trainee Class
***
***this subclass of Role represents a trainee.
**/

package domain;

public class Trainee extends Role {
	
	private double experience = 0;
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Trainee(int turnCreated){
		super(turnCreated);
		addToHistory("Became a Trainee in turn " + turnCreated);
	}
	
	public Trainee(int turnCreated, Entity core){
		super(turnCreated, core);
		addToHistory("Became a Trainee in turn " + turnCreated);
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

	
	
	//make the trainee gain experience. The amount of experience gained per 
	//turn depends on a simulation parameter and the trainee's final grade at 
	//university.
	@Override
	public void performActivity() {
		double expIncrease = (double)SimulationParameters.TRAINEE_DEFAULT_EXP_INCREASE;
		int grade = ((Student) (this.core)).getGrade();
		
		double modifier = getGradeModifier(grade);
		expIncrease *= modifier;
		
		this.experience += expIncrease;
		
		this.addToHistory("Experience increased with " + expIncrease);
		
	}
	
	
	
	//calculate a modifier that changes the rate at which the trainee gains
	//experience. The modifier equals 1 + ((grade - 70)/100)
	private double getGradeModifier(int grade){
		double res = 0.0;
		int diff = grade - 70;
		
		res = ((double)diff / 100.0) + 1;
		
		
		return res;
	}
}
