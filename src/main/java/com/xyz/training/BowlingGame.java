package com.xyz.training;

public class BowlingGame {

	private static final int TEN = 10;
	private int score;
	private int[] rolls = new int[21];
	private int current;

	public void roll(int pins) {
		rolls[current++] = pins;
	}

	public int score() {
		for (int frame = 0, i = 0; frame < TEN; frame++) {
			if (rolls[i] == TEN) {
				score += TEN + rolls[i + 1] + rolls[i + 2];
				i++;
			} else {
				if (isASpare(i)) {
					score += TEN + rolls[i + 2];
				} else {
					score += bothRollsInAFrame(i);
				}
				i += 2;
			}
		}
		return score;
	}

	private boolean isASpare(int i) {
		return bothRollsInAFrame(i) == TEN;
	}

	private int bothRollsInAFrame(int i) {
		return rolls[i] + rolls[i + 1];
	}
}
