package com.becode.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class LineCounterTest {

	@Test
	public void testingEmptyLine() {
		final int countExpected = 0;
		assertEquals("Verficando linea vacia", countExpected, LineCounter.countCodeLines(""));
	}
	
	@Test
	public void OnlyBlanksLineReturnZero() {
		final int countExpected = 0;
		assertEquals("Linea con SOLO caracteres blancos se descarta de la cuenta", countExpected, LineCounter.countCodeLines("   		  "));
	}	
	
	@Test
	public void OneCodeLineReturnOne() {
		final int countExpected = 1;
		assertEquals("Una linea de código devuelve 1", countExpected, LineCounter.countCodeLines(" code line\n"));
	}
	
	@Test
	public void triangulatingTwoCodeLineReturnTwo() {
		final int countExpected = 2;
		assertEquals("Dos lineas de código devuelve 2", countExpected, LineCounter.countCodeLines(" code line\n second code line\n"));
	}	

}
