package CourseMana;
import CourseMana.*;

import java.util.ArrayList;

public class Course {

	private Teacher teacher;
	private String name;
	private int size;
	private ArrayList<Student> studentArray;
	
	public Course() {
		
	}
	
	public Course(String name, int size, Teacher teacher) {
		this.teacher = teacher;
		this.name = name;
		this.size = size;
		this.studentArray = new ArrayList<Student>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean setName(String newName) {
		if (newName == null || newName.equals("")) {
			return false;
		}
		else {
			this.name = newName; 
			return true;
		}
	}
	
	public int getSize() {
		return this.size;
	}
	
	
	
	public boolean setSize(int newSize) {
		if (newSize < 0) {
			return false;
		}
		else if (newSize < this.studentArray.size()) {
			System.out.println("The target size is less than the number of enrolled students!");
			return false;
		}
		else {
			this.size = newSize;
			return true;
		}
	}
	
	public Teacher getTeacher() {
		return this.teacher;
	}
	
	
	public boolean setTeacher(Teacher newTeacher) {
		if (newTeacher == null) {
			return false;
		}
		else {
			this.teacher = newTeacher;
			return true;
		}
	}
	
	public boolean isFull() {
		return this.studentArray.size() > this.size;
	}
	
	public int getEnrollment() {
		return this.studentArray.size();
	}
	
	public boolean addStudent(Student newStudent) {
		if (isFull()) {
			return false;
		}
		else {
			if (newStudent == null) {
				return false;
			}
			else {
				this.studentArray.add(newStudent);
				return true;
			}
		}
	}
	
	public Student deleteStudent(String studentID) {
		for (Student s : this.studentArray) {
			if (s.getId().equals(studentID)) {
				this.studentArray.remove(s);
				return s;
			}
		}
		return null;
	}
	
	public ArrayList<Student> getStudents() {
		return this.studentArray;
	}
	
	// Issues: using arrayList as container for students?
	// What if we want to set the size of the class after some students have been added?
	// camel capitalization vs underscore
	
}
