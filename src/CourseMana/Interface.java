package CourseMana;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Interface {
	
	private List<String> listOfCommands;
	
	public Interface() {
		this.listOfCommands = new LinkedList<String>();
		this.listOfCommands.add("add student");
		this.listOfCommands.add("add teacher");
		this.listOfCommands.add("add student");
	}
	
	
	public void printUsageMessage() {
		System.out.println("This program accepts the following commands");
		for (String command : listOfCommands) {
			System.out.println("<" + command + ">");
		}
	}
	
	public void executeCommand(String input) {
		switch(input) {
		case "add student":
			addStudent();
			break;
		case "add teacher":
			addTeacher();
			break;
		case "add course":
			addCourse();
			break;
		default:
			printUsageMessage();
			break;S
		}
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in); 
		String input = scanner.nextLine();
		
		for (String command : listOfCommands) {
			if (input.equals(command)) {
				executeCommand(input);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Interface i = new Interface();
		while(true) {
			i.run();
		}
	}

}
