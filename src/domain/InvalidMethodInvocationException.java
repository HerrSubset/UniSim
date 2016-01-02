/**
***InvalidMethodInvocationException Class
***
***a custom error for the EntityCore class. It's a subclass of exception and
***doesn't add much to it, except for changing the class name.
**/

package domain;

@SuppressWarnings("serial")
public class InvalidMethodInvocationException extends Exception {
	public InvalidMethodInvocationException(String message){
		super(message);
	}
}
