package com.becode.kata;

public class CommentState implements ParserState {

	@Override
	public boolean validateSourceLineAsCodeLine(SourceLine sourceLine) {
		boolean codeLine = false;

		if (!sourceLine.isWholeLineABlockComment(true))
			codeLine = true;

		return codeLine;
	}

}
