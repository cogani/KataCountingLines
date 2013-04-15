package com.becode.kata;

public class SourceLine {
	private String codeLine;
	private boolean activatedCommentMode = false;

	public SourceLine(String line) {
		this.codeLine = line.trim();
	}

	public boolean isCodeLine(boolean legacyCommentMode) {
		if (legacyCommentMode) {
			findClosingBlockComment();
			return false;
		}

		if (!isBlankLine() && !isComentLine()
				&& !isBlockComment())
			return true;
		else
			return false;
	}

	private boolean isBlockComment() {
		if (codeLine.startsWith("/*")) {
			findClosingBlockComment();
			return true;
		}
		return false;
	}

	private void findClosingBlockComment() {
		if (codeLine.contentEquals("*/"))
			activatedCommentMode = false;
		else
			activatedCommentMode = true;
	}
	
	private boolean isBlankLine(){
		if("".equals(codeLine)) return true;
		else return false;
	}
	
	private boolean isComentLine(){
		if(codeLine.startsWith("//")) return true;
		else return false;
	}

	public boolean isActivatedCommentMode() {
		return activatedCommentMode;
	}

}
