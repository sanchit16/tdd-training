package com.xyz.training;

public class CaeserShift {

	private static final int ALPHABET_SIZE = 26;

	public String encode(String input, int shift) {
		int value=input.toCharArray()[0] + shift % ALPHABET_SIZE;
		if(value > 122) {
			value = value - ALPHABET_SIZE;
		}
		return String.valueOf((char)value);
	}

}
