package com.wordcounter.api.service;

import com.wordcounter.api.client.ReadFileClient;
import com.wordcounter.api.util.StringUtil;
import com.wordcounter.api.vo.WordCountVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordCounterServiceImpl implements WordCounterService{
	
	@Autowired
	private ReadFileClient readFileClient ;

	@Override
	public Map<String, Integer> getTopWordsInText(Integer number) {
		String strFromFile = readFileClient.getTextFileContent();
		Map<String, Integer> wordFrequencies = StringUtil.getWordCountByLimit(strFromFile, number);
			for (Entry<String, Integer> e : wordFrequencies.entrySet()) {
		}
		return wordFrequencies;
	}

	@Override
	public List<WordCountVO> queryWordOccurence(List<String> queryWords) {
		String strFromFile = readFileClient.getTextFileContent();
		List<WordCountVO> wordList = StringUtil.queryWordFrequency(strFromFile, queryWords);
		return wordList;
	}

}
