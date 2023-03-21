package com.gmail.tiutiuniryna;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();

		dictionary.addWords("Hello", "Привіт");
		dictionary.addWords("I", "я");
		dictionary.addWords("love", "люблю");
		dictionary.addWords("reading", "читати");
		dictionary.addWords("read", "читаю");
		dictionary.addWords("books", "книги");
		dictionary.addWords("and", "та");
		dictionary.addWords("magazines", "журнали");
		dictionary.addWords("articles", "статті");

		File engFile = new File("English.in");
		File ukrFile = new File("Ukrainian.out");
		try {
			engFile.createNewFile();
			ukrFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String myText = "Hello I love reading I read books and magazines and articles ";
		try {
			FileWriterService.writeTextToFile(myText, ukrFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		dictionary.translationFromEngFileToUkrFile(engFile, ukrFile);

		File file1 = new File("myFile.txt");
		try {
			file1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scanner sc = new Scanner(System.in);
		String engWord = "";
		String ukrWord = "";
		int chose;
		do {
			Menu.show();

			chose = sc.nextInt();

			switch (chose) {

			case 1:
				System.out.println("Enter an English word:");
				sc.nextLine();
				engWord = sc.nextLine();
				System.out.println("Enter the Ukrainian translation of this word:");
				ukrWord = sc.nextLine();
				dictionary.addWords(engWord.toLowerCase().trim(), ukrWord.toLowerCase().trim());
				break;
			case 2:
				System.out.println(dictionary.getDictionary());
				break;
			case 3:
				dictionary.saveToFile(file1);
				break;
			default:
				if (chose != 0)
					System.out.println("Wrong choice, try again");

			}
		} while (chose != 0);
		sc.close();
	}

}
