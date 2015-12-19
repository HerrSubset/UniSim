package domain;

public class Bar extends Place {
	//************************************************************************
	// Getters/Setters
	//************************************************************************
	
	//Returns the letter that represents this type of place on the map.
	//This letter is "B" in this case.
	@Override
	protected String getCharacterRepresentation(){
		return "B";
	}
	
	
	
	
	//************************************************************************
	// Other Functions
	//************************************************************************
	
	@Override
	public String classnameToString(){
		return "Bar";
	}
}
