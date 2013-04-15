package com.becode.kata;


public class LineCounter {
	String sourceLine;

	public LineCounter(String stringCode) {
		sourceLine = stringCode;
	}

	public int countCodeLines() {
	SourceCode sourceCode = new SourceCode(sourceLine);
	return sourceCode.countNumberCodeLines();
	}
	
	

}
