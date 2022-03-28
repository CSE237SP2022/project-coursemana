package test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import CourseMana.Student;
import CourseMana.Teacher;

public class Teacher_test {

	@Test
	public void testConstructor() {
		Teacher demoTeacher = new Teacher("Shook", "4872631", "CSE", "Professor");
	}
	
	@Test
	public void testSetGetName() throws Exception {
		Teacher demoTeacher = new Teacher("Shook", "4872631", "CSE", "Professor");
		assertEquals("Shook", demoTeacher.getName());
		demoTeacher.setName("Randbo");
		assertEquals("Randbo", demoTeacher.getName());
		
	}
	
	@Test
	public void testSetGetId() {
		Teacher demoTeacher = new Teacher("Shook", "4872631", "CSE", "Professor");
		assertEquals("4872631", demoTeacher.getId());
		demoTeacher.setId("87654321");
		assertEquals("87654321", demoTeacher.getId());
		
	}
	
	@Test
	public void testSetGetDepartment() {
		Teacher demoTeacher = new Teacher("Shook", "4872631", "CSE", "Professor");
		assertEquals("CSE", demoTeacher.getDept());
		demoTeacher.setDept("FILM");
		assertEquals("FILM", demoTeacher.getDept());
	}
	
	@Test
	public void testSetGettitle() {
		Teacher demoTeacher = new Teacher("Shook", "4872631", "CSE", "Professor");
		assertEquals("Professor", demoTeacher.getTitle());
		demoTeacher.setTitle("Prof");
		assertEquals("Prof", demoTeacher.getTitle());
	}
	
	
	
}
