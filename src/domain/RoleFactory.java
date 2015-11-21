package domain;

public class RoleFactory {

	public Role getRole(Roles role) {
		Role res = null;
		
		if (role == Roles.STUDENT)
			res = new Student();
		
		return res;
	}

}
