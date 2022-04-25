package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CourseMana.Course;
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
	
	@Test 
	void testRepeatedID(){
		Interface i = new Interface();
		
		i.addTeacherHelper("Pascal", "123", "CSE", "TA");
		i.addTeacherHelper("James", "123", "MATH", "Prof");
		
		Map<String, Teacher> teachers = i.getAllTeachers();
		
		assertEquals("Pascal", teachers.get("123").getName()); 
		assertEquals(1, teachers.size()); 
		
		i.addStudentHelper("John", "12345", 2024);
		i.addStudentHelper("James", "12345", 2024);
		
		Map<String, Student> students = i.getAllStudents();
		
		assertEquals("John", students.get("12345").getName()); 
		assertEquals(1, students.size()); 
		
		
	}
	
	@Test
	void testAddCourseHelper() {
		Interface i = new Interface();
		
		i.addTeacherHelper("Pascal", "123", "CSE", "TA");
		i.addTeacherHelper("James", "490540", "MATH", "Prof");
		
		i.addCourseHelper("CSE237", "Progamming Tools", "123", 100);
		i.addCourseHelper("CSE361", "Systems Software", "123", 200);
		
		Map<String, Course> courses = i.getAllCourses();
		
		assertEquals(2, courses.size()); 
		assertEquals("Progamming Tools", courses.get("CSE237").getName()); 
		assertEquals("Systems Software", courses.get("CSE361").getName()); 
		
	}
	
	@Test
	void testAddCourseHelperNoTeacher() {
		Interface i = new Interface();

		i.addCourseHelper("CSE237", "Progamming Tools", "123", 100);
		i.addCourseHelper("CSE361", "Systems Software", "123", 200);
		
		Map<String, Course> courses = i.getAllCourses();
		
		assertEquals(0, courses.size()); 
	}
	
	@Test
	void testAddCourseHelperTeachDoesnotExist() {
		Interface i = new Interface();
		
		i.addTeacherHelper("James", "490540", "MATH", "Prof");

		i.addCourseHelper("CSE237", "Progamming Tools", "123", 100);
		i.addCourseHelper("CSE361", "Systems Software", "123", 200);
		
		Map<String, Course> courses = i.getAllCourses();
		
		assertEquals(0, courses.size()); 
	}
	
	@Test
	void testAddCourseHelperDuplicateID() {
		Interface i = new Interface();
		
		i.addTeacherHelper("Pascal", "123", "CSE", "TA");

		i.addCourseHelper("CSE237", "Progamming Tools", "123", 100);
		i.addCourseHelper("CSE237", "Systems Software", "123", 200);
		
		Map<String, Course> courses = i.getAllCourses();
		
		assertEquals(1, courses.size()); 
		assertEquals(courses.get("CSE237").getName(), "Progamming Tools");
	}
	
	@Test
	void testAddStudentToCourse() {
		Interface i = new Interface();
		
		i.addStudentHelper("John", "12345", 2024);
		i.addStudentHelper("James", "490540", 2024);
		
		Student John = new Student("John", "12345", 2024);
		Student James = new Student("James", "490540", 2024);
		
		i.addTeacherHelper("Pascal", "123", "CSE", "TA");

		i.addCourseHelper("CSE237", "Progamming Tools", "123", 100);
		i.addCourseHelper("CSE237", "Systems Software", "123", 200);
		
		i.addStudentToCourseHelper("CSE237", "12345");
		i.addStudentToCourseHelper("CSE237", "490540");
		
		Map<String, Course> courses = i.getAllCourses();

		assertEquals(courses.get("CSE237").getEnrollment(), 2);
		ArrayList<Student> enrolled = courses.get("CSE237").getStudents();
		assertTrue(enrolled.contains(John));
		assertTrue(enrolled.contains(James));
	}
	
	@Test
	void testAddStudentToCourseCourseFull() {
		Interface i = new Interface();
		
		i.addStudentHelper("John", "12345", 2024);
		i.addStudentHelper("James", "490540", 2024);
		
		Student John = new Student("John", "12345", 2024);
		Student James = new Student("James", "490540", 2024);
		
		i.addTeacherHelper("Pascal", "123", "CSE", "TA");

		i.addCourseHelper("CSE237", "Progamming Tools", "123", 1);
		
		i.addStudentToCourseHelper("CSE237", "12345");
		i.addStudentToCourseHelper("CSE237", "490540");
		
		Map<String, Course> courses = i.getAllCourses();

		assertEquals(courses.get("CSE237").getEnrollment(), 1);
		ArrayList<Student> enrolled = courses.get("CSE237").getStudents();
		assertTrue(enrolled.contains(John));
		assertFalse(enrolled.contains(James));
	}
	
	@Test
	void testListStudentFromCourseHelper() {
		Interface i = new Interface();
		
		i.addStudentHelper("John", "12345", 2024);
		i.addStudentHelper("James", "490540", 2024);
		
		Student John = new Student("John", "12345", 2024);
		Student James = new Student("James", "490540", 2024);
		
		i.addTeacherHelper("Pascal", "123", "CSE", "TA");

		i.addCourseHelper("CSE237", "Progamming Tools", "123", 100);
		i.addCourseHelper("CSE361", "Systems Software", "123", 200);
		
		i.addStudentToCourseHelper("CSE237", "12345");
		i.addStudentToCourseHelper("CSE237", "490540");
		
		List<Student> students = i.listStudentFromCourseHelper("CSE237");

		assertEquals(students.size(), 2);
		assertTrue(students.contains(John));
		assertTrue(students.contains(James));
		
		students = i.listStudentFromCourseHelper("CSE361");
		
		assertEquals(students.size(), 0);
		assertFalse(students.contains(John));
		assertFalse(students.contains(James));
		
	}
	

}
