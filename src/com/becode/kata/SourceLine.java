package com.becode.kata;

public class SourceLine {
	private String codeLine;
	private final String OPENING_BLOCK_COMMENT_MARK ="/*";
	private final String CLOSING_BLOCK_COMMENT_MARK ="*/";
	private final String LINE_COMMENT_MARK ="//";
	private boolean activatedCommentMode = false;

	public SourceLine(String line) {
		this.codeLine = line.trim();
	}

	public boolean isCodeLine(boolean legacyCommentMode) {
		if (legacyCommentMode) {
			processClosingBlockComment();
			return false;
		}

		if (!isBlankLine() && !isComentLine()
				&& !isBlockComment())
			return true;
		else
			return false;
	}

	private boolean isBlockComment() {
		if (codeLine.startsWith(OPENING_BLOCK_COMMENT_MARK)) {
			processClosingBlockComment();
			return true;
		}
		return false;
	}

	private void processClosingBlockComment() {
		if (codeLine.endsWith(CLOSING_BLOCK_COMMENT_MARK))
			activatedCommentMode = false;
		else
			activatedCommentMode = true;
	}
	
	private boolean isBlankLine(){
		if("".equals(codeLine)) return true;
		else return false;
	}
	
	private boolean isComentLine(){
		if(codeLine.startsWith(LINE_COMMENT_MARK)) return true;
		else return false;
	}

	public boolean isActivatedCommentMode() {
		return activatedCommentMode;
	}

}
