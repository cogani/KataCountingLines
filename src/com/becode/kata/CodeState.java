package com.becode.kata;


public class CodeState implements ParserState{

	@Override
	public boolean validateSourceLineAsCodeLine(SourceLine sourceLine) {
		boolean codeLine = false;

		if (!sourceLine.isBlankLine() && !sourceLine.isWholeLineACommentLine()
				&& !sourceLine.isWholeLineABlockComment(false))
			codeLine = true;

		return codeLine;
	}

}
