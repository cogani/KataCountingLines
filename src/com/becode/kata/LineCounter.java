package com.becode.kata;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LineCounter {
	String sourceCode;

	public LineCounter(String stringCode) {
		sourceCode = stringCode;
	}

	public int countCodeLines() {
		ArrayList<String> sourceLines = splitSourceLines(sourceCode);
		
		int result = 0;
		for (String line : sourceLines) {
			if (!"".equals(line.trim()))
				result++;
		}
		return result;
	}
	
	private ArrayList<String> splitSourceLines(String stringCode){
		final String[] splitted = sourceCode.split("\\n");
		final ArrayList<String> sourceLines = new ArrayList<String>(
				Arrays.asList(splitted));
		return sourceLines;
	}

}
