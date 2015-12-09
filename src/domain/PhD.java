package domain;

public class PhD extends Role {
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public PhD(int turnCreated){
		super(turnCreated);
		this.addToHistory("Became PhD in turn " + turnCreated);
	}
	
	
	
	public PhD(int turnCreated, Entity core){
		this(turnCreated);
		this.core = core;
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
		return "Ph";
	}

	
	
	@Override
	public void performActivity() {
		// TODO Auto-generated method stub

	}

}
