package com.gmail.tiutiuniryna;

public class InverseTransformer extends TextTransformer {

	@Override
	public String transform(String text) {
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			result = text.charAt(i) + result;
		}
		return result;
	}

}
