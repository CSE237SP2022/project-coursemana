package CourseMana;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture.AsynchronousCompletionTask;

import javax.crypto.AEADBadTagException;

import CourseMana.Student;

public class Interface {
	
	private List<String> listOfCommands;
	private Map<String, Course> idToCourse;
	private Map<String, Student> idToStudent;
	private Map<String, Teacher> idToTeacher;
	
	public Interface() {
		this.listOfCommands = new LinkedList<String>();
		this.listOfCommands.add("add student");
		this.listOfCommands.add("add teacher");
		this.listOfCommands.add("add course");
		this.listOfCommands.add("list course");
		
		this.idToCourse = new HashMap<String, Course>();
		this.idToStudent = new HashMap<String, Student>();
		this.idToTeacher = new HashMap<String, Teacher>();

	}
	
	
	public void printUsageMessage() {
		System.out.println("Cannot recognize user input.This program accepts the following commands: ");
		for (String command : listOfCommands) {
			System.out.println("<" + command + ">");
		}
	}
	
	// add new course to the system
	private void addCourse() {
		System.out.println("Hello From addCourse()");
		String courseName = askStringInput("Please Enter A Course Name: ");
		int courseSize = askPosIntInput("Please Enter The Size of the Course: ");
		String teacherId = askStringInput("Please Enter Teacher ID: ");
		
		Course newCourse = new Course(courseName, courseSize, idToTeacher.get(teacherId));
		idToCourse.put(courseName, newCourse);
		
		System.out.println(courseName + " of size " + courseSize + " is added. ");
		
	}
	
	// list all courses in the system
	private void listCourse() {
		System.out.println("Hello From listCourse()");
	}
		
	
	public void executeCommand(String input) {
		switch(input) {
		case "add student":
			System.out.println("Calling addStudent()...");
			//addStudent();
			break;
		case "add teacher":
			System.out.println("Calling addTeacher()...");
			//addTeacher();
			break;
		case "add course":
			System.out.println("Calling addCourse()...");
			addCourse();
			break;
		case "list course":
			System.out.println("Calling listCourse()...");
			listCourse();
			break;
		default:
			printUsageMessage();
			break;
		}
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in); 
		System.out.println("\nEnter Command:");
		String input = scanner.nextLine();
		
		executeCommand(input);
		
	}
	
	
	//ask for positive integer input from the user
	private int askPosIntInput(String prompt) {
		Scanner scanner = new Scanner(System.in); 
		System.out.println(prompt);
		int input = scanner.nextInt();
		while(input<0) {
			System.out.println("Please enter a positive integer.");
			input = scanner.nextInt();
		}
		return input;
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
