package domain;

@SuppressWarnings("serial")
public class NonExistingParameterException extends Exception {
	public NonExistingParameterException(String message){
		super(message);
	}
}