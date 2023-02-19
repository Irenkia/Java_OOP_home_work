package com.gmail.tiutiuniryna;

public class CSVStringConverter implements StringConverter {
	@Override
	public String toStringRepresentation(Student student) {
		Integer idStudent = student.getId();
		String id = Integer.toString(idStudent) + ", ";
		String groupName = student.getGroupName() + ", ";
		String name = student.getName() + ", ";
		String lastName = student.getLastName() + ", ";
		String gender = student.getGender().toString() + " ";
		String strStudent = id + groupName + name + lastName + gender;
		return strStudent;
	}

	@Override
	public Student fromStringRepresentation(String str) {
		String[] words = str.split(",");
		Integer idStudent = Integer.valueOf(words[0]);
		int id = (int) idStudent;
		String groupName = words[1];
		String name = words[2];
		String lastName = words[3];
		String genderStudent = words[4];

		Gender gender = genderStrValidation(genderStudent.trim().toUpperCase());

		Student student = new Student(name, lastName, gender, id, groupName);
		return student;
	}

	private Gender genderStrValidation(String str) {

		Gender genderValidate = Gender.valueOf(str);
		return genderValidate;
	}

}
