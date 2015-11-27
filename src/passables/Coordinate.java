/**
***Coordinate Class
***
***this is an object that is passed faround the domain to transfer some information.
***It's just a container of final variables without getters/setters, similar to a struct
***in C/C++
**/

package passables;

public class Coordinate {
	public final int x; //represents column on the map
	public final int y; //represents row on the map
	
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
}
