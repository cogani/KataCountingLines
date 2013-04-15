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
	
	@Test
	public void lineIsOnlyComentLine() {
		final int countExpected = 0;
		assertEquals("Una linea de SOLO comentario no suma", countExpected, LineCounter.countCodeLines("//Linea SOLO comentario, no cuenta como codigo"));
	}
	
	@Test
	public void triangulatinglineIsOnlyComentLinePlusCodeLineReturn1() {
		final int countExpected = 1;
		assertEquals("Linea comentario + linea codigo->1", countExpected, LineCounter.countCodeLines("//Linea SOLO comentario, no cuenta como codigo\nLinea codigo"));
	}
	@Test
	public void triangulatinglineIsNotOnlyComentLinePlusCodeLineReturn2() {
		final int countExpected = 2;
		assertEquals("Linea con codigo y comentario + linea codigo->2", countExpected, LineCounter.countCodeLines("Esto es codigo //Linea SOLO comentario, no cuenta como codigo\nLinea codigo"));
	}
	
	@Test
	public void lineIsOnlyblockComentLine() {
		final int countExpected = 0;
		assertEquals("Linea con SOLO comentario de bloque devuelve 0", countExpected, LineCounter.countCodeLines("/* Esto es un comentario de bloque o multilinea"));
	}
	
	@Test
	public void lineIsNotOnlyblockComentLine() {
		final int countExpected = 1;
		assertEquals("Linea con codigo y comentario de bloque devuelve 1", countExpected, LineCounter.countCodeLines("Esto es codigo/* Esto es un comentario de bloque o multilinea"));
	}
	
	@Test
	public void lineIsOnlyblockComentLineAtMultiplesLines() {
		final int countExpected = 0;
		assertEquals("Comentario de bloque en dos lineas devuelve 0", countExpected, LineCounter.countCodeLines("/* Esto es un comentario de bloque o multilinea\nsigue el comentario de bloque anterior*/"));
	}
	
	@Test
	public void triangulatingTwoLinesBlockAsCommetBlockPlusCodeLineReturn1() {
		final int countExpected = 1;
		assertEquals("Comentario de bloque en dos lineas devuelve mas linea codigo devuelve 1", countExpected, LineCounter.countCodeLines("/* Esto es un comentario de bloque o multilinea\nsigue el comentario de bloque anterior*/\ncode line"));
	}
	
	@Test
	public void triangulatingTwoLinesBlockAsCommetBlockPlusTwoCodeLineReturn2() {
		final int countExpected = 2;
		assertEquals("Comentario de bloque en dos lineas devuelve mas 2 lineas codigo devuelve 2", countExpected, LineCounter.countCodeLines("/* Esto es un comentario de bloque o multilinea\nsigue el comentario de bloque anterior*/\ncode line\notra linea"));
	}		
	
	@Test
	public void lineWithBlockComentPlusCode() {
		final int countExpected = 1;
		assertEquals("Comentario de bloque mas codigo en la misma linea", countExpected, LineCounter.countCodeLines("/* Esto es un comentario de bloque*/Esto es codigo"));
	}
	
	@Test
	public void TwolineWithBlockComentPlusCodeAtTheSameLine() {
		final int countExpected = 1;
		assertEquals("Comentario de bloque dos linea, terminando la segunda con codigo", countExpected, LineCounter.countCodeLines("/* Esto es un comentario de bloque\n continua el comentario bloque*/Esto es codigo"));
	}
	
	@Test
	public void CodeLinePlusPlusBeginBlockCommentAtTheSameLinePlusEndBlockCommentAtTheSecondLine() {
		final int countExpected = 1;
		assertEquals("Primera linea con codigo y comienzo comentario bloque, con finalizacion del bloque en la segunda", countExpected, LineCounter.countCodeLines("Esto es codigo/* Esto es un comentario de bloque\n continua el comentario bloque*/"));
	}
	
	@Test
	public void CodeLinePlusPlusBeginBlockCommentAtTheSameLinePlusEndBlockCommentAtTheSecondLinePlusCodeLineAtTheSecondOne() {
		final int countExpected = 2;
		assertEquals("Primera linea con codigo y comienzo comentario bloque, con finalizacion del bloque en la segunda seguido en la misma por más código", countExpected, LineCounter.countCodeLines("Esto es codigo/* Esto es un comentario de bloque\n continua el comentario bloque*/Mas codigo"));
	}
		

}
