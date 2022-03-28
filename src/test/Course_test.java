package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import CourseMana.Course;
import CourseMana.Student;
import CourseMana.Teacher;

public class Course_test {

	@Before
	public void setUp() throws Exception {
	}

	//a course should have name, size, teacher, and an array of students.
	public void test_constructor2() {
		
		Teacher demo_teacher = new Teacher("demo_teacher_name", "4872631", "CSE", "Professor");
		String course_name = "Computer Science";
		int course_size = 10;
		
		Course demo_course_obj = new Course(course_name, course_size, demo_teacher);
		
		//check for name, size, and teacher obj
		assertEquals(course_name, demo_course_obj.getName());
		assertEquals(course_size, demo_course_obj.getSize());
		assertSame(demo_teacher, demo_course_obj.getTeacher());
		
	}
	
	
	@Test
	public void test_set_get_name() {
		Course demo_course_obj = new Course();
		demo_course_obj.setName("cse237");
		assertEquals(demo_course_obj.getName(), "cse237");
		demo_course_obj.setName("cse131");
		assertEquals(demo_course_obj.getName(), "cse131");
	}
	
	@Test
	public void test_set_get_size() {
		Course demo_course_obj = new Course();
		demo_course_obj.setSize(20);
		assertEquals(20, demo_course_obj.getSize());
		demo_course_obj.setSize(2);
		assertEquals(2, demo_course_obj.getSize());
	}
	
	@Test
	public void test_set_get_Teacher() {
		Course demo_course_obj = new Course();
		
		Teacher demo_Teacher = new Teacher("demo_teacher_name", "4872631", "CSE", "Professor");
		demo_course_obj.setTeacher(demo_Teacher);
		assertSame(demo_Teacher, demo_course_obj.getTeacher());
		
		Teacher demo_Teacher2 = new Teacher("demo_teacher_name2", "4asddsa", "CSE", "Lecturer");
		demo_course_obj.setTeacher(demo_Teacher2);
		assertSame(demo_Teacher2, demo_course_obj.getTeacher());
	}
	
	//get an array of students 
	@Test
	public void test_addStudent() {
		Course demo_course_obj = new Course();
		Student demo_student = new Student("Jack", "2133134", 2023);
		Student demo_student2 = new Student("Life", "921345", 2020);
		
		demo_course_obj.addStudent(demo_student);
		demo_course_obj.addStudent(demo_student2);
		
		assertEquals(2, demo_course_obj.getStudents().length);
		assertSame(demo_student, demo_course_obj.getStudents()[0]);
		assertSame(demo_student2, demo_course_obj.getStudents()[1]);
	}
	
	//tell whether the course is full
	@Test
	public void test_isFull() {
		Course demo_course_obj = new Course();
		demo_course_obj.setSize(2);
		
		assertFalse(demo_course_obj.isFull());
		
		Student demo_student = new Student("Jack", "2133134", 2023);
		Student demo_student2 = new Student("Life", "921345", 2020);
		demo_course_obj.addStudent(demo_student);
		demo_course_obj.addStudent(demo_student2);
		
		assertTrue(demo_course_obj.isFull());
	}
	
	
	

}
