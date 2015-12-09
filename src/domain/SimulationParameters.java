/**
***SimulationParameters Class
***
***this is a class that is instantiated during simulation initialization.
***It contains all parameters for the simulation. Since these variables can't
***change during the simulation, they're all implemented as public final static
**/

package domain;

public class SimulationParameters {
	public final static int WORLD_HEIGHT = 4;
	public final static int WORLD_WIDTH = 4;
	public final static int NUMBER_OF_ENITIES = 8;
	
	public final static int ENTITY_SPAWN_CHANCE = 10;	//1% chance of spawning new entities each turn
	public final static int ENTITY_SPAWN_BOUNDARY_LOWER = 1;	//min amount of entities when new entities spawn
	public final static int ENTITY_SPAWN_BOUNDARY_UPPER = 3;	//max amount of entities when new entities spawn
	
	public final static int STUDENT_GRADUATION_AGE = 50;	//turns after which a student graduates
	public final static int STUDENT_ATTENDANCE_RATE = 85;	//chance of a student going to class each turn
	
	public final static int PHD_MIN_ACCEPTANCE_SCORE = 85;	//minimum grade a student needs to become a PHDStudent
	
	public final static int PROFESSOR_PROMOTION_PAPER_MIN = 100;	//amount of papers a post-doc needs to be promoted to professor
	
	public final static int TRAINEE_DEFAULT_EXP_INCREASE = 2;	//the amount of experience that each trainee gains per turn;
	public final static int TRAINEE_PROMOTION_EXP = 100;	//the amount of experience a trainee needs before being promoted
	
	public final static int RETIREMENT_AGE = 420;	//age at which an entity retires
}
