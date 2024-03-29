package com.gmail.tiutiuniryna;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NetworkService {
	public static String getStringFromURL(String spec, String code) throws IOException {
		URL url = new URL(spec);
		URLConnection connection = url.openConnection();
		String result = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), code))) {
			String temp = "";
			for (;;) {
				temp = br.readLine();
				if (temp == null) {
					break;
				}
				result += temp + System.lineSeparator();
			}
			return result;
		}
	}

	public static List<String> findLinks(String html) {
		List<String> links = new ArrayList<String>();
		String[] arrayHtml = html.split(System.lineSeparator());
		int indexStart;
		int indexEnd;
		String stringLinks = "";
		for (int i = 0; i < arrayHtml.length; i++) {
			indexStart = arrayHtml[i].indexOf("href=\"");
			if (indexStart != -1) {
				indexEnd = arrayHtml[i].indexOf("\"", indexStart + 6);
				stringLinks = arrayHtml[i].substring(indexStart + 6, indexEnd);
				if (!stringLinks.equals("#")) {
					links.add(arrayHtml[i].substring(indexStart + 6, indexEnd));
				}
			}

		}
		return links;

	}

	public static void saveToFile(List<String> links, File file) {
		try (PrintWriter pw = new PrintWriter(file)) {
			for (String link : links) {
				pw.println(link + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void siteAvailabilityCheck(File file) {
		String spec = "";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while (spec != null) {
				spec = br.readLine();
				try {
					Map<String, List<String>> headers = getHeadersFromURL(spec);
					System.out.println("Site exists : " + spec);
				} catch (IOException e) {
//					e.printStackTrace();
					System.out.println("Site does not exist : " + spec);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Map<String, List<String>> getHeadersFromURL(String spec) throws IOException {
		URL url = new URL(spec);
		URLConnection connection = url.openConnection();
		return connection.getHeaderFields();
	}

}
