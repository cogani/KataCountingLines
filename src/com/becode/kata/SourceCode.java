package com.becode.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SourceCode {
	List<String> sourceLines;
	private static final String NEW_LINE_REG_EXP = "\\n";
	
	public SourceCode(String sourceCode) {
		sourceLines = splitingSourceLines(sourceCode);
	}
	
	private List<String> splitingSourceLines(String sourceCode){
		final String[] splitted = sourceCode.split(NEW_LINE_REG_EXP);
		final List<String> sourceLines = new ArrayList<String>(
				Arrays.asList(splitted));
		return sourceLines;
	}
	
	public int countNumberCodeLines(){
		ParserState parserState = new CodeState();
		int result = 0;
		for (String line : sourceLines) {
			SourceLine sourceLine = new SourceLine(line);
			sourceLine.setStateParser(parserState);
			if (sourceLine.isCodeLine())
				result++;
			parserState = sourceLine.getStateParser();
		}
		return result;
	}
}
