package com.gmail.tiutiuniryna;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

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
			engText = FileReaderService.readTextFromFile(engFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String ukrText = translationText(engText);

		try {
			FileWriterService.writeTextToFile(ukrText, ukrFile);
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

	public void saveToFile(File file) {
		StringBuilder stringDictionary = new StringBuilder();
		Set<Map.Entry<String, String>> setDictionary = dictionary.entrySet();
		for (Map.Entry<String, String> entries : setDictionary) {
			stringDictionary.append(entries.getKey()).append("\t").append(entries.getValue())
					.append(System.lineSeparator());
		}
		try {
			Files.writeString(file.toPath(), stringDictionary.toString());
		} catch (IOException e) {
			throw new RuntimeException("Error");
		}

	}

	@Override
	public String toString() {
		return "Dictionary [dictionary=" + dictionary + "]";
	}

}
