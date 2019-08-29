package com.xyz.training;

public class CaeserShift {

	private static final int START = 97;
	private static final int ALPHABET_SIZE = 26;

	public String decode(String input, int shift) {
		// TODO Auto-generated method stub
		return encode(input,-shift);
	}
	
	public String encode(String input, int shift) {
		StringBuilder builder = new StringBuilder();
		char[] chars = input.toCharArray();
		for (char character : chars) {
			builder.append((char) applyShift(character, shift));
		}
		return builder.toString();
	}

	private int applyShift(char character, int shift) {
		if (!Character.isAlphabetic(character)) {
			return character;
		}
		int value = character + shift % ALPHABET_SIZE;
		if (goesBeyondAlphabetSet(value)) {
			value = value - ALPHABET_SIZE;
		}
		if (fallsBehindAlphabetSet(value)) {
			value = value + ALPHABET_SIZE;
		}
		return value;
	}

	private boolean fallsBehindAlphabetSet(int value) {
		return value < START;
	}

	private boolean goesBeyondAlphabetSet(int value) {
		return value >= START + ALPHABET_SIZE;
	}

}
