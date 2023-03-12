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
		Student student7 = new Student("Nina", "Nikorov", female, 7, "Group1");
		Student student8 = new Student("Dima", "Popov", male, 8, "Group1");
		Student student9 = new Student("Rostik", "Alibov", male, 9, "Group1");
		Student student10 = new Student("Diana", "Zubkova", female, 10, "Group1");
//		Student student11 = new Student("Pima", "Guseva", female, 11, "Group1");

//	     To test the method : noIdenticalStudents(group1)		
//			Student student10 = new Student("Ivan", "Ivanov", male, 1, "Group1");

		Group group1 = new Group();
		group1.setGroupName("Group1");
		try {
			group1.addStudent(student1);
			group1.addStudent(student2);
			group1.addStudent(student3);
			group1.addStudent(student4);
			group1.addStudent(student5);
			group1.addStudent(student6);
			group1.addStudent(student7);
			group1.addStudent(student8);
			group1.addStudent(student9);
			group1.addStudent(student10);
//			group1.addStudent(student11);

		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}
		System.out.println(group1);
		System.out.println();

		System.out.println("Remove student from id 4");
		System.out.println(group1.removeStudentByID(4));
		System.out.println();
		
		System.out.println(group1);
		System.out.println();

		System.out.println("Search student by Last Name");
		try {
//			group1.searchStudentByLastName("Sidorov");
//			System.out.println(student3);
			group1.searchStudentByLastName(student6.getLastName());
			System.out.println(student6);
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();

//		System.out.println(group1.sortingStudentsByName());

		System.out.println("Sort student by Last Name");
		System.out.println(group1.sortStudentsByLastName());

		System.out.println("to String representation from Student");
		CSVStringConverter strConverter = new CSVStringConverter();
		String strStudent12 = strConverter.toStringRepresentation(student4);
		System.out.println(strStudent12);
		System.out.println("сreate new Student from String");
		Student student12 = strConverter.fromStringRepresentation(strStudent12);
		System.out.println(student12);
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

		System.out.println("There are no identical students in the group");
		System.out.println(group1.noIdenticalStudents(group1));

//		Student student8 = ReadingCharacteristics.createStudent();
//		System.out.println(student8);

	}

}
