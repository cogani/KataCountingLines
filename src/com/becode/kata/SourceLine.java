package com.becode.kata;

public class SourceLine {
	private String codeLine;
	private final String OPENING_BLOCK_COMMENT_MARK = "/*";
	private final String CLOSING_BLOCK_COMMENT_MARK = "*/";
	private final String LINE_COMMENT_MARK = "//";
	private final int NOT_FOUND = -1;

	// State base for State Pattern
	private ParserState parserState;

	public SourceLine(String line) {
		this.codeLine = line.trim();
	}

	public boolean isCodeLine() {
		boolean validCodeLine = false;

		validCodeLine = validateSourceLineAsCodeLine();
		reCalculateCommentModeState();

		return validCodeLine;
	}

	private boolean validateSourceLineAsCodeLine() {
		boolean codeLine = false;

		if (parserState.validateSourceLineAsCodeLine(this))
			codeLine = true;

		return codeLine;
	}

	public boolean isWholeLineABlockComment(boolean commentMode) {

		boolean fullLineIsaBlockComment = false;

		int posBeginingBlockCommentMark = codeLine
				.indexOf(OPENING_BLOCK_COMMENT_MARK);
		int posEndingBlockCommentMark = codeLine
				.lastIndexOf(CLOSING_BLOCK_COMMENT_MARK);

		if ((posBeginingBlockCommentMark == 0 || commentMode)
				&& (posEndingBlockCommentMark == NOT_FOUND || isMarkAtTheEndOfLine(CLOSING_BLOCK_COMMENT_MARK))) {
			fullLineIsaBlockComment = true;
		}

		return fullLineIsaBlockComment;
	}

	public boolean isBlankLine() {
		boolean wholeLineIsACommentLine = false;

		if ("".equals(codeLine))
			wholeLineIsACommentLine = true;

		return wholeLineIsACommentLine;
	}

	public boolean isWholeLineACommentLine() {
		boolean wholeLineIsACommentLine = false;

		if (codeLine.startsWith(LINE_COMMENT_MARK))
			wholeLineIsACommentLine = true;

		return wholeLineIsACommentLine;
	}

	private void reCalculateCommentModeState() {
		if (codeLine.contains(OPENING_BLOCK_COMMENT_MARK)) {
			this.parserState = new CommentState();
		}

		if (codeLine.contains(CLOSING_BLOCK_COMMENT_MARK)) {
			this.parserState = new CodeState();
		}

	}

	private boolean isMarkAtTheEndOfLine(String mark) {
		boolean isAtTheEnd = false;
		if (codeLine.lastIndexOf(CLOSING_BLOCK_COMMENT_MARK) == codeLine
				.length() - mark.length())
			isAtTheEnd = true;
		return isAtTheEnd;
	}

	// Accessor and mutator for state pattern
	public ParserState getStateParser() {
		return parserState;
	}

	public void setStateParser(ParserState parserState) {
		this.parserState = parserState;
	}

}
