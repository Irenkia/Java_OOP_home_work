package com.gmail.tiutiuniryna;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderService {
	public static String readTextFromFile(File file) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String result = "";
			String temp = "";
			while (temp != null){
	            temp = br.readLine();
	            result += temp + System.lineSeparator();
	        }
			return result.substring(0, result.length() - 1);
		} catch (IOException e) {
			throw e;
		}

	}
}
