package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CourseMana.Interface;
import CourseMana.Student;
import CourseMana.Teacher;

class Interface_test {

	@Test
	void testAddStudentOne() {
		Interface i = new Interface();
		assertEquals(i.getNumStudents(), 0);
		i.addStudentHelper("12345", "John", 2024);
		i.addStudentHelper("490540", "James", 2024);
		assertEquals(i.getNumStudents(), 2);
	}
	
	@Test
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
	
	@Test
	void testAddTeacherHelper() {
		Interface i = new Interface();
		
		i.addTeacherHelper("Pascal", "123", "CSE", "TA");
		i.addTeacherHelper("James", "490540", "MATH", "Prof");
		
		Teacher Pascal = new Teacher("Pascal", "123", "CSE", "TA");
		Teacher James = new Teacher("James", "490540", "MATH", "Prof");
		
		Map<String, Teacher> teachers = i.getAllTeachers();
		
		assertTrue(teachers.containsKey("123"));
		assertTrue(teachers.containsKey("490540"));
		
		Teacher mapPascal = teachers.get("123");
		Teacher mapJames = teachers.get("490540");
		
		assertEquals(Pascal.getName(), mapPascal.getName());
		assertEquals(Pascal.getDept(), mapPascal.getDept());
		assertEquals(Pascal.getId(), mapPascal.getId());
		assertEquals(Pascal.getTitle(), mapPascal.getTitle());
		
		assertEquals(James.getName(), mapJames.getName());
		assertEquals(James.getDept(), mapJames.getDept());
		assertEquals(James.getId(), mapJames.getId());
		assertEquals(James.getTitle(), mapJames.getTitle());
	}

}
