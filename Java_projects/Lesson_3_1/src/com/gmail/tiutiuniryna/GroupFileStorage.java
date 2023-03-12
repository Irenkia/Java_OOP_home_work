package com.gmail.tiutiuniryna;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroupFileStorage {
	public static void saveGroupToCSV(Group gr) throws IOException {
		File file = new File(gr.getGroupName() + ".csv");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = "";

		for (int i = 0; i < gr.getStudents().size(); i++) {
			try {
				str += gr.getStudents().get(i).getName() + "," + gr.getStudents().get(i).getLastName() + ","
						+ gr.getStudents().get(i).getGender() + "," + gr.getStudents().get(i).getId() + ","
						+ gr.getStudents().get(i).getGroupName() + "\n";
			} catch (Exception e) {
				break;
			}
		}
		writeGroupToCSV(str, file);
	}

	private static void writeGroupToCSV(String group, File file) throws IOException {
		String[] groupArray = group.split(" , ");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for (int i = 0; i < groupArray.length; i++) {
				bw.write(groupArray[i]);
			}
			bw.flush();
		} catch (IOException e) {
			throw e;
		}
	}

	public static Group loadGroupFromCSV(File file) {
		Group gr = new Group();
		String group = "";
		try {
			group = loadStringFromFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] students = group.split("\n");
		CSVStringConverter obj = new CSVStringConverter();
		for (int i = 0; i < students.length; i++) {
			try {
				gr.addStudent(obj.fromStringRepresentation(students[i]));
			} catch (GroupOverflowException e) {
				e.printStackTrace();
			}
		}
		gr.setGroupName(file.getName().substring(0, file.getName().lastIndexOf(".")));
		return gr;
	}

	private static String loadStringFromFile(File file) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String result = "";
			String temp = "";
			for (;;) {
				temp = br.readLine();
				if (temp == null) {
					break;
				}
				result += temp + System.lineSeparator();
			}
			return result.substring(0, result.length() - 1);
		} catch (IOException e) {
			throw e;
		}
	}

	public static File findFileByGroupName(String groupName, File workFolder) {
		File file = new File(groupName);
		File[] filesArray = workFolder.listFiles();
		if (filesArray != null) {
			for (int i = 0; i < filesArray.length; i++) {
				if (filesArray[i].isFile()) {
					if (filesArray[i].getName().equals(groupName)) {
						return file;
					}
				}
			}
		}
		return null;
	}

}
