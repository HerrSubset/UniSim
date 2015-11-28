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

import passables.Coordinate;

public class Map {
	//************************************************************************
	// Variables
	//************************************************************************
	private Place[][] grid;
	
	//************************************************************************
	// Constructors
	//************************************************************************
	public Map(){
		int h = SimulationParameters.WORLD_HEIGHT;
		int w = SimulationParameters.WORLD_WIDTH;
		grid = new Place[w][h];
		this.populateGrid();
	}
	
	
	//************************************************************************
	// Getters/Setters
	//************************************************************************
	public int getMapHeight(){
		return grid[0].length;
	}
	
	public int getMapWidth(){
		return grid.length;
	}
	
	//return a list of all Place objects on the map
	public List<Place> getPlaces(){
		ArrayList<Place> res = new ArrayList<Place>();
		
		for(int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				res.add(grid[i][j]);
			}
		}
		
		return res;
	}
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	//puts different places in the grid
	private void populateGrid(){
		for(int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				grid[i][j] = new Place();
			}
		}
	}
	
	//return one long string representing the map
	public String toString(){
		//TODO build string with stringbuilder
		String res = "";
		int minLength = getMaxPlaceInhabitants() + 3;
		
		//external loop for selecting rows
		for(int i = 0; i < grid[0].length; i++){
			//internal loop for selecting columns
			for (int j = 0; j < grid.length; j++){
				String tmp = grid[j][i].toString();
				
				//make res a default length of 8 by appending spaces;
				while (tmp.length() < minLength){
					tmp += " ";
				}
				
				res += tmp;
			}
			res += "\n";
		}
		
		return res;
	}
	
	
	
	private int getMaxPlaceInhabitants(){
		int res = 0;
		
		for(int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				if (grid[i][j].getInhabitantsAmount() > res)
					res = grid[i][j].getInhabitantsAmount();
			}
		}
		
		return res;
	}


	//remove all entities from all places
	public void clear() {
		for(int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				grid[i][j].clear();
			}
		}
	}

	
	//find the given place on the grid and return it's coordinates
	public Coordinate getCoordinate(Place p) {
		Coordinate res = null;
		
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				if (grid[i][j] == p){
					res = new Coordinate(i,j);
				}
			}
		}
		
		return res;
	}
}
