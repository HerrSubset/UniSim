/**
***EntityState Class
***
***this is an object that is passed from the domain to the UI to transfer some information.
***It's just a container of final variables without getters/setters, similar to a struct
***in C/C++
**/

package passables;

import java.util.List;

public class EntityState {
	public final int id;
	public final String currentRole;
	public final List<String> history;
	
	
	
	
	//************************************************************************
	// Functions
	//************************************************************************
	
	public EntityState(int id, String role, List<String> history){
		this.id = id;
		this.currentRole = role;
		this.history = history;
	}
	
	
	@Override
	public String toString(){
		String res = currentRole + " (id: " + id + ")";
		return res;
	}
}
