package com.gmail.tiutiuniryna;

import java.io.File;
import java.io.IOException;

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
		}catch(IOException e) {
			e.printStackTrace();
		}
		String myText = "Hello I love reading I read books and magazines and articles ";
		try {
			FileStorage.writeTextToFile(myText,engFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		dictionary.translationFromEngFileToUkrFile(engFile,ukrFile);
		
	}

}
