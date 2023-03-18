package com.gmail.tiutiuniryna;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Map.Entry;

public class Dictionary {
	private Map<String, String> dictionary = new HashMap<>();

	public Dictionary(Map<String, String> dictionary) {
		super();
		this.dictionary = dictionary;
	}

	public Dictionary() {
		super();
	}

	public Map<String, String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, String> dictionary) {
		this.dictionary = dictionary;
	}

	public void addWords(String engWord, String ukWord) {
		dictionary.put(engWord, ukWord);
	}

	public void translationFromEngFileToUkrFile(File engFile, File ukrFile) {
		String engText = "";
		try {
			engText = FileStorage.readTextFromFile(engFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String ukrText = translationText(engText);

		try {
			FileStorage.writeTextToFile(ukrText, ukrFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String translationText(String engText) {
		String[] engArra = engText.split(" ");
		String ukrText = "";
		for (String str : engArra) {
			if (dictionary.containsKey(str)) {
				ukrText += dictionary.getOrDefault(str, ukrText) + " ";
			}
		}
		return ukrText;
	}

	public void saveToFile() {
		File file = new File("myFile.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (PrintWriter pw = new PrintWriter(file)) {
			Set<Map.Entry<String, String>> setDictionary = dictionary.entrySet();
			for (Map.Entry<String, String> setDict : setDictionary) {
				pw.println(setDict.getKey() + "\t" + setDict.getValue());
			}
//          Iterator<Map.Entry<String, String>> it = setDictionary.iterator();
//          for (; it.hasNext(); ) {
//          	Map.Entry<String, String> setDict = it.next();
//              pw.println(setDict.getKey() + "\t" + setDict.getValue());
//          }
			System.out.println("\n" + "Dictionary saved to disk" + "\n");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	@Override
	public String toString() {
		return "Dictionary [dictionary=" + dictionary + "]";
	}

}
