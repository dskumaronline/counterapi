package com.wordcounter.api.vo;

public class WordCountVO {
	private String word;
	private Integer wordCount;

	public WordCountVO(String word, Integer wordCount) {
		this.word = word;
		this.wordCount = wordCount;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getWordCount() {
		return wordCount;
	}

	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
	}

}
