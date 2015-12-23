/**
***SimulationParameters Class
***
***this is a class that is instantiated during simulation initialization.
***It contains all parameters for the simulation. Since these variables can't
***change during the simulation, they're all implemented as private
**/

package domain;

public class SimulationParameters {

	//variable to contain the singleton
	private static SimulationParameters instance = null;




	//************************************************************************
	// Simulation Parameters
	//************************************************************************

	//map settings
	private int initNumberOfPlaces = 11;
	private int initNumberOfLectureHalls = 5;
	private int initNumberOfBars = 2;

	//# of entities of each type at the start
	private int initStartingStudents = 8;
	private int initStartingPhdStudents = 2;
	private int initStartingPostdocs = 3;
	private int initStartingProfessors = 2;
	private int initStartingTrainees = 5;
	private int initStartingConsultants = 4;
	private int initStartingPartners = 1;

	private int entitySpawnChance = 10;	//1% chance of spawning new entities each turn
	private int entitySpawnBoundaryLower = 1;	//min amount of entities when new entities spawn
	private int entitySpawnBoundaryUpper = 3;	//max amount of entities when new entities spawn

	private int studentGraduationAge = 50;	//turns after which a student graduates
	private int studentAttendanceRate = 85;	//chance of a student going to class each turn
	private int studentLectureHallDestinationChance = 90;	//chance of a student going to class each turn
	private int studentBarDestinationChance = 6;
	private int studentDrunkTurns = 4;

	private int phdStudentLectureHallDestinationChance = 50;	//chance of phdstudent going to a lecture hall each turn
	private int phdStudentBarDestinationChance = 4;
	private int phdStudentDrunkTurns = 3;

	private int phdMinAcceptanceScore = 85;	//minimum grade a student needs to become a PHDStudent
	private int phdLectureHallDestinationChance = 70;
	private int phdBarDestinationChance = 2;

	private int professorPromotionPaperMin = 100;	//amount of papers a post-doc needs to be promoted to professor
	private int professorLectureHallDestinationChance = 70;
	private int professorBarDestinationChance = 2;

	private int academicDrunkTurns = 2;

	private int traineeDefaultExpIncrease = 2;	//the amount of experience that each trainee gains per turn;
	private int traineePromotionExp = 100;	//the amount of experience a trainee needs before being promoted
	private int traineeLectureHallDestinationChance = 0;
	private int traineeBarDestinationChance = 0;
	private int traineeDrunkTurns = 1;


	private int consultantLectureHallDestinationChance = 10;
	private int consultantBarDestinationChance = 2;

	private int partnerLectureHallDestinationChance = 20;
	private int partnerBarDestinationChance = 4;

	private int corporateBaseMoneyGain = 1000;	//how much money a corporate gains every turn (affected by modifier based on grade)
	private int corporatePartnerBonusModifier = 10;	//how much percent extra a partner earns
	private int corporatePromotionBoder = 280000;	//mount of money a corporate needs to become partner
	private int corporateDrunkTurns = 2;

	private int retirementAge = 420;	//age at which an entity retires




	//************************************************************************
	// Singleton Functions
	//************************************************************************

	//make sure the constructor can't be called from outside
	private SimulationParameters(){

	}



	//returns the single instance if it exists. Otherwise create it first.
	public static SimulationParameters getInstance(){
		if (instance == null)
			instance = new SimulationParameters();

		return instance;
	}




	//************************************************************************
	// Getters/Setters
	//************************************************************************
	
	public int getInitNumberOfPlaces() {
		return initNumberOfPlaces;
	}



	public void setInitNumberOfPlaces(int initNumberOfPlaces) {
		this.initNumberOfPlaces = initNumberOfPlaces;
	}



	public int getInitNumberOfLectureHalls() {
		return initNumberOfLectureHalls;
	}



	public void setInitNumberOfLectureHalls(int initNumberOfLectureHalls) {
		this.initNumberOfLectureHalls = initNumberOfLectureHalls;
	}



	public int getInitNumberOfBars() {
		return initNumberOfBars;
	}



	public void setInitNumberOfBars(int initNumberOfBars) {
		this.initNumberOfBars = initNumberOfBars;
	}



	public int getInitStartingStudents() {
		return initStartingStudents;
	}



	public void setInitStartingStudents(int initStartingStudents) {
		this.initStartingStudents = initStartingStudents;
	}



	public int getInitStartingPhdStudents() {
		return initStartingPhdStudents;
	}



	public void setInitStartingPhdStudents(int initStartingPhdStudents) {
		this.initStartingPhdStudents = initStartingPhdStudents;
	}



	public int getInitStartingPostdocs() {
		return initStartingPostdocs;
	}



	public void setInitStartingPostdocs(int initStartingPostdocs) {
		this.initStartingPostdocs = initStartingPostdocs;
	}



	public int getInitStartingProfessors() {
		return initStartingProfessors;
	}



	public void setInitStartingProfessors(int initStartingProfessors) {
		this.initStartingProfessors = initStartingProfessors;
	}



	public int getInitStartingTrainees() {
		return initStartingTrainees;
	}



	public void setInitStartingTrainees(int initStartingTrainees) {
		this.initStartingTrainees = initStartingTrainees;
	}



	public int getInitStartingConsultants() {
		return initStartingConsultants;
	}



	public void setInitStartingConsultants(int initStartingConsultants) {
		this.initStartingConsultants = initStartingConsultants;
	}



	public int getInitStartingPartners() {
		return initStartingPartners;
	}



	public void setInitStartingPartners(int initStartingPartners) {
		this.initStartingPartners = initStartingPartners;
	}



	public int getEntitySpawnChance() {
		return entitySpawnChance;
	}



	public void setEntitySpawnChance(int entitySpawnChance) {
		this.entitySpawnChance = entitySpawnChance;
	}



	public int getEntitySpawnBoundaryLower() {
		return entitySpawnBoundaryLower;
	}



	public void setEntitySpawnBoundaryLower(int entitySpawnBoundaryLower) {
		this.entitySpawnBoundaryLower = entitySpawnBoundaryLower;
	}



	public int getEntitySpawnBoundaryUpper() {
		return entitySpawnBoundaryUpper;
	}



	public void setEntitySpawnBoundaryUpper(int entitySpawnBoundaryUpper) {
		this.entitySpawnBoundaryUpper = entitySpawnBoundaryUpper;
	}



	public int getStudentGraduationAge() {
		return studentGraduationAge;
	}



	public void setStudentGraduationAge(int studentGraduationAge) {
		this.studentGraduationAge = studentGraduationAge;
	}



	public int getStudentAttendanceRate() {
		return studentAttendanceRate;
	}



	public void setStudentAttendanceRate(int studentAttendanceRate) {
		this.studentAttendanceRate = studentAttendanceRate;
	}



	public int getStudentLectureHallDestinationChance() {
		return studentLectureHallDestinationChance;
	}



	public void setStudentLectureHallDestinationChance(int studentLectureHallDestinationChance) {
		this.studentLectureHallDestinationChance = studentLectureHallDestinationChance;
	}



	public int getStudentBarDestinationChance() {
		return studentBarDestinationChance;
	}



	public void setStudentBarDestinationChance(int studentBarDestinationChance) {
		this.studentBarDestinationChance = studentBarDestinationChance;
	}



	public int getStudentDrunkTurns() {
		return studentDrunkTurns;
	}



	public void setStudentDrunkTurns(int studentDrunkTurns) {
		this.studentDrunkTurns = studentDrunkTurns;
	}



	public int getPhdStudentLectureHallDestinationChance() {
		return phdStudentLectureHallDestinationChance;
	}



	public void setPhdStudentLectureHallDestinationChance(int phdStudentLectureHallDestinationChance) {
		this.phdStudentLectureHallDestinationChance = phdStudentLectureHallDestinationChance;
	}



	public int getPhdStudentBarDestinationChance() {
		return phdStudentBarDestinationChance;
	}



	public void setPhdStudentBarDestinationChance(int phdStudentBarDestinationChance) {
		this.phdStudentBarDestinationChance = phdStudentBarDestinationChance;
	}



	public int getPhdStudentDrunkTurns() {
		return phdStudentDrunkTurns;
	}



	public void setPhdStudentDrunkTurns(int phdStudentDrunkTurns) {
		this.phdStudentDrunkTurns = phdStudentDrunkTurns;
	}



	public int getPhdMinAcceptanceScore() {
		return phdMinAcceptanceScore;
	}



	public void setPhdMinAcceptanceScore(int phdMinAcceptanceScore) {
		this.phdMinAcceptanceScore = phdMinAcceptanceScore;
	}



	public int getPhdLectureHallDestinationChance() {
		return phdLectureHallDestinationChance;
	}



	public void setPhdLectureHallDestinationChance(int phdLectureHallDestinationChance) {
		this.phdLectureHallDestinationChance = phdLectureHallDestinationChance;
	}



	public int getPhdBarDestinationChance() {
		return phdBarDestinationChance;
	}



	public void setPhdBarDestinationChance(int phdBarDestinationChance) {
		this.phdBarDestinationChance = phdBarDestinationChance;
	}



	public int getProfessorPromotionPaperMin() {
		return professorPromotionPaperMin;
	}



	public void setProfessorPromotionPaperMin(int professorPromotionPaperMin) {
		this.professorPromotionPaperMin = professorPromotionPaperMin;
	}



	public int getProfessorLectureHallDestinationChance() {
		return professorLectureHallDestinationChance;
	}



	public void setProfessorLectureHallDestinationChance(int professorLectureHallDestinationChance) {
		this.professorLectureHallDestinationChance = professorLectureHallDestinationChance;
	}



	public int getProfessorBarDestinationChance() {
		return professorBarDestinationChance;
	}



	public void setProfessorBarDestinationChance(int professorBarDestinationChance) {
		this.professorBarDestinationChance = professorBarDestinationChance;
	}



	public int getAcademicDrunkTurns() {
		return academicDrunkTurns;
	}



	public void setAcademicDrunkTurns(int academicDrunkTurns) {
		this.academicDrunkTurns = academicDrunkTurns;
	}



	public int getTraineeDefaultExpIncrease() {
		return traineeDefaultExpIncrease;
	}



	public void setTraineeDefaultExpIncrease(int traineeDefaultExpIncrease) {
		this.traineeDefaultExpIncrease = traineeDefaultExpIncrease;
	}



	public int getTraineePromotionExp() {
		return traineePromotionExp;
	}



	public void setTraineePromotionExp(int traineePromotionExp) {
		this.traineePromotionExp = traineePromotionExp;
	}



	public int getTraineeLectureHallDestinationChance() {
		return traineeLectureHallDestinationChance;
	}



	public void setTraineeLectureHallDestinationChance(int traineeLectureHallDestinationChance) {
		this.traineeLectureHallDestinationChance = traineeLectureHallDestinationChance;
	}



	public int getTraineeBarDestinationChance() {
		return traineeBarDestinationChance;
	}



	public void setTraineeBarDestinationChance(int traineeBarDestinationChance) {
		this.traineeBarDestinationChance = traineeBarDestinationChance;
	}



	public int getTraineeDrunkTurns() {
		return traineeDrunkTurns;
	}



	public void setTraineeDrunkTurns(int traineeDrunkTurns) {
		this.traineeDrunkTurns = traineeDrunkTurns;
	}



	public int getConsultantLectureHallDestinationChance() {
		return consultantLectureHallDestinationChance;
	}



	public void setConsultantLectureHallDestinationChance(int consultantLectureHallDestinationChance) {
		this.consultantLectureHallDestinationChance = consultantLectureHallDestinationChance;
	}



	public int getConsultantBarDestinationChance() {
		return consultantBarDestinationChance;
	}



	public void setConsultantBarDestinationChance(int consultantBarDestinationChance) {
		this.consultantBarDestinationChance = consultantBarDestinationChance;
	}



	public int getPartnerLectureHallDestinationChance() {
		return partnerLectureHallDestinationChance;
	}



	public void setPartnerLectureHallDestinationChance(int partnerLectureHallDestinationChance) {
		this.partnerLectureHallDestinationChance = partnerLectureHallDestinationChance;
	}



	public int getPartnerBarDestinationChance() {
		return partnerBarDestinationChance;
	}



	public void setPartnerBarDestinationChance(int partnerBarDestinationChance) {
		this.partnerBarDestinationChance = partnerBarDestinationChance;
	}



	public int getCorporateBaseMoneyGain() {
		return corporateBaseMoneyGain;
	}



	public void setCorporateBaseMoneyGain(int corporateBaseMoneyGain) {
		this.corporateBaseMoneyGain = corporateBaseMoneyGain;
	}



	public int getCorporatePartnerBonusModifier() {
		return corporatePartnerBonusModifier;
	}



	public void setCorporatePartnerBonusModifier(int corporatePartnerBonusModifier) {
		this.corporatePartnerBonusModifier = corporatePartnerBonusModifier;
	}



	public int getCorporatePromotionBoder() {
		return corporatePromotionBoder;
	}



	public void setCorporatePromotionBoder(int corporatePromotionBoder) {
		this.corporatePromotionBoder = corporatePromotionBoder;
	}



	public int getCorporateDrunkTurns() {
		return corporateDrunkTurns;
	}



	public void setCorporateDrunkTurns(int corporateDrunkTurns) {
		this.corporateDrunkTurns = corporateDrunkTurns;
	}



	public int getRetirementAge() {
		return retirementAge;
	}



	public void setRetirementAge(int retirementAge) {
		this.retirementAge = retirementAge;
	}
}
