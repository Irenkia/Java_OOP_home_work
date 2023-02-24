package com.gmail.tiutiuniryna;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileServis {
	public static long copyFile(File fileIn, File fileOut) throws IOException {
		try (InputStream is = new FileInputStream(fileIn); OutputStream os = new FileOutputStream(fileOut)) {
			return is.transferTo(os);
		}
	}

	public static void copyFolderByExtension(File folderIn, File FolderOut, String extension) throws IOException {
		File[] files = folderIn.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() && getFileExtension(files[i]).equals(extension)) {
				File fileOut = new File(FolderOut, files[i].getName());
				copyFile(files[i], fileOut);
			}
		}
	}

	private static String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	public static File createFile(File folder, String nameFile) throws IOException {
		File file = new File(folder, nameFile);
		try {
			file.createNewFile();
		} catch (IOException e) {
			throw e;
		}
		return file;
	}

	public static void printFilesInFolder(File folder) {
		File[] files = folder.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}
	}

}
