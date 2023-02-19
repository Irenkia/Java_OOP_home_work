package com.gmail.tiutiuniryna;

import java.util.Scanner;

public class ReadingCharacteristics {
	public static Student createStudent() {
		Scanner sc = new Scanner(System.in);

		String name = nameScValidation(sc);
		String lastName = lastNameScValidation(sc);
		Gender gender = genderScValidation(sc);
		int id = idScValidation(sc);
		sc.nextLine();
		String groupName = groupNameScValidation(sc);
		sc.close();

		Student student = new Student(name, lastName, gender, id, groupName);
		return student;
	}

	private static String nameScValidation(Scanner sc) {
		String nameValidate;
		System.out.println("Enter name student");
		while (!sc.hasNextLine()) {
			sc.nextLine();
			System.out.println("Invalid data entered, please try again");
		}
		nameValidate = sc.nextLine();
		return nameValidate;
	}

	private static String lastNameScValidation(Scanner sc) {
		String lastNameValidate;
		System.out.println("Enter last name student");
		while (!sc.hasNextLine()) {
			sc.nextLine();
			System.out.println("Invalid data entered, please try again");
		}
		lastNameValidate = sc.nextLine();
		return lastNameValidate;
	}

	private static Gender genderScValidation(Scanner sc) {
		String gender;
		System.out.println("Enter the gender of the student");
		System.out.println("enter only \"male\" or \"female\"");
		gender = sc.nextLine().toUpperCase();
		Gender genderValidate = Gender.valueOf(gender);
		return genderValidate;
	}

	private static int idScValidation(Scanner sc) {
		int idValidate;
		System.out.println("Enter id student (integer from 1 to 100)");
		while (!sc.hasNextInt() || (idValidate = sc.nextInt()) > 100 || idValidate < 1) {
			sc.nextLine();
			System.out.println("Invalid data entered, please try again");
		}
		System.out.println();
		return idValidate;
	}

	private static String groupNameScValidation(Scanner sc) {
		String groupNameValidate;
		System.out.println("Enter group name student");
		while (!sc.hasNextLine()) {
			sc.nextLine();
			System.out.println("Invalid data entered, please try again");
		}
		groupNameValidate = sc.nextLine();
		return groupNameValidate;
	}

}