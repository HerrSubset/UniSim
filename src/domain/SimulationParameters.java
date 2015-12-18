/**
***SimulationParameters Class
***
***this is a class that is instantiated during simulation initialization.
***It contains all parameters for the simulation. Since these variables can't
***change during the simulation, they're all implemented as public final static
**/

package domain;

public class SimulationParameters {
	//map settings
	public final static int INIT_NUMBER_OF_PLACES = 11;
	public final static int INIT_NUMBER_OF_LECTURE_HALLS = 5;

	//# of entities of each type at the start
	public final static int INIT_STARTING_STUDENTS = 8;
	public final static int INIT_STARTING_PHD_STUDENTS = 2;
	public final static int INIT_STARTING_POSTDOCS = 3;
	public final static int INIT_STARTING_PROFESSORS = 2;
	public final static int INIT_STARTING_TRAINEES = 5;
	public final static int INIT_STARTING_CONSULTANTS = 4;
	public final static int INIT_STARTING_PARTNERS = 1;
	
	public final static int ENTITY_SPAWN_CHANCE = 10;	//1% chance of spawning new entities each turn
	public final static int ENTITY_SPAWN_BOUNDARY_LOWER = 1;	//min amount of entities when new entities spawn
	public final static int ENTITY_SPAWN_BOUNDARY_UPPER = 3;	//max amount of entities when new entities spawn
	
	public final static int STUDENT_GRADUATION_AGE = 50;	//turns after which a student graduates
	public final static int STUDENT_ATTENDANCE_RATE = 85;	//chance of a student going to class each turn
	public final static int STUDENT_LECTURE_HALL_DESTINATION_CHANCE = 90;	//chance of a student going to class each turn
	
	public final static int PHD_STUDENT_LECTURE_HALL_DESTINATION_CHANCE = 50;	//chance of phdstudent going to a lecture hall each turn
	
	public final static int PHD_MIN_ACCEPTANCE_SCORE = 85;	//minimum grade a student needs to become a PHDStudent
	public final static int PHD_LECTURE_HALL_DESTINATION_CHANCE = 70;
	
	public final static int PROFESSOR_PROMOTION_PAPER_MIN = 100;	//amount of papers a post-doc needs to be promoted to professor
	public final static int PROFESSOR_LECTURE_HALL_DESTINATION_CHANCE = 70;
	
	public final static int TRAINEE_DEFAULT_EXP_INCREASE = 2;	//the amount of experience that each trainee gains per turn;
	public final static int TRAINEE_PROMOTION_EXP = 100;	//the amount of experience a trainee needs before being promoted
	public final static int TRAINEE_LECTURE_HALL_DESTINATION_CHANCE = 0;
	
	
	public final static int CONSULTANT_LECTURE_HALL_DESTINATION_CHANCE = 10;
	
	public final static int PARTNER_LECTURE_HALL_DESTINATION_CHANCE = 20;
	
	public final static int CORPORATE_BASE_MONEY_GAIN = 1000;	//how much money a corporate gains every turn (affected by modifier based on grade)
	public final static int CORPORATE_PARTNER_BONUS_MODIFIER = 10;	//how much percent extra a partner earns
	public final static int CORPORATE_PROMOTION_BORDER = 280000;	//mount of money a corporate needs to become partner
	
	public final static int RETIREMENT_AGE = 420;	//age at which an entity retires
}
