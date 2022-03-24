package test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import CourseMana.Student;
import CourseMana.Teacher;

public class Teacher_test {

	@Test
	void test_constructor() {
		Teacher demo_Teacher = new Teacher("Shook", "4872631", "CSE", "Professor");
	}
	
	@Test
	void test_set_get_name() {
		Teacher demo_Teacher = new Teacher("Shook", "4872631", "CSE", "Professor");
		assertEquals("Shook", demo_Teacher.getName());
		demo_Teacher.setName("Randbo");
		assertEquals("Randbo", demo_Teacher.getName());
		
	}
	
	@Test
	void test_set_get_id() {
		Teacher demo_Teacher = new Teacher("Shook", "4872631", "CSE", "Professor");
		assertEquals("4872631", demo_Teacher.getId());
		demo_Teacher.setId("87654321");
		assertEquals("87654321", demo_Teacher.getId());
		
	}
	
	@Test
	void test_set_get_Department() {
		Teacher demo_Teacher = new Teacher("Shook", "4872631", "CSE", "Professor");
		assertEquals("CSE", demo_Teacher.getDept());
		demo_Teacher.setDept("FILM");
		assertEquals("FILM", demo_Teacher.getDept());
	}
	
	@Test
	void test_set_get_title() {
		Teacher demo_Teacher = new Teacher("Shook", "4872631", "CSE", "Professor");
		assertEquals("Professor", demo_Teacher.getTitle());
		demo_Teacher.setTitle("Prof");
		assertEquals("Prof", demo_Teacher.getTitle());
	}
	
	
	
}
