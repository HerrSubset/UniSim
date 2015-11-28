package domain;

@SuppressWarnings("serial")
public class InvalidMethodInvocationException extends Exception {
	public InvalidMethodInvocationException(String message){
		super(message);
	}
}
