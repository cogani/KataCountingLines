package com.becode.kata;

public class SourceLine {
	private String codeLine;
	private final String OPENING_BLOCK_COMMENT_MARK = "/*";
	private final String CLOSING_BLOCK_COMMENT_MARK = "*/";
	private final String LINE_COMMENT_MARK = "//";
	private boolean activatedCommentMode = false;

	public SourceLine(String line) {
		this.codeLine = line.trim();
	}

	public boolean isCodeLine(boolean legacyCommentMode) {
		boolean isValidCodeLine = false;
		activatedCommentMode = legacyCommentMode;

		if (!isBlankLine() && !isComentLine() && !wholeLineIsBlockComment()
				&& !activatedCommentMode)
			isValidCodeLine = true;

		processClosingBlockComment();

		return isValidCodeLine;
	}

	private boolean wholeLineIsBlockComment() {

		boolean fullLineIsaBlockComment = false;

		int posBeginingBlockCommentMark = codeLine
				.indexOf(OPENING_BLOCK_COMMENT_MARK);
		int posEndingBlockCommentMark = codeLine
				.lastIndexOf(CLOSING_BLOCK_COMMENT_MARK);

		if ((posBeginingBlockCommentMark == 0 || activatedCommentMode)
				&& (posEndingBlockCommentMark == -1 || posEndingBlockCommentMark == codeLine
						.length() - 2)) {
			fullLineIsaBlockComment = true;
			activatedCommentMode = true;
		}

		return fullLineIsaBlockComment;
	}

	private void processClosingBlockComment() {
		if (codeLine.contains(CLOSING_BLOCK_COMMENT_MARK))
			activatedCommentMode = false;
	}

	private boolean isBlankLine() {
		if ("".equals(codeLine))
			return true;
		else
			return false;
	}

	private boolean isComentLine() {
		if (codeLine.startsWith(LINE_COMMENT_MARK))
			return true;
		else
			return false;
	}

	public boolean isActivatedCommentMode() {
		return activatedCommentMode;
	}

}
