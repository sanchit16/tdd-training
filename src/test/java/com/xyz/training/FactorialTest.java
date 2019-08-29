package com.xyz.training;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FactorialTest {
	
	private Factorial factorial;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void setUp() throws Exception{
		factorial=new Factorial();
	}
	
	@Test
	public void shouldNotCalculateForValueGreaterThanTwenty() throws Exception{
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Values greater than 20 are not allowed");
		int result=factorial.calculate(21);
	}
	
	@Test
	public void shouldHandleNegativeValues() throws Exception{
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Negative values are not allowed");
		int result=factorial.calculate(-1);
	}
	
	@Test
	public void shouldReturnOneTwentForInputFive() throws Exception{
		int result=factorial.calculate(5);
		assertThat(result,is(120));
	}
	
	@Test
	public void shouldReturnOneForInputOne() throws Exception{
		int result=factorial.calculate(0);
		assertThat(result,is(1));
	}
	
	@Test
	public void shouldReturnOneForInputZero() throws Exception{
		int result=factorial.calculate(0);
		assertThat(result,is(1));
	}
}
