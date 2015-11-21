/**
***SimulationParameters Class
***
***this is a class that is instantiated during simulation initialization.
***It contains all parameters for the simulation. Since these variables can't
***change during the simulation, they're all implemented as public final static
**/

package domain;

public class SimulationParameters {
	public final static int WORLD_HEIGHT = 4;
	public final static int WORLD_WIDTH = 4;
	public final static int NUMBER_OF_ENITIES = 8;
	
	public final static int ENTITY_SPAWN_CHANCE = 1;	//1% chance of spawning new entities each turn
	public final static int ENTITY_SPAWN_BOUNDARY_LOWER = 1;	//min amount of entities when new entities spawn
	public final static int ENTITY_SPAWN_BOUNDARY_UPPER = 3;	//max amount of entities when new entities spawn
}
