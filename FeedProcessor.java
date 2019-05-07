package com.newsreader.service;

import java.util.LinkedList;
import java.util.List;

public class FeedProcessor {
	
	public String processFeed(String input, List<Word> feedDetails) {
		String result = "";
		Integer defaultPos = 0;
		//none of the words are classified as Entity/Link/UserName then return empty string.
		if(feedDetails.size() < 1) {
			return result;
		}
		try{
		//sort the list on start index.
		feedDetails.sort((Word s1, Word s2)->s1.startIndex.compareTo(s2.startIndex));
		for( Word detail : feedDetails) {
			//consider the word/s which are not classified (Entity/Link/UserName).
			String prefix = input.substring(defaultPos, detail.getStartIndex());
			
			//get the string by passing the start and end index.
			String text = input.substring(detail.getStartIndex(),detail.endIndex);
			
			//invoking text corresponding formatter.
			String tag = detail.formatWord(text);
			result += prefix+tag;
			defaultPos = detail.getEndIndex();
		}
		result += input.substring(defaultPos, input.length());
		} catch(Exception ex) {
			System.out.println("EXCEPTION OCCURED----->"+ex.getMessage());
			ex.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] str) {
		String input = "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile";
		List<Word> details = new LinkedList<>();
		details.add(new EntityFormatter(14, 22));
		details.add(new EntityFormatter(0, 5));
		details.add(new UsernameFormatter(55, 67));
		details.add(new LinkFormatter(37, 54));
		FeedProcessor process = new FeedProcessor();
		System.out.println(process.processFeed(input, details));
	}

}
