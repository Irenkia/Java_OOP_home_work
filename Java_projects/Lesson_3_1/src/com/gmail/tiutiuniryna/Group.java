package com.gmail.tiutiuniryna;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

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

	public Group(String groupName, Student[] students) {
		super();
		this.groupName = groupName;
		this.students = students;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	@Override
	public String toString() {
		String result = groupName + System.lineSeparator();
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				result += students[i] + System.lineSeparator();
			}
		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(students);
		result = prime * result + Objects.hash(groupName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Arrays.equals(students, other.students);
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
//		int val = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
//				if (val == students[i].getLastName().compareTo(lastName)) {
				if (true == students[i].getLastName().equals(lastName)) {
					return students[i];
				}
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

	public boolean noIdenticalStudents(Group group) {
		Student[] students = group.getStudents();
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if (students[i] != null && students[j] != null && i != j) {
					if (true == students[i].equals(students[j])) {
						return false;
					}
				}
			}

		}
		return true;
	}
}
