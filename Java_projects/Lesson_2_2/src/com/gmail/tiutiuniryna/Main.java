package com.gmail.tiutiuniryna;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String text = "Hello world!";
		TextTransformer textTransf1 = new TextTransformer();
		System.out.println(textTransf1.transform(text));
		InverseTransformer textTransf2 = new InverseTransformer();
		System.out.println(textTransf2.transform(text));
		UpDownTransformer textTransf3 = new UpDownTransformer();
		System.out.println(textTransf3.transform(text));
		File file1 = new File("a.txt");
		try {
			file1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("TextSaverr class - using the method saved the string to a file");
		TextSaver textSaver1 = new TextSaver(textTransf1, file1);
		textSaver1.saveTextToFile(text);

	}

}
