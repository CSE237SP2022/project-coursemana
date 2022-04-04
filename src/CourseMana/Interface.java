package CourseMana;

import java.util.Scanner;

public class Interface {
	
	public static void run() {
		Scanner scanner = new Scanner(System.in); 
		String input = scanner.nextLine();
		switch(input) {
		case "Add Student":
			addStudent();
			break;
		case "Add Teacher":
			addTeacher();
			break;
		case "Add Course":
			addCourse();
			break;
		default:
			printUsageMessage();
		}
	}
	
	
	public static void main(String[] args) {
		while(true) {
			run();
		}
	}

}
