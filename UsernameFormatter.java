package com.newsreader.service;

public class UsernameFormatter extends Word {

	UsernameFormatter(Integer startIndex, Integer endIndex) {
		super(startIndex, endIndex);
	}

	@Override
	public String formatWord(String word) {
		return "@<a href=http://twitter.com/" + word + ">" + word + "</a>";
	}

}
