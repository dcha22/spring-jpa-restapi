package com.dilip.jpa.util.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class TimeDateClassTest {

	@BeforeAll
	public void setup() {
		System.out.println("I am called");
	}
	
	@Test
	public void testEpochSecondsNow_ReturnsLongSeconds() {
		String epochSeconds = TimeDateClass.epochSecondsNow();
		Assertions.assertTrue(Long.parseLong(epochSeconds) > 1678424521L);
	}
	
	@Test
	public void testEpochSecondsMillisNow_ReturnsLongSeconds() {
		String epochSecondsMilli = TimeDateClass.epochSecondsMillisNow();
		Assertions.assertTrue(Long.parseLong(epochSecondsMilli) > 1678424521000L);
	}
}
