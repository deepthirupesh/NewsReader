package com.newsreader.service;

public class LinkFormatter extends Word {

	LinkFormatter(Integer startIndex, Integer endIndex) {
		super(startIndex, endIndex);

	}

	@Override
	public String formatWord(String word) {
		return "<a href=" + word + ">" + word + "</a>";
	}

}
