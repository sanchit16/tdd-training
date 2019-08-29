package com.xyz.training;

public class CaeserShift {

	private static final int START = 97;
	private static final int ALPHABET_SIZE = 26;

	public String encode(String input, int shift) {
		char character = input.toCharArray()[0];
		if(!Character.isAlphabetic(character)) {
			return String.valueOf((char)character);
		}
		int value=input.toCharArray()[0] + shift % ALPHABET_SIZE;
		if(value >= START + ALPHABET_SIZE) {
			value = value - ALPHABET_SIZE;
		}
		if(value < START) {
			value = value + ALPHABET_SIZE;
		}
		return String.valueOf((char)value);
	}

}
