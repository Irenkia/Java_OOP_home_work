package com.gmail.tiutiuniryna;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
	private String groupName;
	private Student[] students;

	public Group(String groupName) {
		super();
		this.groupName = groupName;

	}

	public Group() {
		super();
		students = new Student[10];
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
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				result += students[i] + System.lineSeparator();
			}
		}
		return result;
	}

	public void addStudent(Student student) throws GroupOverflowException {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;
				return;
			}
		}
		throw new GroupOverflowException();
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getLastName() == lastName)
					return students[i];
			}
		}
		throw new StudentNotFoundException();
	}

	public boolean removeStudentByID(int id) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getId() == id) {
					students[i] = null;
					return true;
				}
			}
		}
		return false;
	}

	public String sortingStudentsByName() {
		Student temp;
		for (int i = 0; i < students.length; i++) {
			for (int j = i; j < students.length; j++) {
				if (students[i] != null && students[j] != null) {
					if (students[i].getName().compareTo(students[j].getName()) > 0) {
						temp = students[i];
						students[i] = students[j];
						students[j] = temp;
					}
				}

			}
		}
		return toString();
	}
	
	public String sortStudentsByLastName() { 
		Arrays.sort(students, Comparator.nullsLast(new SortStudentsNmaeComparator()));
		return toString();
	}
}
