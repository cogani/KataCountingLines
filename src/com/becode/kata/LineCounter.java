package com.becode.kata;

import java.util.ArrayList;
import java.util.Arrays;

public class LineCounter {
	String sourceCode;

	public LineCounter(String stringCode) {
		sourceCode = stringCode;
	}

	public int countCodeLines() {
		final String[] splitted = sourceCode.split("\\n");
		ArrayList<String> sourceLines = new ArrayList<String>(
				Arrays.asList(splitted));
		int result = 0;
		for (String line : sourceLines) {
			if (!"".equals(line.trim()))
				result++;
		}
		return result;
	}

}
