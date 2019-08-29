package com.xyz.training;

public class Factorial {

	public int calculate(int input) throws Exception {
		if (input > 20) {
			throw new IllegalArgumentException("Values greater than 20 are not allowed");
		}
		if (input < 0) {
			throw new IllegalArgumentException("Negative values are not allowed");
		}
		if (input == 0 || input == 1)
			return 1;

		return input * calculate(input - 1);
	}
}
