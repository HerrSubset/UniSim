package engineModules;

import domain.Bar;
import domain.LectureHall;
import domain.Map;
import domain.Place;
import domain.SimulationParameters;

public class MapFactory {
	private SimulationParameters params = SimulationParameters.getInstance();

	//************************************************************************
	// Methods for creating maps
	//************************************************************************
	public Map getInitialMap(){
		Map res = new Map();
		
		//add places
		for (int i = 0; i < params.getInitNumberOfPlaces(); i ++){
			res.addPlace(new Place());
		}
		
		//add Lecture halls
		for (int i = 0; i < params.getInitNumberOfLectureHalls(); i++){
			res.addPlace(new LectureHall());
		}
		
		//add Bars
		for (int i = 0; i < params.getInitNumberOfBars(); i++){
			res.addPlace(new Bar());
		}
		
		return res;
	}

}
