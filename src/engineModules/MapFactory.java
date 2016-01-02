/**
***MapFactory Class
***
***this engine module handles the creation of new maps. It was created to
***separate some ugly code from the rest of the code base.
**/

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
		for (int i = 0; i < params.getParamValue("initNumberOfPlaces"); i ++){
			res.addPlace(new Place());
		}
		
		//add Lecture halls
		for (int i = 0; i < params.getParamValue("initNumberOfLectureHalls"); i++){
			res.addPlace(new LectureHall());
		}
		
		//add Bars
		for (int i = 0; i < params.getParamValue("initNumberOfBars"); i++){
			res.addPlace(new Bar());
		}
		
		return res;
	}

}
