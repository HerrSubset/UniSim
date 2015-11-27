/**
***RoleFactory Class
***
***this class is an implementation of the factory pattern. To remove the
***combinations of "if" and "new" statements, which results in ugly code, 
***this class has been made so it could be removed from the Entity class.
**/

package domain;

public class RoleFactory {

	//takes a Roles enum and the turn in which this role was created as
	//an argument. The output is the requested Role subclass.
	public Role getRole(Roles role, int turnCreated) {
		Role res = null;
		
		if (role == Roles.STUDENT)
			res = new Student(turnCreated);
		
		return res;
	}

}
