package domain;

public class RoleFactory {

	public Role getRole(Roles role, int turnCreated) {
		Role res = null;
		
		if (role == Roles.STUDENT)
			res = new Student(turnCreated);
		
		return res;
	}

}
