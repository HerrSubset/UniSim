package passables;

import java.util.List;

public class EntityState {
	public final int id;
	public final String currentRole;
	public final List<String> history;
	
	public EntityState(int id, String role, List<String> history){
		this.id = id;
		this.currentRole = role;
		this.history = history;
	}
}
