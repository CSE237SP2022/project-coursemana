package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CourseMana.Course;
import CourseMana.Student;
import CourseMana.Teacher;

public class Course_test {

	@BeforeEach
	public void setUp() throws Exception {
	}

	//a course should have name, size, teacher, and an array of students.
	public void testConstructor() {
		
		Teacher demoTeacher = new Teacher("demo_teacher_name", "4872631", "CSE", "Professor");
		String courseName = "Computer Science";
		int courseSize = 10;
		
		Course demoCourseObj = new Course(courseName, courseSize, demoTeacher);
		
		//check for name, size, and teacher obj
		assertEquals(courseName, demoCourseObj.getName());
		assertEquals(courseSize, demoCourseObj.getSize());
		assertSame(demoTeacher, demoCourseObj.getTeacher());
	}
	
	
	@Test
	public void testSetGetName() {
		Course demoCourseObj = new Course();
		demoCourseObj.setName("cse237");
		assertEquals(demoCourseObj.getName(), "cse237");
		demoCourseObj.setName("cse131");
		assertEquals(demoCourseObj.getName(), "cse131");
	}
	
	@Test
	public void testSetGetSize() {
		Course demoCourseObj = new Course();
		demoCourseObj.setSize(20);
		assertEquals(20, demoCourseObj.getSize());
		demoCourseObj.setSize(2);
		assertEquals(2, demoCourseObj.getSize());
	}
	
	@Test
	public void testSetGetTeacher() {
		Course demoCourseObj = new Course();
		
		Teacher demoTeacher = new Teacher("demo_teacher_name", "4872631", "CSE", "Professor");
		demoCourseObj.setTeacher(demoTeacher);
		assertSame(demoTeacher, demoCourseObj.getTeacher());
		
		Teacher demoTeacher2 = new Teacher("demo_teacher_name2", "4asddsa", "CSE", "Lecturer");
		demoCourseObj.setTeacher(demoTeacher2);
		assertSame(demoTeacher2, demoCourseObj.getTeacher());
	}
	
	//get an array of students 
	@Test
	public void testAddStudent() {
		Course demoCourseObj = new Course();
		demoCourseObj.setSize(10);
		Student demoStudent = new Student("Jack", "2133134", 2023);
		Student demoStudent2 = new Student("Life", "921345", 2020);
		
		demoCourseObj.addStudent(demoStudent);
		demoCourseObj.addStudent(demoStudent2);
		
		assertEquals(2, demoCourseObj.getStudents().size());
		assertSame(demoStudent, demoCourseObj.getStudents().get(0));
		assertSame(demoStudent2, demoCourseObj.getStudents().get(1));
	}
	
	//tell whether the course is full
	@Test
	public void testIsFull() {
		Course demoCourseObj = new Course();
		demoCourseObj.setSize(2);
		
		assertFalse(demoCourseObj.isFull());
		
		Student demoStudent = new Student("Jack", "2133134", 2023);
		Student demoStudent2 = new Student("Life", "921345", 2020);
		demoCourseObj.addStudent(demoStudent);
		demoCourseObj.addStudent(demoStudent2);
		
		assertTrue(demoCourseObj.isFull());
	}
	
	//test the current number of students in the course
	@Test
	public void testGetEnrollment() {
		Course demoCourseObj = new Course();
		demoCourseObj.setSize(2);
		
		assertEquals(0, demoCourseObj.getEnrollment());
		
		Student demoStudent = new Student("Jack", "2133134", 2023);
		Student demoStudent2 = new Student("Life", "921345", 2020);
		demoCourseObj.addStudent(demoStudent);
		
		assertEquals(1, demoCourseObj.getEnrollment());
		
		demoCourseObj.addStudent(demoStudent2);
		
		assertEquals(2, demoCourseObj.getEnrollment());
	}
	
	//test the deleteStudent method
	public void testDeleteStudent() {
		Course demoCourseObj = new Course();
		demoCourseObj.setSize(2);
		
		assertEquals(0, demoCourseObj.getEnrollment());
		
		Student demoStudent = new Student("Jack", "2133134", 2023);
		Student demoStudent2 = new Student("Life", "921345", 2020);
		demoCourseObj.addStudent(demoStudent);	
		demoCourseObj.addStudent(demoStudent2);
		
		assertTrue(demoCourseObj.deleteStudent("2133134").equals(demoStudent));
		assertEquals(1, demoCourseObj.getEnrollment());
		
		assertTrue(demoCourseObj.deleteStudent("00000000").equals(null));
		assertEquals(1, demoCourseObj.getEnrollment());
	}
	
	
	

}
