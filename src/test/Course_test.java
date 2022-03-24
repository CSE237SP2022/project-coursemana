package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import CourseMana.Course;

public class Course_test {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_constructor1() {
		final String course_name = "Computer Science";
		Course demo_course_obj = new Course();
	}
	
	
	@Test
	public void test_set_get_name() {
		Course demo_course_obj = new Course();
		demo_course_obj.setName("cse237");
		assertEquals(demo_course_obj.getName(), "cse237");
		demo_course_obj.setName("cse131");
		assertEquals(demo_course_obj.getName(), "cse131");
	}
	
	

}
