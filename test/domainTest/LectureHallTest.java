package domainTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import domain.Academic;
import domain.LectureHall;

public class LectureHallTest {

	@Test
	public void testHasTeacher() {
		
		LectureHall lh = new LectureHall();
		assertFalse("Lecturhal should not have academic", lh.hasTeacher());
		
		Academic ac = new Academic(0);
		lh.add(ac);
		assertTrue("Lecturehall should have academic", lh.hasTeacher());
	}

}
