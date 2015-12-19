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
import java.util.Hashtable;
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
	}
	
	
	
	
	//************************************************************************
	// Getters/Setters
	//************************************************************************

	//return a list of all Place objects on the map
	public List<Place> getPlaces(){
		return this.grid;
	}
	
	
	
	//return a hash where all places are sorted by type
	public Hashtable<PlaceType, List<Place>> getPlacesHash(){
		Hashtable<PlaceType, List<Place>> res = new Hashtable<PlaceType, List<Place>>();
		
		for (int i = 0; i < grid.size(); i++ ){
			Place p = grid.get(i);
			
			if (p instanceof LectureHall)
				addToHash(p, res, PlaceType.LECTUREHALL);
			
			if (p instanceof Bar)
				addToHash(p, res, PlaceType.BAR);
			
			else
				addToHash(p, res, PlaceType.PLACE);
			
		}
		
		return res;
	}
	
	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************	
	
	//appends a place to the right place in the hash. This is a helper function
	//for the getPlacesHash function.
	private void addToHash(Place p, Hashtable<PlaceType, List<Place>> hash, PlaceType type){
		if (hash.get(type) != null)
			hash.get(type).add(p);
		
		else {
			hash.put(type, new ArrayList<Place>());
			hash.get(type).add(p);
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
			res = grid.get(index).classnameToString();
				
		return res;
	}
	
	
	
	//add a given place to the map
	public void addPlace(Place p){
		grid.add(p);
	}
}
