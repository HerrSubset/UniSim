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
	// Getters/Setters
	//************************************************************************
	public CorporateRole getJobTitle(){
		return this.jobTitle;
	}
	
		
		
		
	//************************************************************************
	// Other Functions
	//************************************************************************
	@Override
	public String getRoleString() {
		String res = "Consultant";
		
		if (this.jobTitle == CorporateRole.PARTNER)
			res = "Partner";
		
		return res;
	}
	
	
	
	//this method is public because the PopulationFactory needs to be able to 
	//promote newly created consultants to partner level
	public void promoteToPartner(int turn){
		this.jobTitle = CorporateRole.PARTNER;
		this.addToHistory("Became partner in turn " + turn);
	}

	
	
	//check if the corporate can be promoted and do so if possible
	@Override
	public Entity promote(int turn){
		if (moneyEarned >= params.getCorporatePromotionBoder() 
						&& this.jobTitle != CorporateRole.PARTNER){
			this.promoteToPartner(turn);
		}
		return this;
	}

	
	
	//return 'C' for consultants and 'Pa' for partners
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
	public void handleSpecificActivity() {
		double moneyGain = this.getGradeModifier(80, this.getGrade()) * params.getCorporateBaseMoneyGain();
		
		if (this.jobTitle == CorporateRole.PARTNER)
			moneyGain *= params.getCorporatePartnerBonusModifier();
		
		this.moneyEarned += moneyGain;
	}



	@Override
	public void drink() {
		this.setDrunkTurns(params.getCorporateDrunkTurns());
	}
}
