package test;

import static org.junit.Assert.*;


import org.junit.Test;
import CourseMana.Student;

class Student_test {


	@Test
	void test_Constructor() {
		Student demoStudent = new Student("Jack", "427689", 2025);
	}
	
	@Test
	void testSetGetName() {
		Student demoStudent = new Student("Jack", "427689", 2025);
		assertEquals("Jack", demoStudent.getName());
		demoStudent.setName("Randbo");
		assertEquals("Randbo", demoStudent.getName());
		
	}
	
	@Test
	void testSetGetId() {
		Student demoStudent = new Student("Jack", "427689", 2025);
		assertEquals("427689", demoStudent.getId());
		demoStudent.setId("12345678");
		assertEquals("12345678", demoStudent.getId());
		
	}
	
	@Test
	void testSetGetYear() {
		Student demoStudent = new Student("Jack", "427689", 2025);
		assertEquals(2025, demoStudent.getYear());
		demoStudent.setYear(2024);
		assertEquals(2024, demoStudent.getYear());
		
	}

}
