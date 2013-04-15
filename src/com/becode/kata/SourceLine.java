package com.becode.kata;

public class SourceLine {
	private String codeLine;
	private final String OPENING_BLOCK_COMMENT_MARK = "/*";
	private final String CLOSING_BLOCK_COMMENT_MARK = "*/";
	private final String LINE_COMMENT_MARK = "//";
	private final int NOT_FOUND = -1;
	private boolean commentMode;

	public SourceLine(String line) {
		this.codeLine = line.trim();
	}

	public boolean isCodeLine(boolean legacyCommentMode) {
		boolean validCodeLine = false;
		commentMode = legacyCommentMode;

		validCodeLine = validateSourceLineAsCodeLine();
		reCalculateCommentModeState();

		return validCodeLine;
	}
	
	private boolean validateSourceLineAsCodeLine() {
		boolean codeLine = false;

		if (!isBlankLine() && !isWholeLineACommentLine()
				&& !isWholeLineABlockComment())
			codeLine = true;

		return codeLine;
	}

	private boolean isWholeLineABlockComment() {

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

	private boolean isBlankLine() {
		boolean wholeLineIsACommentLine = false;

		if ("".equals(codeLine))
			wholeLineIsACommentLine = true;

		return wholeLineIsACommentLine;
	}

	private boolean isWholeLineACommentLine() {
		boolean wholeLineIsACommentLine = false;

		if (codeLine.startsWith(LINE_COMMENT_MARK))
			wholeLineIsACommentLine = true;

		return wholeLineIsACommentLine;
	}

	public boolean isActivatedCommentMode() {
		return commentMode;
	}

	private void reCalculateCommentModeState() {
		if (codeLine.contains(OPENING_BLOCK_COMMENT_MARK))
			commentMode = true;

		if (codeLine.contains(CLOSING_BLOCK_COMMENT_MARK))
			commentMode = false;
	}

	private boolean isMarkAtTheEndOfLine(String mark) {
		boolean isAtTheEnd = false;
		if (codeLine.lastIndexOf(CLOSING_BLOCK_COMMENT_MARK) == codeLine
				.length() - mark.length())
			isAtTheEnd = true;
		return isAtTheEnd;
	}


}
