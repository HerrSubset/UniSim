/**
***SimulationParameters Class
***
***this is a class that is instantiated during simulation initialization.
***It contains all parameters for the simulation. Since these variables can't
***change during the simulation, they're all implemented as private
**/

package domain;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

public class SimulationParameters {

	//variable to contain the singleton
	private static SimulationParameters instance = null;
	
	private Hashtable<String, Integer> paramContainer;



	
	//************************************************************************
	// Singleton Functions
	//************************************************************************

	//make sure the constructor can't be called from outside
	private SimulationParameters(){
		//intitialize all variables to their default
		this.revertToDefaultSettings();
	}



	//returns the single instance if it exists. Otherwise create it first.
	public static SimulationParameters getInstance(){
		if (instance == null)
			instance = new SimulationParameters();

		return instance;
	}
	
	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	//Returns the value of a given parameter
	public int getParamValue(String param){
		return this.paramContainer.get(param);
	}
	
	
	
	//returns the entire hash with parameters
	public Hashtable<String, Integer> getParameterHash(){
		return this.paramContainer;
	}
	
	
	
	//update the given parameter to a new value
	public void updateParameter(String parameter, int newVal) throws NonExistingParameterException{
		if ( !paramContainer.containsKey(parameter))
			throw new NonExistingParameterException("The parameter " + parameter + " does not exist");
		paramContainer.replace(parameter, newVal);
	}
	
	
	
	//takes a hash and loads all parameters into the paramContainer
	public void loadParameters(Hashtable<String, Integer> params){
		Enumeration<String> keys = params.keys();
		
		while (keys.hasMoreElements()){
			String curKey = keys.nextElement();
			
			//only store parameters that already exist in the paramcontainer
			if (paramContainer.containsKey(curKey)){
				paramContainer.replace(curKey, params.get(curKey));
			}
		}
	}
	
	
	
	
	//************************************************************************
	// Default Settings
	//************************************************************************
	
	//reverts all the settings to their default setting
	public void revertToDefaultSettings(){
		paramContainer = new Hashtable<String, Integer>();
		
		//amount of places per type
		this.paramContainer.put("initNumberOfPlaces", 11);
		this.paramContainer.put("initNumberOfLectureHalls", 5);
		this.paramContainer.put("initNumberOfBars", 2);
		
		//# of entities of each type at the start
		this.paramContainer.put("initStartingStudents", 8);
		this.paramContainer.put("initStartingPhdStudents", 2);
		this.paramContainer.put("initStartingPostdocs", 3);
		this.paramContainer.put("initStartingProfessors", 2);
		this.paramContainer.put("initStartingTrainees", 5);
		this.paramContainer.put("initStartingConsultants", 4);
		this.paramContainer.put("initStartingPartners", 1);
		
		//parameters regarding students spawning each turn
		this.paramContainer.put("entitySpawnChance", 10);	//1% chance of spawning new entities each turn
		this.paramContainer.put("entitySpawnBoundaryLower", 1);	//min amount of entities when new entities spawn
		this.paramContainer.put("entitySpawnBoundaryUpper", 3);	//max amount of entities when new entities spawn

		//student parameters
		this.paramContainer.put("studentGraduationAge", 50);	//turns after which a student graduates
		this.paramContainer.put("studentLectureHallDestinationChance", 90);	//
		this.paramContainer.put("studentBarDestinationChance", 6);
		this.paramContainer.put("studentDrunkTurns", 4);
		this.paramContainer.put("studentStudentInfluence", 0);
		
		//phd student parameters
		this.paramContainer.put("phdStudentLectureHallDestinationChance", 50);
		this.paramContainer.put("phdStudentBarDestinationChance", 4);
		this.paramContainer.put("phdStudentDrunkTurns", 3);
		this.paramContainer.put("phdMinAcceptanceScore", 85);	//min grade a student needs to become a phdStudent
		this.paramContainer.put("phdStudentStudentInfluence", 0);

		//phd(postdoc) paramenters
		this.paramContainer.put("phdLectureHallDestinationChance", 70);
		this.paramContainer.put("phdBarDestinationChance", 2);
		this.paramContainer.put("phdDrunkTurns", 2);
		this.paramContainer.put("phdStudentInfluence", 1);

		//professor parameters
		this.paramContainer.put("professorPromotionPaperMin", 100);	//# of papers a postdoc needs to be promoted to professor
		this.paramContainer.put("professorLectureHallDestinationChance", 70);
		this.paramContainer.put("professorBarDestinationChance", 2);
		this.paramContainer.put("professorDrunkTurns", 2);
		this.paramContainer.put("professorStudentInfluence", 2);
		
		//trainee parameters
		this.paramContainer.put("traineeDefaultExpIncrease", 2);	//the amount of experience that each trainee gains per turn
		this.paramContainer.put("traineePromotionExp", 100);	//the amount of experience a trainee needs to be promoted
		this.paramContainer.put("traineeLectureHallDestinationChance", 0);
		this.paramContainer.put("traineeBarDestinationChance", 0);
		this.paramContainer.put("traineeDrunkTurns", 1);
		this.paramContainer.put("traineeStudentInfluence", 0);
		
		//consultant parameters
		this.paramContainer.put("consultantLectureHallDestinationChance", 10);
		this.paramContainer.put("consultantBarDestinationChance", 2);
		this.paramContainer.put("consultantDrunkTurns", 2);
		this.paramContainer.put("consultantStudentInfluence", 10);
		
		//partner parameters
		this.paramContainer.put("partnerLectureHallDestinationChance", 20);
		this.paramContainer.put("partnerBarDestinationChance", 4);
		this.paramContainer.put("partnerDrunkTurns", 2);
		this.paramContainer.put("partnerStudentInfluence", 15);
		
		//corporate (partner + consultant) parameters
		this.paramContainer.put("corporateBaseMoneyGain", 1000);	//how much money a corporate gains every turn (affected by modifier based on grade)
		this.paramContainer.put("corporatePartnerBonusModifier", 10);	//how much percent extra a partner earns
		this.paramContainer.put("corporatePromotionBorder", 280000);	//amount of money a consultant needs to be promoted to partner
		this.paramContainer.put("corporateDrunkTurns", 2);
		
		this.paramContainer.put("retirementAge", 420);
	}
	
	
	
	
	//************************************************************************
	// Random Settings
	//************************************************************************
	
	public void applyRandomSettings(){
		paramContainer = new Hashtable<String, Integer>();
		Random r = new Random();
		
		//amount of places per type
		this.paramContainer.put("initNumberOfPlaces", r.nextInt(19) + 1);
		this.paramContainer.put("initNumberOfLectureHalls", r.nextInt(19) + 1);
		this.paramContainer.put("initNumberOfBars", r.nextInt(19) + 1);
		
		//# of entities of each type at the start
		this.paramContainer.put("initStartingStudents", r.nextInt(20));
		this.paramContainer.put("initStartingPhdStudents", r.nextInt(20));
		this.paramContainer.put("initStartingPostdocs", r.nextInt(20));
		this.paramContainer.put("initStartingProfessors", r.nextInt(20));
		this.paramContainer.put("initStartingTrainees", r.nextInt(20));
		this.paramContainer.put("initStartingConsultants", r.nextInt(20));
		this.paramContainer.put("initStartingPartners", r.nextInt(20));
		
		//parameters regarding students spawning each turn
		this.paramContainer.put("entitySpawnChance", r.nextInt(99));
		this.paramContainer.put("entitySpawnBoundaryLower", r.nextInt(10));
		this.paramContainer.put("entitySpawnBoundaryUpper", r.nextInt(10) + paramContainer.get("entitySpawnBoundaryLower"));	

		//student parameters
		this.paramContainer.put("studentGraduationAge", r.nextInt(99));	
		this.paramContainer.put("studentLectureHallDestinationChance", r.nextInt(50));	
		this.paramContainer.put("studentBarDestinationChance", r.nextInt(50));
		this.paramContainer.put("studentDrunkTurns", r.nextInt(10));
		this.paramContainer.put("studentStudentInfluence", r.nextInt(50) - 25 );
		
		//phd student parameters
		this.paramContainer.put("phdStudentLectureHallDestinationChance", r.nextInt(50));
		this.paramContainer.put("phdStudentBarDestinationChance", r.nextInt(50));
		this.paramContainer.put("phdStudentDrunkTurns", r.nextInt(10));
		this.paramContainer.put("phdMinAcceptanceScore", r.nextInt(99));	
		this.paramContainer.put("phdStudentStudentInfluence", r.nextInt(50));

		//phd(postdoc) paramenters
		this.paramContainer.put("phdLectureHallDestinationChance", r.nextInt(50));
		this.paramContainer.put("phdBarDestinationChance", r.nextInt(50));
		this.paramContainer.put("phdDrunkTurns", r.nextInt(10));
		this.paramContainer.put("phdStudentInfluence", r.nextInt(50));

		//professor parameters
		this.paramContainer.put("professorPromotionPaperMin", r.nextInt(300));	
		this.paramContainer.put("professorLectureHallDestinationChance", r.nextInt(50));
		this.paramContainer.put("professorBarDestinationChance", r.nextInt(50));
		this.paramContainer.put("professorDrunkTurns", r.nextInt(10));
		this.paramContainer.put("professorStudentInfluence", r.nextInt(50));
		
		//trainee parameters
		this.paramContainer.put("traineeDefaultExpIncrease", r.nextInt(10));	
		this.paramContainer.put("traineePromotionExp", r.nextInt(300));	
		this.paramContainer.put("traineeLectureHallDestinationChance", r.nextInt(50));
		this.paramContainer.put("traineeBarDestinationChance", r.nextInt(50));
		this.paramContainer.put("traineeDrunkTurns", r.nextInt(10));
		this.paramContainer.put("traineeStudentInfluence", r.nextInt(50));
		
		//consultant parameters
		this.paramContainer.put("consultantLectureHallDestinationChance", r.nextInt(50));
		this.paramContainer.put("consultantBarDestinationChance", r.nextInt(50));
		this.paramContainer.put("consultantDrunkTurns", r.nextInt(10));
		this.paramContainer.put("consultantStudentInfluence", r.nextInt(50));
		
		//partner parameters
		this.paramContainer.put("partnerLectureHallDestinationChance", r.nextInt(50));
		this.paramContainer.put("partnerBarDestinationChance", r.nextInt(50));
		this.paramContainer.put("partnerDrunkTurns", r.nextInt(10));
		this.paramContainer.put("partnerStudentInfluence", r.nextInt(50));
		
		//corporate (partner + consultant) parameters
		this.paramContainer.put("corporateBaseMoneyGain", r.nextInt(3000) +1);	
		this.paramContainer.put("corporatePartnerBonusModifier", r.nextInt(30));	
		this.paramContainer.put("corporatePromotionBorder", r.nextInt(500000) + 100000);	
		
		this.paramContainer.put("retirementAge", r.nextInt(1000) + 200);
	}
}
