package com.sitemapdev.riddles_you_know.util;

public class ProjectUtility {
	
	
	public String toString(char[] allCharactersOfAnswer) {
		
		String ret = "";
		
		for(char c: allCharactersOfAnswer) {
			if(c == '\u0000') {
				ret = ret + "_";
			}
			ret = ret + " ";
		}
		return ret;
	}

}
