/**
Map Class

a Map represents the current status of the world. It is represented as a two
dimensional matrix. Every cell in the matrix contains a Place, which can contain
an unlimited amount of entities.

The main task of this class is to track where all entities are located
**/

package domain;

import java.util.ArrayList;
import java.util.List;

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
		grid = new Place[h][w];
		this.populateGrid();
	}
	
	
	//************************************************************************
	// Getters/Setters
	//************************************************************************
	public int getMapHeight(){
		return grid.length;
	}
	
	public int getMapWidth(){
		return grid[0].length;
	}
	
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
	
	public String toString(){
		//TODO build string with stringbuilder
		String res = "";
				
		for(int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				res += grid[i][j].toString();
				res += " ";
			}
			res += "\n";
		}
		
		return res;
	}


	public void clear() {
		for(int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				grid[i][j].clear();
			}
		}
	}
}
