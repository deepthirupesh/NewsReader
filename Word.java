package com.newsreader.service;

public abstract class Word {
	Integer startIndex;
	Integer endIndex;

	Word(Integer startIndex, Integer endIndex) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	public abstract String formatWord(String word);

}
