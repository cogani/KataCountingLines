package com.becode.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SourceCode {
	List<String> sourceLines;
	
	public SourceCode(String sourceCode) {
		sourceLines = splitingSourceLines(sourceCode);
	}
	
	private List<String> splitingSourceLines(String sourceCode){
		final String[] splitted = sourceCode.split("\\n");
		final List<String> sourceLines = new ArrayList<String>(
				Arrays.asList(splitted));
		return sourceLines;
	}
	
	public int countNumberCodeLines(){
		int result = 0;
		boolean commentMode = false;
		for (String line : sourceLines) {
			SourceLine sourceLine = new SourceLine(line);
			if (sourceLine.isCodeLine(commentMode))
				result++;
			commentMode = sourceLine.isActivatedCommentMode();
		}
		return result;
	}
}
