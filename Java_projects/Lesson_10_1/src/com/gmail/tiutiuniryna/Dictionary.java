package com.gmail.tiutiuniryna;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

	@Override
	public String toString() {
		return "Dictionary [dictionary=" + dictionary + "]";
	}

}
