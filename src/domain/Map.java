/**
***Map Class
***
***a Map represents the current status of the world. It is represented as a two
***dimensional matrix. Every cell in the matrix contains a Place, which can contain
***an unlimited amount of entities.
***
***The main task of this class is to track where all entities are located
**/

package domain;

import java.util.ArrayList;
import java.util.List;

public class Map {
	//************************************************************************
	// Variables
	//************************************************************************
	private List<Place> grid;
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Map(){
		grid = new ArrayList<Place>();
		this.populateGrid();
	}
	
	
	
	
	//************************************************************************
	// Getters/Setters
	//************************************************************************

	//return a list of all Place objects on the map
	public List<Place> getPlaces(){
		return this.grid;
	}
	
	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	//TODO: REMOVE THIS AND REPLACE WITH FACTORY
	//puts different places in the grid
	private void populateGrid(){
		for(int i = 0; i < SimulationParameters.INIT_NUMBER_OF_PLACES; i++){
			this.grid.add(new LectureHall());
		}
	}
	
	
	
	//return one long string representing the map
	public List<String> getStringList(){
		ArrayList<String> res = new ArrayList<String>();
		
		for (int i = 0; i < grid.size(); i++){
			res.add( grid.get(i).toString() );
		}
		
		return res;
	}


	
	//remove all entities from all places
	public void clear() {
		for(int i = 0; i < grid.size(); i++){
			grid.get(i).clear();
		}
	}
	
	
	
	public String getPlaceName(Place p){
		String res = "";
		
		int index = grid.indexOf(p);
		
		if (index > -1)
			res = grid.get(index).toString();
				
		return res;
	}
}
