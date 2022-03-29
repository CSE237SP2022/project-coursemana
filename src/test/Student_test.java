package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CourseMana.Course;
import CourseMana.Student;
import CourseMana.Teacher;

public class Student_test {


	@Test
	public void testConstructor() {
		Student demoStudent = new Student("Jack", "427689", 2025);
	}
	
	@Test
	public void testSetGetName() {
		Student demoStudent = new Student("Jack", "427689", 2025);
		assertEquals("Jack", demoStudent.getName());
		demoStudent.setName("Randbo");
		assertEquals("Randbo", demoStudent.getName());
		
	}
	
	@Test
	public void testSetGetId() {
		Student demoStudent = new Student("Jack", "427689", 2025);
		assertEquals("427689", demoStudent.getId());
		demoStudent.setId("12345678");
		assertEquals("12345678", demoStudent.getId());
		
	}
	
	@Test
	public void testSetGetYear() {
		Student demoStudent = new Student("Jack", "427689", 2025);
		assertEquals(2025, demoStudent.getYear());
		demoStudent.setYear(2024);
		assertEquals(2024, demoStudent.getYear());
		
	}

}
