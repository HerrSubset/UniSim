/**
***Entity Class
***
***Entities represent people in the simulated world
**/

package domain;

public class Entity {
	//************************************************************************
	// Variables
	//************************************************************************
	private Role currentRole;
	private RoleFactory roleFactory;
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Entity(int turnCreated){
		this(Roles.STUDENT, turnCreated);
	}
	
	public Entity(Roles role, int turnCreated){
		this.roleFactory = new RoleFactory();
		this.currentRole = roleFactory.getRole(role, turnCreated);
	}
}
