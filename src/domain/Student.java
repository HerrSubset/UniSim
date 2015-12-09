/**
***Student Class
***
***this subclass of Role represents a student.
**/

package domain;

import java.util.Random;

public class Student extends Role {
	
	private int classesAttended = 0;
	private int grade;
	//int from 0-99. Closer to zero means preference for academic career
	private int careerPreference;
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Student(int turnCreated){
		super(turnCreated);
		Random rand = new Random();
		this.careerPreference = rand.nextInt(99);
	}

	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	//returns a string representation of the class name
	@Override
	public String getRoleString() {
		return "Student";
	}

	
	
	//checks if the entity can be promoted. If it can, this function creates
	//a new role that wraps around the current entity. It then returns the
	//reference to this new role. If it can't be promoted, this function 
	//returns the reference to the current object. In case this function
	//happens to be called on a Entitycore object, an error is thrown.
	@Override
	public Entity promote(int turn) {
		Entity res = this;
		
		int age = turn - this.turnCreated;
		if (age == SimulationParameters.STUDENT_GRADUATION_AGE){
			this.calculateGrade();
			this.addToHistory("Graduated in turn " + turn 
							+ " with grade " + this.grade);
		
			//promote student to PhDStudent or Trainee
			//based on score and preference
			int minGrade = SimulationParameters.PHD_MIN_ACCEPTANCE_SCORE;
			
			if (this.grade >= minGrade && this.careerPreference < 50)
				res = new PhDStudent(turn, this);
			else
				res = new Trainee(turn, this);
		}
		
		
		return res;
	}
	
	
	//calculates the attendance rate of the student based on the simulation
	//parameters and then gives a grade based on that.
	private void calculateGrade(){
		float attendanceRate = (float) this.classesAttended / 
				(float) SimulationParameters.STUDENT_GRADUATION_AGE;
		
		this.grade = (int)(attendanceRate * 100);
	}



	// return an "S", the abbreviation for student in this simulation
	@Override
	public String getCharacterRepresentation() {
		return "S";
	}



	//give a student a chance each turn to go to class
	@Override
	public void performActivity() {
		Random rand = new Random();
		
		int randomNumber = rand.nextInt(100);
		
		//check if student goes to class this turn
		if (randomNumber < SimulationParameters.STUDENT_ATTENDANCE_RATE){
			this.classesAttended++;
			//log that student went to class
			this.addToHistory("Attended Class");
		}
	}
}
