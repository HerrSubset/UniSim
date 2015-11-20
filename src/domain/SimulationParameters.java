/**
SimulationParameters Class

this is a class that is instantiated during simulation initialization.
It contains all parameters for the simulation. Since these variables can't
change during the simulation, they're all implemented as public final static
**/

package domain;

public class SimulationParameters {
	public final static int WORLD_HEIGHT = 4;
	public final static int WORLD_WIDTH = 4;
}
