/**
***ProgressionHandler Class
***
***This is an engine module. It will loop through all entities each turn.
***In case they can be upgraded to a new role, this class will handle that.
**/

package engineModules;

import java.util.List;

import domain.Entity;
import domain.Role;
import domain.SimulationParameters;
import domain.Student;
import domain.UniSimEngine;

public class ProgressionHandler {
	//************************************************************************
	// Variables
	//************************************************************************
	private UniSimEngine engine;
	
	
	
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public ProgressionHandler(UniSimEngine engine){
		this.engine = engine;
	}




	public void run() {
		List<Entity> population = this.engine.getPopulation().getPopulation();
		
		for (int i = 0; i < population.size(); i++){
			//loop through all entities and perform checks based on their role
			Role r = population.get(i).getCurrentRole();
			
			if (r instanceof Student)
				checkStudentProgression(population.get(i));
		}
	}
	
	
	
	
	//************************************************************************
	// Student progression handling
	//************************************************************************
	private void checkStudentProgression(Entity e){
		int studentAge = engine.getTurn() - e.getTurnCreated();
		
		if (studentAge == SimulationParameters.STUDENT_GRADUATION_AGE){
			//TODO make student become phd student or trainee
			String message = "Turn " + engine.getTurn() + ": graduated";
			e.addToHistory(message);
		}
	}
}
