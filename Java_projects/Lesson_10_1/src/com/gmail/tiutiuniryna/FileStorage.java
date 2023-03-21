package com.gmail.tiutiuniryna;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStorage {
	public static void writeTextToFile(String text, File file) throws IOException {
		String[] textArray = text.split("  ");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for (int i = 0; i < textArray.length; i++) {
				bw.write(textArray[i]);
			}
			bw.flush();
		} catch (IOException e) {
			throw e;
		}
	}

	public static String readTextFromFile(File file) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String result = "";
			String temp = "";
//			for (;;) {
//				temp = br.readLine();
//				if (temp == null) {
//					break;
//				}
//				result += temp + System.lineSeparator();
//			}
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
