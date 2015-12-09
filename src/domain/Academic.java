package domain;

public class Academic extends Role {
	
	private AcademicRole title = AcademicRole.POSTDOC;
	
	
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
		return "PhD";
	}

	
	
	@Override
	public Entity promote(int turn){
		Entity res = this;
		
		
		
		return this;
	}

	
	
	@Override
	public String getCharacterRepresentation() {
		String res = "Ph";
		
		if (this.title == AcademicRole.PROFESSOR)
			res = "Pr";
		
		return res;
	}

	
	
	@Override
	public void performActivity() {
		// TODO Auto-generated method stub

	}

}
