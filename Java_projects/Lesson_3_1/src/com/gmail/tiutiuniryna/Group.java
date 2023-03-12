package com.gmail.tiutiuniryna;

import java.util.*;
//import java.util.Comparator;
//import java.util.Objects;

public class Group {
	private String groupName;
	private List<Student> students = new ArrayList<>();
	private final int groupSize = 10;

	public Group(String groupName) {
		super();
		this.groupName = groupName;

	}

	public Group(List<Student> students) {
		super();
		this.students = students;
	}

	public Group(String groupName, List<Student> students) {
		super();
		this.groupName = groupName;
		this.students = students;
	}

	public Group() {
		super();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		String result = groupName + System.lineSeparator();
		for (Student student : students) {
			if (students != null) {
				result += student + System.lineSeparator();
			}
		}
		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupName, groupSize, students);
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
		return Objects.equals(groupName, other.groupName) && groupSize == other.groupSize
				&& Objects.equals(students, other.students);
	}

	public void addStudent(Student student) throws GroupOverflowException {
		if (students.size() >= groupSize) {
			throw new GroupOverflowException();
		}
		if (!students.contains(student)) {
			students.add(student);
		}
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (Student student : students) {
			if (student != null && student.getLastName().equals(lastName)) {
				return student;
			}
		}
		throw new StudentNotFoundException();
	}

	public boolean removeStudentByID(int id) {
		for (Student student : students) {
			if (student != null) {
				if (student.getId() == id) {
					students.remove(student);
					return true;
				}
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public String sortStudentsByLastName() {
		Collections.sort(students, Comparator.nullsLast(new SortStudentsNmaeComparator()));
		return toString();
	}

	/*
	 * This method is not relevant because the identity check is in the method of
	 * adding a new student
	 */
	public boolean noIdenticalStudents(Group group) {
		for (Student student : students) {
			for (Student newStudent : students) {
				if (student != null && newStudent != null && student != newStudent) {
					if (true == student.equals(newStudent)) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
