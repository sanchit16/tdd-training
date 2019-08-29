package com.xyz.training;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class BowlingGameTest {

	private BowlingGame game;

	@Before
	public void setUp() throws Exception {
		game = new BowlingGame();
	}

	@Test
	public void shouldHandleAPerfectGame() throws Exception {
		rollMany(10, 12);
		assertThat(game.score(), is(300));
	}

	@Test
	public void shouldHandleAGameOfStrike() throws Exception {
		rollAStrike();
		game.roll(5);
		game.roll(3);
		rollMany(0, 16);
		assertThat(game.score(), is(26));
	}

	@Test
	public void shouldHandleAGameOfSpare() throws Exception {
		rollASpare();
		game.roll(3);
		rollMany(0, 17);
		assertThat(game.score(), is(16));
	}

	@Test
	public void shouldScoreAGameOfAllOnes() throws Exception {
		rollMany(1, 20);
		assertThat(game.score(), is(20));
	}

	@Test
	public void shouldScoreGutterGame() throws Exception {
		rollMany(0, 20);
		assertThat(game.score(), is(0));
	}

	private void rollMany(int pins, int times) {
		for (int i = 0; i < times; i++) {
			game.roll(pins);
		}
	}

	private void rollAStrike() {
		game.roll(10);
	}

	private void rollASpare() {
		game.roll(5);
		game.roll(5);
	}
}
