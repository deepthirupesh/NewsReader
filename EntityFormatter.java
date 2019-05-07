package com.newsreader.service;

public class EntityFormatter extends Word {
	
	public EntityFormatter(Integer startIndex, Integer endIndex) {
		super(startIndex, endIndex);
	}
	
	@Override
	public String formatWord(String word) {
		return "<strong>"+word+"</strong>";
	}

}
