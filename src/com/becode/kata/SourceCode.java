package com.becode.kata;

import java.util.List;

public class SourceCode {
	List<SourceLine> sourceLines;
	
	public SourceCode(String sourceCode) {
		sourceLines = LineSplitter.splitingSourceLines(sourceCode);
	}
		
	public int countNumberCodeLines(){
		int result = 0;
		boolean commentMode = false;
		for (SourceLine sourceLine : sourceLines) {
			if (sourceLine.isCodeLine(commentMode))
				result++;
			commentMode = sourceLine.isActivatedCommentMode();
		}
		return result;
	}
}
