package com.xyz.training;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CeaserShiftTest {

	private CaeserShift caeserShift;

	@Before
	public void setUp() throws Exception {
		caeserShift = new CaeserShift();
	}
	
	@Test
	public void shouldDecodeWordWithCharactersThatRollOver() throws Exception {
		String output = caeserShift.decode("zab", 2);
		assertThat(output, is("xyz"));
	}
	
	@Test
	public void shouldDecodeWithASingleCharacterWithAShiftOfOne() throws Exception {
		String output = caeserShift.decode("b", 1);
		assertThat(output, is("a"));
	}
	
	@Test
	public void shouldEncodeWords() throws Exception {
		String output = caeserShift.encode("ab xy", 1);
		assertThat(output, is("bc yz"));
	}

	@Test
	public void shouldEncodeWordsWithAShiftOfOne() throws Exception {
		String output = caeserShift.encode("xyz", 1);
		assertThat(output, is("yza"));
	}

	@Test
	public void shouldNotEncodeAnyNonAlphabeticalCharacters() throws Exception {
		String output = caeserShift.encode("!", 4);
		assertThat(output, is("!"));
	}

	@Test
	public void shouldEnocdeWithAShiftOfNegativeNumbersGreaterThanAlphabetSize() throws Exception {
		String output = caeserShift.encode("a", -27);
		assertThat(output, is("z"));
	}

	@Test
	public void shouldEnocdeWithANegativeShift() throws Exception {
		String output = caeserShift.encode("a", -1);
		assertThat(output, is("z"));
	}

	@Test
	public void shouldEnocdeWithAShiftGreaterThanAlphabetSize() throws Exception {
		String output = caeserShift.encode("z", 27);
		assertThat(output, is("a"));
	}

	@Test
	public void shouldEnocdeCharactersThatOverflowTheAlphabets() throws Exception {
		String output = caeserShift.encode("z", 1);
		assertThat(output, is("a"));
	}

	@Test
	public void shouldEnocdeSmallAToSmallCForAShiftOfTwo() throws Exception {
		String output = caeserShift.encode("a", 2);
		assertThat(output, is("c"));
	}

	@Test
	public void shouldEnocdeSmallAToSmallBForAShiftOfOne() throws Exception {
		String output = caeserShift.encode("a", 1);
		assertThat(output, is("b"));
	}

	@Test
	public void shouldEnocdeSmallAToSmallAForAShiftOfZero() throws Exception {
		String output = caeserShift.encode("a", 0);
		assertThat(output, is("a"));
	}

}
