package com.gmail.tiutiuniryna;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File folder1 = new File("Folder1");
		folder1.mkdirs();
		File folder2 = new File("Folder2");
		folder2.mkdirs();
		File file1 = FileServis.createFile(folder1, "a.txt");
		File file2 = FileServis.createFile(folder1, "b.txt");
		File file3 = FileServis.createFile(folder1, "c.pdf");
		File file4 = FileServis.createFile(folder1, "d.doc");
		File file5 = FileServis.createFile(folder1, "e.pdf");
		System.out.println("All files in Folder1 ");
		FileServis.printFilesInFolder(folder1);
		System.out.println();

		String extension = "pdf";
		try {
			FileServis.copyFolderByExtension(folder1, folder2, extension);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("All files in Folder2 after copying by extension \"pdf\" ");
		FileServis.printFilesInFolder(folder2);

	}

}
