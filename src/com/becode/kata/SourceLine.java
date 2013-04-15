package com.becode.kata;

public class SourceLine{
	private String codeLine;
	private boolean activatedCommentMode = false;

	public SourceLine(String line) {
		this.codeLine = line.trim();
	}
	
	public boolean isCodeLine(boolean legacyCommentMode){
		if (legacyCommentMode){
			if(codeLine.contentEquals("*/")){			
				activatedCommentMode = false;
			}
			if (codeLine.endsWith("*/")) return false;
			else return true;
		}
			
		
		if (!"".equals(codeLine) && !codeLine.startsWith("//")  && !isBlockComment())
			return true;
		else return false;
	}
	
	private boolean isBlockComment()
	{
		if (codeLine.startsWith("/*")){
			if(!codeLine.endsWith("*/"))
				activatedCommentMode = true;
			else activatedCommentMode = false;
			return true;
		}
		return false;
	}

	public boolean isActivatedCommentMode() {
		return activatedCommentMode;
	}
}
