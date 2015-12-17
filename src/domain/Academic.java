package domain;

import java.util.Random;

public class Academic extends Role {
	
	private AcademicRole title = AcademicRole.POSTDOC;
	private int amountOfPapers = 0;
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Academic(int turnCreated){
		super(turnCreated);
		this.addToHistory("Became PhD in turn " + turnCreated);
	}
	
	
	
	public Academic(int turnCreated, Entity core){
		super(turnCreated, core);
		this.addToHistory("Became PhD in turn " + turnCreated);
	}

	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	@Override
	public String getRoleString() {
		String res = "PhD";
		
		if (this.title == AcademicRole.PROFESSOR)
			res = "Professor";
		
		return res;
	}
	
	
	
	//this function is public because it is used to create professors in the
	//PopulationFactory.
	public void promoteToProfessor(int turn){
		this.title = AcademicRole.PROFESSOR;
		this.addToHistory("Promoted to professor on turn " + turn);
	}

	
	
	@Override
	public Entity promote(int turn){
		if (this.amountOfPapers >= SimulationParameters.PROFESSOR_PROMOTION_PAPER_MIN){
			this.promoteToProfessor(turn);
		}
		
		return this;
	}

	
	
	//returns "Ph" for a post-doc and "Pr" for a professor
	@Override
	public String getCharacterRepresentation() {
		String res = "Ph";
		
		if (this.title == AcademicRole.PROFESSOR)
			res = "Pr";
		
		return res;
	}

	
	
	@Override
	public void performActivity() {
		Random rand = new Random();
		
		//assume people work until 60 years old and start studing at 18
		// --> 42 years that they are simulated
		int turnsPerYear = SimulationParameters.RETIREMENT_AGE / 42;
		
		//we want academics to publish 4 papers per year on average. 
		if (rand.nextInt(turnsPerYear) <= (turnsPerYear/4)){
			this.amountOfPapers++;
			this.addToHistory("Wrote paper");
		}
			
	}
}
