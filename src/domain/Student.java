/**
***Student Class
***
***this subclass of Role represents a student.
**/

package domain;

public class Student extends Role {
	
	
	public Student(int turnCreated){
		super(turnCreated);
	}

	@Override
	public String getRoleString() {
		return "Student";
	}
}
