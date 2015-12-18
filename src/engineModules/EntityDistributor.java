/**
***EntityDistributor Class
***
***This is a module of the engine. It's task is to take a list of entities
***and distribute it over the world map. In doing this, it needs to take into
***account the target location preferences of the simulated entities in case such
***preferences are present.
**/

package engineModules;

import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import domain.Academic;
import domain.AcademicRole;
import domain.Corporate;
import domain.CorporateRole;
import domain.Entity;
import domain.LectureHall;
import domain.Map;
import domain.PhDStudent;
import domain.Place;
import domain.PlaceType;
import domain.SimulationParameters;
import domain.Student;
import domain.Trainee;
import domain.UniSimEngine;

public class EntityDistributor {
	//************************************************************************
	// Variables
	//************************************************************************
	private Map map;
	private Random rand = new Random();
	
	
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public EntityDistributor(Map map, UniSimEngine engine){
		this.map = map;
	}
	
	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************

	//this function takes a list of entities and distributes them over the 
	//world map
	public void distribute(List<Entity> population) {
		//remove all entities from the map
		map.clear();
		
		Hashtable<PlaceType, List<Place>> places = map.getPlacesHash();
		
		
		//distribute entities over all places
		for (int i = 0; i < population.size(); i++ ){
			Entity currentPerson = population.get(i);
			//find where this person wants to go to
			PlaceType destination = getDestination(currentPerson);
			
			//store person in one of those places
			store(currentPerson, places.get(destination), destination);
		}
	}
	
	
	
	//take an entity and a list of places. Store the person in one of the
	//places at random.
	private void store(Entity e, List<Place> list, PlaceType dest) {
		if (e instanceof Academic && dest == PlaceType.LECTUREHALL)
			storeTeacher(e, list);
		else 
			storeRandom(e,list);
	}
	
	
	
	//store an entity in a random place in the list
	private void storeRandom(Entity e, List<Place> list){
		int index = rand.nextInt(list.size());
		list.get(index).add(e);
	}
	
	
	
	//store a teacher in a place in the list. If there's still a place without
	//a teacher, send the teacher there. If all spots are filled, send the 
	//teacher to a random location
	private void storeTeacher(Entity e, List<Place> list){
		
		//boolean to check if the teacher is stored in the following for loop.
		//It also breaks the loop upon storing the teacher
		boolean teacherWasStored = false;
		
		for ( int i = 0; i < list.size() && !teacherWasStored; i++ ){
			LectureHall lh = (LectureHall) list.get(i);
			if (lh.hasTeacher() == false) {
				lh.add(e);
				teacherWasStored = true;
			}
		}
		
		//if the teacher was not stored in a lecturehall, select a random one
		if ( !teacherWasStored )
			storeRandom(e, list);
	}



	//************************************************************************
	// Destination Related Functions
	//************************************************************************
	private PlaceType getDestination(Entity e){
		PlaceType res = PlaceType.PLACE;
		
		if (e instanceof Student)
			res = getStudentDestination();
		
		if (e instanceof PhDStudent)
			res = getPhDStudentDestination();
		
		if (e instanceof Academic)
			res = getAcademicDestination(e);
		
		if (e instanceof Trainee)
			res = getTraineeDestination();
		
		if (e instanceof Corporate)
			res = getCorporateDestination(e);
		
		return res;
	}
	
	
	
	//return a student's destination based on the simulation parameters
	private PlaceType getStudentDestination(){
		PlaceType res = PlaceType.PLACE;
		int random = rand.nextInt(100);
		
		if (random < SimulationParameters.STUDENT_LECTURE_HALL_DESTINATION_CHANCE)
			res = PlaceType.LECTUREHALL;
		
		return res;
	}
	
	
	
	//return a phdstudent's destination based on the simulation parameters
	private PlaceType getPhDStudentDestination(){
		PlaceType res = PlaceType.PLACE;
		int random = rand.nextInt(100);
		
		if (random < SimulationParameters.PHD_STUDENT_LECTURE_HALL_DESTINATION_CHANCE)
			res = PlaceType.LECTUREHALL;
		
		return res;
	}
	
	
	
	//return an academic's destination based on the simulation parameters
	private PlaceType getAcademicDestination(Entity e){
		Academic a = (Academic) e;
		PlaceType res = PlaceType.PLACE;
		int random = rand.nextInt(100);
		
		if (a.getTitle() == AcademicRole.POSTDOC){
			if (random < SimulationParameters.PHD_LECTURE_HALL_DESTINATION_CHANCE)
				res = PlaceType.LECTUREHALL;
		} else {
			if (random < SimulationParameters.PROFESSOR_LECTURE_HALL_DESTINATION_CHANCE)
				res = PlaceType.LECTUREHALL;
		}
		return res;
	}
	
	
	
	//return a tranee's destination based on the simulation parameters
	private PlaceType getTraineeDestination(){
		PlaceType res = PlaceType.PLACE;
		int random = rand.nextInt(100);
		
		if (random < SimulationParameters.TRAINEE_LECTURE_HALL_DESTINATION_CHANCE)
			res = PlaceType.LECTUREHALL;
		
		return res;
	}
	
	
	
	//return a corporate's destination based on the simulation parameters
	private PlaceType getCorporateDestination(Entity e){
		Corporate c = (Corporate) e;
		PlaceType res = PlaceType.PLACE;
		int random = rand.nextInt(100);
		
		if (c.getJobTitle() == CorporateRole.CONSULTANT){
			if (random < SimulationParameters.CONSULTANT_LECTURE_HALL_DESTINATION_CHANCE)
				res = PlaceType.LECTUREHALL;
		} else {
			if (random < SimulationParameters.PARTNER_LECTURE_HALL_DESTINATION_CHANCE)
				res = PlaceType.LECTUREHALL;
		}
		return res;
	}
}
