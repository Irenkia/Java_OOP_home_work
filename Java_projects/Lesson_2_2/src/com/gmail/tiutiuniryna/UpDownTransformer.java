package com.gmail.tiutiuniryna;

public class UpDownTransformer extends TextTransformer {

	@Override
	public String transform(String text) {
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			if ((i + 1) % 2 == 0) {
				result += Character.toLowerCase(text.charAt(i));
			} else {
				result += Character.toUpperCase(text.charAt(i));
			}

		}
		return result;
	}

}
