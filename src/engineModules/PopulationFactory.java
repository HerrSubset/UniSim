/**
***PopulationFactory Class
***
***this class was made to separate all ugly code regarding the creation of new
***entities and populations from the rest of the code base.
**/

package engineModules;

import java.util.Random;

import domain.Academic;
import domain.Corporate;
import domain.PhDStudent;
import domain.Population;
import domain.SimulationParameters;
import domain.Student;
import domain.Trainee;
import domain.UniSimEngine;

public class PopulationFactory {
	//************************************************************************
	// Variables
	//************************************************************************
	private UniSimEngine engine;
	private Random rand = new Random();
	private SimulationParameters params = SimulationParameters.getInstance();
	
	
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public PopulationFactory(UniSimEngine engine){
		this.engine = engine;
	}
	
	
	
	
	//************************************************************************
	// Methods for creating populations
	//************************************************************************
	public Population getInitialPopulation(){
		Population res = new Population();		
		//add students
		for (int i = 0; i< params.getParamValue("initStartingStudents"); i++){
			res.add(this.createStudent());
		}
		
		//add PhD students
		for (int i = 0; i< params.getParamValue("initStartingPhdStudents"); i++){
			res.add(this.createPhDStudent());
		}
		
		//add postdocs
		for (int i = 0; i< params.getParamValue("initStartingPostdocs"); i++){
			res.add(this.createPostDoc());
		}
		
		//add professors
		for (int i = 0; i< params.getParamValue("initStartingProfessors"); i++){
			res.add(this.createProfessor());
		}
		
		//add trainees
		for (int i = 0; i< params.getParamValue("initStartingTrainees"); i++){
			res.add(this.createTrainee());
		}
		
		//add consultants
		for (int i = 0; i< params.getParamValue("initStartingConsultants"); i++){
			res.add(this.createConsultant());
		}
		
		//add consultants
		for (int i = 0; i< params.getParamValue("initStartingPartners"); i++){
			res.add(this.createPartner());
		}

		
		return res;
	}
	
	
	
	
	//************************************************************************
	// Methods to create individual entities
	//************************************************************************
	private Student createStudent(){
		return new Student(engine.getTurn());
	}
	
	
	
	private PhDStudent createPhDStudent(){
		//create student with grade
		Student s = createStudent();
		int grade = rand.nextInt(100);
		s.setGrade(grade);
		
		return new PhDStudent(engine.getTurn(), s);
	}
	
	
	
	private Academic createPostDoc(){
		PhDStudent phd = this.createPhDStudent();
		
		return new Academic(engine.getTurn(), phd);
	}
	
	
	
	private Academic createProfessor(){
		Academic a = createPostDoc();
		a.promoteToProfessor(engine.getTurn());
		return a;
	}
	
	
	
	private Trainee createTrainee(){
		Student s = createStudent();
		int grade = rand.nextInt(100);
		s.setGrade(grade);
		
		return new Trainee(engine.getTurn(), s);
	}
	
	
	
	private Corporate createConsultant(){
		Trainee t = createTrainee();
		
		return new Corporate(engine.getTurn(), t);
	}
	
	
	
	private Corporate createPartner(){
		Corporate c = this.createConsultant();
		c.promoteToPartner(engine.getTurn());
		return c;
	}
}
