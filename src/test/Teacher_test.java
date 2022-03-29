package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CourseMana.Course;
import CourseMana.Student;
import CourseMana.Teacher;

class Teacher_test {

	@Test
	void testConstructor() {
		Teacher demoTeacher = new Teacher("Shook", "4872631", "CSE", "Professor");
	}
	
	@Test
	void testSetGetName() throws Exception {
		Teacher demoTeacher = new Teacher("Shook", "4872631", "CSE", "Professor");
		assertEquals("Shook", demoTeacher.getName());
		demoTeacher.setName("Randbo");
		assertEquals("Randbo", demoTeacher.getName());
		
	}
	
	@Test
	void testSetGetId() {
		Teacher demoTeacher = new Teacher("Shook", "4872631", "CSE", "Professor");
		assertEquals("4872631", demoTeacher.getId());
		demoTeacher.setId("87654321");
		assertEquals("87654321", demoTeacher.getId());
		
	}
	
	@Test
	void testSetGetDepartment() {
		Teacher demoTeacher = new Teacher("Shook", "4872631", "CSE", "Professor");
		assertEquals("CSE", demoTeacher.getDept());
		demoTeacher.setDept("FILM");
		assertEquals("FILM", demoTeacher.getDept());
	}
	
	@Test
	void testSetGettitle() {
		Teacher demoTeacher = new Teacher("Shook", "4872631", "CSE", "Professor");
		assertEquals("Professor", demoTeacher.getTitle());
		demoTeacher.setTitle("Prof");
		assertEquals("Prof", demoTeacher.getTitle());
	}
	
	
	
}
