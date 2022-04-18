package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CourseMana.Interface;
import CourseMana.Student;

class Interface_test {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddStudentOne() {
		Interface i = new Interface();
		assertEquals(i.getNumStudents(), 0);
		i.addStudentHelper("12345", "John", 2024);
		i.addStudentHelper("490540", "James", 2024);
		assertEquals(i.getNumStudents(), 2);
	}
	
	void testAddStudentTwo() {
		Interface i = new Interface();
		i.addStudentHelper("John", "12345", 2024);
		i.addStudentHelper("James", "490540", 2024);
		Student John = new Student("John", "12345", 2024);
		Student James = new Student("James", "490540", 2024);
		Map<String, Student> students = i.getAllStudents();
		assertTrue(students.containsKey("12345"));
		assertTrue(students.containsKey("490540"));
		assertEquals(students.get("12345"), John);
		assertEquals(students.get("490540"), James);
	}

}
