package passables;

public class EntityState {
	public final int id;
	public final String currentRole;
	public final int turnCreated;
	
	public EntityState(int id, String role, int turnCreated){
		this.id = id;
		this.currentRole = role;
		this.turnCreated = turnCreated;
	}
}
