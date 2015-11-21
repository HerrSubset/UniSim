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
	public Entity(){
		this(Roles.STUDENT);
	}
	
	public Entity(Roles role){
		this.roleFactory = new RoleFactory();
		this.currentRole = roleFactory.getRole(role);
	}
}
