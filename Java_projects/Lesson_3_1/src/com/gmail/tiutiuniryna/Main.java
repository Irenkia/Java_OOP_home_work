package com.gmail.tiutiuniryna;

public class Main {

	public static void main(String[] args) {
		Gender male = Gender.MALE;
		Gender female = Gender.FEMALE;

		Student student1 = new Student("Ivan", "Ivanov", male, 1, "group1");
		Student student2 = new Student("Pete", "Petrov", male, 2, "group1");
		Student student3 = new Student("Ola", "Tkach", female, 3, "group1");
		Student student4 = new Student("Slava", "Sidorov", male, 4, "group1");
		Student student5 = new Student("Sveta", "Altuhova", female, 5, "group1");
		Student student6 = new Student("Lena", "Polakova", female, 6, "group1");

		Group group1 = new Group();
		try {
			group1.addStudent(student1);
			group1.addStudent(student2);
			group1.addStudent(student3);
			group1.addStudent(student4);
			group1.addStudent(student5);
			group1.addStudent(student6);
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}
		System.out.println(group1);
		System.out.println();

		System.out.println(group1.removeStudentByID(4));
		System.out.println(group1);
		System.out.println();

		try {
//			group1.searchStudentByLastName("Sidorov");
//			System.out.println(student3);
			group1.searchStudentByLastName(student6.getLastName());
			System.out.println(student6);
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();

		System.out.println(group1.sortingStudentsByName());

		System.out.println(group1.sortStudentsByLastName());

		CSVStringConverter strConverter = new CSVStringConverter();
		String strStudent7 = strConverter.toStringRepresentation(student4);
		System.out.println(strStudent7);
		Student student7 = strConverter.fromStringRepresentation(strStudent7);
		System.out.println(student7);
		System.out.println();

		Student student8 = ReadingCharacteristics.createStudent();
		System.out.println(student8);

	}

}
