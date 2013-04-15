package com.becode.kata;

public class SourceLine {
	private String codeLine;
	private final String OPENING_BLOCK_COMMENT_MARK = "/*";
	private final String CLOSING_BLOCK_COMMENT_MARK = "*/";
	private final String LINE_COMMENT_MARK = "//";
	private final int NOT_FOUND = -1;
	private boolean activatedCommentMode;

	public SourceLine(String line) {
		this.codeLine = line.trim();
	}

	public boolean isCodeLine(boolean legacyCommentMode) {
		boolean isValidCodeLine = false;
		activatedCommentMode = legacyCommentMode;

		if (!isBlankLine() && !wholeLineIsAComment() && !isWholeABlockComment()
				&& !activatedCommentMode)
			isValidCodeLine = true;

		reCalculateCommentModeState();

		return isValidCodeLine;
	}

	private boolean isWholeABlockComment() {

		boolean fullLineIsaBlockComment = false;

		int posBeginingBlockCommentMark = codeLine
				.indexOf(OPENING_BLOCK_COMMENT_MARK);
		int posEndingBlockCommentMark = codeLine
				.lastIndexOf(CLOSING_BLOCK_COMMENT_MARK);

		if ((posBeginingBlockCommentMark == 0 || activatedCommentMode)
				&& (posEndingBlockCommentMark == NOT_FOUND || isMarkAtTheEndOfLine(CLOSING_BLOCK_COMMENT_MARK))) {
			fullLineIsaBlockComment = true;
		}

		return fullLineIsaBlockComment;
	}

	private void reCalculateCommentModeState() {
		if (codeLine.contains(OPENING_BLOCK_COMMENT_MARK))
			activatedCommentMode = true;
		
		if (codeLine.contains(CLOSING_BLOCK_COMMENT_MARK))
			activatedCommentMode = false;
	}

	private boolean isBlankLine() {
		if ("".equals(codeLine))
			return true;
		else
			return false;
	}

	private boolean wholeLineIsAComment() {
		if (codeLine.startsWith(LINE_COMMENT_MARK))
			return true;
		else
			return false;
	}

	public boolean isActivatedCommentMode() {
		return activatedCommentMode;
	}

	private boolean isMarkAtTheEndOfLine(String mark) {
		boolean isAtTheEnd = false;
		if (codeLine.lastIndexOf(CLOSING_BLOCK_COMMENT_MARK) == codeLine
				.length() - mark.length())
			isAtTheEnd = true;
		return isAtTheEnd;
	}
}
