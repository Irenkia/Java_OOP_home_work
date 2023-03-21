package com.gmail.tiutiuniryna;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterService {
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
}
