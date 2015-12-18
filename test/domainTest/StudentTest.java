package domainTest;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Academic;
import domain.LectureHall;
import domain.Student;

public class StudentTest {

	@Test
	public void LecturehallWithTeacherIncreasesClassCount() {
		LectureHall lh = new LectureHall();
		Academic ac = new Academic(0);
		lh.add(ac);
		
		Student s = new Student(0);
		int classes = s.getClassesAttended();
		lh.add(s);
		
		assertEquals("Student's location has to be updated upon adding him to a location", s.getCurrentLocation(), lh);
		
		//make student follow class
		s.performActivity();
		
		assertEquals("Student class count needs to increase by one", classes + 1, s.getClassesAttended());
	}

}
