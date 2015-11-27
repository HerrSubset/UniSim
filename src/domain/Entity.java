/**
***Entity Class
***
***Entities represent people in the simulated world
**/

package domain;

import java.util.ArrayList;
import java.util.List;

import passables.EntityState;

public class Entity {
	//************************************************************************
	// Variables
	//************************************************************************
	private Role currentRole;
	private RoleFactory roleFactory;
	private int id;
	private List<String> history;
	
	private static int entityCount = 0;
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Entity(int turnCreated){
		this(Roles.STUDENT, turnCreated);
	}
	
	public Entity(Roles role, int turnCreated){
		this.history = new ArrayList<String>();
		this.roleFactory = new RoleFactory();
		this.currentRole = roleFactory.getRole(role, turnCreated);
		
		this.id = Entity.entityCount;
		entityCount++;
		
		//add first history entry
		String birthMessage = "Turn " + turnCreated + ": born as "
				+ this.currentRole.toString();
		this.history.add(birthMessage);
	}
	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	public EntityState getState(){
		String role = this.currentRole.toString();
		
		return new EntityState(id, role, history);
	}

	public void addToHistory(String historyItem) {
		this.history.add(historyItem);
	}
}
