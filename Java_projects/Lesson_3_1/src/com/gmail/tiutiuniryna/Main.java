package com.gmail.tiutiuniryna;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Gender male = Gender.MALE;
		Gender female = Gender.FEMALE;

		Student student1 = new Student("Ivan", "Ivanov", male, 1, "Group1");
		Student student2 = new Student("Pete", "Petrov", male, 2, "Group1");
		Student student3 = new Student("Ola", "Tkach", female, 3, "Group1");
		Student student4 = new Student("Slava", "Sidorov", male, 4, "Group1");
		Student student5 = new Student("Sveta", "Altuhova", female, 5, "Group1");
		Student student6 = new Student("Lena", "Polakova", female, 6, "Group1");

		Group group1 = new Group();
		group1.setGroupName("Group1");
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

		try {
			GroupFileStorage.saveGroupToCSV(group1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Group newGroup = new Group();
		File workFolder = new File(".");
		File[] filesArray = workFolder.listFiles();
		for (int i = 0; i < filesArray.length; i++) {
			if (filesArray[i].isFile()) {
				// System.out.println(filesArray[i].getName());
				if (filesArray[i].getName().substring(0, filesArray[i].getName().lastIndexOf("."))
						.equals(group1.getGroupName())) {
					newGroup = GroupFileStorage.loadGroupFromCSV(filesArray[i]);
					break;
				}
			}

		}

		System.out.println(newGroup);

		File file1 = GroupFileStorage.findFileByGroupName("Group1.csv", workFolder);
		System.out.println(file1.getName());
		System.out.println();

		Student student8 = ReadingCharacteristics.createStudent();
		System.out.println(student8);

	}

}
