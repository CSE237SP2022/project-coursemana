package CourseMana;

public class Teacher {
	
	// a teacher obj has name, id, dept, and title;
	
	private String name;
	private String id;
	private String department;
	private String title;

	public Teacher(String name, String id, String department, String title) {
		this.name = name;
		this.id = id;
		this.department = department;
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
	
	public String getDept() {
		return department;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setId(String newId) {
		id = newId;
	}
	
	public void setDept(String newDept) {
		department = newDept;
	}
	
	public void setTitle(String newTitle) {
		title = newTitle;
	}

}
