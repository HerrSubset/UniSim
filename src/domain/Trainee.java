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
	public Trainee(int turnCreated, int grade){
		super(turnCreated);
		addToHistory("Became a Trainee in turn " + turnCreated);
		this.setInfluence(params.getParamValue("traineeStudentInfluence"));
		this.setGrade(grade);
	}
	
	public Trainee(int turnCreated, Entity core){
		super(turnCreated, core);
		addToHistory("Became a Trainee in turn " + turnCreated);
		this.setInfluence(params.getParamValue("traineeStudentInfluence"));
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
		
		double promotionLevel = (double) params.getParamValue("traineePromotionExp");
		if (experience >= promotionLevel)
			res = new Corporate(turn, this);
		
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
	public void handleSpecificActivity() {
		double expIncrease = (double) params.getParamValue("traineeDefaultExpIncrease");
		int grade = this.getGrade();
		
		double modifier = getGradeModifier(70, grade);
		expIncrease *= modifier;
		
		this.experience += expIncrease;		
	}

	
	
	//sets for how many turns this trainee will be drunk
	@Override
	public void drink() {
		this.setDrunkTurns(params.getParamValue("traineeDrunkTurns"));
	}
}
