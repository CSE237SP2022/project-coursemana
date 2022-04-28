package CourseMana;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture.AsynchronousCompletionTask;

import javax.crypto.AEADBadTagException;

import CourseMana.Student;

public class Interface {
	
	// Data structure to keep track of supported commands.
	private List<String> listOfCommands;
	
	// Data base to keep track of courses, students, and teacher in the system.
	private Map<String, Course> idToCourse;
	private Map<String, Student> idToStudent;
	private Map<String, Teacher> idToTeacher;
	
	
	// initialize the command list and database
	public Interface() {
		this.listOfCommands = new LinkedList<String>();
		this.listOfCommands.add("add student to course");
		this.listOfCommands.add("add student");
		this.listOfCommands.add("add teacher");
		this.listOfCommands.add("add course");
		this.listOfCommands.add("list course");
		this.listOfCommands.add("list teacher");
		this.listOfCommands.add("list student");
		this.listOfCommands.add("quit");
		
		this.idToCourse = new HashMap<String, Course>();
		this.idToStudent = new HashMap<String, Student>();
		this.idToTeacher = new HashMap<String, Teacher>();

	}
	
	// called when invalid 
	public void printUsageMessage() {
		System.out.println("Cannot recognize user input. This program accepts the following commands: ");
		for (String command : listOfCommands) {
			System.out.println("<" + command + ">");
		}
	}
	
	private void listStudentFromCourse() {
		System.out.println("Hello From listStudentFromCourse()");
		String courseID = askStringInput("Please Enter A Course ID: ");
		ArrayList<Student> students = listStudentFromCourseHelper(courseID);
		if (students != null) {
			for(Student s : students) {
				String id = s.getId();
				String name = s.getName();
				int year = s.getYear();
				String message = "ID: "+ id + " Name: " + name + " Year: " + year;
				System.out.println(message);
			}
		}
	}
	
	public ArrayList<Student> listStudentFromCourseHelper(String courseID) {
		if (!idToCourse.containsKey(courseID)) {
			System.out.println("Invalid course ID.");
			return null;
		}
		return this.idToCourse.get(courseID).getStudents();
	}
	
	private void addStudentToCourse() {
		System.out.println("Hello From addStudentToCourse()");
		String courseID = askStringInput("Please Enter A Course ID: ");
		String studentID = askStringInput("Please Enter A Student ID: ");
        addStudentToCourseHelper(courseID, studentID);
	}
	
	public void addStudentToCourseHelper(String courseID, String studentID) {
		if (!idToCourse.containsKey(courseID)) {
			System.out.println("Student NOT added to course. Invalid course ID.");
			return;
		}
		if (!idToStudent.containsKey(studentID)) {
			System.out.println("Student NOT added to course. Invalid student ID.");
			return;
        }
		Course c = this.idToCourse.get(courseID);
		Student s = this.idToStudent.get(studentID);
		if (c.addStudent(s)) {
			System.out.println("Student successfully added.");
			return;
		} else {
			System.out.println("Student NOT added.");
			return;
		}
	}
	
	private void addCourse() {
		System.out.println("Hello From addCourse()");		
		String courseID = askStringInput("Please Enter A Course ID: ");
		String courseName = askStringInput("Please Enter A Course Name: ");
		int courseSize = askPosIntInput("Please Enter The Size of the Course: ");
		String teacherId = askStringInput("Please Enter Teacher ID: ");	
		addCourseHelper(courseID, courseName, teacherId, courseSize);
		
	}
	
	public void addCourseHelper(String courseID, String courseName, String teacherId, int courseSize) {
		if(idToCourse.containsKey(courseID)) {
			System.out.println("Invalid course ID - already exists");
			return;
		}
		if(idToTeacher.size()==0) {
			System.out.println("Cannot add course since there is no teacher in the system.");
			return;
		}
		if(!idToTeacher.containsKey(teacherId)) {
			System.out.println("Teacher id does not exist, please input a valid teacher id");
			return;
		}
		Course newCourse = new Course(courseName, courseID, courseSize, idToTeacher.get(teacherId));
		idToCourse.put(courseID, newCourse);
		System.out.println("ID: "+ courseID + " Name: " + courseName + " of size " + courseSize + " is added.");
	}
	
	public Map<String, Course> getAllCourses() {
		return this.idToCourse;
	}
	
    // add new student to the system
    private void addStudent() {
        System.out.println("Hello From addStudent()");
        String studentID = askStringInput("Please Enter A Student ID: ");
        String studentName = askStringInput("Please Enter A Student Name: ");
        int year = askPosIntInput("Please Enter The Year of the Student: ");
        addStudentHelper(studentName, studentID, year);
    }
    

    public void addStudentHelper(String studentName, String studentID, int year) {
	   if (idToStudent.containsKey(studentID)) {
           System.out.println("Student NOT added. ID <" + studentID + "> is in use.");
           return;
       }
	   Student newStudent = new Student(studentName, studentID, year);
       idToStudent.put(studentID, newStudent);
       System.out.println("ID: " + studentID + " Name: " + studentName + " of year " + year + " is added. ");
   }
    
	public int getNumStudents() {
		return this.idToStudent.size();
	}
	
	public Map<String, Student> getAllStudents() {
		return this.idToStudent;
	}
    
    //adds a new teacher into the system
    private void addTeacher() {
        System.out.println("Hello From addTeacher()");
        String teacherID = askStringInput("Please Enter A Teacher ID: ");
        String teacherName = askStringInput("Please Enter A Teacher Name: ");
        String teacherDepartment = askStringInput("Please Enter The Department of The Teacher: ");
        String teacherTitle = askStringInput("Please Enter The Title of The Teacher: ");
        addTeacherHelper(teacherName, teacherID, teacherDepartment, teacherTitle);
    }
    
    // helper method that add teacher to the system
    public void addTeacherHelper(String teacherName, String teacherID, String teacherDept, String teacherTitle) {
    	if (idToTeacher.containsKey(teacherID)) {
            System.out.println("Teacher NOT added. ID <" + teacherID + "> is in use.");
            return;
        }
    	Teacher newTeacher = new Teacher(teacherName, teacherID, teacherDept, teacherTitle);
        idToTeacher.put(teacherID, newTeacher);
        System.out.println("ID: " + teacherID + " Name: " + teacherName + " of department " + teacherDept + " with the title " + teacherTitle + " is added. ");
    }
    
    // get the map of teachers
    public Map<String, Teacher> getAllTeachers() {
		return this.idToTeacher;
	}
    
	// list all courses in the system
	private void listCourse() {
		System.out.println("Hello From listCourse()");
		for(Course c : idToCourse.values()) {
			String name = c.getName();
			int size = c.getSize();
			String teacherName = c.getTeacher().getName();
			String courseID = c.getID();
			String message = "ID: "+ courseID + " Name: " + name + " Size: " + size + " Teacher: " + teacherName;
			System.out.println(message);
		}
	}
	
	// list all teachers in the system
	private void listTeacher() {
		System.out.println("Hello From listTeacher()");
		for(Teacher t : idToTeacher.values()) {
			String id = t.getId();
			String name = t.getName();
			String dept = t.getDept();
			String title = t.getTitle();
			String message = "ID: "+ id + " Name: " + name + " Department: " + dept + " Title: " + title;
			System.out.println(message);
		}
	}

	
	// list all students in the system
	private void listStudent() {
		System.out.println("Hello From listStudent()");
		for(Student s : idToStudent.values()) {
			String id = s.getId();
			String name = s.getName();
			int year = s.getYear();
			String message = "ID: "+ id + " Name: " + name + " Year: " + year;
			System.out.println(message);
		}
	}
	
	
	// handle different command
	public void executeCommand(String input) {
		input = input.toLowerCase();
		input = input.replaceAll("\\s+","");
		switch(input) {
		case "liststudentfromcourse":
			System.out.println("Calling listStudentFromCourse()...");
			listStudentFromCourse();
			break;
		case "addstudenttocourse":
			System.out.println("Calling addStudentToCourse()...");
			addStudentToCourse();
			break;
		case "addstudent":
			System.out.println("Calling addStudent()...");
			addStudent();
			break;
		case "addteacher":
			System.out.println("Calling addTeacher()...");
			addTeacher();
			break;
		case "listteacher":
			System.out.println("Calling listTeacher()...");
			listTeacher();
			break;
		case "addcourse":
			System.out.println("Calling addCourse()...");
			addCourse();
			break;
		case "listcourse":
			System.out.println("Calling listCourse()...");
			listCourse();
			break;
		case "liststudent":
			System.out.println("Calling listCourse()...");
			listStudent();
			break;
		case "quit":
			System.out.println("Quiting CourseMana...");
			System.exit(0);
		default:
			printUsageMessage();
			break;
		}
	}
	
	// start the interface
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nEnter Command:");
		System.out.print("List of commands: ");
		for (String command : listOfCommands) {
			System.out.print("<" + command + "> ");
		}
		System.out.println();
		String input = scanner.nextLine();
		executeCommand(input);
	}
	
	//ask for positive integer input from the user
	private int askPosIntInput(String prompt) {
		Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        while (true) {
            try {
                String input = scanner.nextLine();
                int num = Integer.parseInt(input);
                if (num >= 0) {
                    return num;
                }
                System.out.println("Please enter a positive integer: ");
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format!");
            }
        }
	}
	
	// ask for string input from the user
	private String askStringInput(String prompt) {
		Scanner scanner = new Scanner(System.in); 
		System.out.println(prompt);
		String input = scanner.nextLine();
		return input;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to CourseMana :)");
		
		Interface i = new Interface();
		while(true) {
			i.run();
		}
	}

}
