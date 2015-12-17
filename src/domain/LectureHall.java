/**
***LectureHall Class
***
***a LectureHall is a place on the map that is primarily visited by students
***and academics. This is a place where classes are taught.
***Sometimes, corporates also visit. This way they can influence the students'
***preference for a career type once they graduate.
**/

package domain;

public class LectureHall extends Place {
	//Returns the letter that represents this type of place on the map.
	//This letter is "L" in this case.
	@Override
	protected String getCharacterRepresentation(){
		return "L";
	}
}