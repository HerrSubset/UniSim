/**
***Role Class
***
***this abstract class is the superclass of all the roles an entity can have.
**/

package domain;

import java.util.List;

import passables.EntityState;

public abstract class Role extends Entity {
	//************************************************************************
	// Variables
	//************************************************************************
	protected Entity core;
	
	
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Role(int turnCreated){
		super(turnCreated);
		this.core = new EntityCore(turnCreated, this);
	}
	
	
	
	public Role(int turnCreated, Entity core){
		super(turnCreated);
		this.core = core;
	}
	
	
	
	
	//************************************************************************
	// Getters/Setters
	//************************************************************************
	public int getTurnCreated(){
		return this.turnCreated;
	}
	
	
	
	public int getBirthTurn(){
		return core.getBirthTurn();
	}
	
	
	
	@Override
	public void setCurrentLocation(Place p){
		this.core.setCurrentLocation(p);
	}
	
	
	
	@Override
	public Place getCurrentLocation(){
		return this.core.getCurrentLocation();
	}
	
	
	
	//returns a string representation of the class name
	public abstract String getRoleString();

	
	
	//returns the entity's history contained in the EntityCore
	@Override
	public List<String> getHistory() {
		return core.getHistory();
	}

	
	
	//returns the entity's id
	@Override
	public int getID() {
		return core.getID();
	}
	
	
	
	@Override
	public void setDrunkTurns(int turns) {
		this.core.setDrunkTurns(turns);
	}



	@Override
	public int getDrunkTurns() {
		return this.core.getDrunkTurns();
	}
	
	
	
	@Override
	public int getInfluence() {
		return this.core.getInfluence();
	}
	
	
	
	@Override
	protected void setInfluence(int influence) {
		this.core.setInfluence(influence);
	}
	
	
	
	@Override
	protected int getCareerPreference() {
		return this.core.getCareerPreference();
	}



	@Override
	protected void setCareerPreference(int preference) {
		this.core.setCareerPreference(preference);
	}
	
	
	
	@Override
	protected int getGrade() {
		return this.core.getGrade();
	}
	
	
	
	@Override
	protected void setGrade(int grade) {
		this.core.setGrade(grade);
	}
	
	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	//returns the state of this entity
	@Override
	public EntityState getState() {
		List<String> history = core.getHistory();
		int id = core.getID();
		
		return new EntityState(id, getRoleString(), history);
	}
	
	
	
	//add a string to this entity's history. The history resides in the
	//entity's EntityCore
	@Override
	public void addToHistory(String historyItem) {
		core.addToHistory(historyItem);
	}
	
	
	
	//calculate a modifier that changes the rate at which the trainee gains
	//experience. The modifier equals 1 + ((grade - referenceGrade)/100)
	protected double getGradeModifier(int referenceGrade, int grade){
		double res = 0.0;
		int diff = grade - referenceGrade;
		
		res = ((double)diff / 100.0) + 1;
		
	
		return res;
	}
	
	
	
	//change the careerPreference by a given amount
	@Override
	public void influence(int influence) {
		this.core.influence(influence);
	}
}
