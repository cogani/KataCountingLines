package com.becode.kata;

import java.util.ArrayList;
import java.util.List;

public class LineSplitter {
	private static final String NEW_LINE_REG_EXP = "\\n";

	public static List<SourceLine> splitingSourceLines(String sourceCode){
		final String[] splitted = sourceCode.split(NEW_LINE_REG_EXP);
		
		ArrayList<SourceLine> sourceLineList = new ArrayList<SourceLine>();
		
		for (String line : splitted) {
			SourceLine sourceLine = new SourceLine(line);
			sourceLineList.add(sourceLine);
		}
		
		return sourceLineList;
	}
}
