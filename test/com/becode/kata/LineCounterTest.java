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
	
	@Test
	public void OnlyBlanksLineReturnZero() {
		final LineCounter lineCounter = new LineCounter("   		  ");
		final int countExpected = 0;
		assertEquals("Linea con SOLO caracteres blancos se descarta de la cuenta", countExpected, lineCounter.countCodeLines());
	}	
	
	@Test
	public void OneCodeLineReturnOne() {
		final LineCounter lineCounter = new LineCounter("   		  ");
		final int countExpected = 1;
		assertEquals("Una linea de código devuelve 1", countExpected, lineCounter.countCodeLines());
	}	

}
