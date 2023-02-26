package com.gmail.tiutiuniryna;

public class CSVStringConverter implements StringConverter {
	@Override
	public String toStringRepresentation(Student student) {
		String name = student.getName() + ", ";
		String lastName = student.getLastName() + ", ";
		String gender = student.getGender().toString() + ", ";
		String id = String.valueOf(student.getId()) + ", ";
		String groupName = student.getGroupName() + " ";
		String strStudent = name + lastName + gender + id + groupName;
		return strStudent;
	}

	@Override
	public Student fromStringRepresentation(String str) {
		String[] words = str.split(",");
		String name = words[0];
		String lastName = words[1];
		String genderStudent = words[2];
		Integer idStudent = Integer.valueOf(words[3].trim());
		int id = (int) idStudent;
		String groupName = words[4];

		Gender gender = genderStrValidation(genderStudent.trim().toUpperCase());

		Student student = new Student(name, lastName, gender, id, groupName);
		return student;
	}

	private Gender genderStrValidation(String str) {

		Gender genderValidate = Gender.valueOf(str);
		return genderValidate;
	}

}
