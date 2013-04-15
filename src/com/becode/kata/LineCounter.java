package com.becode.kata;


public class LineCounter {

	public static int countCodeLines(String stringCode) {
	SourceCode sourceCode = new SourceCode(stringCode);
	return sourceCode.countNumberCodeLines();
	}
}
