package domain;

public abstract class Role {
	
	private int turnCreated;
	
	public Role(int turnCreated){
		this.turnCreated = turnCreated;
	}
	
	public int getTurnCreated(){
		return this.turnCreated;
	}


}
