/**
***NonExistingParameterException Class
***
***a custom error for the SimulationParameter class, thrown when an non-existing
***setting is being changed. It's a subclass of exception and doesn't add much
***to it, except for changing the class name.
**/

package domain;

@SuppressWarnings("serial")
public class NonExistingParameterException extends Exception {
	public NonExistingParameterException(String message){
		super(message);
	}
}