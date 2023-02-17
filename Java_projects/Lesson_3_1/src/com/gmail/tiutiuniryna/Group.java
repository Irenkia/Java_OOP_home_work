package com.gmail.tiutiuniryna;

public class Group {
	private String groupName;
	private Student[] studens;

	public Group(String groupName) {
		super();
		this.groupName = groupName;

	}

	public Group() {
		super();
		studens = new Student[10];
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		String result = "Group" + System.lineSeparator();
		for (int i = 0; i < studens.length; i++) {
			if (studens[i] != null) {
				result += studens[i] + System.lineSeparator();
			}
		}
		return result;
	}

	public void addStudent(Student student) throws GroupOverflowException {
		for (int i = 0; i < studens.length; i++) {
			if (studens[i] == null) {
				studens[i] = student;
				return;
			}
		}
		throw new GroupOverflowException();
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (int i = 0; i < studens.length; i++) {
			if (studens[i] != null) {
				if (studens[i].getLastName() == lastName)
					return studens[i];
			}
		}
		throw new StudentNotFoundException();
	}

	public boolean removeStudentByID(int id) {
		for (int i = 0; i < studens.length; i++) {
			if (studens[i] != null) {
				if (studens[i].getId() == id) {
					studens[i] = null;
					return true;
				}
			}
		}
		return false;
	}
}
