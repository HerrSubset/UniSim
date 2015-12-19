package engineModules;

import domain.Bar;
import domain.LectureHall;
import domain.Map;
import domain.Place;
import domain.SimulationParameters;

public class MapFactory {	

	//************************************************************************
	// Methods for creating maps
	//************************************************************************
	public Map getInitialMap(){
		Map res = new Map();
		
		//add places
		for (int i = 0; i < SimulationParameters.INIT_NUMBER_OF_PLACES; i ++){
			res.addPlace(new Place());
		}
		
		//add Lecture halls
		for (int i = 0; i < SimulationParameters.INIT_NUMBER_OF_LECTURE_HALLS; i++){
			res.addPlace(new LectureHall());
		}
		
		//add Bars
		for (int i = 0; i < SimulationParameters.INIT_NUMBER_OF_BARS; i++){
			res.addPlace(new Bar());
		}
		
		return res;
	}

}
