package test;

import static org.junit.Assert.*;


import org.junit.Test;
import CourseMana.Student;

class Student_test {


	@Test
	void test_constructor() {
		Student demo_Student = new Student("Jack", "427689", 2025);
	}
	
	@Test
	void test_ste_get_name() {
		Student demo_Student = new Student("Jack", "427689", 2025);
		assertEquals("Jack", demo_Student.getName());
		demo_Student.setName("Randbo");
		assertEquals("Randbo", demo_Student.getName());
		
	}
	
	@Test
	void test_ste_get_id() {
		Student demo_Student = new Student("Jack", "427689", 2025);
		assertEquals("427689", demo_Student.getId());
		demo_Student.setId("12345678");
		assertEquals("12345678", demo_Student.getId());
		
	}
	
	@Test
	void test_ste_get_year() {
		Student demo_Student = new Student("Jack", "427689", 2025);
		assertEquals(2025, demo_Student.getYear());
		demo_Student.setYear(2024);
		assertEquals(2024, demo_Student.getYear());
		
	}

}
