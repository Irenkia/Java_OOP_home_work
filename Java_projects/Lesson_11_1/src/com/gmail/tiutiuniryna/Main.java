package com.gmail.tiutiuniryna;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String spec = "https://dou.ua/";
		String html = "";

		try {
			html = NetworkService.getStringFromURL(spec, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> links = new ArrayList<String>();
		links = NetworkService.findLinks(html);

		File file = new File("Links.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		NetworkService.saveToFile(links, file);

		NetworkService.siteAvailabilityCheck(file);

	}

}
