package com.xyz.training;

public class CaeserShift {

	public String encode(String input, int shift) {
		
		return String.valueOf((char)(input.toCharArray()[0]+shift));
	}

}
