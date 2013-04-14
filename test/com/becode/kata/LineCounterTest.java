package com.becode.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class LineCounterTest {

	@Test
	public void testingEmptyLine() {
		final LineCounter lineCounter = new LineCounter("");
		final int countExpected = 0;
		assertEquals("Verficando linea vacia", countExpected, lineCounter.countCodeLines());
	}

}
