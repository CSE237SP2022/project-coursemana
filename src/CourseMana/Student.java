package CourseMana;

import java.security.KeyStore.PrivateKeyEntry;

public class Student {
	
	private String name;
	private String studentId;
	private int year;
	
	public Student(String name, String studentId, int year) {
		this.name = name;
		this.studentId = studentId;
		this.year = year;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getId() {
		return this.studentId;
	}

	public void setId(String newId) {
		this.studentId = newId;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int newYear) {
		this.year = newYear;
		
	}
}
