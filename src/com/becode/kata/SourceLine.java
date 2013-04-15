package com.becode.kata;

public class SourceLine{
	String codeLine;

	public SourceLine(String line) {
		this.codeLine = line.trim();
	}
	
	public boolean isCodeLine(){
		if (!"".equals(codeLine) && !codeLine.startsWith("//")  && !codeLine.startsWith("/*"))
			return true;
		else return false;
	}

}
