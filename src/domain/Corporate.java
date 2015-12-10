package domain;

public class Corporate extends Role {
	
	private CorporateRole jobTitle = CorporateRole.CONSULTANT;
	private double moneyEarned = 0.0;
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Corporate(int turnCreated){
		super(turnCreated);
		this.addToHistory("Became Consultant in turn " + turnCreated);
	}
	
	
	
	public Corporate(int turnCreated, Entity core){
		super(turnCreated, core);
		this.addToHistory("Became Consultant in turn " + turnCreated);
	}
	
		
		
		
	//************************************************************************
	// Other Functions
	//************************************************************************
	@Override
	public String getRoleString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity promote(int turn){
		return this;
	}

	@Override
	public String getCharacterRepresentation() {
		String res = "C";
		
		if (this.jobTitle == CorporateRole.PARTNER)
			res = "Pa";
		
		return res;
	}

	//let the corporate earn money. The rate at which money is earned depends
	//on his university grade and a 
	@Override
	public void performActivity() {
		
	}

}
